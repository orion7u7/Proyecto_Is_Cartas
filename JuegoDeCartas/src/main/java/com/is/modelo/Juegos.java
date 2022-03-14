/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is.modelo;

import java.awt.Image;

/**
 *
 * @author oguev
 */
public class Juegos {

    String nombre, descripcion;
    int total_cartas;
    Image imagen;

    public Juegos() {
    }

    public Juegos(String nombre, String descripcion, int total_cartas, Image imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.total_cartas = total_cartas;
        this.imagen = imagen;
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

    public int getTotal_cartas() {
        return total_cartas;
    }

    public void setTotal_cartas(int total_cartas) {
        this.total_cartas = total_cartas;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

}
