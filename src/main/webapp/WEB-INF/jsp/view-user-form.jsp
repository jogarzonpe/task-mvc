<%--
  Created by IntelliJ IDEA.
  User: JonathanGarzónPeña
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo Usuario</title>
</head>
<body>
<c:url var="add_book_url" value="/users/save"/>
<form:form action="${add_book_url}" method="post" modelAttribute="user">
    <form:input type="hidden" path="id"/>
    <form:input type="hidden" path="data.id"/>
    <form:label path="data.name">Nombres: </form:label> <form:input type="text" path="data.name"/>
    <form:label path="data.lastname">Apellidos: </form:label> <form:input type="text" path="data.lastname"/>
    <form:label path="data.age">Edad: </form:label> <form:input type="text" path="data.age"/>
    <form:label path="email">Correo: </form:label> <form:input type="text" path="email"/>
    <form:label path="password">Password: </form:label> <form:input type="password" path="password"/>
    <form:label path="role">Rol: </form:label> <form:select path="role"><form:options items="${roles}" itemLabel="name"/></form:select>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
