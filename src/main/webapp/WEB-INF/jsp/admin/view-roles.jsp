<%--
  Created by IntelliJ IDEA.
  User: JonathanGarzónPeña
  Date: 26/01/2025
  Time: 2:10 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Ver Roles</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<c:if test="${saveRoleSuccess}">
    <div>Rol guardado con ID: ${savedRole.id}</div>
</c:if>
<div><a href="${contextPath}/roles/add">Nuevo Rol</a></div>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nombre rol</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${roles}" var="role">
        <tr>
            <td>${role.id}</td>
            <td>${role.name}</td>
            <td>
                <a href="${contextPath}/roles/<c:out value='${role.id}'/>">Editar</a>
                <a href="${contextPath}/roles/delete/<c:out value='${role.id}'/>">Borrar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
