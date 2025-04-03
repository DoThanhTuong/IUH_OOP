package tuan5_NhaDat;

public class GiaoDichNha extends GiaoDich {
    // Enum định nghĩa loại nhà (giúp tránh nhập sai dữ liệu)
    public enum LoaiNha {
        CAO_CAP, THUONG
    }

    // Thuộc tính loại nhà và địa chỉ
    private LoaiNha loaiNha;
    private String diaChi;

    // Constructor mặc định
    public GiaoDichNha() {
        super();
        this.loaiNha = LoaiNha.THUONG; // Mặc định là nhà thường
        this.diaChi = "Chưa xác định";
    }

    // Constructor đầy đủ
    public GiaoDichNha(String maGiaoDich, String ngayGiaoDich, double donGia, double dienTich, LoaiNha loaiNha, String diaChi) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }
    

    // Cài đặt phương thức abstract thanhTien() từ lớp GiaoDich
    @Override
    public double thanhTien() {
        // Nếu là nhà cao cấp, không giảm giá, còn lại giảm 10%
        return loaiNha == LoaiNha.CAO_CAP ? dienTich * donGia : dienTich * donGia * 0.9;
    }

    // Getters & Setters cho loaiNha và diaChi
    public LoaiNha getLoaiNha() {
        return loaiNha;
    }

    public void setLoaiNha(LoaiNha loaiNha) {
        this.loaiNha = loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    // Phương thức toString() hiển thị thông tin giao dịch nhà
    @Override
    public String toString() {
        return super.toString() + String.format(" | Loại nhà: %s | Thành tiền: %.2f | Địa chỉ: %s",
                loaiNha, thanhTien(), diaChi);
    }

	
}
