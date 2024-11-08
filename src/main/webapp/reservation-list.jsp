<%--
  Created by IntelliJ IDEA.
  User: acero
  Date: 08/11/2024
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
  <title>Lista de Reservas</title>
</head>
<body>
<h2>Lista de Reservas</h2>
<p>
  <a href="client?action=list">Clientes</a> |
  <a href="table?action=list">Mesas</a> |
  <a href="reservation?action=list">Reservas</a>
</p>

<a href="reservation?action=new">Adicionar Nova Reserva</a>
<table border="1">
  <tr>
    <th>ID</th>
    <th>ID do Cliente</th>
    <th>ID da Mesa</th>
    <th>Data e Hora</th>
    <th>Status</th>
    <th>Ações</th>
  </tr>
  <c:if test="${empty reservationList}">
    <p>Nenhuma reserva disponível.</p>
  </c:if>
  <c:forEach var="reservation" items="${reservationList}">
    <tr>
      <td>${reservation.id}</td>
      <td>${reservation.clientId}</td>
      <td>${reservation.tableId}</td>
      <td>${reservation.formattedDate}</td>
      <td>${reservation.status}</td>
      <td>
        <a href="reservation?action=edit&id=${reservation.id}">Editar</a> |
        <a href="reservation?action=delete&id=${reservation.id}" onclick="return confirm('Tem certeza?')">Deletar</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
