package tuan5_NhaDat;

public class GiaoDichDat extends GiaoDich {
	//attributes
	private String loaiDat;
	private double thanhTien;
	//constructor
	public GiaoDichDat() {
		super();
		loaiDat = "chưa xác định";
		thanhTien = 0;
	}
	public GiaoDichDat(String maGiaoDich, String ngayGiaoDich, double donGia, double dienTich, String loaiDat) {
		super(maGiaoDich,ngayGiaoDich,donGia,dienTich);
		this.loaiDat = loaiDat;
		if (loaiDat.equalsIgnoreCase("a")) {
			this.thanhTien = super.getDienTich() * super.getDonGia() * 1.5;
		}else {
			this.thanhTien = super.getDienTich() * super.getDonGia();
		}
	}
	//methods
	public String getLoaiDat() {
		return loaiDat;
	}
	public void setLoaiDat(String loaiDat) throws Exception{
		if (loaiDat.equalsIgnoreCase("a")) {
			this.thanhTien = super.getDienTich() * super.getDonGia() * 1.5;
			this.loaiDat = loaiDat;
		}else if (loaiDat.equalsIgnoreCase("b") || loaiDat.equalsIgnoreCase("c")){
			this.thanhTien = super.getDienTich() * super.getDonGia();
			this.loaiDat = loaiDat;
		}else {
			throw new Exception("Loại đất không hợp lệ!");
		}
	}
	public String toString() {
		return super.toString() + String.format("%15s",getLoaiDat());
	}
}
