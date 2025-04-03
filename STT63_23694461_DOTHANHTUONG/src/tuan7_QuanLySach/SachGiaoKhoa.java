package tuan7_QuanLySach;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SachGiaoKhoa extends Sach {
    private boolean tinhTrang;

    public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, boolean tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public double getThanhTien() {
        // Tính ThanhTien: nếu sách mới (tinhTrang = true) thì tính giá gốc, còn không giảm 50%
        if (tinhTrang) {
            return getSoLuong() * getDonGia();
        } else {
            return getSoLuong() * getDonGia() * 0.5;
        }
    }

    // Cấu hình định dạng ngày tháng và tiền tệ
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Locale local = new Locale("vi", "VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(local);

    @Override
    public String toString() {
        // Trả về thông tin sách và giá trị ThanhTien trong định dạng bảng
        return super.toString() + String.format("|%-10s|%-20s",
                tinhTrang == true ? "Moi" : "Cu",
                nf.format(getThanhTien()) // Thêm phần hiển thị ThanhTien
        );
    }
}
