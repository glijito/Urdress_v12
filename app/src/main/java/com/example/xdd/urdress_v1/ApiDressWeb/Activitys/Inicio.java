package com.example.xdd.urdress_v1.ApiDressWeb.Activitys;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.xdd.urdress_v1.ApiDressWeb.ApiWebSoap.CerrarSesion;
import com.example.xdd.urdress_v1.R;

public class Inicio extends AppCompatActivity {

    private SharedPreferences prefs;
    private Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        btnCerrarSesion = (Button) findViewById(R.id.btnCerrarSesion);
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CerrarSesion cerrarSesion = new CerrarSesion(prefs, getApplicationContext());
                cerrarSesion.Cerrar();
            }
        });

    }
}
