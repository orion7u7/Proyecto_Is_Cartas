/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is.servlets;

import com.is.database.BaseDatos;
import com.is.database.MisConsultas;
import com.is.modelo.Persona;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oguev
 */
public class ModificarInformacion extends HttpServlet {

    private MisConsultas misConsultas = new MisConsultas();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificarInformacion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarInformacion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Persona persona = new Persona(request.getParameter("nombres"), request.getParameter("apellidos"));
        persona.setDireccionEmail(request.getParameter("email"));
        persona.setContra(request.getParameter("contra"));
        try {
            if (insertarPersona(persona) == true) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title> Servlet Consulta: Get </title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>");
                out.println("<p>Error al intentar la informacion de la persona</p>");
                out.println("</p>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean insertarPersona(Persona persona) throws SQLException {
        int res = 0;
        Connection conne = BaseDatos.getConecction();
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        String sql = "";
        System.out.println(misConsultas.consultaid());
        sql = "insert into persona values (";
        sql = sql + (misConsultas.consultaid() + 1) + ",";
        sql = sql + "'" + persona.getNombres() + "',";
        sql = sql + "'" + persona.getApellidos() + "',";
        sql = sql + "'" + persona.getDireccionEmail() + "',";
        sql = sql + "'" + persona.getContra() + "',0,0)";
        System.out.println("sql=" + sql);
        pstatement = conne.prepareStatement(sql);
        res = pstatement.executeUpdate();
        if (res == 1) {
            conne.commit();
            return true;
        } else {
            System.out.println("Error al insertar");
            conne.rollback();
            return false;
        }
    }

    private void response(HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Consulta1: get </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>");
        for (Persona persona : misConsultas.consulta()) {
            out.println("<p> ID=" + persona.getIdentificacion()
                    + " nombres=" + persona.getNombres() + " apellidos="
                    + persona.getApellidos()
                    + " email=" + persona.getDireccionEmail() + " contraseña=" + persona.getContra());
        }
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");
    }

    private void responseError(HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Servlet Consulta: Get </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>");
        out.println("<p>Error al insertar la informacion de la persona</p>");
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");
    }

    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    
    private boolean deletePersona(int id) throws SQLException {
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
