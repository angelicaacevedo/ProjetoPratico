<%--
  Created by IntelliJ IDEA.
  User: acero
  Date: 08/11/2024
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Reservation List</title>
</head>
<body>
<h2>Reservation List</h2>
<a href="reservation?action=new">Add New Reservation</a>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Client ID</th>
    <th>Table ID</th>
    <th>Date and Time</th>
    <th>Status</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="reservation" items="${reservationList}">
    <tr>
      <td>${reservation.id}</td>
      <td>${reservation.clientId}</td>
      <td>${reservation.tableId}</td>
      <td>${reservation.dateTime}</td>
      <td>${reservation.status}</td>
      <td>
        <a href="reservation?action=edit&id=${reservation.id}">Edit</a> |
        <a href="reservation?action=delete&id=${reservation.id}" onclick="return confirm('Are you sure?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

