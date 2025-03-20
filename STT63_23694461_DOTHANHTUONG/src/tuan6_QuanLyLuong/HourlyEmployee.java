package tuan6_QuanLyLuong;

public class HourlyEmployee extends Employee {
	private double wage;
    private int hours;
    
    public HourlyEmployee(String fName, String lName, String ssn, double w, int h) {
        super(fName, lName, ssn);
        this.wage = w;
        this.hours = h;
    }
    
    @Override
    public double earnings() {
        return (hours <= 40) ? wage * hours : (40 * wage + (hours - 40) * wage * 1.5);
    }
    
    @Override
    public void display() {
        System.out.println("Hourly Employee: " + firstName + " " + lastName + "\nSSN: " + SSN +
                "\nHourly Wage: " + wage + " Hours Worked: " + hours + "\n");
    }
}
