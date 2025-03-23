package tuan6_QuanLyLuong;

public abstract class Employee {
    protected String firstName;
    protected String lastName;
    protected String SSN;

    public Employee(String fName, String lName, String ssn) {
        this.firstName = fName;
        this.lastName = lName;
        this.SSN = ssn;
    }

    public abstract double earnings(); // Phương thức trừu tượng để tính lương

    @Override
    public abstract String toString(); // Phương thức trừu tượng để hiển thị thông tin
}