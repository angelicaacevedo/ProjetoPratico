<%--
  Created by IntelliJ IDEA.
  User: acero
  Date: 07/11/2024
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Clientes</title>
</head>
<body>
<p>
    <a href="client?action=list">Clientes</a> |
    <a href="table?action=list">Mesas</a> |
    <a href="reservation?action=list">Reservas</a>
</p>

<h2>Lista de Clientes</h2>
<a href="client?action=new">Adicionar Novo Cliente</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Telefone</th>
        <th>Ações</th>
    </tr>
    <c:choose>
        <c:when test="${not empty clientList}">
            <c:forEach var="client" items="${clientList}">
                <tr>
                    <td>${client.id}</td>
                    <td>${client.name}</td>
                    <td>${client.email}</td>
                    <td>${client.phone}</td>
                    <td>
                        <a href="client?action=edit&id=${client.id}">Editar</a> |
                        <a href="client?action=delete&id=${client.id}" onclick="return confirm('Tem certeza?')">Deletar</a>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr><td colspan="5">Nenhum cliente disponível.</td></tr>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>

