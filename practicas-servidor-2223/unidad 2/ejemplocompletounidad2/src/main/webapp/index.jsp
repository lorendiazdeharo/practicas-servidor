<%-- 
    Document   : index
    Created on : 1 oct 2022, 17:04:51
    Author     : lodiade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrada de datos</title>
    </head>
    <body>
        <h1>Entrada de datos</h1>
        <form action="RecogeDatosServlet" method="POST">
            <h2>Datos de alumnos</h2>
            Nombre: <input text="text" name="nombreP" /><br>
            Primer Apellido <input text="text" name="primerApellidoP" /><br>
            Segundo Apellido: <input text="text" name="segundoApellidoP" /><br>
            Edad: <input text="text" name="edadP" /><br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
