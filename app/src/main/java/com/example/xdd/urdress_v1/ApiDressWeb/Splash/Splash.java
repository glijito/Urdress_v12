package com.example.xdd.urdress_v1.ApiDressWeb.Splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.xdd.urdress_v1.ApiDressWeb.Activitys.Activity_main;
import com.example.xdd.urdress_v1.R;

public class Splash extends AppCompatActivity {

    private final int DURACION_SPLASH = 1000; // 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(Splash.this, Activity_main.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}
