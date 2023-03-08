<%-- 
    Document   : detalle
    Created on : 06-mar-2023, 18:24:18
    Author     : Alberto Miguel Blázquez Caraballo
--%>

<%@page import="dao.CuentaDaoImplement"%>
<%@page import="dao.UsuarioDaoImplement"%>
<%@page import="model.Mensaje"%>
<%@page import="dao.MensajeDaoImplement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle</title>
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
        <% } else {%>
        <% int id = Integer.parseInt(request.getParameter("id"));
            Mensaje men = new MensajeDaoImplement().getMensaje(id);
            String origen = new CuentaDaoImplement().getEmail(men.getCuecodigoorigen());
        %>
        <header>
                <h1>Práctica HLC 5</h1>
                <form method="post" action="CerrarSesion">
                    <input type="submit" value="Salir" />
                </form>
                <form method="post" action="articulo.jsp">
                    <input type="submit" value="Atras" />
                </form>
        </header>
        <section>
            <article id="mensaje">
                <h1><%= men.getAsunto()%></h1>
                <h1>De: <%= origen%></h1>
                <p>Fecha Envio: <%= men.getFecha().toString()%><p>
                <p>Leido: <% if (men.getLeido() == 1) { %>
                    Si
                    <%} else { %>
                    No
                    <%}%></p>
                <p><%= men.getContenido()%></p>
            </article>
        </section>
        <footer><h1>Hecho por: <a href="google.com">Alberto Miguel Blázquez Caraballo</a></h1></footer>
            <% }%>
    </body>
</html>
