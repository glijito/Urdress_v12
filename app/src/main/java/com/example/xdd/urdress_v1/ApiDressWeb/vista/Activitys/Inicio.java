package com.example.xdd.urdress_v1.ApiDressWeb.vista.Activitys;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentInicio;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentMenu;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentPerfil;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentPublicados;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentRentados;
import com.example.xdd.urdress_v1.R;

public class Inicio extends AppCompatActivity implements FragmentInicio.DataListener,
        FragmentMenu.DataListener,
        FragmentPerfil.DataListeners,
        FragmentPublicados.DataListeres,
        FragmentRentados.DataListener {

    private SharedPreferences prefs;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        FragmentInicio fr = new FragmentInicio();
        Fragment ff = (Fragment) fr;
        setFragment(ff, "fragment_inicio");
    }

    public void setFragment(Fragment newFragment, String tag){
        int commit = getFragmentManager().beginTransaction().replace(R.id.contenedor,newFragment,tag).commit();
        if(commit>0)
            Log.w("CREACION","correcto");
        else
            Log.w("CREACION","incorrecto");
    }

    @Override
    public void sendInicio(String fragmento) {
        if(fragmento=="menu"){
            FragmentMenu fr = new FragmentMenu();
            Fragment ff = (Fragment) fr;
            setFragment(ff, "fragment_menu");
        }else if(fragmento=="publicar"){
            Intent intent = new Intent(this, PublicarVestido.class);
            startActivity(intent);
        }
    }

    @Override
    public void sendMenu(String fragmento) {
        if(fragmento=="Perfil"){
            FragmentPerfil fr = new FragmentPerfil();
            Fragment ff = (Fragment) fr;
            setFragment(ff, "fragment_perfil");
        }else if(fragmento=="Publicados"){
            FragmentPublicados fr = new FragmentPublicados();
            Fragment ff = (Fragment) fr;
            setFragment(ff, "fragment_publicados");
        }else if(fragmento=="Rentados"){
            FragmentRentados fr = new FragmentRentados();
            Fragment ff = (Fragment) fr;
            setFragment(ff, "fragment_rentados");
        }else if(fragmento=="Terminos"){

        }else if(fragmento=="AcercaDe"){

        }else if(fragmento=="Cerrar"){
            FragmentInicio fr = new FragmentInicio();
            Fragment ff = (Fragment) fr;
            setFragment(ff, "fragment_inicio");
        }
    }

    @Override
    public void sendPerfil(String Dato) {
        if(Dato=="Inicio"){
            FragmentInicio fr = new FragmentInicio();
            Fragment ff = (Fragment) fr;
            setFragment(ff, "fragment_inicio");
        }
    }

    @Override
    public void sendPublicados(String fragmento) {
        if(fragmento=="Atras"){
            FragmentInicio fr = new FragmentInicio();
            Fragment ff = (Fragment) fr;
            setFragment(ff, "fragment_inicio");
        }
    }

    @Override
    public void sendRentados(String fragmento) {
        if(fragmento=="Atras"){
            FragmentInicio fr = new FragmentInicio();
            Fragment ff = (Fragment) fr;
            setFragment(ff, "fragment_inicio");
        }
    }

    @Override
    public void onBackPressed() {
        FragmentInicio fr = new FragmentInicio();
        Fragment ff = (Fragment) fr;
        setFragment(ff, "fragment_inicio");
    }
}

