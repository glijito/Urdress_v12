package com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.xdd.urdress_v1.R;

public class FragmentRegistro_03 extends Fragment {

    private DataListener callback;

    private ImageButton Siguiente;
    private TextView txtCiudad;

    public FragmentRegistro_03() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_03, container, false);

        try {
            callback = (FragmentRegistro_03.DataListener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }

        txtCiudad = (TextView) view.findViewById(R.id.eTCiudad) ;
        Siguiente = (ImageButton) view.findViewById(R.id.imgSig);

        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ciudad = txtCiudad.getText().toString();
                callback.sendDataFR3(ciudad);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public interface DataListener {
        void sendDataFR3(String Ciudad);
    }
}
