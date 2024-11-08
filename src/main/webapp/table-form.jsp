<%--
  Created by IntelliJ IDEA.
  User: acero
  Date: 07/11/2024
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Table List</title>
</head>
<body>
<h2>Table List</h2>
<a href="table?action=new">Add New Table</a>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Number</th>
    <th>Capacity</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="table" items="${tableList}">
    <tr>
      <td>${table.id}</td>
      <td>${table.number}</td>
      <td>${table.capacity}</td>
      <td>
        <a href="table?action=edit&id=${table.id}">Edit</a> |
        <a href="table?action=delete&id=${table.id}" onclick="return confirm('Are you sure?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
