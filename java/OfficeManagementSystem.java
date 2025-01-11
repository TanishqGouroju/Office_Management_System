package com.company.officemanagement;

public class OfficeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        ResourceManager resourceManager = new ResourceManager();

        // Example Usage
        employeeManager.addEmployee(1, "Alice", "IT");
        employeeManager.addEmployee(2, "Bob", "HR");

        System.out.println("Employees:");
        for (String employee : employeeManager.listEmployees()) {
            System.out.println(employee);
        }

        resourceManager.addResource(1, "Laptop", true);
        resourceManager.addResource(2, "Projector", false);

        System.out.println("Resources:");
        for (String resource : resourceManager.listResources()) {
            System.out.println(resource);
        }
    }
}
