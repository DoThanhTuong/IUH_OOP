package tuan6_QuanLyHangHoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon, String nhaSanXuat, LocalDate ngayNhapKho) throws IllegalAccessException {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaSanXuat = nhaSanXuat;
        setNgayNhapKho(ngayNhapKho);
    }

    public void setNgayNhapKho(LocalDate ngayNhapKho) {
        if (ngayNhapKho.isBefore(LocalDate.now())) {
            this.ngayNhapKho = ngayNhapKho;
        } else {
            this.ngayNhapKho = LocalDate.now(); // Gán ngày hiện tại nếu không hợp lệ
        }
    }

    @Override
    public String danhGiaBanBuon() {
        long diffDays = ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
        if (soLuongTon > 50 && diffDays > 10) {
            return "Bán chậm";
        }
        return "Không đánh giá";
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.10; // VAT 10%
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return super.toString() + String.format("| Nhà sản xuất: %-15s| Ngày nhập kho: %-15s",
                nhaSanXuat, ngayNhapKho.format(formatter));
    }
}