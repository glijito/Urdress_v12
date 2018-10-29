package com.example.xdd.urdress_v1.ApiDressWeb.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.xdd.urdress_v1.R;

public class FragmentRegistro_01 extends Fragment {

    private DataListener callback;
    private EditText txtEmail;
    private EditText txtPassword;
    private ImageButton btnSiguiente;

    public FragmentRegistro_01() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_01, container, false);

        txtEmail = (EditText) view.findViewById(R.id.eTCorreo);
        txtPassword = (EditText) view.findViewById(R.id.eTContra);
        btnSiguiente = (ImageButton) view.findViewById(R.id.imgBrectangle_61);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = txtEmail.getText().toString();
                String Password = txtPassword.getText().toString();
                if(!isValidEmail(Email))
                    Toast.makeText(getActivity(), "El email no es valido", Toast.LENGTH_LONG).show();
                else if(!isValidPassword(Password))
                    Toast.makeText(getActivity(), "La contraseña no es valida", Toast.LENGTH_LONG).show();
                else{
                    callback.sendDataFR1(Email, Password);
                }
            }
        });



        return view;
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean isValidPassword(String password) {
        return password.length() >= 4;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (DataListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
    }

    public interface DataListener {
        void sendDataFR1(String text, String Password);
    }
}
