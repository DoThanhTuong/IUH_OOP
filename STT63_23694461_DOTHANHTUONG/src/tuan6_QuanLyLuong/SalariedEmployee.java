package tuan6_QuanLyLuong;

public class SalariedEmployee extends Employee {
private double weeklySalary;
    
    public SalariedEmployee(String fName, String lName, String ssn, double salary) {
        super(fName, lName, ssn);
        this.weeklySalary = salary;
    }
    
    @Override
    public double earnings() {
        return weeklySalary;
    }
    
    @Override
    public void display() {
        System.out.println("Salaried Employee: " + firstName + " " + lastName + "\nSSN: " + SSN +
                "\nWeekly Salary: " + weeklySalary + "\n");
    }
}
