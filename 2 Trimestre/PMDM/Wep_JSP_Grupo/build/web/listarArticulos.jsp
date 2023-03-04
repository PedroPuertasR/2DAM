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

            .imagenes{
                display: flex;
                flex-direction: row;
                justify-content: center;
                margin-bottom: 50px;
            }

            .imagenes img{
                margin-right: 40px;
            }

            .contenedor, .contenedor-map{
                display: flex;
                flex-direction: column;
                justify-content: center;
                margin: 2%
            }

            #comidaEspania, #comidaIndia, #comidaMexico{
                display: none;
            }

            section{
                display: none;
                flex-direction: column;
                justify-content: center;
            }

            article{
                text-align: center;
                justify-content: center;
                margin-left: 100px;
                margin-right: 100px;
            }
            
            a{
                background-color: red;
                color: black;
                margin-left: 800px;
                margin-right: 800px;
                padding-top: 20px;
                padding-bottom: 20px;
                margin-top: 20px;
                margin-bottom: 20px;
            }
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
            Comida c6 = new Comida("Enchilada", "México", new Date(1800, 01, 01), 400, "./img/enchiladas.jpg");
            Comida c7 = new Comida("Burrito", "México", new Date(1900, 01, 01), 600, "./img/burritos.jpg");
            Comida c8 = new Comida("Pollo Tandoori", "India", new Date(1920, 01, 01), 300, "./img/pollotandoori.jpg");
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
        <div class="contenedor">
            <div class="imagenes">
                <img id="espania" width="250" height="160" src="./img/españa.png" alt="Bandera España">
                <img id="mexico" width="250" height="160" src="./img/mexico.png" alt="Bandera México">
                <img id="india" width="250" height="160" src="./img/india.png" alt="Bandera India">
            </div>

            <p id="texto-personalizado"></p>

            <a id="botonVolver">Volver</a>
            
            <a href="index.jsp">Inicio</a>
        </div>

        <section id="comidaEspania">
            <%
                for(java.util.Map.Entry<String, Comida> food : listaEspania.entrySet()) {
                    
                    String key = food.getKey();
                    Comida aux = food.getValue();
            %>

            <article>
                <h1>Nombre: <%=aux.getNombre()%></h1>

                <p>
                    País: <%=aux.getPais()%>
                </p>

                <p>
                    Fecha de invencion: <%=aux.getFecha_inv()%>
                </p>

                <p>
                    Calorias: <%=aux.getCalorias()%> cal.
                </p>

                <img width="350" height="260" src=<%=aux.getFoto()%> alt="Imagen de comida">

                <%
                    if(key.toLowerCase().equalsIgnoreCase("tortilla")){
                    
                %>
                <p>
                    La tortilla de patatas es un plato típico de la gastronomía española, 
                    que consiste en una tortilla hecha a base de huevos y patatas. Se suele 
                    cortar en trozos y servirse como aperitivo o como plato principal. 
                    La tortilla de patatas es uno de los platos más populares de España y 
                    se consume en todo el país.
                </p>
                <%
                    }else if(key.toLowerCase().equalsIgnoreCase("salmorejo")){     
                %>
                <p>
                    El salmorejo cordobés es una crema servida habitualmente como primer plato;
                    se trata de una preparación tradicional de Córdoba (Andalucía).​ Se elabora 
                    mediante un majado (machacado, triturado) de una cierta cantidad de miga de pan 
                    (o la telera, un pan también de origen cordobés), a la que se le incluye 
                    además ajo, aceite de oliva, sal y tomates.
                </p>
                <%
                    }else if(key.toLowerCase().equalsIgnoreCase("cocido")){
                %>
                <p>
                    El cocido es un plato típico de la gastronomía española, especialmente 
                    popular en el centro y norte de España. Consiste en un guiso de carnes, 
                    legumbres y verduras, que se cuecen juntas en una olla a fuego lento durante
                    varias horas. Los ingredientes pueden variar según la región, pero suelen
                    incluir garbanzos, carne de cerdo, pollo, chorizo, morcilla, patatas,
                    zanahorias y repollo. Se suele servir en dos partes: primero se sirve
                    el caldo, y luego los ingredientes sólidos. Se cree que su origen se 
                    remonta a la época de los romanos.
                </p>
                <%
                    }else if(key.toLowerCase().equalsIgnoreCase("paella")){
                %>
                <p>
                    La paella es un plato típico de la gastronomía española, originario de 
                    la Comunidad Valenciana. Se trata de un arroz seco que se cocina en una
                    paellera (una sartén plana y ancha) junto con otros ingredientes, 
                    como pollo, conejo, mariscos, verduras y especias. La paella es uno 
                    de los platos más conocidos de España y se ha popularizado en todo el mundo.
                </p>
                <%
                    }
                %>
            </article>

            <%
            }
            %>
        </section>

        <section id="comidaMexico">
            <%
                for(java.util.Map.Entry<String, Comida> food : listaMexico.entrySet()) {
                    
                    String key = food.getKey();
                    Comida aux = food.getValue();
            %>

            <article>
                <h1>Nombre: <%=aux.getNombre()%></h1>

                <p>
                    País: <%=aux.getPais()%>
                </p>

                <p>
                    Fecha de invencion: <%=aux.getFecha_inv()%>
                </p>

                <p>
                    Calorias: <%=aux.getCalorias()%> cal.
                </p>

                <img width="350" height="260" src=<%=aux.getFoto()%> alt="Imagen de comida">

                <%
                    if(key.toLowerCase().equalsIgnoreCase("tacos")){
                    
                %>
                <p>
                    Los tacos son un plato de la cocina mexicana que consiste en tortillas de 
                    maíz o de trigo rellenas de carne, pescado, verduras u otros ingredientes,
                    y que se suelen aderezar con salsa y limón. Los tacos se pueden servir 
                    blandos o crujientes, y son una comida muy popular en México y en todo el mundo.
                </p>
                <%
                    }else if(key.toLowerCase().equalsIgnoreCase("enchilada")){     
                %>
                <p>
                    Las enchiladas son un plato de la cocina mexicana que consiste en tortillas 
                    de maíz rellenas de carne, pollo o frijoles, y que se cubren con una salsa
                    picante de chile. A veces se añade queso, crema y cebolla para darle más sabor.
                    Se suelen servir con arroz y frijoles refritos. Las enchiladas son muy populares 
                    en México y en otros países de América Latina.
                </p>
                <%
                    }else if(key.toLowerCase().equalsIgnoreCase("burrito")){
                %>
                <p>
                    Los burritos son un plato de la cocina mexicana que consiste en tortillas de
                    trigo rellenas de arroz, frijoles, carne, verduras y otros ingredientes.
                    Los burritos se enrollan en forma de cilindro y se pueden comer con las manos.
                    Los burritos son muy populares en México y en los Estados Unidos.
                </p>
                <%
                    }
                %>
            </article>

            <%
            }
            %>
        </section>

        <section id="comidaIndia">
            <%
                for(java.util.Map.Entry<String, Comida> food : listaIndia.entrySet()) {
                    
                    String key = food.getKey();
                    Comida aux = food.getValue();
            %>

            <article>
                <h1>Nombre: <%=aux.getNombre()%></h1>

                <p>
                    País: <%=aux.getPais()%>
                </p>

                <p>
                    Fecha de invencion: <%=aux.getFecha_inv()%>
                </p>

                <p>
                    Calorias: <%=aux.getCalorias()%> cal.
                </p>

                <img width="350" height="260" src=<%=aux.getFoto()%> alt="Imagen de comida">

                <%
                    if(key.toLowerCase().equalsIgnoreCase("pollo tandoori")){
                    
                %>
                <p>
                    El pollo Tandoori es un plato de la cocina india que se elabora con 
                    pollo marinado en una mezcla de especias y yogur, y se cocina en un
                    horno de barro llamado tandoor. El resultado es un pollo muy aromático,
                    tierno y jugoso. Se suele servir con arroz basmati y pan naan.
                </p>
                <%
                    }else if(key.toLowerCase().equalsIgnoreCase("lassi")){     
                %>
                <p>
                    Los curries son un plato de la cocina india que consisten en una mezcla
                    de especias y hierbas que se utilizan para cocinar una variedad de platos
                    con carne, pescado, verduras o legumbres. Los curries pueden ser suaves 
                    o muy picantes, dependiendo de las especias utilizadas. Se suelen servir
                    con arroz o pan naan.
                </p>
                <%
                    }else if(key.toLowerCase().equalsIgnoreCase("curries")){
                %>
                <p>
                    El lassi es una bebida refrescante de la cocina india que se elabora con 
                    yogur, agua y especias. Se puede hacer dulce o salado, dependiendo de los
                    ingredientes utilizados. El lassi se suele servir frío y es muy popular
                    en toda la India.
                </p>
                <%
                    }
                %>
            </article>

            <%
            }
            %>
        </section>
    </body>

    <script>
        var imagen1 = document.getElementById('espania');
        var imagen2 = document.getElementById('mexico');
        var imagen3 = document.getElementById('india');
        var arrayEspania = document.getElementById('comidaEspania');
        var arrayMexico = document.getElementById('comidaMexico');
        var arrayIndia = document.getElementById('comidaIndia');
        var textoPersonalizado = document.getElementById('texto-personalizado');

        imagen1.addEventListener('click', mostrarTextoPersonalizado);
        imagen2.addEventListener('click', mostrarTextoPersonalizado);
        imagen3.addEventListener('click', mostrarTextoPersonalizado);

        botonVolver.addEventListener('click', function () {
            imagen1.style.display = 'inline-block';
            imagen2.style.display = 'inline-block';
            imagen3.style.display = 'inline-block';
            arrayEspania.style.display = "none";
            arrayMexico.style.display = "none";
            arrayIndia.style.display = "none";

            textoPersonalizado.textContent = '';
        });

        function mostrarTextoPersonalizado(event) {
            var idImagen = event.target.id;

            switch (idImagen) {
                case 'espania':
                    textoPersonalizado.textContent = 'Has hecho clic en España';
                    arrayEspania.style.display = "flex";
                    imagen1.style.display = "inline-block";
                    imagen2.style.display = "none";
                    imagen3.style.display = "none";
                    break;
                case 'mexico':
                    textoPersonalizado.textContent = 'Has hecho clic en México';
                    arrayMexico.style.display = "flex";
                    imagen1.style.display = "none";
                    imagen2.style.display = "inline-block";
                    imagen3.style.display = "none";
                    break;
                case 'india':
                    textoPersonalizado.textContent = 'Has hecho clic en India';
                    arrayIndia.style.display = "flex";
                    imagen1.style.display = "none";
                    imagen2.style.display = "none";
                    imagen3.style.display = "inline-block";
                    break;
                default:
                    textoPersonalizado.textContent = '';
            }
        }

    </script>
</html>
