package com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xdd.urdress_v1.R;

public class FragmentPublicarVestido_1 extends Fragment {

    private Datalistener callback;
    private Button cancelar;

    public FragmentPublicarVestido_1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__publicar_vestido_1, container, false);
        try {
            this.callback = (FragmentPublicarVestido_1.Datalistener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }

        cancelar = (Button) view.findViewById(R.id.Cancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendPublicar1("Cancelar");
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.callback = (FragmentPublicarVestido_1.Datalistener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }
    }

    public interface Datalistener{
        void sendPublicar1(String fragmento);
    }

}
