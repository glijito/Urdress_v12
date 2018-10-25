package com.example.xdd.urdress_v1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AltaUsuario {
   // GET /wsAppDress.asmx/altaUsuario?
    // pidPerfil=string&
    // pidTipoUsuario=string&
    // pCorreoElectronico=string&
    // pUsuario=string&
    // pContrasenia=string&
    // pPrimerNombre=string&
    // pSegundoNombre=string&
    // pApellidoPaterno=string&
    // pApellidoMaterno=string&
    // pCelular=string&
    // pCalle=string&
    // pNumeroExterior=string&
    // pNumerointerior=string&
    // pidPais=string&
    // pidCodigoPostal=string&
    // pidColonia=string&
    // pidMunicipio=string&
    // pidEstado=string&
    // pidTipoDispositivo=string&
    // pToke=string
    // HTTP/1.1
   @Headers({
           "Content-Length: 500",
           "Content-Type: application/x-www-form-urlencoded"
   })
   @GET("altaUsuario?pidPerfil=0")
   Call<Resp> getUsu(@Query("pidTipoUsuario") int pidTipoUsuario,
                     @Query("pCorreoElectronico") String pCorreoElectronico,
                     @Query("pUsuario") String pUsuario,
                     @Query("pContrasenia") String pContrasenia,
                     @Query("pPrimerNombre") String pPrimerNombre,
                     @Query("pSegundoNombre") String pSegundoNombre,
                     @Query("pApellidoPaterno") String pApellidoPaterno,
                     @Query("pApellidoMaterno") String pApellidoMaterno,
                     @Query("pCelular") String pCelular,
                     @Query("pCalle") String pCalle,
                     @Query("pNumeroExterior") String pNumeroExterior,
                     @Query("pNumerointerior") String pNumerointerior,
                     @Query("pidPais") int pidPais,
                     @Query("pidCodigoPostal") int pidCodigoPostal,
                     @Query("pidColonia") int pidColonia,
                     @Query("pidMunicipio") int pidMunicipio,
                     @Query("pidEstado") int pidEstado,
                     @Query("pidTipoDispositivo") int pidTipoDispositivo,
                     @Query("pToke") String pToke);
}