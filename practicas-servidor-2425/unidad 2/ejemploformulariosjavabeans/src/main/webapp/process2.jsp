<%-- 
    Document   : process2
    Created on : 11 sept 2022, 11:04:42
    Author     : lodiade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" scope="request" class="com.mycompany.ejemploformulariosjavabeans.entities.Usuario" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información transportada a través de JavaBean</title>
    </head>
    <body>
        <b>Usted indicó la siguiente información:</b>
        <br>
        <b>Nombre : </b> <jsp:getProperty name="usuario" property="nombre" />
        <br>
        <b>Email : </b> <jsp:getProperty name="usuario" property="email" />        
        <br>
        <b>Este es el segundo JSP que recoge el JavaBean y lo muestra por pantalla</b>
    </body>
</html>
