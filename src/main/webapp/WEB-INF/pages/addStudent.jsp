<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 31.07.2018
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/student/add">
    <table cellspacing="1" cellpadding="1" border="1">
        <tr>
            <td>Name</td>
            <td><input type="text" value="" name="name"></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" value="" name="age"></td>
        </tr>
        <tr>
            <td>Admin</td>
            <td><input type="checkbox" name="admin"></td>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form>
</body>
</html>
