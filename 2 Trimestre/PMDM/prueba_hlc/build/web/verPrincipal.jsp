<%-- 
    Document   : verPrincipal
    Created on : 08-mar-2023, 18:36:57
    Author     : alumno
--%>
<%@page import="dao.AutorDaoImplement"%>
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
                <h1 class="headerH1">Examen HLC</h1>
                <form method="post" action="LogOut">
                    <input type="submit" value="Salir"/>
                </form>
            </div>
        </header>

        <div class="bienve">
            <div class="divCol">
                <img src="fotos/<%= session.getAttribute("foto").toString()%>"/>
                <h1>
                    Hola, <%=session.getAttribute("nombre")%> <%=session.getAttribute("apellido")%>
                </h1>

                <h1>
                    Numero: <%=session.getAttribute("id")%>
                </h1>

                <h1>
                    Fecha de nacimiento: <%=session.getAttribute("fecha")%>
                </h1>
            </div>

            <div class="divCol">
                <form method="post" action="verTabla.jsp">
                    <input type="submit" value="Ver en tabla"/>
                </form>

                <form method="post" action="verArticulo.jsp">
                    <input type="submit" value="Ver en article"/>
                </form>
            </div>
        </div>
        <%}%>  

        <footer>
            <h1>Examen HLC</h1>
            <a href="#volver">Volver arriba</a>
        </footer>
    </body>
</html>
