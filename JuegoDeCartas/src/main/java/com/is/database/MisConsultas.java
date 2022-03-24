package com.is.database;

import com.is.modelo.Juegos;
import com.is.modelo.Carta;
import com.is.modelo.Cartaj; //aquí
import com.is.modelo.Juegos;
import com.is.modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MisConsultas {

    public Collection<Persona> consulta(String nombres) {
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = " SELECT * ";
        sql = sql + " FROM powercards.persona where nickname like '%" + nombres + "%' ";
        sql = sql + " order by 1 asc ";

        System.out.println("sql=" + sql);

        Vector<Persona> listado = new Vector<Persona>();
        try {
            Connection conne = BaseDatos.getConecction();
            pstatement = conne.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {

                Persona persona = new Persona();
                persona.setNickname(resultSet.getString(1));
                persona.setContraseña(resultSet.getString(2));
                persona.setRol(resultSet.getString(3));

                listado.add(persona);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;

    }

    public Collection<Persona> consulta() {
        ResultSet resultSet = null;
        String sql = " SELECT *";
        sql = sql + " FROM powercards.persona ";

        Vector<Persona> listado = new Vector<Persona>();
        try {
            Connection conne = BaseDatos.getConecction();
            ps = conne.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Persona persona = new Persona();
                persona.setNickname(resultSet.getString(1));
                persona.setContraseña(resultSet.getString(2));
                persona.setRol(resultSet.getString(3));

                listado.add(persona);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;

    }

    public static Collection<Cartaj> consultac() {
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = "select *from carta";

        Vector<Cartaj> listar = new Vector<Cartaj>();
        try {
            Connection conne = BaseDatos.getConecction();
        } catch (SQLException ex) {

        }
        return null;
    }

    PreparedStatement ps = null;

    public Collection<Juegos> consulta_juego() {

        ResultSet resultSet = null;
        String sql = " SELECT *";
        sql = sql + " FROM powercards.juego ";

        Vector<Juegos> listado = new Vector<Juegos>();
        try {
            Connection conne = BaseDatos.getConecction();
            ps = conne.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Juegos juego = new Juegos();
                juego.setNombre(resultSet.getString(1));
                juego.setDescripcion(resultSet.getString(2));
                juego.setTotal_cartas(resultSet.getInt(3));
                juego.setFoto(resultSet.getBytes(4));
                listado.add(juego);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Juegos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;

    }

    public boolean insertarUser(Persona per) throws SQLException {
        int res = 0;
        Connection conne = BaseDatos.getConecction();
        PreparedStatement pstatement = null;
        ResultSet resulSet = null;
        String sql = "";
        sql = "insert into powercards.persona VALUES (";

        sql = sql + "'" + per.getNickname() + "',";
        sql = sql + "'" + per.getContraseña() + "',";
        sql = sql + "'jugador')";

        System.out.println("sql=" + sql);
        pstatement = conne.prepareStatement(sql);
        res = pstatement.executeUpdate();
        System.out.println(res);
        try {
            if (res == 1) {
                conne.commit();
                return true;
            } else {
                System.out.println("Error al insertar");
                conne.rollback();
                return false;
            }
        } catch (SQLException ex) {
            conne.rollback();
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int consultaid() {
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = " SELECT *";
        sql = sql + " FROM powercards.carta ";
        sql = sql + " order by idCarta asc";
        int id = 0;
        Vector<Cartaj> listado = new Vector<Cartaj>();
        try {
            Connection conne = BaseDatos.getConecction();
            pstatement = conne.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {

                Cartaj carta = new Cartaj();
                carta.setIdCarta(resultSet.getInt(1));

                listado.add(carta);
                id = carta.getIdCarta();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

}
