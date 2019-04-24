<%--
  Created by IntelliJ IDEA.
  User: hugo
  Date: 03/04/19
  Time: 08:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>espace user</title>
</head>
<body>

<h1>user</h1>
<p>Bonjour <%= request.getSession().getAttribute("login")%> !</p>
</body>
</html>
