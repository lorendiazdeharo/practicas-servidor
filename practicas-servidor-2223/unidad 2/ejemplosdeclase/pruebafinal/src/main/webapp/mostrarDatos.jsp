<%-- 
    Document   : mostrarDatos
    Created on : 5 oct 2022, 12:02:13
    Author     : CicloM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="objetoAlumno" scope="request" class="com.mycompany.pruebafinal.entities.Alumno" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar datos de alumnos</title>
    </head>
    <body>
        Nombre: <jsp:getProperty name="objetoAlumno" property="nombre" />
        <br>
        Apellidos: <jsp:getProperty name="objetoAlumno" property="apellidos" />
        <br>
        Edad: <jsp:getProperty name="objetoAlumno" property="edad" />
        <br>  
    </body>
</html>
