package com.example.xdd.urdress_v1.ApiDressWeb.vista.Activitys;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.xdd.urdress_v1.ApiDressWeb.modelo.ApiWebSoap.DressAltaUsuario;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentRegistro_01;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentRegistro_02;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentRegistro_03;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentRegistro_04;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentRegistro_05;
import com.example.xdd.urdress_v1.R;

public class AltaUsuario extends AppCompatActivity implements FragmentRegistro_01.DataListener,
        FragmentRegistro_02.DataListener,
        FragmentRegistro_03.DataListener,
        FragmentRegistro_04.DataListener,
        FragmentRegistro_05.DataListener {
    private SharedPreferences prefs;

    private String Correo;
    private String Password;
    private String Nombre;
    private String ApeidoP;
    private String ApeidoM;
    private String Ciudad;
    private String Telefono;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_usuario);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        FragmentRegistro_01 fr = new FragmentRegistro_01();
        Fragment ff = (Fragment) fr;
        setFragment(ff, "fragment_registro_01");
    }
    public void setFragment(Fragment newFragment, String tag){
        int commit = getFragmentManager().beginTransaction().replace(R.id.contenedor,newFragment,tag).
                commit();
        if(commit>0)
            Log.w("CREACION","correcto");
        else
            Log.w("CREACION","incorrecto");
    }

    @Override
    public void sendDataFR1(String text, String Password) {
        this.Correo=text;
        this.Password=Password;
        FragmentRegistro_02 fr = new FragmentRegistro_02();
        Fragment ff = (Fragment) fr;
        setFragment(ff, "fragment_registro_02");
        Toast.makeText(this, "Password: "+this.Password, Toast.LENGTH_LONG).show();
    }

    @Override
    public void sendDataFR2(String Nombre, String ApeidoP, String ApeidoM) {
        this.Nombre=Nombre;
        this.ApeidoP=ApeidoP;
        this.ApeidoM=ApeidoM;
        FragmentRegistro_03 fr = new FragmentRegistro_03();
        Fragment ff = (Fragment) fr;
        setFragment(ff, "fragment_registro_03");
        Toast.makeText(this, "Nombre: "+this.Nombre, Toast.LENGTH_LONG).show();
    }

    @Override
    public void sendDataFR3(String Ciudad) {
        this.Ciudad = Ciudad;
        FragmentRegistro_04 fr = new FragmentRegistro_04();
        Fragment ff = (Fragment) fr;
        setFragment(ff, "fragment_registro_04");
        Toast.makeText(this, "Ciudad: "+this.Ciudad, Toast.LENGTH_LONG).show();
    }

    @Override
    public void sendDataFR4(String Foto) {
        FragmentRegistro_05 fr = new FragmentRegistro_05();
        Fragment ff = (Fragment) fr;
        setFragment(ff, "fragment_registro_05");
        Toast.makeText(this, "Foto: "+Foto, Toast.LENGTH_LONG).show();
    }


    @Override
    public void sendDataFR5(String numero) {
        this.Telefono=numero;
        id = 3;

        DressAltaUsuario alta = new DressAltaUsuario(getApplication(), this.Correo, this.Password, this.Nombre, this.ApeidoP, this.ApeidoM, this.Telefono );
        alta.execute();
        try {
            id = Integer.parseInt(alta.get().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Id: "+id,Toast.LENGTH_LONG).show();
        if(id>0){
            goToMain();
            saveOnPreferences();
        }else
            Toast.makeText(getApplicationContext(), "El correo ya esta registrado",Toast.LENGTH_LONG).show();
    }

    private void goToMain(){
        Intent intent = new Intent(this, Inicio.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void saveOnPreferences(){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("email", Correo);
        editor.putString("pass", Password);
        editor.putString("id", String.valueOf(id));
        editor.apply();
    }
}
