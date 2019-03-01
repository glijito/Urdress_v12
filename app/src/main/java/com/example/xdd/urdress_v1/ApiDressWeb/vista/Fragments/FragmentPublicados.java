package com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xdd.urdress_v1.R;

public class FragmentPublicados extends Fragment {

    private DataListeres callback;
    private Button atras;
    private Button pendientes;
    private Button reservados;

    public FragmentPublicados() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_publicados, container, false);
        try {
            this.callback = (FragmentPublicados.DataListeres) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }
        atras = (Button) view.findViewById(R.id.atras);
        pendientes = (Button) view.findViewById(R.id.btnPendientes);
        reservados = (Button) view.findViewById(R.id.btnReservados);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendPublicados("Atras");
            }
        });
        pendientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pendientes.setBackgroundColor(Color.parseColor("#83919E"));
                reservados.setBackgroundColor(Color.parseColor("#697989"));
            }
        });
        reservados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pendientes.setBackgroundColor(Color.parseColor("#697989"));
                reservados.setBackgroundColor(Color.parseColor("#83919E"));
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.callback = (FragmentPublicados.DataListeres) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }
    }

    public interface DataListeres {
        void sendPublicados(String fragmento);
    }
}
