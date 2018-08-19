<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<form:form method="post" action="/book/editBook/${bookAttribute.id}" modelAttribute="bookAttribute">
    <table>
        <tr>
            <td><form:label path="id"></form:label></td>
            <td><form:input path="id" disabled="true"></form:input></td>
        </tr>
        <tr>
            <td></td>

        </tr>

    </table>

</form:form>

</body>
</html>
