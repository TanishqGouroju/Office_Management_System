package com.company.officemanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    public void addEmployee(int id, String name, String department) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, department);
            stmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> listEmployees() {
        List<String> employees = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                employees.add(rs.getInt("id") + " - " + rs.getString("name") + " - " + rs.getString("department"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
