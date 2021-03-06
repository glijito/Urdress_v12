package com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.xdd.urdress_v1.R;


public class FragmentRegistro_04 extends Fragment {

    private DataListener callback;
    private ImageButton Foto;

    public FragmentRegistro_04() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_04, container, false);
        Foto = (ImageButton) view.findViewById(R.id.Foto);

        try {
            callback = (FragmentRegistro_04.DataListener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }

        Foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendDataFR4("Foto");
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public interface DataListener {
        void sendDataFR4(String Foto);
    }

}
