<%@page contentType="text/html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1,h2, div {text-align: center;}
            h2 {color:red;}
        </style>
    </head>
    <body>
        <h1>JavaScript - Get selected value from dropdown list</h1>
        <h2 id="result">mango</h2>
        <br/>
        <%!Map<String, String> foods = new HashMap<String, String>();
        %>
        <%
            foods.put("man", "mango");
            foods.put("app", "apple");
            foods.put("gra", "grapes");
            foods.put("car", "carrot");
            foods.put("asp", "asparagus");
            foods.put("ban", "banana");
        %>
        <div>
        <select id="food" name="fooditems">
        <%
            for(java.util.Map.Entry<String, String> food : foods.entrySet()) {
        %>
                <option value="<%=food.getKey()%>">
                <%=food.getValue() %>
            </option>

        <%
        }
        %>
        </select>
        <script>
	function GetSelectedValue(){
		var e = document.getElementById("food");
		var result = e.options[e.selectedIndex].value;
		document.getElementById("result").innerHTML = result;
	}

	function GetSelectedText(){
		var e = document.getElementById("food");
		var result = e.options[e.selectedIndex].text;
		document.getElementById("result").innerHTML = result;
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
