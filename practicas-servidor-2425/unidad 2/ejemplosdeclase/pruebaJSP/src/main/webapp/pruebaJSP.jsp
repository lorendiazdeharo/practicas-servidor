<%-- 
    Document   : pruebaJSP
    Created on : 16 sept 2022, 12:09:01
    Author     : CicloM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page errorPage="paginaerror.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hola mundo desde JSP con fecha <%= new Date()  %> </h1>
        Voy a hacer una division por cero (esto se convierte en un string) <%= 4/2 %>
        <br>
        <% 
            double a = Math.random(); // Esto es una variable local
            int b = 0; // Esto es una variable local
            out.println("El valor de a es " + a + "<br>");
            if (a<0.5) { 
        %>            
                Qué <b>dios</b> te bendiga
        <% } else { %>
                Qué el diablo guie tus pasos
        <% } %>        
        <%! int contador = 0;  %> <!-- Esto es una variable global -->
        <% 
            contador++; // Incrementamos la variable global
            b++;  // Incrementamos la variable local
                        
            out.println("<br> El valor de la variable global contador es : " + contador);
            out.println("<br> El valor de la variable local b es : " + b);
        %>
    </body>
</html>
