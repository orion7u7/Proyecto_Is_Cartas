/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is.modelo;

import com.is.database.BaseDatos;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laptop
 */
public class CartaDAO {
    BaseDatos cn= new BaseDatos();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<Cartaj>lista= new ArrayList<>();
        String sql="select *from carta";
        try {
            con=cn.getConecction();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cartaj c= new Cartaj();
                c.setIdCarta(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setAtaque(rs.getInt(4));
                c.setDefensa(rs.getInt(5));
                c.setTipo(rs.getString(6));
                c.setJuego_nombre(rs.getString(7));
                c.setAtributo(rs.getString(8));
                c.setValor(rs.getInt(9));
                c.setFoto(rs.getBinaryStream(10));
                lista.add(c);
            }
        } catch (Exception e){
        }
        return lista;
    }
    
    public void listarImg(int idCarta, HttpServletResponse response){
        String sql= "select *from carta where id="+idCarta;
        InputStream inputStream= null;
        OutputStream outputStream= null;
        BufferedInputStream bufferedInputStream= null;
        BufferedOutputStream bufferedOutputStream= null;
        response.setContentType("image/*");
        try{
            outputStream=response.getOutputStream();
            con=cn.getConecction();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                inputStream=rs.getBinaryStream("foto");
            }
            bufferedInputStream= new BufferedInputStream(inputStream);
            bufferedOutputStream= new BufferedOutputStream(outputStream);
            int i=0;
            while((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
        } catch (Exception e){
        }
    }
    
    public void agregar(Cartaj c){
        String sql="insert into carta(nombre,descripcion,ataque,defensa,tipo,Juego_nombre,atributo,valor,foto)values(?,?,?,?,?,?,?,?,?)";
        try {
            con=cn.getConecction();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getAtaque());
            ps.setInt(4, c.getDefensa());
            ps.setString(5, c.getTipo());
            ps.setString(6, c.getJuego_nombre());
            ps.setString(7, c.getAtributo());
            ps.setInt(8, c.getValor());
            ps.setBlob(9, c.getFoto());
            ps.executeUpdate();
        } catch (Exception e){
        }
    }
}
