/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.pruebaambitos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CicloM
 */
public class Servlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private int visitasAplicacion;
    
    @Override
    public void init()
            throws ServletException {
        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        visitasAplicacion = 0;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String varAplicacion = "Variable de aplicación. Visitas: ";
            String varSesion = "Variable de sesion. Visitas: ";
            int visitasSesion;
            String varPeticion = "Variable de petición. Visitas: ";
            int visitasPeticion = 0;
            
            // Asignamos la variable al ámbito application
            ServletContext a = this.getServletContext();
            a.setAttribute("varAplicacion", varAplicacion);
            visitasAplicacion++;
            a.setAttribute("visitasAplicacion", String.valueOf(visitasAplicacion));
            
            // Asignamos la variable al ámbito session
            request.getSession().setAttribute("varSesion", varSesion);
            
            if (request.getSession().getAttribute("visitasSesion")==null){
                visitasSesion = 0;
            }else{
                visitasSesion = Integer.valueOf((String) request.getSession().getAttribute("visitasSesion"));
            }
            request.getSession().setAttribute("visitasSesion", String.valueOf(visitasSesion));
            
            // Asignamos la variable al ámbito requesrt
            request.setAttribute("varPeticion", varPeticion);
            visitasPeticion++;
            request.setAttribute("visitasPeticion", String.valueOf(visitasPeticion));
            
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Servlet2");
            rd.forward(request, response);
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
