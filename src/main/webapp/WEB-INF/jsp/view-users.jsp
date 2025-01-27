<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Ver usuarios</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<c:if test="${saveUserSuccess}">
    <div>Usuario guardado con ID: ${savedUser.id}</div>
</c:if>
<div><a href="${contextPath}/users/add">Nuevo Usuario</a></div>
<table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Edad</th>
        <th>Correo</th>
        <th>Rol</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.data.name}</td>
            <td>${user.data.lastname}</td>
            <td>${user.data.age}</td>
            <td>${user.email}</td>
            <td>${user.role.name}</td>
            <td>
                <a href="${contextPath}/users/<c:out value='${user.id}'/>">Editar</a>
                <a href="${contextPath}/users/delete/<c:out value='${user.id}'/>">Borrar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
