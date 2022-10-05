/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.pruebaservletforward;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CicloM
 */
public class ServletForward extends HttpServlet {

    int contadorAccesos = 0;

    @Override
    public void init() throws ServletException {
        super.init();
        contadorAccesos = 5;
    }

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
      //  if (contadorAccesos > 0) {
            response.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletForward</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet ServletForward at " + request.getContextPath() + "</h1>" + "<br>");
                out.println("Que servlet está contestando? : " + this.getServletName() + "<br>");
                out.println("Que protocolo está contestando? : " + request.getProtocol() + "<br>");
                out.println("Que esquema tiene la petición? : " + request.getScheme() + "<br>");
                out.println("En que servidor está funcionando esto? : " + request.getServerName() + "<br>");
                out.println("En que puerto está funcionando esto? : " + request.getServerPort() + "<br>");
                out.println("ETamaño de la pagina que va a generar : " + response.getBufferSize() + "<br>");
                out.println("Los accesos que quedan son: " + contadorAccesos + "<br>");
                contadorAccesos--;
                
                Enumeration<String> listaParametros =  request.getParameterNames();
                
                while(listaParametros.hasMoreElements()){
                    String parametro = listaParametros.nextElement();
                    String valor = request.getParameter(parametro);
                    out.println("nombre de parametro : " + parametro
                            + " - valor del parametro: " + valor + "<br>");
                }
                
                out.println("</body>");
                out.println("</html>");
            }
       // }
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
