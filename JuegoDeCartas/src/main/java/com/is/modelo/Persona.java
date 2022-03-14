package com.is.modelo;

public class Persona {

    
    String nickname,rol,contraseña;

    public Persona() {
    }

    public Persona(String nickname, String rol, String contraseña) {
        this.nickname = nickname;
        this.rol = rol;
        this.contraseña = contraseña;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
}
