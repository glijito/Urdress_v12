package com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xdd.urdress_v1.R;

public class FragmentMenu extends Fragment {

    private DataListener callback;
    private TextView Perfil;
    private TextView Publicados;
    private TextView Rentados;
    private TextView Terminos;
    private TextView AcercaDe;
    private ImageView Cerrar;

    public FragmentMenu() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__menu, container, false);
        try {
            callback = (DataListener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }

        Perfil = (TextView) view.findViewById(R.id.Perfil);
        Publicados = (TextView) view.findViewById(R.id.Publicados);
        Rentados = (TextView) view.findViewById(R.id.rentados);
        Terminos = (TextView) view.findViewById(R.id.terminos);
        AcercaDe = (TextView) view.findViewById(R.id.acerca);
        Cerrar = (ImageView) view.findViewById(R.id.Cerrar);

        Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendMenu("Perfil");
            }
        });
        Publicados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendMenu("Publicados");
            }
        });
        Rentados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendMenu("Rentados");
            }
        });
        Terminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendMenu("Terminos");
            }
        });
        AcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendMenu("AcercaDe");
            }
        });
        Cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendMenu("Cerrar");
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public interface DataListener{
        void sendMenu(String fragmento);
    }

}
