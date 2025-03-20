package tuan5_NhaDat;

public class GiaoDichNha extends GiaoDich {
	//attributes
	private String loaiNha,diaChi;
	private double thanhTien;
	//constructors
	public GiaoDichNha() {
		super();
		loaiNha = "chưa xác định";
		diaChi = "chưa xác định";
		thanhTien = 0;
	}
	public GiaoDichNha(String maGiaoDich, String ngayGiaoDich, double donGia, double dienTich, String loaiNha, String diaChi) {
		super(maGiaoDich,ngayGiaoDich,donGia,dienTich);
		this.loaiNha = loaiNha;
		this.diaChi = diaChi;
		if (loaiNha.equalsIgnoreCase("cao cấp")) {
			this.thanhTien = super.getDienTich() * super.getDonGia();
		}else {
			this.thanhTien = super.getDienTich() * super.getDonGia()* 0.9 ;
		}
	}
	//methods
	public String getLoaiNha() {
		return loaiNha;
	}
	public void setLoaiNha(String loaiNha) throws Exception {
		if (loaiNha.equalsIgnoreCase("cao cấp")) {
			this.thanhTien = super.getDienTich() * super.getDonGia();
			this.loaiNha = loaiNha;
		}else if (loaiNha.equalsIgnoreCase("thường")){
			this.thanhTien = super.getDienTich() * super.getDonGia() * 0.9;
			this.loaiNha = loaiNha;
		}else {
			throw new Exception("Loại nhà không hợp lệ!");
		}
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public double getThanhTien() {
		return this.thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String toString() {
		return super.toString() + String.format("%15s %20s",getLoaiNha(),getDiaChi());
	}
}
