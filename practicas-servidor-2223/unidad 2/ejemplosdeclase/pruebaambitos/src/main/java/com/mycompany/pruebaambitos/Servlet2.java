/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.pruebaambitos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CicloM
 */
public class Servlet2 extends HttpServlet {

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
            out.println("<title>Servlet Servlet2</title>");            
            out.println("</head>");
            out.println("<body>");

            // Variables a nivel de aplicacion
            String varAplicacion = (String) this.getServletContext().getAttribute("varAplicacion");
            int visitasAplicacion = Integer.valueOf((String) this.getServletContext().getAttribute("visitasAplicacion"));
            out.println(varAplicacion + visitasAplicacion);
            out.println("<br>");
            visitasAplicacion++;
            this.getServletContext().setAttribute("visitasAplicacion", String.valueOf(visitasAplicacion));
            
            // Variables a nivel de sesion
            String varSesion = (String) request.getSession().getAttribute("varSesion");
            int visitasSesion = Integer.valueOf((String) request.getSession().getAttribute("visitasSesion"));
            out.println(varSesion + visitasSesion);
            out.println("<br>");
            visitasSesion++;
            request.getSession().setAttribute("visitasSesion", String.valueOf(visitasSesion));            

            // Variables a nivel de peticion
            String varPeticion = (String) request.getAttribute("varPeticion");
            int visitasPeticion = Integer.valueOf((String) request.getAttribute("visitasPeticion"));
            out.println(varPeticion + visitasPeticion);
            out.println("<br>");
            visitasPeticion++;
            request.setAttribute("visitasPeticion", String.valueOf(visitasPeticion));              
            
            String referencia = "<a href=\"./Servlet3\"> pulsa aqui</a>";
            out.println(referencia);
            
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
