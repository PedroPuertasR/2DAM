<%@page contentType="text/html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>
<%@page import="ejercicio.Comida"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de países</title>
        <style>
            h1,h2, div {text-align: center;}
            h2 {color:red;}
        </style>
    </head>
    <body>
        <h1>Selecciona un país para ver sus comidas</h1>
        <h2 id="result">Países</h2>
        <br/>
        <%
            Map<String, Comida> listaEspania = new HashMap<String, Comida>();
            Map<String, Comida> listaMexico = new HashMap<String, Comida>();
            Map<String, Comida> listaIndia = new HashMap<String, Comida>();
            
            Comida c1 = new Comida("Tortilla de patatas", "España", new Date(1800, 01, 01), 300, "./img/tortilla.jpg");
            Comida c2 = new Comida("Paella", "España", new Date(1750, 01, 01), 500, "./img/paella.jpg");
            Comida c3 = new Comida("Cocido", "España", new Date(200, 01, 01), 600, "./img/cocido.jpg");
            Comida c4 = new Comida("Salmorejo", "España", new Date(1737, 01, 01), 200, "./img/salmorejo.jpg");
            Comida c5 = new Comida("Tacos", "México", new Date(1900, 01, 01), 200, "./img/tacos.jpg");
            Comida c6 = new Comida("Enchilada", "México", new Date(1800, 01, 01), 400, "./img/enchilada.jpg");
            Comida c7 = new Comida("Burrito", "México", new Date(1900, 01, 01), 600, "./img/burrito.jpg");
            Comida c8 = new Comida("Pollo Tandoori", "India", new Date(1920, 01, 01), 300, "./img/pollo.jpg");
            Comida c9 = new Comida("Curries", "India", new Date(200, 01, 01), 500, "./img/curries.jpg");
            Comida c10 = new Comida("Lassi", "India", new Date(200, 01, 01), 200, "./img/lassi.jpg");
            
            listaEspania.put("Tortilla", c1);
            listaEspania.put("Paella", c2);
            listaEspania.put("Cocido", c3);
            listaEspania.put("Salmorejo", c4);
            listaMexico.put("Tacos", c5);
            listaMexico.put("Enchilada", c6);
            listaMexico.put("Burrito", c4);
            listaIndia.put("Pollo Tandoori", c8);
            listaIndia.put("Curries", c9);
            listaIndia.put("Lassi", c10);
        %>
        <div>
            <select id="food" name="fooditems">
                <%
                    for(java.util.Map.Entry<String, Comida> food : listaEspania.entrySet()) {
                %>
                <option value="<%=food.getKey()%>">
                    <%=food.getValue() %>
                </option>

                <%
                }
                %>
            </select>
            <script>
                function GetSelectedValue() {
                    var e = document.getElementById("food");
                    var result = e.options[e.selectedIndex].value;
                    document.getElementById("result").innerHTML = result;
                }

                function GetSelectedText() {
                    var e = document.getElementById("food");
                    var result = e.options[e.selectedIndex].text;
                    document.getElementById("result").innerHTML = result;
                }

                var imagen1 = document.getElementById('espania');
                var imagen2 = document.getElementById('mexico');
                var imagen3 = document.getElementById('india');
                var textoPersonalizado = document.getElementById('texto-personalizado');

                imagen1.addEventListener('click', mostrarTextoPersonalizado);
                imagen2.addEventListener('click', mostrarTextoPersonalizado);
                imagen3.addEventListener('click', mostrarTextoPersonalizado);

                function mostrarTextoPersonalizado(event) {
                    var idImagen = event.target.id;
                    
                    switch (idImagen) {
                        case 'espania':
                            textoPersonalizado.textContent = 'Has hecho clic en la imagen 1';
                            break;
                        case 'mexico':
                            textoPersonalizado.textContent = 'Has hecho clic en la imagen 2';
                            break;
                        case 'india':
                            textoPersonalizado.textContent = 'Has hecho clic en la imagen 3';
                            break;
                        default:
                            textoPersonalizado.textContent = '';
                    }
                }

            </script>
            <br/>
            <br/>
            <button type="button" onclick="GetSelectedValue()">Get Selected Value</button>
            <button type="button" onclick="GetSelectedText()">Get Selected Text</button>
        </div>
        <p>Pulsa <a href="index.jsp">aquí</a> para ver el origen.</p>
    </body>
</html>
