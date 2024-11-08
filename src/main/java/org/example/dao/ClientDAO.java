package org.example.dao;

import org.example.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    public void insertClient(Client client) throws SQLException {
        String sql = "INSERT INTO Clients (name, email, phone) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getPhone());
            stmt.executeUpdate();
        }
    }

    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Clients";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("client_id"));
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                client.setPhone(rs.getString("phone"));
                clients.add(client);
            }
        }
        return clients;
    }

    public void updateClient(Client client) throws SQLException {
        String sql = "UPDATE Clients SET name = ?, email = ?, phone = ? WHERE client_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getPhone());
            stmt.setInt(4, client.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteClient(int clientId) throws SQLException {
        String sql = "DELETE FROM Clients WHERE client_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, clientId);
            stmt.executeUpdate();
        }
    }
}
