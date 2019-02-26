package com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.xdd.urdress_v1.R;

public class FragmentInicio extends Fragment {

    private DataListener callback;
    private ImageView menu;
    private ImageButton publicarVestido;
    private ImageButton rentarVestido;


    public FragmentInicio() {    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__inicio, container, false);
        try {
            callback = (DataListener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }

        menu = (ImageView) view.findViewById(R.id.menu);
        publicarVestido = (ImageButton) view.findViewById(R.id.btn_publicar_vestido);
        rentarVestido = (ImageButton) view.findViewById(R.id.btn_rentar_vestido);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendInicio("menu");
            }
        });

        publicarVestido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendInicio("publicar");
            }
        });

        rentarVestido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendInicio("rentar");
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (DataListener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }
    }

    public interface DataListener {
        void sendInicio(String fragmento);
    }
}
