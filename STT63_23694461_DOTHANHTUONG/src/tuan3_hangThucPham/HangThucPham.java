package tuan3_hangThucPham;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangThucPham {
	
    private final String maHang; // Không cho phép sửa
    private String tenHang;
    private double donGia;
    private Date ngaySanXuat;
    private Date ngayHetHan;

    // Giá trị mặc định
 
    private static final String TEN_HANG_MAC_DINH = "Tên hàng mặc định";
    private static final double DON_GIA_MAC_DINH = 1.0;

    // Định dạng ngày
 
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor đầy đủ tham số
    public HangThucPham(String maHang, String tenHang, double donGia, Date ngaySanXuat, Date ngayHetHan) {
        if (maHang == null || maHang.isEmpty()) {
        	
            throw new IllegalArgumentException("Mã hàng không được để trống!");
        }
        this.maHang = maHang;
        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }

    // Constructor với tham số là mã hàng
    public HangThucPham(String maHang) {
        if (maHang == null || maHang.isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống!");
        }
        this.maHang = maHang;
        this.tenHang = TEN_HANG_MAC_DINH;
        this.donGia = DON_GIA_MAC_DINH;
    }

    // Getter và Setter cho tên hàng
    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.isEmpty()) {
            this.tenHang = TEN_HANG_MAC_DINH;
        } else {
            this.tenHang = tenHang;
        }
    }

    // Getter và Setter cho đơn giá
    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia > 0) {
            this.donGia = donGia;
        } else {
            this.donGia = DON_GIA_MAC_DINH;
        }
    }

    // Getter và Setter cho ngày sản xuất
    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        if (ngaySanXuat == null) {
            throw new IllegalArgumentException("Ngày sản xuất không được để trống!");
        }
        this.ngaySanXuat = ngaySanXuat;
    }

    // Getter và Setter cho ngày hết hạn
    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan == null) {
            throw new IllegalArgumentException("Ngày hết hạn không được để trống!");
        }
        if (ngaySanXuat != null && ngayHetHan.before(ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất!");
        }
        this.ngayHetHan = ngayHetHan;
    }

    // Kiểm tra hàng đã hết hạn chưa
    public boolean daHetHan() {
        if (ngayHetHan == null) return false;
        return ngayHetHan.before(new Date());
    }

    public String getMaHang() {
		return maHang;
	}

	// Phương thức toString
    @Override
    public String toString() {
    	
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        String donGiaFormat = decimalFormat.format(donGia);
        String ngaySanXuatFormat = (ngaySanXuat == null) ? "N/A" : dateFormat.format(ngaySanXuat);
        String ngayHetHanFormat = (ngayHetHan == null) ? "N/A" : dateFormat.format(ngayHetHan);

        return String.format("%-20s %-20s %-20s %-20s %-20s %-20s",
                maHang, tenHang, donGiaFormat, ngaySanXuatFormat, ngayHetHanFormat, daHetHan() ? "Có" : "Không");
    }
}
