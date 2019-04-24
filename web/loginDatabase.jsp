<%--
  Created by IntelliJ IDEA.
  User: hugo
  Date: 27/03/19
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login avec JDBC</title>
</head>
<body>

    <h2>Page de connexion</h2>


    <div>
        <form method="post" action="loginDatabase">
            <label>Email : </label>
            <input type="text" name="email"/>
            <br/>
            <label>Password :</label>
            <input type="password" name="password"/>
            <br/>
            <input type="submit">
        </form>
    </div>
</body>
</html>
