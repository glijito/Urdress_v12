package com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xdd.urdress_v1.R;

public class FragmentInicio extends Fragment {

    DataListener callback;
    private Button btnCerrarSesion;
    private Button btnPerfil;

    public FragmentInicio() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__inicio, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (DataListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (DataListener) activity;
        } catch (Exception e) {
            throw new ClassCastException(activity.toString() + " should implement DataListener");
        }
    }

    public interface DataListener {
        void sendDataInicio(boolean opcion);
    }

}
