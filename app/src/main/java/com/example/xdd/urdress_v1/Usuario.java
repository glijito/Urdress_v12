package com.example.xdd.urdress_v1;

import com.google.gson.annotations.Expose;

public class Usuario {

    @Expose
    private String Usuario;
    private int idPerfil;
    private int idTipoUsuario;
    private String CorreoElectronico;
    private String Contrasenia;
    private String PrimerNombre;
    private String SegundoNombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String Celular;
    private String Calle;
    private String NumeroExterior;
    private String NumeroInterior;
    private int idPais;
    private int CodigoPostal;
    private int idColonia;
    private int idMunicipio;
    private int idEstado;
    private int idTipoDispositivo;
    private String toke;

    public Usuario(){

    }

    public Usuario(String usuario, int idPerfil, int idTipoUsuario, String correoElectronico, String contrasenia, String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, String celular, String calle, String numeroExterior, String numeroInterior, int idPais, int codigoPostal, int idColonia, int idMunicipio, int idEstado, int idTipoDispositivo, String toke) {
        this.Usuario = usuario;
        this.idPerfil = idPerfil;
        this.idTipoUsuario = idTipoUsuario;
        this.CorreoElectronico = correoElectronico;
        this.Contrasenia = contrasenia;
        this.PrimerNombre = primerNombre;
        this.SegundoNombre = segundoNombre;
        this.ApellidoPaterno = apellidoPaterno;
        this.ApellidoMaterno = apellidoMaterno;
        this.Celular = celular;
        this.Calle = calle;
        this.NumeroExterior = numeroExterior;
        this.NumeroInterior = numeroInterior;
        this.idPais = idPais;
        this.CodigoPostal = codigoPostal;
        this.idColonia = idColonia;
        this.idMunicipio = idMunicipio;
        this.idEstado = idEstado;
        this.idTipoDispositivo = idTipoDispositivo;
        this.toke = toke;
    }

    public String getUsuario() {
        return Usuario;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        CorreoElectronico = correoElectronico;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public String getNumeroExterior() {
        return NumeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        NumeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return NumeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        NumeroInterior = numeroInterior;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        CodigoPostal = codigoPostal;
    }

    public int getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(int idColonia) {
        this.idColonia = idColonia;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdTipoDispositivo() {
        return idTipoDispositivo;
    }

    public void setIdTipoDispositivo(int idTipoDispositivo) {
        this.idTipoDispositivo = idTipoDispositivo;
    }

    public String getToke() {
        return toke;
    }

    public void setToke(String toke) {
        this.toke = toke;
    }
}