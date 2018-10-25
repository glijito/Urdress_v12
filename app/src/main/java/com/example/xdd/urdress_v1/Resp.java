package com.example.xdd.urdress_v1;

public class Resp {
    String idUsuario;
    String Mensaje;
    String Usuario;
    String Alias;
    String Nombre;
    String Acceso;

    Resp(){}

    public Resp(String idUsuario, String mensaje, String usuario, String alias, String nombre, String acceso) {
        this.idUsuario = idUsuario;
        Mensaje = mensaje;
        Usuario = usuario;
        Alias = alias;
        Nombre = nombre;
        Acceso = acceso;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAcceso() {
        return Acceso;
    }

    public void setAcceso(String acceso) {
        Acceso = acceso;
    }
}
