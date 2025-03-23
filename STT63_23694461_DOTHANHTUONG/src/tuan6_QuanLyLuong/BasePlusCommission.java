package tuan6_QuanLyLuong;

public class BasePlusCommission extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommission(String fName, String lName, String ssn, double sales, double rate, double salary) {
        super(fName, lName, ssn, sales, rate);
        this.baseSalary = salary;
    }

    @Override
    public double earnings() {
        return baseSalary + super.earnings(); // Lương căn bản cộng lương theo doanh số
    }

    @Override
    public String toString() {
        return String.format("Base Plus Commission Employee: %s %s\nSSN: %s\nGross Sales: %.2f\nCommission Rate: %.2f\nBase Salary: %.2f\n",
                firstName, lastName, SSN, grossSales, commissionRate, baseSalary);
    }
}