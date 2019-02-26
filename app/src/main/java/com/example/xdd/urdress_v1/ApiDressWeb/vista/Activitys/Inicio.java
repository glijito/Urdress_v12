package com.example.xdd.urdress_v1.ApiDressWeb.vista.Activitys;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentInicio;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentMenu;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentPerfil;
import com.example.xdd.urdress_v1.R;

public class Inicio extends AppCompatActivity implements FragmentInicio.DataListener,
        FragmentMenu.DataListener,
        FragmentPerfil.DataListeners {

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
        }

    }

    @Override
    public void sendMenu(String fragmento) {
        if(fragmento=="Perfil"){
            FragmentPerfil fr = new FragmentPerfil();
            Fragment ff = (Fragment) fr;
            setFragment(ff, "fragment_perfil");
        }else if(fragmento=="Publicados"){

        }else if(fragmento=="Rentados"){

        }else if(fragmento=="Terminos"){

        }else if(fragmento=="AcercaDe"){

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
}

