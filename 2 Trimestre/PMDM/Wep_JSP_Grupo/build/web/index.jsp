<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Principal</title>
        
        <style>
          
            h2 {
                margin-bottom: 50px;
                text-align: center;
                font-weight: bold;
                color: #FFFFFF;
            }
            
            h4 {

                text-align: center;
                font-weight: bold;
                color: #FFFFFF;
            }

            p{
                text-align: center;
            }
            

            html {
                position: relative;
            }

            body {
                background-color: rgb(80, 80, 80);
            }

            header {
                position: fixed;
                width: 100%;
                padding: 30px 100px;
                background: linear-gradient(45deg, white, transparent);
            }

            section {
                margin: 50px;
                border: 8px double #888;
                border-radius: 200px 50px 200px 50px;
                padding: 80px;
                background-color: #ccc;
            }


            article {
                font-family: Verdana;
                font-weight: 200;
                color: #ffffff;
                background:#925178;
                padding: 20px;
                margin: 0 0 25px;
                overflow: visible;
                border-radius: 35px 0px 35px 0px;
                text-align: center;
            }

            footer {
                background-color: #00FFFF;
                padding: 10px;
                text-align: center;
                color: black;             
            }
        </style>
    </head>
    
    <body>
        
        <header>PROYECTO HLC WEB CON JSP</header>
        <%@page language="java" import="java.util.*" %>
        <section>
            <article>
                <h2>Accede a ver la Edad y Horóscopo de los creadores de esta Web</h2>
                        <a href="edadyZodiaco.jsp">¡Descubramos como de viejos son!</a>        
            </article>
            
            <article>
              <h2>Visita nuestra lista de comidas de típicas de los siguientes países: España, India y Mexico</h2>
                <a href="listarTabla.jsp">Descubre las comidas típicas de España, Mexico y India</a>
            </article>  
            
            <article>
              <h2>Conoce más sobre cada una de las comidas típicas</h2>
                <a href ="listarArticulos.jsp">Conozcamos en detalle estas comidas</a>
                </article> 
                    
            <article>
                <h2><u>Creadores de la web</u></h2>
                    <h4>Pedro Puertas Rodriguez</h4>
                    <h4>Guillermo Pernas Ruiz </h4>
                    <h4>Inmaculada Rueda Bautista</h4>
            </article>
        </section>
    </body>
    
    <footer>
        <span>ESPERAMOS QUE TE GUSTE TOMÁS</span>
    </footer>
</html>
