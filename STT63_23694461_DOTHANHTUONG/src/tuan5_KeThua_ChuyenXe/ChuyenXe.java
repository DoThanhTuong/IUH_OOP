package tuan5_KeThua_ChuyenXe;

import java.util.Scanner;

public class ChuyenXe {
    //Attributes
    protected String maChuyenXe,hoTenTaiXe,soXe;
    protected double doanhThu;
    protected String getmaChuyenXe() {
        return maChuyenXe;
    }
    //Constructor
    protected ChuyenXe(){
        maChuyenXe = "";
        hoTenTaiXe = "";
        soXe = "";
        doanhThu = 0f;
    }
    protected ChuyenXe(String maChuyenXe, String hoTenTaiXe, String soXe, double doanhThu) {
        this.maChuyenXe = maChuyenXe;
        this.hoTenTaiXe = hoTenTaiXe;
        this.soXe = soXe;
        this.doanhThu = doanhThu;
    }
    //hashCode and equals
    //hashCode(): Cung cấp một giá trị băm duy nhất cho mỗi đối tượng.
    //equals(): Kiểm tra xem hai đối tượng có giống nhau về nội dung hay không.
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maChuyenXe == null) ? 0 : maChuyenXe.hashCode());
        return result;
    }

    public boolean equals(Object obj) { 	// Object duoc coi nhu dai dien cho tat ca cac lop trong java
        if (this == obj)					// so sanh vung tham chieu cua 2 doi tuong
            return true;
        if (obj == null)					// so sanh voi gia tri NULL
            return false;
        ChuyenXe other = (ChuyenXe) obj;	// Ep kieu du lieu cua doi tuong obj ve cung class de so sanh noi dung
        if (maChuyenXe.equals(other.getmaChuyenXe())) {
            return true;
        }else
            return false;
    }
    //Methods
    protected String getMaChuyenXe() {
        return maChuyenXe;
    }
    protected String getHoTenTaiXe(){
        return hoTenTaiXe;
    }
    protected String getSoXe() {
        return soXe;
    }
    protected double getDoanhThu() {
        return doanhThu;
    }
    protected void setmaChuyenXe(String maChuyenXe) {
        this.maChuyenXe = maChuyenXe;
    }
    protected void setHoTenTaiXe(String hoTenTaiXe) {
        this.hoTenTaiXe = hoTenTaiXe;
    }
    protected void setSoXe(String soXe) {
        this.soXe = soXe;
    }
    protected void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }
    public String toString() {
        return String.format("%15s %25s %10s %15.3f", getMaChuyenXe(),getHoTenTaiXe(),getSoXe(),getDoanhThu());
    }
    protected String getTenTaiXe() {
        String[] parts = hoTenTaiXe.trim().split("\\s+"); // Tách chuỗi thành các phần dựa trên khoảng trắng
        return parts[parts.length - 1]; // Lấy phần tử cuối cùng (tên)
    }
}
