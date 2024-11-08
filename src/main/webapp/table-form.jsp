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
  <title>${table != null ? "Editar Mesa" : "Nova Mesa"}</title>
</head>
<body>
<h2>${table != null ? "Editar Mesa" : "Nova Mesa"}</h2>
<form action="table" method="post">
  <input type="hidden" name="action" value="${table != null ? "update" : "insert"}">
  <input type="hidden" name="id" value="${table != null ? table.id : ""}">

  <p>
    <label>Número:</label>
    <input type="number" name="number" value="${table != null ? table.number : ""}" required>
  </p>
  <p>
    <label>Capacidade:</label>
    <input type="number" name="capacity" value="${table != null ? table.capacity : ""}" required>
  </p>
  <p>
    <button type="submit">${table != null ? "Atualizar" : "Salvar"}</button>
    <a href="table?action=list">Cancelar</a>
  </p>
</form>
</body>
</html>
