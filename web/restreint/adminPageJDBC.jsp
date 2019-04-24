<%@ page import="beans.User" %><%--
  Created by IntelliJ IDEA.
  User: hugo
  Date: 27/03/19
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>espace admin JDBC</title>
</head>
<body>
<% User user = ((User)request.getSession().getAttribute("user"));%>
<h1>Admin</h1>
<p>Bonjour <%= user.getEmail() %> </p>
<p>date d'inscription : <%= user.getDateInscription() %> !</p>

<a href="<%= request.getContextPath() + "/admin/listUser"%>">Listing User</a>

</body>
</html>
