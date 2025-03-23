package tuan6_QuanLyHangHoa;

class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh; // Thời gian bảo hành (tháng)
    private double congSuat; // Công suất (KW)

    public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon, int thoiGianBaoHanh, double congSuat) throws IllegalAccessException {
        super(maHang, tenHang, donGia, soLuongTon);
        setThoiGianBaoHanh(thoiGianBaoHanh);
        setCongSuat(congSuat);
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if (thoiGianBaoHanh >= 0) {
            this.thoiGianBaoHanh = thoiGianBaoHanh;
        } else {
            throw new IllegalArgumentException("Thời gian bảo hành không hợp lệ.");
        }
    }

    public void setCongSuat(double congSuat) {
        if (congSuat >= 0) {
            this.congSuat = congSuat;
        } else {
            throw new IllegalArgumentException("Công suất không hợp lệ.");
        }
    }

    @Override
    public String danhGiaBanBuon() {
        if (soLuongTon < 3) {
            return "Bán được";
        }
        return "Không đánh giá";
    }

    @Override
    public double tinhVAT() {
        return donGia * 0.10; // VAT 10%
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| Thời gian bảo hành: %d tháng |Công suất: %.2f kW",
                thoiGianBaoHanh, congSuat);
    }
}