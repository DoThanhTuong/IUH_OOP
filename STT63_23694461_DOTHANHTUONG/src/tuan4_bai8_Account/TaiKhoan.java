package tuan4_bai8_Account;

import java.text.NumberFormat;
import java.util.Locale;

public class TaiKhoan {
    private long soTaiKhoan;
    private String ten;
    private double soDu;

    
    private static final double PHI_CHUYEN = 0.02;

   
    public TaiKhoan() {
        this.soTaiKhoan = 999999;
        this.ten = "chua xac dinh";
        this.soDu = 50000;
    }

   
    public TaiKhoan(long soTaiKhoan, String ten, double soDu) {
        setSoTaiKhoan(soTaiKhoan);
        setTen(ten);
        setSoDu(soDu);
    }

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
            this.ten = "chua xac dinh";
        }
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        if (soDu >= 50000) {
            this.soDu = soDu;
        } else {
            this.soDu = 50000;
        }
    }

    
    public boolean napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            return true;
        }
        return false;
    }

    
    public boolean rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            return true;
        }
        return false;
    }

    
    public boolean transfer(TaiKhoan accNhan, double soTien) throws Exception {
        if (accNhan == null) {
            throw new Exception("Tai khoan nhan khong ton tai!");
        }
        if (soTien <= 0) {
            throw new Exception("So tien phai > 0!");
        }

       
        double tongTra = soTien + soTien * PHI_CHUYEN;

        if (tongTra <= this.soDu) {
            accNhan.napTien(soTien); 
            this.rutTien(tongTra);   
            return true;
        } else {
            throw new Exception("So du khong du de chuyen!");
        }
    }

  
    @Override
    public String toString() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String formattedSoDu = currencyVN.format(soDu);
        return String.format("%-20d %-20s %-20s", soTaiKhoan, ten, formattedSoDu);
    }
}