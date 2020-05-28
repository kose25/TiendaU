/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import NEGOCIO.TiendaU;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kose_
 */
@WebServlet(name = "RegistrarTienda", urlPatterns = {"/RegistrarTienda"})
public class RegistrarTienda extends HttpServlet {

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
        try {
            TiendaU tu = new TiendaU();
            String nombre = request.getParameter("inputNombre");
            String lema = request.getParameter("inputLema");
            String descripcion = request.getParameter("inputDescripcion");
            String email = request.getParameter("inputEmail");
            String clave = request.getParameter("inputPassword");
            String propietario = request.getParameter("inputPropietario");
            String facebook = request.getParameter("inputFacebook");
            String sitio = request.getParameter("inputWeb");
            String imagen = request.getParameter("inputImagen");
            if (tu.registrarTienda(nombre, lema, descripcion, email, clave, propietario, facebook, lema, imagen)) {
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Registro exitoso');");
                pw.println("</script>");
                request.getSession().setAttribute("resultado", tu);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
                 request.getSession().setAttribute("error", "error");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getSession().setAttribute("error", e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
        processRequest(request, response);
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
