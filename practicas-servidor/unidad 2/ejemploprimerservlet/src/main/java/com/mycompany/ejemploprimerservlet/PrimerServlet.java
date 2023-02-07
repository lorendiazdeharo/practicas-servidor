/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ejemploprimerservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lodiade
 */
public class PrimerServlet extends HttpServlet {

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
            out.println("<title>Servlet PrimerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PrimerServlet at " + request.getContextPath() + "</h1>");
            out.println("<b>Servlet Name: </b> " + this.getServletName());
            out.println("<br>");
            out.println("<b>Protocol: </b>" + request.getProtocol());
            out.println("<br>");
            out.println("<b>Scheme: </b>" + request.getScheme());
            out.println("<br>");
            out.println("<b>Server Port: </b>" + request.getServerPort());
            out.println("<br>");
            out.println("<b>Server Info: </b>" + getServletContext().getServerInfo());
            out.println("<br>");
            out.println("<b>Remote Addr: </b>" + request.getRemoteAddr());
            out.println("<br>");
            out.println("<b>Remote Host: </b>" + request.getRemoteHost());
            out.println("<br>");
            out.println("<b>Locale: </b>" + request.getLocale());
            out.println("<br>");
            out.println("<b>Default Response Buffer: </b>" + response.getBufferSize());
            out.println("<br>");
            out.println("<b>Request is Secure: </b>" + request.isSecure());
            out.println("<br>");
            out.println("<b>HTTP Method: </b>" + request.getMethod());
            out.println("<br>");
            out.println("<b>Request URI: </b>" + request.getRequestURI());
            out.println("<br>");
            out.println("<b>Context Path: </b>" + request.getContextPath());
            out.println("<br>");
            out.println("<b>Servlet Path: </b>" + request.getServletPath());
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
