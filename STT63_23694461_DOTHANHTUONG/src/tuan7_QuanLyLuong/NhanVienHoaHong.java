package tuan7_QuanLyLuong;

public class NhanVienHoaHong extends Employee {
	protected double doanhSo;
    protected double tyLeHoaHong;

    public NhanVienHoaHong(String ho, String ten, String cmnd, double doanhSo, double tyLe) {
        super(ho, ten, cmnd);
        this.doanhSo = doanhSo;
        this.tyLeHoaHong = tyLe;
    }

    @Override
    public double tinhLuong() {
        return doanhSo * tyLeHoaHong;
    }

    @Override
    public String toString() {
        return String.format("Nhân viên hoa hồng: %s %s\nCMND: %s\nDoanh số: %.2f\nTỷ lệ hoa hồng: %.2f\n", ho, hoTen, soCMND, doanhSo, tyLeHoaHong);
    }
}
