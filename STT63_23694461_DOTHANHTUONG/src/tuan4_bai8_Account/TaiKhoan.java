package tuan4_bai8_Account;

import java.text.NumberFormat;
import java.util.Locale;

public class TaiKhoan {
    private long soTaiKhoan;
    private String ten;
    private double soDu;

    private static final double PHI_CHUYEN = 0.02; // Phí chuyển tiền cố định

    // Constructor mặc định
    public TaiKhoan() {
        this.soTaiKhoan = 999999;
        this.ten = "Chưa xác định";
        this.soDu = 50000; // Số dư tối thiểu là 50000
    }

    // Constructor với các tham số
    public TaiKhoan(long soTaiKhoan, String ten, double soDu) {
        setSoTaiKhoan(soTaiKhoan);
        setTen(ten);
        setSoDu(soDu);
    }

    // Getter và Setter
    public long getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(long soTaiKhoan) {
        if (soTaiKhoan > 0) {
            this.soTaiKhoan = soTaiKhoan;
        } else {
            this.soTaiKhoan = 999999;
        }
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        if (ten != null && !ten.trim().isEmpty()) {
            this.ten = ten;
        } else {
            this.ten = "Chưa xác định";
        }
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        if (soDu >= 50000) {
            this.soDu = soDu;
        } else {
            this.soDu = 50000; // Đảm bảo số dư tối thiểu là 50000
        }
    }

    // Nạp tiền vào tài khoản
    public boolean napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            return true;
        }
        return false;
    }

    // Rút tiền từ tài khoản
    public boolean rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            return true;
        }
        return false;
    }

    // Chuyển tiền từ tài khoản này sang tài khoản khác
    public boolean transfer(TaiKhoan accNhan, double soTien) throws Exception {
        if (accNhan == null) {
            throw new Exception("Tài khoản nhận không tồn tại!");
        }
        if (soTien <= 0) {
            throw new Exception("Số tiền phải > 0!");
        }

        // Tính tổng tiền cần chuyển, bao gồm phí chuyển
        double tongTra = soTien + soTien * PHI_CHUYEN;

        if (tongTra <= this.soDu) {
            accNhan.napTien(soTien);  // Nạp tiền vào tài khoản nhận
            this.rutTien(tongTra);    // Rút tiền từ tài khoản gửi
            return true;
        } else {
            throw new Exception("Số dư không đủ để chuyển!");
        }
    }

    // Phương thức để xuất thông tin tài khoản dưới dạng chuỗi
    @Override
    public String toString() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String formattedSoDu = currencyVN.format(soDu);
        return String.format("%-20d %-20s %-20s", soTaiKhoan, ten, formattedSoDu);
    }
}
