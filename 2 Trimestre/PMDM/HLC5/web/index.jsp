<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Indice HLC5</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%session.setAttribute("conectado", false);%>
        <header>
            <h1>Práctica HLC 5</h1>
        </header>

        <div class="loginInicio">
            <h2>Nombre: Pedro Puertas Rodríguez</h2>
            <h2>Curso: 2ºDAM</h2>

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
        </div>
        
        <footer>
            <h1>HLC 5</h1>
            <a href="#loginInicio">Volver arriba</a>
        </footer>
    </body>
</html>
