<%--
  Created by IntelliJ IDEA.
  User: hugo
  Date: 25/03/19
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h2>Content : </h2>
    <ul>
      <li><a href="<%= request.getContextPath() + "/form"%>">Listing cookies</a></li>
      <li><a href="<%= request.getContextPath() + "/login"%>">Login</a></li>
      <li><a href="<%= request.getContextPath() + "/loginDatabase"%>">Login avec JDBC</a></li>
    </ul>
  </body>
</html>
