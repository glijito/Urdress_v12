package com.example.xdd.urdress_v1.ApiDressWeb.vista.Activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.xdd.urdress_v1.ApiDressWeb.interfaces.Contrato;
import com.example.xdd.urdress_v1.ApiDressWeb.presentador.desencadenadores.TrigerDatosService;
import com.example.xdd.urdress_v1.R;

public class Inicio extends AppCompatActivity implements Contrato.VistaActivity,View.OnClickListener {

    private SharedPreferences prefs;
    private TrigerDatosService triger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityinicio);
        ImageButton publicarVestido=findViewById(R.id.btn_publicar_vestido);
        ImageButton rentarVestido=findViewById(R.id.btn_rentar_vestido);

        triger = new TrigerDatosService();
        triger.setVista(this);

        publicarVestido.setOnClickListener(this);
        rentarVestido.setOnClickListener(this);
    }

    @Override
    public void setConexionErrorUser(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setLoadButtonsActivitys(String opcion){
        Intent intent =new Intent(this,opcion.getClass());
        startActivity(intent);
    }

    @Override
    public void setMenuUser() {

    }

    @Override
    public void setRecyclerViewDressInit() {
        triger.getDataConectedWebDress();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_publicar_vestido)
            setLoadButtonsActivitys("activity_publicarvestido");

        /*if(v.getId()==R.id.btn_rentar_vestido)
            setLoadButtonsActivitys("mundo");*/
    }

    public void setFragment(android.support.v4.app.Fragment newFragment, String tag) {
        int commit= newFragment.getFragmentManager().beginTransaction()
                .replace(R.id.contenedorInicio, newFragment, tag)
                .commit();

        if (commit > 0)
            Log.w("CREACION", "correcto");
        else
            Log.w("CREACION", "incorrecto");
    }

}

