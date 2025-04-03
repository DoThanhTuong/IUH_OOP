package tuan7_QuanLyLuong;

public class NhanVienCoDinh extends Employee {
	private double luongTuan;

    public NhanVienCoDinh(String ho, String ten, String cmnd, double luong) {
        super(ho, ten, cmnd);
        this.luongTuan = luong;
    }

    @Override
    public double tinhLuong() {
        return luongTuan;
    }

    @Override
    public String toString() {
        return String.format("Nhân viên lương cố định: %s %s\nCMND: %s\nLương hàng tuần: %.2f\n", ho, hoTen, soCMND, luongTuan);
    }
}
