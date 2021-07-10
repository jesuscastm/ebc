<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Reporte de usuarios</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Usuario</th>
                    <th>Eliminado</th>
                    <th>Visitas</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="usr">
                    <tr>
                        <td>${usr.name}</td>
                        <td>${usr.username}</td>
                        <td>${usr.deleted}</td>
                        <td>${usr.visits}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>