package org.example.dao;

import org.example.model.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableDAO {

    public void insertTable(Table table) throws SQLException {
        String sql = "INSERT INTO Tables (number, capacity) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, table.getNumber());
            stmt.setInt(2, table.getCapacity());
            stmt.executeUpdate();
        }
    }

    public List<Table> getAllTables() throws SQLException {
        List<Table> tables = new ArrayList<>();
        String sql = "SELECT * FROM Tables";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Table table = new Table();
                table.setId(rs.getInt("table_id"));
                table.setNumber(rs.getInt("number"));
                table.setCapacity(rs.getInt("capacity"));
                tables.add(table);
            }
        }
        return tables;
    }

    public void updateTable(Table table) throws SQLException {
        String sql = "UPDATE Tables SET number = ?, capacity = ? WHERE table_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, table.getNumber());
            stmt.setInt(2, table.getCapacity());
            stmt.setInt(3, table.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteTable(int tableId) throws SQLException {
        String sql = "DELETE FROM Tables WHERE table_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tableId);
            stmt.executeUpdate();
        }
    }
}

