package tuan6_QuanLyLuong;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new SalariedEmployee("John", "Doe", "123-45-6789", 1000.00);
        employees[1] = new HourlyEmployee("Jane", "Smith", "987-65-4321", 40, 15.00);
        employees[2] = new CommissionEmployee("Jim", "Brown", "456-78-9012", 5000, 0.1);
        employees[3] = new BasePlusCommission("Jake", "White", "321-54-9876", 3000, 0.2, 500);

        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.printf("Earnings: %.2f\n", employee.earnings());
        }
    }
}
