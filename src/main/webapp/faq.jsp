<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: michaelsigg
  Date: 7/13/22
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>

<% System.out.println("Hello World!");%>
<%! String color; %>
<%
    if(request.getParameter("color") != null) {
        color = request.getParameter("color");
    }
%>
<html>
<head>
    <title>Title</title>
    <nav>Nav Bar</nav>
</head>
<body>


<h1> Frequently akxed questions</h1>
<form action="faq.jsp" method="post">
    <label for="color">What yo color illz?</label>
    <input type="text" id="color" name="color" value="blue">
    <button type="submit">Gimme</button>
</form>
<p>
    Favorite color is: < ${param.color}>
</p>

<%
    List<String> trails = new ArrayList<>();
    trails.add("Salado Creek Greenway");
    trails.add("Whatever");
    trails.add("Something");

%>

<%
request.setAttribute("trails", trails);
%>
<ul>
    <c:forEach var="trail" items="${trails}">
        <li>${trail}</li>
    </c:forEach>
</ul>

<c:if test="${param.color !=null}">
    <c:choose>
        <c:when test='${param.color.equalsIgnoreCase("blue")}'>
            <h1>Whoa blue is my favorite color!</h1>
        </c:when>
        <c:otherwise>
            <h1> But... ${param.color} is not blue...</h1>
        </c:otherwise>
    </c:choose>
</c:if>

</body>
</html>
