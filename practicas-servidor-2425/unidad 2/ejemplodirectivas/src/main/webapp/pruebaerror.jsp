<%-- 
    Document   : pruebaerror
    Created on : 8 sept 2022, 19:15:39
    Author     : lodiade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página JSP con error</title>
    </head>
    <body>
        <%= 0/0 %>
    </body>
</html>
