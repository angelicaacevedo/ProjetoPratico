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
  <title>${client != null ? "Editar Cliente" : "Novo Cliente"}</title>
</head>
<body>
<h2>${client != null ? "Editar Cliente" : "Novo Cliente"}</h2>
<form action="client" method="post">
  <input type="hidden" name="action" value="${client != null ? "update" : "insert"}">
  <input type="hidden" name="id" value="${client.id}">
  <p>
    <label>Nome:</label>
    <input type="text" name="name" value="${client != null ? client.name : ""}" required>
  </p>
  <p>
    <label>Email:</label>
    <input type="email" name="email" value="${client != null ? client.email : ""}" required>
  </p>
  <p>
    <label>Telefone:</label>
    <input type="text" name="phone" value="${client != null ? client.phone : ""}" required>
  </p>
  <p>
    <button type="submit">${client != null ? "Atualizar" : "Salvar"}</button>
    <a href="client?action=list">Cancelar</a>
  </p>
</form>
</body>
</html>

