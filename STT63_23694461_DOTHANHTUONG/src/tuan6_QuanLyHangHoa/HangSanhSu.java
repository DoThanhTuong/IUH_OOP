package tuan6_QuanLyHangHoa;

import java.util.Date;

class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private Date ngayNhapKho;

    public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon, String nhaSanXuat, Date ngayNhapKho) {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public String danhGiaBanBuon() {
        Date now = new Date();
        long diff = now.getTime() - ngayNhapKho.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        if (soLuongTon > 50 && diffDays > 10) {
            return "Bán chậm";
        }
        return "Không đánh giá";
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.1;
    }
}