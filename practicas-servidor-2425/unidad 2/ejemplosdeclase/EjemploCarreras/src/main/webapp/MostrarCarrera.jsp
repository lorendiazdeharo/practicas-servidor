<%-- 
    Document   : MostrarCarrera
    Created on : 24 sept 2024, 18:34:16
    Author     : lodiade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="carrera" scope="request" 
             class="com.mycompany.ejemplocarreras.entities.Carrera"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostramos los datos</title>
    </head>
    <body>
        <h1>Mostramos los datos de la vista</h1>
        etiquetaNombre: <jsp:getProperty name="carrera" property="nombre" /> </br>
        Pais: <jsp:getProperty name="carrera" property="pais" /> </br>
        Km: <jsp:getProperty name="carrera" property="km" /> </br>
        <a href="./AltaCarrera.jsp">Volver a alta</a>
    </body>
</html>
