package org.example.controller;

import org.example.dao.ReservationDAO;
import org.example.model.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {

    private ReservationDAO reservationDAO = new ReservationDAO();

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
                    insertReservation(request, response);
                    break;
                case "delete":
                    deleteReservation(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateReservation(request, response);
                    break;
                default:
                    listReservations(request, response); // Lista todas as reservas
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("insert".equals(action)) {
                insertReservation(request, response);
            } else if ("update".equals(action)) {
                updateReservation(request, response);
            } else {
                doGet(request, response); // Redireciona para doGet se não houver ação definida
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listReservations(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Reservation> reservations = reservationDAO.getAllReservations();
        request.setAttribute("reservationList", reservations);
        request.getRequestDispatcher("/reservation-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/reservation-form.jsp").forward(request, response);
    }

    private void insertReservation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int clientId = Integer.parseInt(request.getParameter("clientId"));
        int tableId = Integer.parseInt(request.getParameter("tableId"));
        String dateTime = request.getParameter("dateTime");
        String status = request.getParameter("status");

        Reservation reservation = new Reservation();
        reservation.setClientId(clientId);
        reservation.setTableId(tableId);
        reservation.setDateTime(LocalDateTime.parse(dateTime));
        reservation.setStatus(status);
        reservationDAO.insertReservation(reservation);

        response.sendRedirect("reservation?action=list");
    }

    private void deleteReservation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            try {
                request.setAttribute("errorMessage", "Invalid ID provided for deletion.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return;
        }

        int id = Integer.parseInt(idParam);
        reservationDAO.deleteReservation(id);
        response.sendRedirect("reservation?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            request.setAttribute("errorMessage", "Invalid ID provided for reservation.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            Reservation existingReservation = reservationDAO.getReservationById(id);
            if (existingReservation != null) {
                request.setAttribute("reservation", existingReservation);
                request.getRequestDispatcher("/reservation-form.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Reservation not found.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (NumberFormatException | SQLException e) {
            request.setAttribute("errorMessage", "ID format is invalid.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void updateReservation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int clientId = Integer.parseInt(request.getParameter("clientId"));
        int tableId = Integer.parseInt(request.getParameter("tableId"));
        String dateTime = request.getParameter("dateTime");
        String status = request.getParameter("status");

        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setClientId(clientId);
        reservation.setTableId(tableId);
        reservation.setDateTime(LocalDateTime.parse(dateTime));
        reservation.setStatus(status);
        reservationDAO.updateReservation(reservation);

        response.sendRedirect("reservation?action=list");
    }
}