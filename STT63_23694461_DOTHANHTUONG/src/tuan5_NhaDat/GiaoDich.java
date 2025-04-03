package tuan5_NhaDat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class GiaoDich {
    // Các thuộc tính chung cho giao dịch
    protected String maGiaoDich;  // Mã giao dịch
    protected LocalDate ngayGiaoDich;  // Ngày giao dịch
    protected double donGia;  // Đơn giá
    protected double dienTich;  // Diện tích

    // Định dạng ngày tháng theo dd/MM/yyyy
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Constructor mặc định (không có tham số)
    protected GiaoDich() {
        this("GD0000", "01/01/2000", 0, 0);
    }

    // Constructor có tham số
    protected GiaoDich(String maGiaoDich, String ngayGiaoDich, double donGia, double dienTich) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = LocalDate.parse(ngayGiaoDich, DATE_FORMATTER); // Chuyển đổi chuỗi thành LocalDate
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    public String getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	// Phương thức equals để so sánh giao dịch dựa vào mã giao dịch
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Nếu cùng tham chiếu thì là cùng một đối tượng
        if (!(obj instanceof GiaoDich)) return false; // Kiểm tra kiểu đối tượng
        GiaoDich gd = (GiaoDich) obj;
        return Objects.equals(maGiaoDich, gd.maGiaoDich);
    }

    // Hàm hashCode đảm bảo nếu hai đối tượng equals() thì hashCode cũng giống nhau
    @Override
    public int hashCode() {
        return Objects.hash(maGiaoDich);
    }

    // Getter để lấy ngày giao dịch dưới dạng String
    public String getNgayGiaoDichFormatted() {
        return ngayGiaoDich.format(DATE_FORMATTER);
    }

    // Phương thức trừu tượng tính thành tiền, sẽ được triển khai trong lớp con
    public abstract double thanhTien();
    
    

    // Phương thức toString() hiển thị thông tin giao dịch
    @Override
    public String toString() {
        return String.format("%10s | %10s | %10.2f | %10.2f",
                maGiaoDich, getNgayGiaoDichFormatted(), donGia, dienTich);
    }
}
