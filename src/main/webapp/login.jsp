<%--
  Created by IntelliJ IDEA.
  User: michaelsigg
  Date: 7/13/22
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<%--//get dat name--%>
<%--//username and password start--%>
<form action="login.jsp" method="POST">

    <label for="username">Username</label>
    <input type="text" id="username" name="username">

    <label for="password">password</label>
    <input type="text" id="password" name="password">

    <button>Gimme</button>

</form>
<%--//username and password end--%>
<%--JSTL start--%>

<%--/// checking for null case--%>
<%--<c:if test="${(param.username != null) && (param.password != null) }">--%>
<%--&lt;%&ndash;    ///if passed&ndash;%&gt;--%>
<%--    <c:choose>--%>
<%--        <c:when test='${(param.username.equalsIgnoreCase("admin")) && (param.password.equalsIgnoreCase("password"))}'>--%>
<%--            <%response.sendRedirect("/profile.jsp");%>--%>
<%--        </c:when>--%>
<%--&lt;%&ndash;        ///default&ndash;%&gt;--%>
<%--        <c:otherwise>--%>
<%--            <%response.sendRedirect("/login.jsp");%>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>

<%--</c:if>--%>
</body>
</html>
<%

    if(request.getParameter("username") != null || request.getParameter("password") != null) {
        if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("password")) {
            response.sendRedirect("/profile.jsp");
        } else {
            response.sendRedirect("/login.jsp");
        }
    }
%>