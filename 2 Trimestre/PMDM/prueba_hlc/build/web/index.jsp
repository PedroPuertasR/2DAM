<%-- 
    Document   : index
    Created on : 08-mar-2023, 18:10:22
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login del examen</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <header>
            <h1>Examen HLC</h1>
        </header>

        <form class="formLogin" method="post" action="LogIn">
            <div class="formCol">

                <div class="formFil">
                    <p>Usuario</p> 
                    <input type="text" name="user"</br>
                </div>

                <div class="formFil">
                    <p>Contraseña</p> 
                    <input type="password" name="pass"</br>
                </div>

                <input id="botonLog" type="submit" value="Login">
            </div>

        </form>

    </body>
</html>
