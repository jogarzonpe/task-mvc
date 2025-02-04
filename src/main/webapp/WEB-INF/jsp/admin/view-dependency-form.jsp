<%--
  Created by IntelliJ IDEA.
  User: JonathanGarzónPeña
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Nueva Dependencia</title>
</head>
<body>
<c:url var="add_dependency_url" value="/dependencies/save"/>
<form:form action="${add_dependency_url}" method="post" modelAttribute="dependency">
    <form:input type="hidden" path="id"/>
    <form:label path="name">Nombre: </form:label> <form:input type="text" path="name"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
