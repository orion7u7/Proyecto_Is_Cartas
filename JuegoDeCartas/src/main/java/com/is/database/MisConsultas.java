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

}
