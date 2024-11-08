package org.example.dao;

import org.example.model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    public void insertReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO Reservations (client_id, table_id, date_time, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservation.getClientId());
            stmt.setInt(2, reservation.getTableId());
            stmt.setTimestamp(3, Timestamp.valueOf(reservation.getDateTime()));
            stmt.setString(4, reservation.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Reservations";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(rs.getInt("reservation_id"));
                reservation.setClientId(rs.getInt("client_id"));
                reservation.setTableId(rs.getInt("table_id"));
                reservation.setDateTime(rs.getTimestamp("date_time").toLocalDateTime());
                reservation.setStatus(rs.getString("status"));
                reservations.add(reservation);
            }
        }
        return reservations;
    }

    public Reservation getReservationById(int reservationId) throws SQLException {
        String sql = "SELECT * FROM Reservations WHERE reservation_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservationId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setId(rs.getInt("reservation_id"));
                    reservation.setClientId(rs.getInt("client_id"));
                    reservation.setTableId(rs.getInt("table_id"));
                    reservation.setDateTime(rs.getTimestamp("date_time").toLocalDateTime());
                    reservation.setStatus(rs.getString("status"));
                    return reservation;
                }
            }
        }
        return null;
    }

    public void updateReservation(Reservation reservation) throws SQLException {
        String sql = "UPDATE Reservations SET client_id = ?, table_id = ?, date_time = ?, status = ? WHERE reservation_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservation.getClientId());
            stmt.setInt(2, reservation.getTableId());
            stmt.setTimestamp(3, Timestamp.valueOf(reservation.getDateTime()));
            stmt.setString(4, reservation.getStatus());
            stmt.setInt(5, reservation.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteReservation(int reservationId) throws SQLException {
        String sql = "DELETE FROM Reservations WHERE reservation_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservationId);
            stmt.executeUpdate();
        }
    }
}
