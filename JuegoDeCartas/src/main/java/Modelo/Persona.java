package Modelo;

public class Persona {
String nickname,contraseña,rol;

    public Persona() {
    }

    public Persona(String nickname, String contraseña, String rol) {
        this.nickname = nickname;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
