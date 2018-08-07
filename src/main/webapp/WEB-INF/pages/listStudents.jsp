<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 31.07.2018
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" cellpadding="1" cellspacing="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>admin</td>
        <td>Date</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td><c:out value="${student.id}"/></td>
            <td><c:out value="${student.name}"/></td>
            <td><c:out value="${student.age}"/></td>
            <td><c:out value="${student.admin}"/></td>
            <td><c:out value="${student.createddate}"/></td>
            <td><a href="/student/del/${student.id}">Delete</a> </td>
            <td><a href="/student/edit/${student.id}">Update</a> </td>
            <td><a href="/book/${student.id}">List books</a> </td>
        </tr>
    </c:forEach>
</table>

<a href="/student/add">Create Student</a>

</body>
</html>
