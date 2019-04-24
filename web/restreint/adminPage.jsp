<%--
  Created by IntelliJ IDEA.
  User: hugo
  Date: 27/03/19
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>espace admin</title>
</head>
<body>

    <h1>Admin</h1>
    <p>Bonjour <%= request.getSession().getAttribute("user") %> <%= request.getSession().getAttribute("password") %> !</p>
</body>
</html>
