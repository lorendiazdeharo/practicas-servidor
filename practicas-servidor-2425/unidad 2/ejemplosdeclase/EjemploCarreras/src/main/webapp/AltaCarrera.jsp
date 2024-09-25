<%-- 
    Document   : AltaCarrera
    Created on : 24 sept 2024, 18:21:12
    Author     : lodiade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de carreras</title>
    </head>
    <body>
        <h1>Alta de carreras</h1>
        <form action="CarrerasController" method="POST">
            <h2>Dame los datos de la carrera</h2><!-- comment -->
            Nombre: <input type="text" name="nombreP" /></br>
            Pais: <input type="text" name="paisP" /></br>
            KM: <input type="text" name="kmP" /></br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
