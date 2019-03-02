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

public class FragmentRentados extends Fragment {

    private DataListener callback;
    private Button atras;
    private Button pendientes;
    private Button reservados;

    public FragmentRentados() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rentados, container, false);
        try {
            this.callback = (FragmentRentados.DataListener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }
        atras = (Button) view.findViewById(R.id.btnAtras);
        pendientes = (Button) view.findViewById(R.id.btnPendientes1);
        reservados = (Button) view.findViewById(R.id.btnReservados1);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendRentados("Atras");
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
            this.callback = (FragmentRentados.DataListener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    public interface DataListener {
        void sendRentados(String fragmento);
    }
}
