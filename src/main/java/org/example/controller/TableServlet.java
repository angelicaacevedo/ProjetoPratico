package org.example.controller;

import org.example.dao.TableDAO;
import org.example.model.Table;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/table")
public class TableServlet extends HttpServlet {

    private TableDAO tableDAO = new TableDAO();

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
                    insertTable(request, response);
                    break;
                case "delete":
                    deleteTable(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateTable(request, response);
                    break;
                default:
                    listTables(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listTables(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Table> tables = tableDAO.getAllTables();
        request.setAttribute("tableList", tables);
        request.getRequestDispatcher("/table-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/table-form.jsp").forward(request, response);
    }

    private void insertTable(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int number = Integer.parseInt(request.getParameter("number"));
        int capacity = Integer.parseInt(request.getParameter("capacity"));

        Table newTable = new Table();
        newTable.setNumber(number);
        newTable.setCapacity(capacity);
        tableDAO.insertTable(newTable);

        response.sendRedirect("table?action=list");
    }

    private void deleteTable(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        tableDAO.deleteTable(id);
        response.sendRedirect("table?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Table existingTable = tableDAO.getAllTables().stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        request.setAttribute("table", existingTable);
        request.getRequestDispatcher("/table-form.jsp").forward(request, response);
    }

    private void updateTable(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int number = Integer.parseInt(request.getParameter("number"));
        int capacity = Integer.parseInt(request.getParameter("capacity"));

        Table table = new Table();
        table.setId(id);
        table.setNumber(number);
        table.setCapacity(capacity);
        tableDAO.updateTable(table);

        response.sendRedirect("table?action=list");
    }
}
