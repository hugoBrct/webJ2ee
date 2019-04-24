<%--
  Created by IntelliJ IDEA.
  User: hugo
  Date: 24/04/19
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Listing des utilisateurs</title>
</head>
<body>

    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>email</th>
            <th>date_inscription</th>
            <th>role</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.getId()}" />></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
