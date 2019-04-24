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
    <title>espace user JDBC</title>
</head>
<body>

<h1>User</h1>
<p>Bonjour <%= request.getSession().getAttribute("user") %> </p>
<p>date d'inscription : <%= request.getSession().getAttribute("date_inscription") %> !</p>

</body>
</html>
