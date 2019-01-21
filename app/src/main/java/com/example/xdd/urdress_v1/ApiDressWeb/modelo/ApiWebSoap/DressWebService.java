package com.example.xdd.urdress_v1.ApiDressWeb.modelo.ApiWebSoap;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class DressWebService extends AsyncTask<String,Integer,Integer> {

    private int operationService=0;
    private boolean result;
    private String mensaje;
    private boolean continuar;
    private int id=0;

    public DressWebService(){}

    public void altaUsuarioSystem(int operacionService,String correo, String password, String nombre, String apeidop, String apeidom, String numero){
        this.operationService=operacionService;
        doInBackground(correo,password,nombre,apeidop,apeidom,numero);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }

    @Override
    protected Integer doInBackground(String... strings) {
        switch(operationService){
            case 1:
                altaUsuario(strings);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                Log.e("OPC","sin opcion sin escoger");
        }
        return 1;
    }


    private void altaUsuario(String... strings) {

        String MAINURL = "http://drees.siidmex.com.mx/wsAppDress.asmx";
        String METHODNAME = "altaUsuario ";
        String SOAP_ACTION = "http://tempuri.org/altaUsuario";
        String NAMESPACE = "http://tempuri.org/";
        SoapObject resultsString;

        try {
            SoapObject request = new SoapObject(NAMESPACE, METHODNAME);
            request.addProperty("pidPerfil", 2);
            request.addProperty("pidTipoUsuario", 3);
            request.addProperty("pCorreoElectronico", strings[0]);
            request.addProperty("pUsuario", strings[0]);
            request.addProperty("pContrasenia", strings[1]);
            request.addProperty("pPrimerNombre", strings[2]);
            request.addProperty("pSegundoNombre", "");
            request.addProperty("pApellidoPaterno", strings[3]);
            request.addProperty("pApellidoMaterno", strings[4]);
            request.addProperty("pCelular", strings[5]);
            request.addProperty("pCalle", "");
            request.addProperty("pNumeroExterior", "");
            request.addProperty("pNumerointerior", "");
            request.addProperty("pidPais", 1);
            request.addProperty("pidCodigoPostal", 0);
            request.addProperty("pidColonia", 0);
            request.addProperty("pidMunicipio", 0);
            request.addProperty("pidEstado", 15);
            request.addProperty("pidTipoDispositivo", 3);
            request.addProperty("pToke", "informacion");

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = true;
            soapEnvelope.setAddAdornments(false);
            soapEnvelope.setOutputSoapObject(request);

            HttpTransportSE transport = new HttpTransportSE(MAINURL);
            transport.debug = true;
            transport.call(SOAP_ACTION, soapEnvelope);

            resultsString = (SoapObject) soapEnvelope.getResponse();
            id = Integer.parseInt(resultsString.getPrimitivePropertyAsString("id"));
            mensaje = resultsString.getPrimitivePropertyAsString("mensaje");
            continuar = Boolean.parseBoolean(resultsString.getPrimitivePropertyAsString("continuar"));
        } catch (Exception e) {
            Log.e("Error ", "PROBLEMA:" + e.getMessage());
            result = false;
        }
    }

}
