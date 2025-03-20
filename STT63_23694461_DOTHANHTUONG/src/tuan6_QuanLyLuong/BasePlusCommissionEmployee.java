package tuan6_QuanLyLuong;

public class BasePlusCommissionEmployee extends CommissionEmployee {
private double baseSalary;
    
    public BasePlusCommissionEmployee(String fName, String lName, String ssn, double sales, double rate, double base) {
        super(fName, lName, ssn, sales, rate);
        this.baseSalary = base;
    }
    
    @Override
    public double earnings() {
        return super.earnings() + baseSalary;
    }
    
    @Override
    public void display() {
        System.out.println("Base Salaried Commission Employee: " + firstName + " " + lastName + "\nSSN: " + SSN +
                "\nGross Sales: " + grossSales + " Commission Rate: " + commissionRate +
                "\nBase Salary: " + baseSalary + "\n");
    }
}
