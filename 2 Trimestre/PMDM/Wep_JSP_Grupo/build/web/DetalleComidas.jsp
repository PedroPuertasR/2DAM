<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conozcamos al detalle las distintas comidas</title>
    </head>
    <body>
        
        <header>COMIDAS DEL MUNDO</header>
        
        <%
        String datos = request.getParameter("country");
        int index = 0;
        if (datos != null) {

            if (datos.contains("Tortilla de Patatas")) {
        %>
        
        <img src="imganes/españa.jpg" width="250" height="150" alt="Tortilla de Patatas">
        <p><u><strong>  Datos del objeto Selecionado: </strong></u></p>
        <p> <%=datos%></p>

        <p><strong> DESCRIPCION </strong></p>

        <p>La tortilla de patatas es un plato típico de la gastronomía española, que consiste en una tortilla hecha a base de huevos 
        y patatas. Se suele cortar en trozos y servirse como aperitivo o como plato principal. La tortilla de patatas es uno de los platos
        más populares de España y se consume en todo el país.

        </p>
    <%

    } else if (datos.contains("Cocido")) {
        %>
        <p><h2>COCIDO</h2></p>
        <img src="imagenes/españa.jpg" width="250" height="150" alt="Cocido">

        <p><u><strong>  Datos del objeto Selecionado: </strong></u></p>
        <p> <%=datos%></p>

        <p><u><strong> Descripcion </strong></u></p>
        <p>El cocido es un plato típico de la gastronomía española, especialmente popular en el centro y norte de España. Consiste en un guiso de 
            carnes, legumbres y verduras, que se cuecen juntas en una olla a fuego lento durante varias horas. Los ingredientes pueden variar según
            la región, pero suelen incluir garbanzos, carne de cerdo, pollo, chorizo, morcilla, patatas, zanahorias y repollo. Se suele servir en 
            dos partes: primero se sirve el caldo, y luego los ingredientes sólidos. Se cree que su origen se remonta a la época de los romanos.</p>

       <%
    }else if (datos.contains("Paella")) {
        %>
        <p><h2>PAELLA</h2></p>
        <img src="imagenes/españa.jpg" width="250" height="150" alt="Paella">

        <p><u><strong>  Datos del objeto Selecionado: </strong></u></p>
        <p> <%=datos%></p>

        <p><u><strong> DESCRIPCION </strong></u></p>
        <p>
            La paella es un plato típico de la gastronomía española, originario de la Comunidad Valenciana. Se trata de un arroz seco que se cocina 
            en una paellera (una sartén plana y ancha) junto con otros ingredientes, como pollo, conejo, mariscos, verduras y especias. La paella es 
            uno de los platos más conocidos de España y se ha popularizado en todo el mundo.
        </p>
        <%
    }else if (datos.contains("Salmorejo")) {
        %>
        <p><h2>SALMOREJO</h2></p>
        <img src="imagenes/españa.jpg" width="250" height="150" alt="Salmorejo">

        <p><u><strong>  Datos del objeto Selecionado: </strong></u></p>
        <p> <%=datos%></p>

        <p><u><strong> DESCRIPCION </strong></u></p>
        <p>
            El salmorejo es una sopa fría típica de la cocina española, originaria de la región de Andalucía. Se elabora a partir de tomates maduros, 
            pan, ajo, aceite de oliva y vinagre. Todo se tritura hasta conseguir una textura suave y homogénea. Se suele servir frío como entrante o primer plato.
        </p>
        
        <%
    }else if (datos.contains("Enchiladas")) {
        %>
        <p><h2>ENCHILADAS</h2></p>
        <img src="imagenes/Mexico.jpg" width="250" height="150" alt="Enchiladas">

        <p><u><strong>  Datos del objeto Selecionado: </strong></u></p>
        <p> <%=datos%></p>

        <p><u><strong> DESCRIPCION </strong></u></p>
        <p>
            Las enchiladas son un plato de la cocina mexicana que consiste en tortillas de maíz rellenas de carne, pollo o frijoles, y que se cubren 
            con una salsa picante de chile. A veces se añade queso, crema y cebolla para darle más sabor. Se suelen servir con arroz y frijoles refritos.
            Las enchiladas son muy populares en México y en otros países de América Latina.
        </p>
        <%
    }else if (datos.contains("Tacos")) {
        %>
        <p><h2>TACOS</h2></p>
        <img src="imagenes/Mexico.jpg" width="250" height="150" alt="Tacos">

        <p><u><strong>  Datos del objeto Selecionado: </strong></u></p>
        <p> <%=datos%></p>

        <p><u><strong> DESCRIPCION </strong></u></p>
        <p>
            Los tacos son un plato de la cocina mexicana que consiste en tortillas de maíz o de trigo rellenas de carne, pescado, verduras u otros 
            ingredientes, y que se suelen aderezar con salsa y limón. Los tacos se pueden servir blandos o crujientes, y son una comida muy popular 
            en México y en todo el mundo.
        </p>
        <%
    }else if (datos.contains("Burritos")) {
        %>
        <p><h2>BURRITOS</h2></p>
        <img src="imagenes/Mexico.jpg" width="250" height="150" alt="Burritos">

        <p><u><strong>  Datos del objeto Selecionado: </strong></u></p>
        <p> <%=datos%></p>

        <p><u><strong> DESCRIPCION </strong></u></p>
        <p>
            Los burritos son un plato de la cocina mexicana que consiste en tortillas de trigo rellenas de arroz, frijoles, carne, verduras y otros
            ingredientes. Los burritos se enrollan en forma de cilindro y se pueden comer con las manos. Los burritos son muy populares en México.
        </p>
        <%
    }else if (datos.contains("Pollo Tandoori")) {
        %>
        <p><h2>POLLO TANDOORI</h2></p>
        <img src="imagenes/India.jpg" width="250" height="150" alt="Pollo Tandoori">

        <p><u><strong>  Datos del objeto Selecionado: </strong></u></p>
        <p> <%=datos%></p>

        <p><u><strong> DESCRIPCION </strong></u></p>
        <p>
            El pollo Tandoori es un plato de la cocina india que se elabora con pollo marinado en una mezcla de especias y yogur, y se cocina 
            en un horno de barro llamado tandoor. El resultado es un pollo muy aromático, tierno y jugoso. Se suele servir con arroz basmati y pan naan.
        </p>
        <%
    }else if (datos.contains("Curries")) {
        %>
        <p><h2>CURRIES</h2></p>
        <img src="imagenes/India.jpg" width="250" height="150" alt="Curries">

        <p><u><strong>  Datos del objeto Selecionado: </strong></u></p>
        <p> <%=datos%></p>

        <p><u><strong> DESCRIPCION </strong></u></p>
        <p>
            Los curries son un plato de la cocina india que consisten en una mezcla de especias y hierbas que se utilizan para cocinar una variedad de 
            platos con carne, pescado, verduras o legumbres. Los curries pueden ser suaves o muy picantes, dependiendo de las especias utilizadas. 
            Se suelen servir con arroz o pan naan.
        </p>
        <%
    } else if (datos.contains("Lassi")) {
        %>
        <p><h2>LASSI</h2></p>
        <img src="imagenes/India.jpg" width="250" height="150" alt="Lassi">

        <p><u><strong>  Datos del objeto Selecionado: </strong></u></p>
        <p> <%=datos%></p>

        <p><u><strong> DESCRIPCION </strong></u></p>
        <p>
            El lassi es una bebida refrescante de la cocina india que se elabora con yogur, agua y especias. Se puede hacer dulce o salado, dependiendo 
            de los ingredientes utilizados. El lassi se suele servir frío y es muy popular en toda la India.
        </p>
        <%
   } else{
        %><p>No hay información disponible para esta comida.</p>
       
   }
   
   <footer>
       <p>Para volver a la página principal pinche aquí <a href="index.jsp"> </a> </p>
   </footer> 
        
   </body>
</html>
