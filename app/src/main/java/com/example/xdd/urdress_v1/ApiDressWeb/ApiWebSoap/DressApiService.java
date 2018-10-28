package com.example.xdd.urdress_v1.ApiDressWeb.ApiWebSoap;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class DressApiService extends AsyncTask<String,Integer,Boolean> {

    private SharedPreferences prefs;
    private String Mensaje;
    private int id=0;
    private String Nombre=null;
    private int Acceso=0;
    private boolean result;
    private Application context;
    private String Contrasenia;
    private String Dato;
    private boolean esFacebook;
    private int TipoUsuario;


    public DressApiService(String mensajeSoap, boolean result, Application context, String contrasenia, String dato, boolean esFacebook, int tipoUsuario) {
        this.Mensaje = mensajeSoap;
        this.result = result;
        this.context = context;
        Contrasenia = contrasenia;
        Dato = dato;
        this.esFacebook = esFacebook;
        TipoUsuario = tipoUsuario;

    }

    public DressApiService(Application context,String contrasenia, String dato, boolean esFacebook, int tipoUsuario) {
        this(null, true, context, contrasenia, dato, esFacebook, tipoUsuario);
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        loguinUsuario();
        return result;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (aBoolean) {
            Toast.makeText(context, "Resultado: " + id, Toast.LENGTH_LONG).show();

        } else
            Toast.makeText(context, "Error al obtener el dato, revise", Toast.LENGTH_LONG).show();
    }

    private void loguinUsuario() {

        String MAINURL = "http://drees.siidmex.com.mx/wsAppDress.asmx";
        String METHODNAME = "loguin";
        String SOAP_ACTION = "http://tempuri.org/loguin";
        String NAMESPACE = "http://tempuri.org/";

        try {
            SoapObject request = new SoapObject(NAMESPACE, METHODNAME);
            request.addProperty("contrasenia", Contrasenia);
            request.addProperty("dato", Dato);
            request.addProperty("esFacebook", esFacebook);
            request.addProp       SoapObject resultsString;
erty("idTipoDispositivo", 3);
            request.addProperty("idTipoLoguin", 1);
            request.addProperty("idTipoUsuario", TipoUsuario);
            request.addProperty("tokenDispositivo", "xdd");

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = true;
            soapEnvelope.setAddAdornments(false);
            soapEnvelope.setOutputSoapObject(request);

            HttpTransportSE transport = new HttpTransportSE(MAINURL);
            transport.debug = true;
            transport.call(SOAP_ACTION, soapEnvelope);

            resultsString = (SoapObject) soapEnvelope.getResponse();
            Mensaje = resultsString.getPrimitivePropertyAsString("Mensaje");
            id = Integer.parseInt(resultsString.getPrimitivePropertyAsString("IdUsuario"));
            Nombre = resultsString.getPrimitivePropertyAsString("Nombre");
            Acceso = Integer.parseInt(resultsString.getPrimitivePropertyAsString("Acceso"));
        } catch (Exception e) {
            Log.e("Error ", "PROBLEMA:" + e.getMessage());
            result = false;
        }
    }
}