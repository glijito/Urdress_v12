package com.example.xdd.urdress_v1.ApiDressWeb.Activitys;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.widget.Toast;

import com.example.xdd.urdress_v1.ApiDressWeb.ApiWebSoap.CerrarSesion;
import com.example.xdd.urdress_v1.ApiDressWeb.Fragments.FragmentInicio;
import com.example.xdd.urdress_v1.ApiDressWeb.Fragments.FragmentPerfil;
import com.example.xdd.urdress_v1.R;

public class Inicio extends AppCompatActivity implements FragmentInicio.DataListener,FragmentPerfil.DataListener {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityinicio);
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);


        FragmentInicio fr = new FragmentInicio();
        Fragment ff = (Fragment) fr;
        setFragment(ff, "fragment_inicio");
    }

    public void setFragment(Fragment newFragment, String tag){
        int commit = getFragmentManager().beginTransaction().replace(R.id.contenedorInicio,newFragment,tag).
                commit();
        if(commit>0)
            Log.w("CREACION","correcto");
        else
            Log.w("CREACION","incorrecto");
    }

    @Override
    public void sendDataInicio(boolean opcion) {
        if (opcion==false){
            CerrarSesion cerrarSesion = new CerrarSesion(prefs, getApplicationContext());
            cerrarSesion.Cerrar();
        }else{
            FragmentPerfil fr = new FragmentPerfil();
            Fragment ff = (Fragment) fr;
            setFragment(ff, "fragment_perfil");
        }
    }

    @Override
    public void sendDataPer() {
        FragmentInicio fr = new FragmentInicio();
        Fragment ff = (Fragment) fr;
        setFragment(ff, "fragment_inicio");
    }

}
