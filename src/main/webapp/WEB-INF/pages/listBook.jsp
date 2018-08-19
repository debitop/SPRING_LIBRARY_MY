<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 22.07.2018
  Time: 13:38
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
        <td>studentId</td>
        <td>name</td>
        <td>pages</td>
        <td>author</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td><c:out value="${book.id}"/></td>
            <td><c:out value="${book.student.id}"/></td>
            <td><c:out value="${book.name}"/></td>
            <td><c:out value="${book.pages}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><a href="/book/editBook/${book.id}">Edit</a></td>
            <td><a href="/book/deleteBook/${book.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/book/addBook/${studentId}">Add book</a>
<a href="/student/">List students</a>
</body>
</html>
