package com.example.xdd.urdress_v1.ApiDressWeb.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.xdd.urdress_v1.R;


public class FragmentRegistro_02 extends Fragment {

    private DataListener callback;
    private EditText eTNombre;
    private EditText eTapaterno;
    private EditText eTamaterno;
    private ImageButton Siguiente;

    public FragmentRegistro_02() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_02, container, false);

        eTNombre = (EditText) view.findViewById(R.id.eTNombre);
        eTapaterno = (EditText) view.findViewById(R.id.eTapaterno);
        eTamaterno = (EditText) view.findViewById(R.id.eTamaterno);
        Siguiente = (ImageButton) view.findViewById(R.id.imgSig);

        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nombre = eTNombre.getText().toString();
                String ApeidoP = eTapaterno.getText().toString();
                String ApeidoM = eTamaterno.getText().toString();
                if(!isValidData(Nombre, ApeidoP))
                    Toast.makeText(getActivity(), "Inserte todo los datos", Toast.LENGTH_LONG).show();
                else
                    callback.sendDataFR2(Nombre, ApeidoP, ApeidoM);
            }
        });
        return view;
    }

    private boolean isValidData(String Nombre, String ApeidoP) {

        return !TextUtils.isEmpty(Nombre) && !TextUtils.isEmpty(ApeidoP);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (FragmentRegistro_02.DataListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
    }

    public interface DataListener {
        void sendDataFR2(String Nombre, String ApeidoP, String ApeidoM);
    }
}
