/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.is.database.BaseDatos;
import com.is.modelo.Juegos;
import com.is.servlets.ModificarInformacion;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Laptop
 */
public class Controlerjuego extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlerjuego</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlerjuego at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        Juegos j = new Juegos();
        System.out.println(request.getParameter("txtjuego"));
        String nombre = request.getParameter("txtjuego");
        System.out.println(request.getParameter("txtcantidad"));
        int total_cartas = Integer.parseInt(request.getParameter("txtcantidad"));
        String descripcion = request.getParameter("txtdescripcion");
        Part part = request.getPart("filefotojuego");
        InputStream inputStream = part.getInputStream();
        j.setNombre(nombre);
        j.setTotal_cartas(total_cartas);
        j.setDescripcion(descripcion);
        j.setFoto(inputStream);
        try {
            if (insertarJuegos(j) == true) {
                request.getRequestDispatcher("Juegoadmin.jsp").forward(request, response);
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

    public boolean insertarJuegos(Juegos juego) throws SQLException {
        int res = 0;
        Connection conne = BaseDatos.getConecction();
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        //System.out.println(MisConsultas.consultaidJuego());
        String sql = "";
        sql = "insert into juego(nombre,descripcion,total_cartas,logo) values (";
        //sql = sql + (MisConsultas.consultaidJuego() + 1) + ",";
        sql = sql + "'" + juego.getNombre() + "',";
        sql = sql + "'" + juego.getDescripcion() + "',";
        sql = sql + juego.getTotal_cartas() + ",?)";
        System.out.println("sql=" + sql);
        pstatement = conne.prepareStatement(sql);
        pstatement.setBlob(1, juego.getFoto());
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
