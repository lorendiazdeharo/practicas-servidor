<%-- 
    Document   : pruebaVariables.jsp
    Created on : 9 sept 2022, 21:52:53
    Author     : lodiade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        La IP de tu ordenador es: <%= request.getRemoteHost() %>
        <BR>
        El nombre del servidor es: <%= request.getServerName() %>
        <BR>
        El puerto del servidor es: <%= request.getServerPort() %>
        <BR>
        La IP del servidor es: <%= request.getRemoteAddr() %>
        <BR>
        El protocolo que estas usando es: <%= request.getProtocol() %>           
    </body>
</html>
