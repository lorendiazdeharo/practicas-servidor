<%-- 
    Document   : mostrarDatos
    Created on : 1 oct 2022, 17:17:25
    Author     : lodiade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="alumnoAtrib" scope="request" 
             class="com.mycompany.ejemplocompletounidad2.entities.Alumno" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muestra de datos</title>
    </head>
    <body>
        <h1>El alumno introducido es:</h1>
        Nombre: <jsp:getProperty name="alumnoAtrib" property="nombre" /> <br><!-- comment -->
        Primer Apellido: <jsp:getProperty name="alumnoAtrib" property="primerApellido" /><br>
        Segundo Apellido: <jsp:getProperty name="alumnoAtrib" property="segundoApellido" /><br>
        Edad: <jsp:getProperty name="alumnoAtrib" property="edad" /><br>
    </body>
</html>
