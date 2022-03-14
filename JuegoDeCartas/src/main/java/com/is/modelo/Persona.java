package com.is.modelo;

public class Persona {

    Double identificacion;
    String nombres;
    String apellidos;
    String usuario;
    String direccionEmail;
    String telefono;

    public Persona() {
        this.identificacion = 0.0;
        this.nombres = "";
        this.apellidos = "";
        this.usuario = "";
        this.direccionEmail = "";
        this.telefono = "";
    }

    public Persona(Double identificacion, String nombres, String apellidos) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = "";
        this.direccionEmail = "";
        this.telefono = "";
    }

    public Double getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Double identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDireccionEmail() {
        return direccionEmail;
    }

    public void setDireccionEmail(String direccionEmail) {
        this.direccionEmail = direccionEmail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
