<%-- 
    Document   : verTabla
    Created on : 08-mar-2023, 19:03:25
    Author     : alumno
--%>

<%@page import="dao.AutorDaoImplement"%>
<%@page import="dao.LibroDaoImplement"%>
<%@page import="model.Libro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla examen HLC</title>
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
        
        <% int id = Integer.parseInt(session.getAttribute("id").toString());
           ArrayList<Libro> libros = new LibroDaoImplement().getLibroByAutor(id);
        %>
        <table>
            <tr>
                <th>Código</th>
                <th>Título</th>
                <th>Fecha publicación</th>
                <th>Precio</th>
                <th>Autor</th>
            </tr>

            <%
                for (Libro l : libros) {
                    Libro lib = l;
                    String origen = new AutorDaoImplement().getNombreAutorById(l.getAutnumero());

            %>
            <tr>
                <td><%= lib.getCodigo()%></td>
                <td><%= lib.getTitulo()%></td>
                <td><%= lib.getFechapublicacion()%></td>
                <td><%= lib.getPrecio()%>€</td>
                <td><%= origen%></td>
            </tr>
            <% }%>
        </table>
        
        <%}%>
        
        <footer>
            <h1>Examen HLC</h1>
            <a href="#volver">Volver arriba</a>
        </footer>
    </body>
</html>
