package com.example.xdd.urdress_v1.ApiDressWeb.Activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.xdd.urdress_v1.ApiDressWeb.ApiWebSoap.DressLoguin;
import com.example.xdd.urdress_v1.R;

public class Activity_main extends AppCompatActivity {

    private SharedPreferences prefs;

    private EditText Email;
    private EditText Password;
    private ImageButton Entrar;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        checarInicio();

        Email = (EditText) findViewById(R.id.eTextEmail);
        Password = (EditText) findViewById(R.id.eTextPassword);
        Entrar = (ImageButton) findViewById(R.id.group_2356);

        setCredentialsIfExist();

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

    private void setCredentialsIfExist() {
        String email = prefs.getString("email", "");
        String password = prefs.getString("pass", "");
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            Email.setText(email);
            Password.setText(password);
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

    private void checarInicio(){
        if(Integer.parseInt(prefs.getString("id", "0"))>0)
            goToMain();
    }
}
