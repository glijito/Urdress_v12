package com.example.xdd.urdress_v1.ApiDressWeb.presentador.desencadenadores;


import com.example.xdd.urdress_v1.ApiDressWeb.interfaces.Contrato;

public class TrigerDatosService implements Contrato.TrigerServiceListener {

    private Contrato.VistaActivity vistaInicio;

    @Override
    public void setVista(Contrato.VistaActivity vista) {
        vistaInicio=vista;
    }

    @Override
    public void onServerError() {
        vistaInicio.setConexionErrorUser("[Problemas de servidor,disculpa las molestias]");
    }

    @Override
    public void onNetWorkError() {
        vistaInicio.setConexionErrorUser("[Sin conexion a internet, verifique su conexion]");
    }

    @Override
    public void getDataConectedWebDress() {

    }

}
