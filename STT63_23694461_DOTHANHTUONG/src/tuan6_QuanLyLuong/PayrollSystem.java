package tuan6_QuanLyLuong;

import java.util.*;

public class PayrollSystem {
	public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new SalariedEmployee("John", "Doe", "111-11-1111", 800));
        employees.add(new HourlyEmployee("Jane", "Smith", "222-22-2222", 20, 42));
        employees.add(new CommissionEmployee("Emily", "Jones", "333-33-3333", 5000, 0.05));
        employees.add(new BasePlusCommissionEmployee("Michael", "Brown", "444-44-4444", 4000, 0.04, 300));
        
        System.out.println("Payroll Information:\n");
        for (Employee emp : employees) {
            emp.display();
            System.out.println("Earnings: $" + emp.earnings() + "\n");
        }
    }
}
