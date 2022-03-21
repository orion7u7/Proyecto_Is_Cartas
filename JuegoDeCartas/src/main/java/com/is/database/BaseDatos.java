package com.is.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDatos {

    private static Connection connection = null;

    public static Connection getConecction() throws SQLException {

        String ip = "localhost";
        String basedatos = "powercards";
        String usuario = "root";
        String pass = "root";
        String puerto = "3306";
        String url = "jdbc:mysql://" + ip + ":" + puerto + "/" + basedatos + "?serverTimezone=UTC&autoReconnect=true&useSSL=false";

        try {
            if (BaseDatos.connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                BaseDatos.connection = DriverManager.getConnection(url, usuario, pass);
                BaseDatos.connection.setAutoCommit(false);
                return BaseDatos.connection;
            }
        } catch (Exception ex) {
            System.out.println("ERROR EN EL DRIVER \n ERROR : " + ex.getMessage());
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            BaseDatos.connection.close();
        }

        return BaseDatos.connection;

    }

}
