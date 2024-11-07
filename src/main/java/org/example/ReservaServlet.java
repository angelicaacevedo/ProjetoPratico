package org.example;

import org.example.dao.ClienteDAO;
import org.example.model.Cliente;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reserva")
public class ReservaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Cliente cliente = new Cliente();
        cliente.setNome("Teste Nome");
        cliente.setEmail("teste@exemplo.com");
        cliente.setTelefone("123456789");

        ClienteDAO clienteDAO = new ClienteDAO();
        try {
            clienteDAO.inserirCliente(cliente);
            response.getWriter().println("<h1>Cliente inserido com sucesso!</h1>");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<h1>Erro ao inserir cliente: " + e.getMessage() + "</h1>");
        }
    }
}
