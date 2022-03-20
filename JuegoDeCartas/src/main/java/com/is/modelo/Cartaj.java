
package com.is.modelo;

import java.io.InputStream;

/**
 *
 * @author Laptop
 */
public class Cartaj {
    int idCarta,ataque,defensa,valor;
    String nombre,descripcion,tipo,Juego_nombre,atributo;
    InputStream foto;
    
    public Cartaj(){
    }

    public Cartaj(int idCarta, int ataque, int defensa, int valor, String nombre, String descripcion, String tipo, String Juego_nombre, String atributo, InputStream foto) {
        this.idCarta = idCarta;
        this.ataque = ataque;
        this.defensa = defensa;
        this.valor = valor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.Juego_nombre = Juego_nombre;
        this.atributo = atributo;
        this.foto = foto;
    }

    public int getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getJuego_nombre() {
        return Juego_nombre;
    }

    public void setJuego_nombre(String Juego_nombre) {
        this.Juego_nombre = Juego_nombre;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }
    
    
    
    
}
