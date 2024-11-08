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
    <title>${reservation != null ? "Edit Reservation" : "New Reservation"}</title>
</head>
<body>
<h2>${reservation != null ? "Edit Reservation" : "New Reservation"}</h2>
<form action="reservation" method="post">
    <input type="hidden" name="action" value="${reservation != null ? "update" : "insert"}">
    <input type="hidden" name="id" value="${reservation != null ? reservation.id : ""}">

    <p>
        <label>Client ID:</label>
        <input type="number" name="clientId" value="${reservation != null ? reservation.clientId : ""}" required>
    </p>
    <p>
        <label>Table ID:</label>
        <input type="number" name="tableId" value="${reservation != null ? reservation.tableId : ""}" required>
    </p>
    <p>
        <label>Date and Time:</label>
        <input type="datetime-local" name="dateTime" value="${reservation != null ? reservation.dateTime : ""}" required>
    </p>
    <p>
        <label>Status:</label>
        <input type="text" name="status" value="${reservation != null ? reservation.status : ""}" required>
    </p>
    <p>
        <button type="submit">${reservation != null ? "Update" : "Save"}</button>
        <a href="reservation?action=list">Cancel</a>
    </p>
</form>
</body>
</html>
