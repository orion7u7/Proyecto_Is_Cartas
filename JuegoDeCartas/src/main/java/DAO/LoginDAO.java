/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Persona;
import com.is.database.BaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HOMEPCTK
 */
public class LoginDAO {

    
    int rspta = 0;
    String sql = "";
    BaseDatos cn = new BaseDatos();
    ResultSet rs = null;
    PreparedStatement ps;
    public int validarLogin(Persona per) {
        sql = "Select count(nickname) as cantidad from persona where nickname='" + per.getNickname() + "' and contraseña='" + per.getContraseña() + "'";
        
        return rspta;
    }
}
