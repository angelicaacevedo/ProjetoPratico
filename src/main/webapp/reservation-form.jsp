<%--
  Created by IntelliJ IDEA.
  User: acero
  Date: 08/11/2024
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${reservation != null ? "Editar Reserva" : "Nova Reserva"}</title>
</head>
<body>
<h2>${reservation != null ? "Editar Reserva" : "Nova Reserva"}</h2>
<form action="reservation" method="post">
    <input type="hidden" name="action" value="${reservation != null ? "update" : "insert"}">
    <input type="hidden" name="id" value="${reservation != null ? reservation.id : ""}">

    <p>
        <label>ID do Cliente:</label>
        <input type="number" name="clientId" value="${reservation != null ? reservation.clientId : ""}" required min="1">
    </p>
    <p>
        <label>ID da Mesa:</label>
        <input type="number" name="tableId" value="${reservation != null ? reservation.tableId : ""}" required min="1">
    </p>
    <p>
        <label>Data e Hora:</label>
        <input type="datetime-local" name="dateTime" value="${reservation != null ? reservation.dateTime : ""}" required>
    </p>
    <p>
        <label>Status:</label>
        <input type="text" name="status" value="${reservation != null ? reservation.status : ""}" required>
    </p>
    <p>
        <button type="submit">${reservation != null ? "Atualizar" : "Salvar"}</button>
        <a href="reservation?action=list">Cancelar</a>
    </p>
</form>
</body>
</html>
