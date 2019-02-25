package com.example.xdd.urdress_v1.ApiDressWeb.vista.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xdd.urdress_v1.ApiDressWeb.modelo.ApiWebSoap.MyVerificationListener;
import com.example.xdd.urdress_v1.R;
import com.sinch.verification.CodeInterceptionException;
import com.sinch.verification.Config;
import com.sinch.verification.InitiationResult;
import com.sinch.verification.InvalidInputException;
import com.sinch.verification.ServiceErrorException;
import com.sinch.verification.SinchVerification;
import com.sinch.verification.Verification;
import com.sinch.verification.VerificationListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentRegistro_05 extends Fragment {

    private DataListener callback;
    private EditText Telefono;
    private ImageButton Terminar;
    private ImageButton btnVerificacion;
    private EditText codigoVerification;
    private Verification verification;
    String Numero;

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
        final View view = inflater.inflate(R.layout.fragment_registro_05, container, false);

        try {
            callback = (FragmentRegistro_05.DataListener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " should implement DataListener");
        }

        Telefono = (EditText) view.findViewById(R.id.eTelefono);
        Terminar = (ImageButton) view.findViewById(R.id.ibFinalizar);
        btnVerificacion = (ImageButton) view.findViewById(R.id.Codigo);
        codigoVerification = (EditText) view.findViewById(R.id.Codigover);

        btnVerificacion.setVisibility(view.GONE);
        cambiarEstado(view,view.GONE);
        btnVerificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = codigoVerification.getText().toString();
                verification.verify(code);
            }
        });

        Terminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Numero = Telefono.getText().toString();
                if(!isValidPhone(Numero))
                    Toast.makeText(getActivity(),"Inserte un telefono valido", Toast.LENGTH_LONG).show();
                else{
                    startVerification(Numero);
                    cambiarEstado(view, view.VISIBLE);
                    Terminar.setVisibility(view.GONE);
                    btnVerificacion.setVisibility(view.VISIBLE);
                }

            }
        });
        return view;

    }

    private void cambiarEstado(View view, int estado){
        ImageView rectangle_108_= (ImageView) view.findViewById(R.id.rectangle_108_);
        TextView txtMovil_ = (TextView) view.findViewById(R.id.txtMovil_);
        ImageView imgCelular_= (ImageView) view.findViewById(R.id.imgCelular_);
        EditText Codigover = (EditText) view.findViewById(R.id.Codigover);

        rectangle_108_.setVisibility(estado);
        txtMovil_.setVisibility(estado);
        imgCelular_.setVisibility(estado);
        Codigover.setVisibility(estado);
    }

    private void startVerification(String phoneNumber){
        String telefono="+52"+phoneNumber;
        String resultado=null;
        Config config = SinchVerification.config().applicationKey("645161d2-7154-46a8-8ab2-6954dad7bdf5").context(getActivity()).build();
        VerificationListener listener = new MyVerificationListener(getActivity());
        List<String> languages = new ArrayList();
        languages.add("es-ES");
        verification = SinchVerification.createSmsVerification(config, telefono, null, languages, new VerificationListener() {
            @Override
            public void onInitiated(InitiationResult initiationResult) {    }

            @Override
            public void onInitiationFailed(Exception e) {
                if (e instanceof InvalidInputException) {
                    Toast.makeText(getActivity(),"El numero puesto es invalido",Toast.LENGTH_LONG).show();
                } else if (e instanceof ServiceErrorException) {
                    Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(),"Error, checa tu conexion a la red", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onVerified() {
                Toast.makeText(getActivity(), "Verificacion Correcta", Toast.LENGTH_SHORT).show();
                callback.sendDataFR5(Numero);
            }

            @Override
            public void onVerificationFailed(Exception e) {
                if (e instanceof CodeInterceptionException) {
                    Toast.makeText(getActivity(),"Enviando Mensaje",Toast.LENGTH_LONG).show();
                } else if (e instanceof ServiceErrorException) {
                    Toast.makeText(getActivity(), "Error en el servicio",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(),"Error, checa tu conexion a la red", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onVerificationFallback() {

            }
        });
        verification.initiate();
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
