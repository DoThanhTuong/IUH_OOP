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
    public String toString() {
        return String.format("Salaried Employee: %s %s\nSSN: %s\nWeekly Salary: %.2f\n",
                firstName, lastName, SSN, weeklySalary);
    }
}