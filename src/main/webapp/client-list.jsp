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
    <c:choose>
        <c:when test="${not empty clientList}">
            <c:forEach var="client" items="${clientList}">
                <tr>
                    <td>${client.id}</td>
                    <td>${client.name}</td>
                    <td>${client.email}</td>
                    <td>${client.phone}</td>
                    <td>
                        <a href="client?action=edit&id=${client.id}">Edit</a>
                        <a href="client?action=delete&id=${client.id}" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr><td colspan="5">No clients available.</td></tr>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>

