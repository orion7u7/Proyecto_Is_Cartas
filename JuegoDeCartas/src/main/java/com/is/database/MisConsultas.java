package com.is.database;

import com.is.modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;

/**
 *
 * @author pc-eis
 */
public class MisConsultas {

    public Collection<Persona> consulta(String nombres) {
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = " SELECT id,nombre,apellido,email,contraseña ";
        sql = sql + " FROM persona where nombres like '%" + nombres + "%' ";
        sql = sql + " order by id asc ";

        System.out.println("sql=" + sql);

        Vector<Persona> listado = new Vector<Persona>();
        try {
            Connection conne = BaseDatos.getConecction();
            pstatement = conne.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {

                Persona persona = new Persona(resultSet.getString(2), resultSet.getString(3));
                persona.setIdentificacion(resultSet.getInt(1));
                persona.setDireccionEmail(resultSet.getString(4));
                persona.setContra(resultSet.getString(5));

                listado.add(persona);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;

    }

    public static LinkedList<Persona> consulta() {
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = " SELECT id,nombre,apellido,email,contraseña  ";
        sql = sql + " FROM quiz_jsp.persona ";
        sql = sql + " order by id asc ";

        LinkedList<Persona> listado = new LinkedList<Persona>();
        try {
            Connection conne = BaseDatos.getConecction();
            pstatement = conne.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {

                Persona persona = new Persona(resultSet.getString(2), resultSet.getString(3));
                persona.setIdentificacion(resultSet.getInt(1));
                persona.setDireccionEmail(resultSet.getString(4));
                persona.setContra(resultSet.getString(5));

                listado.add(persona);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;

    }

    public int consultaid() {
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = " SELECT id,nombre,apellido,email,contraseña ";
        sql = sql + " FROM quiz_jsp.persona ";
        sql = sql + " order by id asc";
        int id = 0;
        Vector<Persona> listado = new Vector<Persona>();
        try {
            Connection conne = BaseDatos.getConecction();
            pstatement = conne.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {

                Persona persona = new Persona(resultSet.getString(2), resultSet.getString(3));
                persona.setIdentificacion(resultSet.getInt(1));
                persona.setDireccionEmail(resultSet.getString(4));
                persona.setContra(resultSet.getString(5));

                listado.add(persona);
                id = persona.getIdentificacion();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    private boolean updatePersona(Persona persona) throws SQLException {
        int res = 0;
        Connection conne = BaseDatos.getConecction();
        PreparedStatement pstatement = null;
        ResultSet resulSet = null;
        String sql = "";

        sql = "update persona set ";
        sql = sql + "nombres= '" + persona.getNombres() + "',";
        sql = sql + "apellidos= '" + persona.getApellidos() + "',";
        sql = sql + "email= '" + persona.getDireccionEmail() + "',";
        sql = sql + "contra= '" + persona.getContra() + "'";
        sql = sql + " where id= '" + persona.getIdentificacion() + "'";

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

    private boolean deletePersona(Double id) throws SQLException {
        int res = 0;
        Connection conne = BaseDatos.getConecction();
        PreparedStatement pstatement = null;
        ResultSet resulSet = null;
        String sql = "";
        sql = "delete from persona where id=" + id;

        System.out.println("sql= " + sql);
        pstatement = conne.prepareStatement(sql);
        res = pstatement.executeUpdate();
        try {
            if (res == 1) {
                conne.commit();
                return true;
            } else {
                System.out.println("Error al eliminar");
                conne.rollback();
                return false;
            }
        } catch (SQLException ex) {
            conne.rollback();
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
