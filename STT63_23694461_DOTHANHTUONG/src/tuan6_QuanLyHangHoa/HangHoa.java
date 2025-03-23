package tuan6_QuanLyHangHoa;

abstract class HangHoa {
    protected final String maHang; // Mã hàng
    protected String tenHang; // Tên hàng
    protected double donGia; // Đơn giá
    protected int soLuongTon; // Số lượng tồn

    public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) throws IllegalAccessException {
        if (maHang != null && !maHang.trim().isEmpty()) {
            this.maHang = maHang;
        } else {
            throw new IllegalAccessException("Mã hàng không được để trống.");
        }
        setTenHang(tenHang);
        setDonGia(donGia);
        setSoLuongTon(soLuongTon);
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang != null && !tenHang.trim().isEmpty()) {
            this.tenHang = tenHang;
        } else {
            this.tenHang = "xxx"; // Gán giá trị mặc định
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) throws IllegalAccessException {
        if (donGia >= 0) {
            this.donGia = donGia;
        } else {
            throw new IllegalAccessException("Đơn giá phải lớn hơn hoặc bằng 0.");
        }
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) throws IllegalAccessException {
        if (soLuongTon >= 0) {
            this.soLuongTon = soLuongTon;
        } else {
            throw new IllegalAccessException("Số lượng tồn phải lớn hơn hoặc bằng 0.");
        }
    }

    public abstract String danhGiaBanBuon();
    public abstract double tinhVAT();

    @Override
    public String toString() {
        return String.format("Mã hàng: %-15s| Tên hàng: %-15s| Đơn giá: %-15.2f| Số lượng tồn: %-15d",
                maHang, tenHang, donGia, soLuongTon);
    }
}
