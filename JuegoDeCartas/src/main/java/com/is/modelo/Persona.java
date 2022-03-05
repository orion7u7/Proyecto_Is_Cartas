package com.is.modelo;

public class Persona {

    int identificacion;
    String nombres;
    String apellidos;
    String direccionEmail;
    String contra;

    public Persona() {
        this.nombres = "";
        this.apellidos = "";
        this.direccionEmail = "";
        this.contra = "";
    }

    public Persona(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccionEmail = "";
        this.contra = "";
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
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

    public String getDireccionEmail() {
        return direccionEmail;
    }

    public void setDireccionEmail(String direccionEmail) {
        this.direccionEmail = direccionEmail;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String telefono) {
        this.contra = telefono;
    }

}
