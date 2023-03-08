<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>IES El Majuelo</title>
        <link rel="stylesheet" href="estilos/style.css">
    </head>
    <body>
        <% session.setAttribute("conectado", false);%>
        <header><h1>Práctica HLC 5</h1></header>

        <h2>Github: </h2>
        <h2>Gmail: ablacar395@g.educaand.es</h2>

        <form method="post" action="InicioSesion">
            Usuario:    <input type="text" name="user"></br>
            Contraseña: <input type="password" name="pass"</br>
            </br></br><input type="submit" value="Login">
        </form>

        <footer><h1>Hecho por: <a href="google.com">Alberto Miguel Blázquez Caraballo</a></h1></footer>
    </body>
</html>
