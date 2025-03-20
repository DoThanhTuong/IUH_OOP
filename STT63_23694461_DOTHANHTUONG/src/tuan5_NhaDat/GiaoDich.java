package tuan5_NhaDat;

public class GiaoDich {
	//attributes
	protected String maGiaoDich,ngayGiaoDich;
	protected double donGia,dienTich;
	//constructors
	protected GiaoDich() {
		maGiaoDich = "GD0000";
		ngayGiaoDich = "chưa xác định";
		donGia = 0;
		dienTich = 0;
	}
	protected GiaoDich(String maGiaoDich, String ngayGiaoDich, double donGia, double dienTich) {
		super();
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}
	//equals
	public boolean equals(Object obj) {
		if (this == obj) return true;
		else if (obj == null) return false;
		GiaoDich temp = (GiaoDich) obj;
		if (this.getMaGiaoDich().equalsIgnoreCase(temp.getMaGiaoDich())) {
			return true;
		}else {
			return false;
		}
	}
	
	//methods


	protected String getMaGiaoDich() {
		return maGiaoDich;
	}
	protected void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}
	protected String getNgayGiaoDich() {
		return ngayGiaoDich;
	}
	protected void setNgayGiaoDich(String ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}
	protected double getDonGia() {
		return donGia;
	}

	protected void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	protected double getDienTich() {
		return dienTich;
	}
	protected void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	public String toString() {
		return String.format("%15s %20s %15.3f %10.3f",getMaGiaoDich(),getNgayGiaoDich(),getDonGia(),getDienTich());
	}
}
