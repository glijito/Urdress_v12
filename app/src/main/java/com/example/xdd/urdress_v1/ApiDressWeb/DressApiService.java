package com.example.xdd.urdress_v1.ApiDressWeb;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class DressApiService extends AsyncTask<String,Integer,Boolean> {

    private String mensajeSoap;
    private boolean result;
    private Application context;

    public DressApiService(String mensajeSoap, boolean result, Application context) {
        this.mensajeSoap = mensajeSoap;
        this.result = result;
        this.context = context;
    }

    public DressApiService(Application context) {
        this(null, true, context);
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        loguinUsuario();
        return result;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (aBoolean) {
            Toast.makeText(context, "Resultado: " + mensajeSoap, Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(context, "Error al obtener el dato, revise", Toast.LENGTH_LONG).show();
    }

    private void loguinUsuario() {

        String MAINURL = "http://drees.siidmex.com.mx/wsAppDress.asmx";
        String METHODNAME = "loguin";
        String SOAP_ACTION = "http://tempuri.org/loguin";
        String NAMESPACE = "http://tempuri.org/";
        SoapObject resultsString;

        try {
            SoapObject request = new SoapObject(NAMESPACE, METHODNAME);
            request.addProperty("contrasenia", "Prueba123");
            request.addProperty("dato", "morsalmir@gmail.com");
            request.addProperty("esFacebook", false);
            request.addProperty("idTipoDispositivo", 2);
            request.addProperty("idTipoLoguin", 1);
            request.addProperty("idTipoUsuario", 3);
            request.addProperty("tokenDispositivo", "xdd");

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = true;
            soapEnvelope.setAddAdornments(false);
            soapEnvelope.setOutputSoapObject(request);

            HttpTransportSE transport = new HttpTransportSE(MAINURL);
            transport.debug = true;
            transport.call(SOAP_ACTION, soapEnvelope);

            resultsString = (SoapObject) soapEnvelope.getResponse();
            mensajeSoap = resultsString.getPrimitivePropertyAsString("Mensaje");
        } catch (Exception e) {
            Log.e("Error ", "PROBLEMA:" + e.getMessage());
            result = false;
        }
    }

}