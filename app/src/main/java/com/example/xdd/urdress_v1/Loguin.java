package com.example.xdd.urdress_v1;

import java.util.Map;

import bolts.Task;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Loguin {
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/wsAppDress.asmx/loguin")
    Call<Task> getIni(@Field(value="contrasenia",encoded = true) String contrasenia,
                      @Field(value="dato",encoded = true) String dato,
                      @Field(value="esFacebook",encoded = true) String esFacebook,
                      @Field(value="idTipoDispositivo",encoded = true) String idTipoDispositivo,
                      @Field(value="idTipoLoguin",encoded = true) String idTipoLoguin,
                      @Field(value="idTipoUsuario" ,encoded = true) String idTipoUsuario,
                      @Field(value="tokenDispositivo",encoded = true) String tokenDispositivo);
}
