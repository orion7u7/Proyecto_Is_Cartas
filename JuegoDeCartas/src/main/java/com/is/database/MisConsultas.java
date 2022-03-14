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
        String sql = " SELECT id,nombres,apellidos,usuario,email,telefono  ";
        sql = sql + " FROM personas where nombres like '%" + nombres + "%' ";
        sql = sql + " order by 1 asc ";

        System.out.println("sql=" + sql);

        Vector<Persona> listado = new Vector<Persona>();
        try {
            Connection conne = BaseDatos.getConecction();
            pstatement = conne.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {

                Persona persona = new Persona(resultSet.getDouble(1), resultSet.getString(2), resultSet.getString(3));
                persona.setDireccionEmail(resultSet.getString(4));
                persona.setUsuario(resultSet.getString(5));
                persona.setTelefono(resultSet.getString(6));

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
        String sql = " SELECT id,nombres,apellidos,usuario,email,telefono  ";
        sql = sql + " FROM misclientes.personas ";
        sql = sql + " order by 1 asc ";

        Vector<Persona> listado = new Vector<Persona>();
        try {
            Connection conne = BaseDatos.getConecction();
            pstatement = conne.prepareStatement(sql);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {

                Persona persona = new Persona(resultSet.getDouble(1), resultSet.getString(2), resultSet.getString(3));
                persona.setDireccionEmail(resultSet.getString(4));
                persona.setUsuario(resultSet.getString(5));
                persona.setTelefono(resultSet.getString(6));

                listado.add(persona);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;

    }

}
