package tuan6_QuanLyLuong;

public class HourlyEmployee extends Employee {
    private double hours;
    private double wage;

    public HourlyEmployee(String fName, String lName, String ssn, double hours, double wage) {
        super(fName, lName, ssn);
        this.hours = hours;
        this.wage = wage;
    }

    @Override
    public double earnings() {
        return hours * wage; // Tính lương theo giờ
    }

    @Override
    public String toString() {
        return String.format("Hourly Employee: %s %s\nSSN: %s\nHours: %.2f\nWage: %.2f\n",
                firstName, lastName, SSN, hours, wage);
    }
}