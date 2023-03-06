
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dao.UsuarioDaoImplement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>IES El Majuelo</title>
    </head>
    <body style="background-color: #ccccff"> 
        <!-- 1 carga la fecha y la hora -->
        <%
            GregorianCalendar date = new GregorianCalendar();
            try{
                // si el parametro invalidate es true, venimos de pulsar el boton de desconectar e iniciamos nueva sesion
                if (request.getParameter("invalidate").equals("true")){ 
                        request.getSession().invalidate();
                        //request.getSession(true);
                }
            } catch(NullPointerException npe){}
        %>
        
        <!-- 2 si hay parametro username intenta validarse -->
        <c:choose>            
            <c:when test='${param.username != null}'>
                <%
                    try{
                        UsuarioDaoImplement udi = new UsuarioDaoImplement();
                        Usuario usuario = null;
                        // Filtrando la consulta con un where -> ArrayList con un ususario
                        usuario = udi.getUsuariosConWhere(request.getParameter("username"), request.getParameter("password")).get(0); // coge el unico profesor del arraylist de profesores con ese nombre y contraseña
                        // Consulta completa -> Filtrando el arrayList
                        //usuario = udi.getUsuarios(request.getParameter("username"), request.getParameter("password")).get(0);

                        if (usuario != null){
                            // validación OK
                            request.getSession().setAttribute("correctLogin", "true");
                            request.getSession().setAttribute("usuarioID", usuario.getNumero());
                            request.getSession().setAttribute("usuarioName", usuario.getNombre());
                            %>
                            <script>alert("Correct username and password.");</script>
                            <%
                        }
                    } catch (IndexOutOfBoundsException OOBE){ // esta excepcion salta cuando no hay elementos en el array, por lo que hemos fallado en el login
                        request.getSession().setAttribute("correctLogin", "false");
                        %>
                            <script>alert("Incorrect username and/or password.");</script>
                        <%
                    }
                %>
            </c:when>
        </c:choose>                            
         
        <% 
            if (request.getSession().getAttribute("correctLogin") == "false" || request.getSession().getAttribute("correctLogin") == null){            
        %>
            <!-- 3 Formulario. Llama al mismo jsp -->
            <div class="container">
                <form method="post" action="">
                    Username:</br> <input type="text" name="username" id="username"></br>
                    Password:</br> <input type="password" name="password"</br>
                    </br></br><input type="submit" value="Login">
                </form>
                <br/>
                <button onclick="showInfo()">About</button>
            </div>
            <%
                }else{
            %>
            <!-- 4 Formulario. Tras estar validado, informa, y va a MySeervlet -->
            <div class="container">
                <form action="MyServlet" method="post">
                    <h1>Welcome, <%=request.getSession().getAttribute("usuarioName")%>. </h1>
                    <input type="submit" value="Enter">
                    <input type="hidden" name="usuario" value="<%=request.getSession().getAttribute("usuarioID")%>">
                </form>
            </div>
                <%
                    }
                %>
                <script>function showInfo() {alert("Prueba de JavaScript.\nDate:<%= date.get(Calendar.DATE)+"/"+(date.get(Calendar.MONTH)+1)+"/"+date.get(Calendar.YEAR) %>.");} </script>
    </body>
</html>
