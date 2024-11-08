<%--
  Created by IntelliJ IDEA.
  User: acero
  Date: 07/11/2024
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Client List</title>
</head>
<body>
<h2>Client List</h2>
<a href="client?action=new">Add New Client</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="client" items="${clientList}">
        <tr>
            <td>${client.id}</td>
            <td>${client.name}</td>
            <td>${client.email}</td>
            <td>${client.phone}</td>
            <td>
                <a href="client?action=edit&id=${client.id}">Edit</a> |
                <a href="client?action=delete&id=${client.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
