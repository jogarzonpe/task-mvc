<%--
  Created by IntelliJ IDEA.
  User: JonathanGarzónPeña
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Ver Dependencias</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<c:if test="${saveDependencySuccess}">
    <div>Dependencia guardada con ID: ${savedDependency.id}</div>
</c:if>
<div><a href="${contextPath}/dependencies/add">Nueva Dependencia</a></div>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nombre Dependencia</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dependencies}" var="dependency">
        <tr>
            <td>${dependency.id}</td>
            <td>${dependency.name}</td>
            <td>
                <a href="${contextPath}/dependencies/<c:out value='${dependency.id}'/>">Editar</a>
                <a href="${contextPath}/dependencies/delete/<c:out value='${dependency.id}'/>">Borrar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
