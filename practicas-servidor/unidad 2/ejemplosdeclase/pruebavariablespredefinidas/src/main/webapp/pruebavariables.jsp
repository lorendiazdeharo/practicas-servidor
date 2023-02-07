<%-- 
    Document   : pruebavariables
    Created on : 23 sept 2022, 12:18:59
    Author     : CicloM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba de variables predefinidas</title>
    </head>
    <body>
        <%
            out.println("<br> El protocolo es : " + request.getProtocol());
            out.println("<br> Método por el que se ha solicitado la pagina : " + request.getMethod());
            out.println("<br> Es seguro? : " + request.isSecure());
            out.println("<br> Idioma : " + response.getLocale()); 
            out.println("<br>");
            if(
                ((request.getParameter("nombreP")!=null) &&
                (!request.getParameter("nombreP").isBlank())) &&
                ((request.getParameter("edadP")!=null) &&
                (!request.getParameter("edadP").isBlank()))
               ){
                    if(Integer.valueOf(request.getParameter("edadP"))>=18) {
                        out.println("El nombre introducido es: " + request.getParameter("nombreP"));
                        out.println("<br>");
                        out.println("La edad introducida es: " + request.getParameter("edadP"));
                    } else {
                        out.println("Eres menor de edad, por lo que no puedo imprimir la información.");
                    }
                }                                
        %>
        
        <form action="pruebavariables.jsp" method="GET" >
            <br>
            Pon mi nombre: <input type="text" name="nombreP" size="30" >
            <br>
            Pon mi edad: <input type="text" name="edadP" size="30" >
            <input type="submit" value="Enviar">
        </form>
                
    </body>
</html>
