<%-- 
    Document   : tabla
    Created on : 06-mar-2023, 17:30:15
    Author     : Alberto Miguel Blázquez Caraballo
--%>

<%@page import="dao.MensajeDaoImplement"%>
<%@page import="model.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla</title>
        <link rel="stylesheet" href="estilos/style.css">
    </head>
    <body>
        <% Boolean conectado = (Boolean) session.getAttribute("conectado");
            if (!conectado.booleanValue()) { %>
        <form method="post" id="casa" action='index.jsp'/>
        <script type="text/javascript">
            function formAutoSubmit() {
                var frm = document.getElementById("casa");
                frm.submit();
            }
            window.onload = formAutoSubmit;
        </script>
        <% } else { %>
        <header>
            <h1>Práctica HLC 5</h1>
            <form method="post" action="LogOut">
                <input type="submit" value="Salir" />
            </form>
            <form method="post" action="principal.jsp">
                <input type="submit" value="Atras" />
            </form>
        </header>
        <% int id = Integer.parseInt(session.getAttribute("id").toString());
            ArrayList<Mensaje> mensajes = new MensajeDaoImplement().getMensajesUsuario(id); %>
        <table>
            <thead>
                <tr>
                    <th>Asunto</th>
                    <th>Contenido</th>
                    <th>Leido</th>
                    <th>Fecha</th>
                </tr>
            </thead>

            <%
                for (Mensaje m : mensajes) {
                    Mensaje mensaje = m;

            %>
            <tr>
                <td><%= mensaje.getAsunto()%></td>
                <td><%= mensaje.getContenido()%></td>
                <td><% if (mensaje.getLeido() == 1) { %>
                    Si
                    <%} else {%>
                    No
                    <%}%>
                </td>
                <td><%= mensaje.getFecha().toString()%></td>
            </tr>
            <% }%>
        </table>

        <footer><h1>Hecho por: <a href="google.com">Alberto Miguel Blázquez Caraballo</a></h1></footer>
            <% }%>
    </body>
</html>
