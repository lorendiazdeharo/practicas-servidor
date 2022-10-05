<%-- 
    Document   : formdatos
    Created on : 5 oct 2022, 11:49:08
    Author     : CicloM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrada de datos</title>
    </head>
    <body>
        <form action="ServletController" method="GET" >
            <br>
            Pon mi nombre: <input type="text" name="nombreP" size="30" >
            <br>
            Pon mis apellidos: <input type="text" name="apellidosP" size="30" >
            <br>            
            Pon mi edad: <input type="number" name="edadP" size="30" >
            <br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
