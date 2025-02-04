<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Inicio</title>
</head>
<body>
<div><a href="${contextPath}/roles">Ir a gestión de roles</a></div>
<div><a href="${contextPath}/users">Ir a gestión de usuarios</a></div>
<div><a href="${contextPath}/job-titles">Ir a gestión de cargos</a></div>
<div><a href="${contextPath}/dependencies">Ir a gestión de dependencias</a></div>
<div><a href="${contextPath}/employees">Ir a gestión de empleados</a></div>
</body>
</html>
