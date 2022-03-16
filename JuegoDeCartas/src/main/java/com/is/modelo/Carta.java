package com.is.modelo;

public class Carta {

    int idCarta,ataque,defensa,valor;
    String nombre,descripcion,tipo,nombre_juego,atributo;

    public Carta() {
    }

    public Carta(int idCarta, int ataque, int defensa, int valor, String nombre, String descripcion, String tipo, String nombre_juego, String atributo) {
        this.idCarta = idCarta;
        this.ataque = ataque;
        this.defensa = defensa;
        this.valor = valor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.nombre_juego = nombre_juego;
        this.atributo = atributo;
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

    public String getNombre_juego() {
        return nombre_juego;
    }

    public void setNombre_juego(String nombre_juego) {
        this.nombre_juego = nombre_juego;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }


}
