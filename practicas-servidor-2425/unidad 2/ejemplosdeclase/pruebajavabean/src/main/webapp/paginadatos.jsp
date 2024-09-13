<%-- 
    Document   : paginadatos
    Created on : 26 sept 2022, 11:57:57
    Author     : CicloM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="objetoUsuario" scope="request" 
             class="com.mycompany.pruebajavabean.entities.Usuario" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        El nombre del usuario es: <jsp:getProperty name="objetoUsuario" property="nombre" />
        <br>
        La edad del usuario es: <jsp:getProperty name="objetoUsuario" property="edad" />
    </body>
</html>
