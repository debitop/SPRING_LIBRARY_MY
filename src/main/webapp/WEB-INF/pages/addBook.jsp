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

<form method="post" action="/book/addBook/${studentId}">
    <table border="1" cellspacing="1" cellpadding="1">
        <tr>
            <td>name</td>
            <td><input type="text" name="name" value=""></td>
        </tr>
        <tr>
            <td>pages</td>
            <td><input type="text" name="pages" value=""></td>
        </tr>
        <tr>
            <td>author</td>
            <td><input type="text" name="author" value=""></td>
        </tr>
    </table>
    <input type="submit" value="OK">
</form>
</body>
</html>
