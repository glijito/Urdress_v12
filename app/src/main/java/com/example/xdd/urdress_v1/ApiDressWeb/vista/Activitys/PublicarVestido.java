package com.example.xdd.urdress_v1.ApiDressWeb.vista.Activitys;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentPublicarVestido_1;
import com.example.xdd.urdress_v1.R;

public class PublicarVestido extends AppCompatActivity implements
        FragmentPublicarVestido_1.Datalistener {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_vestido);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        FragmentPublicarVestido_1 fr = new FragmentPublicarVestido_1();
        Fragment ff = (Fragment) fr;
        setFragment(ff, "fragment_publicar_vestido_1");
    }

    public void setFragment(Fragment newFragment, String tag){
        int commit = getFragmentManager().beginTransaction().replace(R.id.ContenedorPublicar,newFragment,tag).commit();
        if(commit>0)
            Log.w("CREACION","correcto");
        else
            Log.w("CREACION","incorrecto");
    }


    @Override
    public void sendPublicar1(String fragmento) {
        if(fragmento=="Cancelar"){
            Intent intent = new Intent(this, Inicio.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
