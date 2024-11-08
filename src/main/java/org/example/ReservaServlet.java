package org.example;

import org.example.dao.ClientDAO;
import org.example.model.Client;

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

        Client client = new Client();
        client.setName("Teste Nome");
        client.setEmail("teste@exemplo.com");
        client.setPhone("123456789");

        ClientDAO clientDAO = new ClientDAO();
        try {
            clientDAO.insertClient(client);
            response.getWriter().println("<h1>Cliente inserido com sucesso!</h1>");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<h1>Erro ao inserir cliente: " + e.getMessage() + "</h1>");
        }
    }
}
