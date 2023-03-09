<%-- 
    Document   : verArticulo
    Created on : 08-mar-2023, 19:03:37
    Author     : alumno
--%>

<%@page import="model.Libro"%>
<%@page import="dao.LibroDaoImplement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.AutorDaoImplement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista libros article</title>
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
                <h1 class="headerH1">Examen HLC</h1>
                <form method="post" action="LogOut">
                    <input type="submit" value="Salir"/>
                </form>
                <form method="post" action="verPrincipal.jsp">
                    <input type="submit" value="Atras"/>
                </form>
            </div>
        </header>

        <section>

            <%
                int id = Integer.parseInt(session.getAttribute("id").toString());
                ArrayList<Libro> libros = new LibroDaoImplement().getLibroByAutor(id);
                for (Libro lib : libros) {
                    Libro l = lib;
            %>

            <article>
                <h1>Titulo: <%=l.getTitulo()%></h1>
                <img src="imagenes/<%=l.getImagen().toString()%>"/>
                <form method="post" action="verDetalle.jsp">
                    <input type="hidden" value="<%= l.getCodigo()%>" name="id"/>
                    <input type="submit" value="Ver más">
                </form>
            </article>

                <%}%>
        </section>

            <%}%>
        <footer>
            <h1>Examen HLC</h1>
            <a href="#volver">Volver arriba</a>
        </footer>
    </body>
</html>