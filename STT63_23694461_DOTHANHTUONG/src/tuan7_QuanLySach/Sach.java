package tuan7_QuanLySach;

import java.time.LocalDate;

abstract class Sach {
    protected String maSach;
    protected LocalDate ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public final String getMaSach() {
        return maSach;
    }

    public final LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public final double getDonGia() {
        return donGia;
    }

    public final int getSoLuong() {
        return soLuong;
    }

    public final String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public final void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public final void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public final void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public final void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public final void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    protected abstract double getThanhTien();

    @Override
    public String toString() {
        return String.format("%-10s | %-10s | %-10.2f | %-10d | %-20s", 
            maSach, 
            ngayNhap, 
            donGia, 
            soLuong, 
            nhaXuatBan);
    }
}


