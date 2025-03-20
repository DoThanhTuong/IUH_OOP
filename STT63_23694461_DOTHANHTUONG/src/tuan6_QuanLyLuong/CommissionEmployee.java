package tuan6_QuanLyLuong;

public class CommissionEmployee extends Employee{
protected double grossSales, commissionRate;
    
    public CommissionEmployee(String fName, String lName, String ssn, double sales, double rate) {
        super(fName, lName, ssn);
        this.grossSales = sales;
        this.commissionRate = rate;
    }
    
    @Override
    public double earnings() {
        return grossSales * commissionRate;
    }
    
    @Override
    public void display() {
        System.out.println("Commission Employee: " + firstName + " " + lastName + "\nSSN: " + SSN +
                "\nGross Sales: " + grossSales + " Commission Rate: " + commissionRate + "\n");
    }
}
