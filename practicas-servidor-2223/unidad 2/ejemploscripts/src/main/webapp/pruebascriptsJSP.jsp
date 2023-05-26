<%-- 
    Document   : pruebascriptsJSP
    Created on : 8 sept 2022, 21:17:30
    Author     : lodiade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con scripts</title>
    </head>
    <body>
        Contenido dinámico de scripts JSP de ejemplo de los apuntes:
        <UL>
            <LI>
                <B>Expresiones JSP</B>
                <BR>
                Fecha actual: <%= new Date()%>                      
            </LI>

            <LI>
                <B>Scriptlet JSP </B>
                <BR>
                <% Calendar cal = Calendar.getInstance();
                    out.println("La fecha actual es: "
                            + cal.get(Calendar.DATE) + " /"
                            + (cal.get(Calendar.MONTH) + 1) + " / " + cal.get(Calendar.YEAR));
                %>
            </LI>

            <LI>
                <B>Declaración (más expresión)</B>
                <BR>
                <%!private int accessCount = 0;%>
                Accesos a la página:
                <%=++accessCount%>                  
            </LI>
        </UL>
    </body>
</html>
