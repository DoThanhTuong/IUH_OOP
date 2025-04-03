package tuan7_QuanLyLuong;

public class NhanVienLamViecTheoGio extends Employee {
	private double soGio;
    private double luongGio;

    public NhanVienLamViecTheoGio(String ho, String ten, String cmnd, double soGio, double luongGio) {
        super(ho, ten, cmnd);
        this.soGio = soGio;
        this.luongGio = luongGio;
    }

    @Override
    public double tinhLuong() {
        return soGio * luongGio;
    }

    @Override
    public String toString() {
        return String.format("Nhân viên theo giờ: %s %s\nCMND: %s\nSố giờ làm: %.2f\nLương giờ: %.2f\n", ho, hoTen, soCMND, soGio, luongGio);
    }
}
