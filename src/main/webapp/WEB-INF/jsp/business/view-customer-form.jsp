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
    <title>Nuevo Cliente</title>
</head>
<body>
<c:url var="add_customer_url" value="/employees/${employeeId}/customers/save"/>
<form:form action="${add_customer_url}" method="post" modelAttribute="customer">
    <form:input type="hidden" path="id"/>
    <form:input type="hidden" path="data.id"/>
    <form:input type="hidden" path="responsible"/>
    <form:label path="data.name">Nombres: </form:label> <form:input type="text" path="data.name"/>
    <form:label path="data.lastname">Apellidos: </form:label> <form:input type="text" path="data.lastname"/>
    <form:label path="data.age">Edad: </form:label> <form:input type="text" path="data.age"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
