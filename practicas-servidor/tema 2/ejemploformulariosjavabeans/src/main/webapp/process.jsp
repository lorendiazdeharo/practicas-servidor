<%-- 
    Document   : process
    Created on : 10 sept 2022, 10:28:48
    Author     : lodiade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" scope="request" class="com.mycompany.ejemploformulariosjavabeans.entities.Usuario" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba de formularios JavaBeans con JSP</title>
    </head>
    <body bgcolor="#ffffcc">
        <% if (
                ((request.getParameter("nombre")==null) &&
                    (request.getParameter("email")==null)) ||
                ((request.getParameter("nombre").equals("")) &&
                    (request.getParameter("email").equals("")))
            ) { %>
            Complete este formulario
            <BR>
            <form method="POST" action="process.jsp">
                Su nombre: <input type="text" name="nombre" size="30">
                <BR>
                Su email: <input type="text" name="email" size="30">
                <BR>
                <input type="submit" value="Enviar">
            </form>
        <% } else { %>
            <%-- scriptlet JSP --%>
            <% 
               String nombre, mail;
               nombre = request.getParameter("nombre");
               mail = request.getParameter("email");
            %>
            <jsp:setProperty name="usuario" property="nombre" value="<%= nombre %>" />
            <jsp:setProperty name="usuario" property="email" value="<%= mail %>" />
            <jsp:forward page="/process2.jsp" ></jsp:forward>
        <% } %>
    </body>
</html>
