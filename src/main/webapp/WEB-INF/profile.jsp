<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <h1>Viewing ${username} profile.  Is <em>${password}</em> your password?</h1>
        <form action="/login">
            <button>I want out</button>
        </form>
    </div>

</body>
</html>
