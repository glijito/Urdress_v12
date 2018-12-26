package com.example.xdd.urdress_v1.ApiDressWeb.vista.Activitys;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.xdd.urdress_v1.ApiDressWeb.interfaces.InicioView;
import com.example.xdd.urdress_v1.ApiDressWeb.modelo.ApiWebSoap.CerrarSesion;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentInicio;
import com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments.FragmentPerfil;
import com.example.xdd.urdress_v1.R;

public class Inicio extends AppCompatActivity implements InicioView {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment__inicio);
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

    }

    @Override
    public void setConexionErrorUser() {
        Toast.makeText(this,"La tarea no puede ser realizada, consulte su conexion a internet ",Toast.LENGTH_LONG).show();
    }

    @Override
    public void setButtonPublicarVestido() {

    }

    @Override
    public void setButtonRentarVestido() {

    }

    @Override
    public void setMenuUser() {

    }

    @Override
    public void setRecyclerViewDressInit() {

    }


    public void setFragment(Fragment newFragment, String tag){
        int commit = getFragmentManager().beginTransaction().replace(R.id.contenedorInicio,newFragment,tag).
                commit();
        if(commit>0)
            Log.w("CREACION","correcto");
        else
            Log.w("CREACION","incorrecto");
    }

    /*

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
*/
}

