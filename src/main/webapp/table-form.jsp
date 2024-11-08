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
  <title>New Table</title>
</head>
<body>
<h2>${table != null ? "Edit Table" : "New Table"}</h2>
<form action="table" method="post">
  <input type="hidden" name="action" value="${table != null ? "update" : "insert"}">
  <input type="hidden" name="id" value="${table != null ? table.id : ""}">

  <p>
    <label>Number:</label>
    <input type="number" name="number" value="${table != null ? table.number : ""}" required>
  </p>
  <p>
    <label>Capacity:</label>
    <input type="number" name="capacity" value="${table != null ? table.capacity : ""}" required>
  </p>
  <p>
    <button type="submit">${table != null ? "Update" : "Save"}</button>
    <a href="table?action=list">Cancel</a>
  </p>
</form>
</body>
</html>
