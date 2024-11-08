package org.example.controller;

import org.example.dao.ClientDAO;
import org.example.model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {

    private ClientDAO clientDAO = new ClientDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertClient(request, response);
                    break;
                case "delete":
                    deleteClient(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateClient(request, response);
                    break;
                default:
                    listClients(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listClients(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Client> clients = clientDAO.getAllClients();
        request.setAttribute("clientList", clients);
        request.getRequestDispatcher("/client-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/client-form.jsp").forward(request, response);
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Client newClient = new Client();
        newClient.setName(name);
        newClient.setEmail(email);
        newClient.setPhone(phone);
        clientDAO.insertClient(newClient);

        response.sendRedirect("client?action=list");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        clientDAO.deleteClient(id);
        response.sendRedirect("client?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            request.setAttribute("errorMessage", "Invalid ID provided.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            Client existingClient = clientDAO.getClientById(id);
            if (existingClient != null) {
                request.setAttribute("client", existingClient);
                request.getRequestDispatcher("/client-form.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Client not found.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (NumberFormatException | SQLException e) {
            request.setAttribute("errorMessage", "ID format is invalid.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Client client = new Client();
        client.setId(id);
        client.setName(name);
        client.setEmail(email);
        client.setPhone(phone);
        clientDAO.updateClient(client);

        response.sendRedirect("client?action=list");
    }
}

