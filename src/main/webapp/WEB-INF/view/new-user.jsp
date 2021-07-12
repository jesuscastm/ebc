<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Nuevo usuario</title>
    </head>
    <body>
        <c:if test="${newUserSuccess}">
            <div>El usuario ${newUser.username} fué creado correctamente.</div>
        </c:if>
        <c:url var="new_user_url" value="/ventas/newUser" />
        <form:form action="${new_user_url}" method="post" modelAttribute="user">
            <form:label path="name">Nombre: </form:label>
            <form:input type="text" path="name"/>
            <form:label path="username">Usuario: </form:label>
            <form:input type="text" path="username"/>
            <form:label path="password">Contraseña: </form:label>
            <form:input type="password" path="password"/>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>