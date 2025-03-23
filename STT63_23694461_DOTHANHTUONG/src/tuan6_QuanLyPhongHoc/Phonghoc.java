package tuan6_QuanLyPhongHoc;

import java.util.Objects;

public abstract class Phonghoc {
	protected String maPhong;      // Mã phòng
	protected String dayNha;       // Dãy nhà
	protected double dienTich;     // Diện tích phòng
	protected int soBongDen;       // Số bóng đèn

	// Constructor
	public Phonghoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}

	// Getters
	public String getMaPhong() {
		return maPhong;
	}

	public String getDayNha() {
		return dayNha;
	}

	public double getDienTich() {
		return dienTich;
	}

	public int getSoBongDen() {
		return soBongDen;
	}

	// Setters
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	public void setSoBongDen(int soBongDen) {
		this.soBongDen = soBongDen;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true; // So sánh đối tượng với chính nó
		if (obj == null || getClass() != obj.getClass()) return false; // Kiểm tra null và kiểu lớp
		Phonghoc other = (Phonghoc) obj;
		return Objects.equals(maPhong, other.maPhong); // So sánh mã phòng
	}

	// Phương thức trừu tượng để kiểm tra phòng đạt chuẩn
	protected abstract boolean checkDatChuan();
	@Override
	public String toString() {
		return String.format("Mã Phòng: %-15s, Dãy Nhà: %-15s, Diện Tích: %.2f m², Số Bóng Đèn: %d",
				maPhong, dayNha, dienTich, soBongDen);
	}
}