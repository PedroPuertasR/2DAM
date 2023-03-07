<%@page import="dao.CuentaDaoImplement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>verPrincipal HLC 5</title>
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
            <div class="header-center">
                <h1 id="volver" class="headerH1">Práctica HLC 5</h1>

                <div class="bienve">
                    <img src="fotos/<%= session.getAttribute("foto").toString()%>"/>
                    <h1>Hola, <%=session.getAttribute("nombre")%></h1>
                </div>
            </div>
        </header>

        <div class="centrar">
            <form class="formMedio" method="post" action="LogOut">
                <input type="submit" value="Salir" />
            </form>

            <%
                int id = Integer.parseInt(session.getAttribute("id").toString());
                double recargo = new CuentaDaoImplement().getRecargo(id);
            %>

            <button onclick='alert("<%=recargo%>")'>
                Recargos pendientes
            </button>

            <form method="post" action="verTabla.jsp">
                <input type="submit" value="Tabla"/>
            </form>

            <form method="post" action="verArticulo.jsp">
                <input type="submit" value="Articulos"/>
            </form>
        </div>

        <footer>
            <h1>HLC 5</h1>
            <a href="#volver">Volver arriba</a>
        </footer>

        <% }%>
    </body>
</html>
