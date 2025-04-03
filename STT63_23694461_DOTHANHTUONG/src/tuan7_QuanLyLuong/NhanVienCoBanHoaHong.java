package tuan7_QuanLyLuong;

public class NhanVienCoBanHoaHong extends NhanVienHoaHong {
	private double luongCoBan;

    public NhanVienCoBanHoaHong(String ho, String ten, String cmnd, double doanhSo, double tyLe, double luongCoBan) {
        super(ho, ten, cmnd, doanhSo, tyLe);
        this.luongCoBan = luongCoBan;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + super.tinhLuong();
    }

    @Override
    public String toString() {
        return String.format("Nhân viên lương cơ bản + hoa hồng: %s %s\nCMND: %s\nDoanh số: %.2f\nTỷ lệ hoa hồng: %.2f\nLương cơ bản: %.2f\n", ho, hoTen, soCMND, doanhSo, tyLeHoaHong, luongCoBan);
    }
}
