<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Ver Empleados</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<c:if test="${saveCustomerSuccess}">
    <div>Cliente guardado con ID: ${savedCustomer.id}</div>
</c:if>
<div><a href="${contextPath}/employees/<c:out value='${employeeId}'/>/customers/add">Nuevo Cliente</a></div>
<table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Edad</th>
        <th>Cliente Desde</th>
        <th>Responsable</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.data.name}</td>
            <td>${customer.data.lastname}</td>
            <td>${customer.data.age}</td>
            <td>${customer.sinceDate}</td>
            <td>${customer.responsible.data.name} ${customer.responsible.data.lastname}</td>
            <td>
                <a href="${contextPath}/employees/<c:out value='${employeeId}'/>/customers/<c:out value='${customer.id}'/>">Editar</a>
                <a href="${contextPath}/employees/<c:out value='${employeeId}'/>/customers/delete/<c:out value='${customer.id}'/>">Borrar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
