package tuan5_NhaDat;

public class GiaoDichDat extends GiaoDich {
    // Enum định nghĩa loại đất (giúp tránh nhập sai dữ liệu)
    public enum LoaiDat {
        A, B, C
    }

    // Thuộc tính loại đất
    private LoaiDat loaiDat;

    // Constructor mặc định
    public GiaoDichDat() {
        super();
        this.loaiDat = LoaiDat.B; // Mặc định là loại B
    }


    // Constructor đầy đủ
    public GiaoDichDat(String maGiaoDich, String ngayGiaoDich, double donGia, double dienTich, LoaiDat loaiDat) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiDat = loaiDat;
    }
    

    // Cài đặt phương thức abstract thanhTien() từ lớp GiaoDich
    @Override
    public double thanhTien() {
        // Nếu là loại đất A, giá trị tăng 1.5 lần
        return loaiDat == LoaiDat.A ? dienTich * donGia * 1.5 : dienTich * donGia;
    }

    // Getter & Setter cho loaiDat
    public LoaiDat getLoaiDat() {
        return loaiDat;
    }

    public void setLoaiDat(LoaiDat loaiDat) {
        this.loaiDat = loaiDat;
    }

    // Phương thức toString() hiển thị thông tin giao dịch đất
    @Override
    public String toString() {
        return super.toString() + String.format(" | Loại đất: %s | Thành tiền: %.2f", loaiDat, thanhTien());
    }
    

}
