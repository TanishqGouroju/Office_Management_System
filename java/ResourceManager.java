package com.company.officemanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceManager {
    public void addResource(int id, String name, boolean available) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO resources (id, name, available) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setBoolean(3, available);
            stmt.executeUpdate();
            System.out.println("Resource added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> listResources() {
        List<String> resources = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM resources";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                resources.add(rs.getInt("id") + " - " + rs.getString("name") + " - Available: " + rs.getBoolean("available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resources;
    }
}
