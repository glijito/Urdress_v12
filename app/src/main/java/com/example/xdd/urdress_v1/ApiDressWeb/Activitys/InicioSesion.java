package com.example.xdd.urdress_v1.ApiDressWeb.Activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xdd.urdress_v1.ApiDressWeb.ApiWebSoap.DressLoguin;
import com.example.xdd.urdress_v1.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InicioSesion extends AppCompatActivity {

    private SharedPreferences prefs;

    private LoginButton loginButton;
    private CallbackManager mFacebookCallbackManager;

    private ImageButton imagebtnFacebook;

    private EditText Email;
    private EditText Password;
    private ImageButton Entrar;
    private TextView AltaUsuario;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciosesion);

        mFacebookCallbackManager = CallbackManager.Factory.create();
        imagebtnFacebook = (ImageButton) findViewById(R.id.imagebtnFacebook);
        facebook();

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        //Checa si esta iniciada la sesion
        checarInicio();

        Email = (EditText) findViewById(R.id.eTextEmail);
        Password = (EditText) findViewById(R.id.eTextPassword);
        Entrar = (ImageButton) findViewById(R.id.group_2356);
        AltaUsuario = (TextView) findViewById(R.id.txtcuentaURD);

        AltaUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAltaUsuario();
            }
        });

        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoEmail = Email.getText().toString();
                String textoPassword = Password.getText().toString();

                if(login(textoEmail, textoPassword)){
                    DressLoguin dressLoguin =new DressLoguin(getApplication(),textoPassword,textoEmail, false, 3);
                    dressLoguin.execute();
                    try {
                        id=Integer.parseInt(dressLoguin.get().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(id>0){
                        goToMain();
                        saveOnPreferences(textoEmail, textoPassword);
                    }else
                        Toast.makeText(getApplicationContext(), "Correo y/o Contraseña Erronea",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
    private void facebook(){
        //Clickea el boton de facebook cuando se aprieta el que tiene diseño
        imagebtnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton.performClick();
            }
        });

        loginButton = (LoginButton) findViewById(R.id.btnloguinFace);
        //Pide los permisos necesarios
        loginButton.setReadPermissions(Arrays.asList("public_profile", "user_friends", "email", "user_birthday"));
        loginButton.registerCallback(mFacebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // Obtiene los datos
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                try {
                                    // get profile information
                                    String name = "";
                                    String email = "";
                                    if (object.getString("name") != null) {
                                        name = object.getString("name");
                                        Toast.makeText(getApplicationContext(),"Nombre: "+name, Toast.LENGTH_LONG).show();
                                    }
                                    if (object.getString("email") != null) {
                                        email = object.getString("email");
                                        Toast.makeText(getApplicationContext(),"Email: "+email, Toast.LENGTH_LONG).show();
                                    }
                                    loguinface(email);
                                    if(id>0){
                                        goToMain();
                                        saveOnPreferences(email, "");
                                    }else
                                        Toast.makeText(getApplicationContext(), "No esta registrado",Toast.LENGTH_LONG).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,link,gender,birthday,email,picture");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"Inicio de sesion cancelada", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(),"Error en el inicio de sesion", Toast.LENGTH_LONG).show();
            }
        });
    }

    private int loguinface(String email){
        DressLoguin dressLoguin =new DressLoguin(getApplication(),"",email, true, 2);
        dressLoguin.execute();
        try {
            id=Integer.parseInt(dressLoguin.get().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private boolean login(String email, String password) {
        if (!isValidEmail(email)) {
            Toast.makeText(this, "El email no es valido", Toast.LENGTH_LONG).show();
            return false;
        } else if (!isValidPassword(password)) {
            Toast.makeText(this, "La contraseña no es valida", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 4;
    }

    private void saveOnPreferences(String email, String password) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("email", email);
            editor.putString("pass", password);
            editor.putString("id", String.valueOf(id));
            editor.apply();
    }
    private void goToMain() {
        Intent intent = new Intent(this, Inicio.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void goToAltaUsuario(){
        Intent intent = new Intent(this, AltaUsuario.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    private void checarInicio(){
        if(Integer.parseInt(prefs.getString("id", "0"))>0)
            goToMain();
    }
}
