<%-- 
    Document   : paginaformulario
    Created on : 26 sept 2022, 11:57:42
    Author     : CicloM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="objetoUsuario" scope="request" 
             class="com.mycompany.pruebajavabean.entities.Usuario" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%-- Trabajamos primero con que tenemos datos --%>
        <%
            if (((request.getParameter("nombreP") != null)
                    && (!request.getParameter("nombreP").isBlank()))
                    && ((request.getParameter("edadP") != null)
                    && (!request.getParameter("edadP").isBlank()))) {

                    // Como tengo datos recojo los datos
                    String nombre = request.getParameter("nombreP");
                    int edad = Integer.valueOf(request.getParameter("edadP"));
                    // Asi tb se puede asignar los valores
                    // bjetoUsuario.setEdad(edad);                 
        %> 
        
            <jsp:setProperty name="objetoUsuario" property="nombre" 
                value="<%=nombre%>" />
                
            <jsp:setProperty name="objetoUsuario" property="edad" 
                value="<%=edad%>" />
            
            <%-- Redirigimos a la otra pagina --%>
            <jsp:forward page="/paginadatos.jsp" />
                
        <%-- No tenemos datos. Muestra el formulario --%>        
        <% } else { %>

        <form action="Servlet" method="GET" >
            <br>
            Pon mi nombre: <input type="text" name="nombreP" size="30" >
            <br>
            Pon mi edad: <input type="text" name="edadP" size="30" >
            <input type="submit" value="Enviar">
        </form>

        <% }%>
    </body>
</html>
