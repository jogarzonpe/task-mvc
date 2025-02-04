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
    <title>Ver Cargos</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<c:if test="${saveJobTitleSuccess}">
    <div>Cargo guardado con ID: ${savedJobTitle.id}</div>
</c:if>
<div><a href="${contextPath}/job-titles/add">Nuevo Cargo</a></div>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nombre Cargo</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${jobTitles}" var="dependency">
        <tr>
            <td>${dependency.id}</td>
            <td>${dependency.name}</td>
            <td>
                <a href="${contextPath}/job-titles/<c:out value='${dependency.id}'/>">Editar</a>
                <a href="${contextPath}/job-titles/delete/<c:out value='${dependency.id}'/>">Borrar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
