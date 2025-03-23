package tuan6_QuanLyLuong;

public class CommissionEmployee extends Employee {
    protected double grossSales;
    protected double commissionRate;

    public CommissionEmployee(String fName, String lName, String ssn, double sales, double rate) {
        super(fName, lName, ssn);
        this.grossSales = sales;
        this.commissionRate = rate;
    }

    public double earnings() {
        return grossSales * commissionRate; // Tính lương theo doanh số
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    @Override
    public String toString() {
        return String.format("Commission Employee: %s %s\nSSN: %s\nGross Sales: %.2f\nCommission Rate: %.2f\n",
                firstName, lastName, SSN, grossSales, commissionRate);
    }
}