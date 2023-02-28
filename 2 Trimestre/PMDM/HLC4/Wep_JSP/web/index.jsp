<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>JSP Page</h1>
    <jsp:include page="aIncluir.html" flush="false"></jsp:include>
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
   
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        <p>Hello ${param.name}!</p>
    </c:if>
    <c:choose>
        <c:when test='${param.name == null}'>
            <form>
                <strong>Introduce tu nombre, por favor</strong>
                <input type=text name="name"/>
                <input type="hidden" name="sayHello" value="true">               
                <input type="submit"/>
            </form>
        </c:when>
        <c:otherwise>
            <p>Hola ${param.name}!</p>
        </c:otherwise>
    </c:choose>
    
    <p>Con JavaBeans: Pulsa <a href="jspCalendar.jsp">aquí</a> para ver saber en que momento estamos</p>
    <p>Scriptlets (JSP puro): Pulsa <a href="listar.jsp">aquí</a> para probar</p>
    <p>JSTL (JSP taglib prefix="c") : Pulsa <a href="listar2.jsp">aquí</a> para probar</p>
    </body>
</html>
