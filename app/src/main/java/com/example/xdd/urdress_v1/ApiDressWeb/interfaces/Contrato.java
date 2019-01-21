package com.example.xdd.urdress_v1.ApiDressWeb.interfaces;


public interface Contrato {

     interface TrigerServiceListener {
        void setVista(VistaActivity vista);
        void onServerError();
        void onNetWorkError();
        void getDataConectedWebDress();
    }

     interface VistaActivity {
        void setConexionErrorUser(String mensaje);
        void setLoadButtonsActivitys(String opcion);
        void setMenuUser();
        void setRecyclerViewDressInit();
    }

}
