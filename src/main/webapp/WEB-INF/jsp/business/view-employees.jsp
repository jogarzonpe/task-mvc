<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Ver Empleados</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<c:if test="${saveEmployeeSuccess}">
    <div>Empleado guardado con ID: ${savedEmployee.id}</div>
</c:if>
<div><a href="${contextPath}/employees/add">Nuevo Empleado</a></div>
<table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Edad</th>
        <th>Cargo</th>
        <th>Dependencia</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.data.name}</td>
            <td>${employee.data.lastname}</td>
            <td>${employee.data.age}</td>
            <td>${employee.jobTitle.name}</td>
            <td>${employee.dependency.name}</td>
            <td>
                <a href="${contextPath}/employees/<c:out value='${employee.id}'/>">Editar</a>
                <a href="${contextPath}/employees/delete/<c:out value='${employee.id}'/>">Borrar</a>
                <a href="${contextPath}/employees/<c:out value='${employee.id}'/>/customers">Ver Clientes</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
