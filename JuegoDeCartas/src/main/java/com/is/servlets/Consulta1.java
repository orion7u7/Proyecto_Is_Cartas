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
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oguev
 */
public class Consulta1 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consulta1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Consulta1 at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        response(response, request.getParameter("nombres"));
    }

    private void response(HttpServletResponse resp, String texto) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Consulta1: get </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>");
        System.out.println("texto=" + texto);
        for (Persona persona : misConsultas.consulta(texto)) {
            out.println("<p> ID=" + persona.getNickname()
                    + " nombres=" + persona.getContraseña() + " apellidos="
                    + persona.getRol());
        }
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
        String user = request.getParameter("user");
        String jugador = request.getParameter("playeruser");
        String pass = request.getParameter("pass");
        String menu = request.getParameter("menu");
        MisConsultas consulta = new MisConsultas();
        Collection<Persona> persona = consulta.consulta();
        if (menu.equals("admin")) {
            for (Persona persona2 : persona) {
                if ((persona2.getNickname()).equals(user) && (persona2.getContraseña()).equals(pass)) {
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect(request.getContextPath() + "/session");
                    request.setAttribute("succes", 1);
                } else {
                    request.setAttribute("succes", 0);
                    request.getRequestDispatcher("index.jsp").include(request, response);
                }
            }
        } else {
            Persona per = new Persona();
            per.setNickname(jugador);
            per.setContraseña("");
            for (Persona persona3 : persona) {
                if ((persona3.getNickname()).equals(jugador)) {
                    System.out.println(persona3.getNickname());
                    System.out.println(jugador);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    request.setAttribute("succes", 2);
                } else {
                    try {
                        consulta.insertarUser(per);
                    } catch (Exception e) {
                    }
                    request.getSession().setAttribute("user", jugador);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);

                }
            }
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
