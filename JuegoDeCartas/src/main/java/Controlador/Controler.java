/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.is.database.BaseDatos;
import com.is.database.MisConsultas;
import com.is.modelo.CartaDAO;
import com.is.modelo.Cartaj;
import com.is.modelo.Persona;
import com.is.servlets.ModificarInformacion;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
@MultipartConfig
public class Controler extends HttpServlet {

    Cartaj c = new Cartaj();
    private MisConsultas MisConsultas = new MisConsultas();
    CartaDAO dao = new CartaDAO();

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

        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":
                List<Cartaj> lista = dao.listar();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("VistaCartasPokemon.jsp").forward(request, response);
                break;
            case "Guardar":
                String nombre = request.getParameter("txtnombre");
                int ataque = Integer.parseInt(request.getParameter("txtataque"));
                int defensa = Integer.parseInt(request.getParameter("txtdefensa"));
                String descripcion = request.getParameter("txtdescripcion");
                String Juego_nombre = request.getParameter("selectJuego");
                String tipo = request.getParameter("selectTipo");
                String atributo = request.getParameter("txtatributo1");
                int valor = Integer.parseInt(request.getParameter("txtvalor1"));
                Part part = request.getPart("filefoto");
                InputStream inputStream = part.getInputStream();
                c.setNombre(nombre);
                c.setAtaque(ataque);
                c.setDefensa(defensa);
                c.setDescripcion(descripcion);
                c.setJuego_nombre(Juego_nombre);
                c.setTipo(tipo);
                c.setAtributo(atributo);
                c.setValor(valor);
                c.setFoto(inputStream);
                try {
                    if (insertarCarta(c) == true) {
                        lista = dao.listar();
                        request.setAttribute("lista", lista);
                        request.getRequestDispatcher("VistaCartasPokemon.jsp").forward(request, response);
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
                break;
            default:
                request.getRequestDispatcher("Controler?accion=Listar").forward(request, response);
                break;
        }

    }

    public boolean insertarCarta(Cartaj carta) throws SQLException {
        int res = 0;
        Connection conne = BaseDatos.getConecction();
        PreparedStatement pstatement = null;
        ResultSet resultSet = null;
        System.out.println(MisConsultas.consultaid());
        String sql = "";
        sql = "insert into carta(idCarta,nombre,descripcion,ataque,defensa,tipo,Juego_nombre,atributo,valor,foto) values (";
        sql = sql + (MisConsultas.consultaid() + 1) + ",";
        sql = sql + "'" + carta.getNombre() + "',";
        sql = sql + "'" + carta.getDescripcion() + "',";
        sql = sql + carta.getAtaque() + ",";
        sql = sql + carta.getDefensa() + ",";
        sql = sql + "'" + carta.getTipo() + "',";
        sql = sql + "'" + carta.getJuego_nombre() + "',";
        sql = sql + "'" + carta.getAtributo() + "',";
        sql = sql + carta.getValor() + ",?)";
        System.out.println("sql=" + sql);
        pstatement = conne.prepareStatement(sql);
        pstatement.setBlob(1, carta.getFoto());
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
        for (Cartaj carta : MisConsultas.consultac()) {
            out.println("<p> ID=" + carta.getIdCarta()
                    + " nombres=" + carta.getNombre() + " apellidos="
                    + carta.getDescripcion() + " usuario=" + carta.getTipo()
                    + " email=" + carta.getJuego_nombre() + " telefono=" + carta.getFoto());
        }
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");
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
