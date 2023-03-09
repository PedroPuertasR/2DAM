<%-- 
    Document   : verDetalle
    Created on : 08-mar-2023, 19:23:34
    Author     : alumno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.AutorDaoImplement"%>
<%@page import="dao.LibroDaoImplement"%>
<%@page import="model.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
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

        <header>
            <div id="volver" class="header-center">
                <h1>Examen HLC</h1>
                <form method="post" action="LogOut">
                    <input type="submit" value="Salir"/>
                </form>
                <form method="post" action="verArticulo.jsp">
                    <input type="submit" value="Atras"/>
                </form>
            </div>
        </header>

        <% int id = Integer.parseInt(request.getParameter("id"));
            Libro l = new LibroDaoImplement().getLibroById(id);
            String origen = new AutorDaoImplement().getNombreAutorById(l.getAutnumero());
        %>

        <div class="detalle">
            <img src="imagenes/<%=l.getImagen().toString()%>"/>
            <h1>Código: <%=l.getCodigo()%></h1>
            <h1>Título: <%=l.getTitulo()%></h1>
            <h1>Fecha de publicación: <%=l.getFechapublicacion()%></h1>
            <h1>Precio: <%=l.getPrecio()%></h1>
            <h1>Autor: <%=origen%></h1>
        </div>

        <%}%>
        
        <footer>
            <h1>Examen HLC</h1>
            <a href="#volver">Volver arriba</a>
        </footer>
    </body>
</html>
