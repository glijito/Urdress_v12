package com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.xdd.urdress_v1.ApiDressWeb.modelo.ApiWebSoap.MyVerificationListener;
import com.example.xdd.urdress_v1.R;
import com.sinch.verification.Config;
import com.sinch.verification.SinchVerification;
import com.sinch.verification.Verification;
import com.sinch.verification.VerificationListener;

public class FragmentRegistro_05 extends Fragment {

    private DataListener callback;
    private EditText Telefono;
    private ImageButton Terminar;

    public FragmentRegistro_05() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_05, container, false);

        try {
            callback = (FragmentRegistro_05.DataListener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }

        Telefono = (EditText) view.findViewById(R.id.eTelefono);
        Terminar = (ImageButton) view.findViewById(R.id.ibFinalizar);

        Terminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Numero = Telefono.getText().toString();
                if(!isValidPhone(Numero))
                    Toast.makeText(getActivity(),"Inserte un telefono valido", Toast.LENGTH_LONG).show();
                else
                    startVerification(Numero);
            }
        });

        return view;

    }

    private void startVerification(String phoneNumber){
        String telefono="+52"+phoneNumber;
        String resultado=null;
        Config config = SinchVerification.config().applicationKey("645161d2-7154-46a8-8ab2-6954dad7bdf5").context(getActivity()).build();
        VerificationListener listener = new MyVerificationListener(getActivity());
        Verification verification = SinchVerification.createFlashCallVerification(config, telefono, resultado, listener);
        verification.initiate();

        Toast.makeText(getActivity(), resultado,Toast.LENGTH_LONG).show();
    }

    private boolean isValidPhone(String Numero){
        return !TextUtils.isEmpty(Numero) && Patterns.PHONE.matcher(Numero).matches() && Numero.length()==10;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    public interface DataListener {
        void sendDataFR5(String numero);
    }
}
