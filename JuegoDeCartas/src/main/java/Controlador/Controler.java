/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.is.modelo.CartaDAO;
import com.is.modelo.Cartaj;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
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
@MultipartConfig
public class Controler extends HttpServlet {
    CartaDAO dao= new CartaDAO();
    Cartaj c= new Cartaj();
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
            out.println("<title>Servlet Controler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controler at " + request.getContextPath() + "</h1>");
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
        String accion=request.getParameter("accion");
        switch(accion){
            case "Listar":
                List<Cartaj>lista=dao.listar();
                request.setAttribute("lista",lista);
                request.getRequestDispatcher("VistaCartasPokemon.jsp").forward(request, response);
                break;
            case "Guardar":
                String nombre=request.getParameter("txtnombre");
                int ataque=Integer.parseInt(request.getParameter("txtataque"));
                int defensa=Integer.parseInt(request.getParameter("txtdefensa"));
                String descripcion=request.getParameter("txtdescripcion");
                String Juego_nombre=request.getParameter("selectJuego");
                String tipo=request.getParameter("selectTipo");
                String atributo=request.getParameter("txtatributo1");
                int valor=Integer.parseInt(request.getParameter("txtvalor1"));
                Part part= request.getPart("filefoto");
                InputStream inputStream=part.getInputStream();
                c.setNombre(nombre);
                c.setAtaque(ataque);
                c.setDefensa(defensa);
                c.setDescripcion(descripcion);
                c.setJuego_nombre(Juego_nombre);
                c.setTipo(tipo);
                c.setAtributo(atributo);
                c.setValor(valor);
                c.setFoto(inputStream);
                dao.agregar(c);
                request.getRequestDispatcher("Administrador.jsp").forward(request, response);
                
                break;
            default:
                request.getRequestDispatcher("Controler?accion=Listar").forward(request, response);
                break;
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
