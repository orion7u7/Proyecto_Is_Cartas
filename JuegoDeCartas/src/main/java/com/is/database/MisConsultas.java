package com.is.database;

import com.is.modelo.Juegos;
import com.is.modelo.Carta;
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

/**
 *
 * @author pc-eis
 */
public class MisConsultas {

    public Collection<Persona> consulta(String nombres) {
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = " SELECT * ";
        sql = sql + " FROM persona where nickname like '%" + nombres + "%' ";
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
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = " SELECT nickname,contraseña,rol  ";
        sql = sql + " FROM powercards.persona ";
        sql = sql + " order by 1 asc ";

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

    public boolean insertarCarta(Carta carta) throws SQLException {
        int res = 0;
        Connection conne = BaseDatos.getConecction();
        PreparedStatement pstatement = null;
        ResultSet resulSet = null;
        String sql = "";
        sql = "insert into powercards.persona (nombre,descripcion,ataque,defensa,tipo,Juego_nombre,atributo,valor) VALUES (";

        sql = sql + "'" + carta.getNombre() + "'";
        sql = sql + "'" + carta.getDescripcion() + "'";
        sql = sql + carta.getAtaque();
        sql = sql + carta.getDefensa();
        sql = sql + "'" + carta.getTipo() + "'";
        sql = sql + "'" + carta.getNombre_juego() + "'";
        sql = sql + "'" + carta.getAtributo() + "'";
        sql = sql + carta.getValor() + ")";

        System.out.println("sql=" + sql);
        pstatement = conne.prepareStatement(sql);
        res = pstatement.executeUpdate();
        try {
            if (res == 1) {
                conne.commit();
                return true;
            } else {
                System.out.println("Error al actualizar");
                conne.rollback();
                return false;
            }
        } catch (SQLException ex) {
            conne.rollback();
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
int r;
    public int Agregar(Carta carta) {
        String sentencia = "INSERT INTO powercards.carta (nombre,descripcion,ataque,defensa,tipo,Juego_nombre,atributo,valor) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = null;
            Connection con = BaseDatos.getConecction();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, carta.getNombre());
            ps.setString(2, carta.getDescripcion());
            ps.setInt(3, carta.getAtaque());
            ps.setInt(4, carta.getDefensa());
            ps.setString(5, carta.getTipo());
            ps.setString(6, carta.getNombre_juego());
            ps.setString(7, carta.getAtributo());
            ps.setInt(8, carta.getValor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MisConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Collection<Juegos> consulta_juego() {
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = " SELECT *";
        sql = sql + " FROM powercards.juego ";

        Vector<Juegos> listado = new Vector<Juegos>();
        try {
            Connection conne = BaseDatos.getConecction();
            pstatement = conne.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
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
}
