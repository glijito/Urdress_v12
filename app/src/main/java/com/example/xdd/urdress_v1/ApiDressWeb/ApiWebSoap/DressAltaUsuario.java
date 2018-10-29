package com.example.xdd.urdress_v1.ApiDressWeb.ApiWebSoap;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class DressAltaUsuario extends AsyncTask<String,Integer,Integer> {

    private SharedPreferences prefs;

    private boolean result;
    private Application context;

    private int id=0;
    private String Mensaje;
    private boolean Continuar;

    private String Correo;
    private String Password;
    private String Nombre;
    private String ApeidoP;
    private String ApeidoM;
    private String Telefono;


    public DressAltaUsuario(String mensajeSoap, boolean result, Application context, String Correo, String Password, String Nombre, String ApeidoP, String ApeidoM, String Numero) {
        this.Mensaje = mensajeSoap;
        this.result = result;
        this.context = context;
        this.Correo=Correo;
        this.Password = Password;
        this.Nombre = Nombre;
        this.ApeidoP = ApeidoP;
        this.ApeidoM = ApeidoM;
        this.Telefono = Numero;
    }

    public DressAltaUsuario(Application context, String Correo, String Password, String Nombre, String ApeidoP, String ApeidoM, String Numero) {
        this(null, true, context, Correo, Password, Nombre, ApeidoP, ApeidoM, Numero);
    }

    @Override
    protected Integer doInBackground(String... strings) {
        altaUsuario();
        return id;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }

    private void altaUsuario() {

        String MAINURL = "http://drees.siidmex.com.mx/wsAppDress.asmx";
        String METHODNAME = "altaUsuario ";
        String SOAP_ACTION = "http://tempuri.org/altaUsuario";
        String NAMESPACE = "http://tempuri.org/";
        SoapObject resultsString;

        try {
            SoapObject request = new SoapObject(NAMESPACE, METHODNAME);
            request.addProperty("pidPerfil", 2);
            request.addProperty("pidTipoUsuario", 3);
            request.addProperty("pCorreoElectronico", this.Correo);
            request.addProperty("pUsuario", this.Correo);
            request.addProperty("pContrasenia", this.Password);
            request.addProperty("pPrimerNombre", this.Nombre);
            request.addProperty("pSegundoNombre", "");
            request.addProperty("pApellidoPaterno", this.ApeidoP);
            request.addProperty("pApellidoMaterno", this.ApeidoM);
            request.addProperty("pCelular", this.Telefono);
            request.addProperty("pCalle", "");
            request.addProperty("pNumeroExterior", "");
            request.addProperty("pNumerointerior", "");
            request.addProperty("pidPais", 1);
            request.addProperty("pidCodigoPostal", 0);
            request.addProperty("pidColonia", 0);
            request.addProperty("pidMunicipio", 0);
            request.addProperty("pidEstado", 15);
            request.addProperty("pidTipoDispositivo", 3);
            request.addProperty("pToke", "XDD");

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = true;
            soapEnvelope.setAddAdornments(false);
            soapEnvelope.setOutputSoapObject(request);

            HttpTransportSE transport = new HttpTransportSE(MAINURL);
            transport.debug = true;
            transport.call(SOAP_ACTION, soapEnvelope);

            resultsString = (SoapObject) soapEnvelope.getResponse();
            id = Integer.parseInt(resultsString.getPrimitivePropertyAsString("id"));
            Mensaje = resultsString.getPrimitivePropertyAsString("mensaje");
            Continuar = Boolean.parseBoolean(resultsString.getPrimitivePropertyAsString("continuar"));
        } catch (Exception e) {
            Log.e("Error ", "PROBLEMA:" + e.getMessage());
            result = false;
        }
    }
}