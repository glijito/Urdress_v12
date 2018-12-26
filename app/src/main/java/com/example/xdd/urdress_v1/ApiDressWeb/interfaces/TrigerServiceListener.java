package com.example.xdd.urdress_v1.ApiDressWeb.interfaces;

public interface TrigerServiceListener {

    void onServerError();
    void onNetWorkError();
    void onFailedDressSearch();
    void onSucessDressSearch();

}
