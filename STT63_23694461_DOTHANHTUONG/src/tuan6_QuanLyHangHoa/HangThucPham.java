package tuan6_QuanLyHangHoa;

import java.util.Date;

class HangThucPham extends HangHoa {
    private String nhaCungCap;
    private Date ngaySanXuat;
    private Date ngayHetHan;

    public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String nhaCungCap, Date ngaySanXuat, Date ngayHetHan) {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaCungCap = nhaCungCap;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public String danhGiaBanBuon() {
        Date now = new Date();
        if (soLuongTon > 0 && ngayHetHan.before(now)) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.05;
    }
}