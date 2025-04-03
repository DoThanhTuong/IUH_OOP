package tuan7_QuanLyHangHoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class HangThucPham extends HangHoa {
    private String nhaCungCap;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;

    public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String nhaCungCap, LocalDate ngaySanXuat, LocalDate ngayHetHan) throws IllegalAccessException {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaCungCap = nhaCungCap;
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        if (ngaySanXuat.isBefore(LocalDate.now())) {
            this.ngaySanXuat = ngaySanXuat;
        } else {
            this.ngaySanXuat = LocalDate.now(); // Gán ngày hiện tại nếu không hợp lệ
        }
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if (ngayHetHan.isAfter(ngaySanXuat)) {
            this.ngayHetHan = ngayHetHan;
        } else {
            this.ngayHetHan = ngaySanXuat; // Gán ngày sản xuất nếu không hợp lệ
        }
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    @Override
    public String danhGiaBanBuon() {
        if (soLuongTon > 0 && ngayHetHan.isBefore(LocalDate.now())) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.05; // VAT 5%
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return super.toString() + String.format("| Nhà cung cấp: %-15s| Ngày sản xuất: %-15s| Ngày hết hạn: %-15s| Đánh Giá Bán Buôn: %-15s| VAT: %-15f",
                nhaCungCap, ngaySanXuat.format(formatter), ngayHetHan.format(formatter),danhGiaBanBuon(),tinhVAT());
    }
}