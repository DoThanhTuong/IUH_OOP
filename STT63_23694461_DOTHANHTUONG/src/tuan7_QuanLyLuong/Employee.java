package tuan7_QuanLyLuong;

public abstract class Employee {
	protected String hoTen;
    protected String ho;
    protected String soCMND;

    public Employee(String ho, String ten, String cmnd) {
        this.ho = ho;
        this.hoTen = ten;
        this.soCMND = cmnd;
    }

    public abstract double tinhLuong();

    @Override
    public abstract String toString();
}
