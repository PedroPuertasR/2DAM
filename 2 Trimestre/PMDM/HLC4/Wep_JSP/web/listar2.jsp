<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> How to Loop over Map i.e. HashMap or Hashtable in JSP - JSTL foreach tag example</title>
    </head>

    <body>  
        <h2> How to traverse HashMap in JSP</h2>

        <%
            // Avoid Java Code in JSP - This is only for ease of testing
            Map<Integer, String> numberToString = new HashMap<Integer, String>();
            numberToString.put(1, "JSP");
            numberToString.put(2, "Java");
            numberToString.put(3, "JSTL");
            numberToString.put(4, "J2EE");
            numberToString.put(5, "JEE");

            // put the hashmap as pageContext attribute
            pageContext.setAttribute("map", numberToString);
        %>


        <%-- JSTL foreach tag example to loop a HashMap in JSP --%>
        <table>
            <c:forEach var="entry" items="${pageScope.map}">
                <tr><td><c:out value="${entry.key}"/></td> <td><c:out value="${entry.value}"/> </td></tr>
            </c:forEach>
        </table>
        
         <h2> How to loop Hashtable in JSP</h2>

        <%
            // Avoid Java Code in JSP - This is only for ease of testing
            Map<String, Integer> prices = new Hashtable<String, Integer>();
            prices.put("Google", 500);
            prices.put("Apple", 300);
            prices.put("Amazon", 320);
            prices.put("BABA", 94);
            prices.put("MSFT", 30);

            // putting hashtable into pageContext variable
            pageContext.setAttribute("sharePrice", prices);
        %>


        <%-- JSTL foreach tag example to loop Hashtable in JSP --%>
        <table>
            <c:forEach var="entry" items="${pageScope.sharePrice}">
                <tr><td><c:out value="${entry.key}"/></td> <td><c:out value="${entry.value}"/> </td></tr>
            </c:forEach>
        </table>
        <p>Pulsa <a href="index.jsp">aquí</a> para ver el origen.</p>
    </body>
</html>

