<%--
  Created by IntelliJ IDEA.
  User: acero
  Date: 07/11/2024
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Mesas</title>
</head>
<body>
<p>
    <a href="client?action=list">Clientes</a> |
    <a href="table?action=list">Mesas</a> |
    <a href="reservation?action=list">Reservas</a>
</p>

<h2>Lista de Mesas</h2>
<a href="table?action=new">Adicionar Nova Mesa</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Número</th>
        <th>Capacidade</th>
        <th>Ações</th>
    </tr>
    <c:forEach var="table" items="${tableList}">
        <tr>
            <td>${table.id}</td>
            <td>${table.number}</td>
            <td>${table.capacity}</td>
            <td>
                <a href="table?action=edit&id=${table.id}">Editar</a> |
                <a href="table?action=delete&id=${table.id}" onclick="return confirm('Tem certeza?')">Deletar</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
