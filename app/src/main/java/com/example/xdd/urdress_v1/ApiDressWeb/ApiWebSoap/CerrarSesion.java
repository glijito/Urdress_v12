package com.example.xdd.urdress_v1.ApiDressWeb.ApiWebSoap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.xdd.urdress_v1.ApiDressWeb.Activitys.Inicio;
import com.example.xdd.urdress_v1.ApiDressWeb.Splash.Splash;
import com.facebook.login.LoginManager;

public class CerrarSesion {
    private SharedPreferences prefs;
    Context context;

    public CerrarSesion(SharedPreferences prefs, Context context) {
        this.prefs = prefs;
        this.context = context;
    }

    public void Cerrar(){
        LoginManager.getInstance().logOut();
        deleteOnPreferences();
        goToSplash();
    }

    private void deleteOnPreferences(){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("email", "");
        editor.putString("pass", "");
        editor.putString("id", "0");
        editor.apply();
    }
    private void goToSplash(){
        Intent intent = new Intent(context, Splash.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}
