package tuan6_QuanLyPhongHoc;

public class PhongThiNghiem extends Phonghoc {
	private String chuyenNganh; // Chuyên ngành
	private double sucChua; // Sức chứa
	private boolean hasBonRua; // Có bồn rửa không

	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh,
						  double sucChua, boolean hasBonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.chuyenNganh = chuyenNganh;
		this.sucChua = sucChua;
		this.hasBonRua = hasBonRua;
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public boolean isHasBonRua() {
		return hasBonRua;
	}

	public void setHasBonRua(boolean hasBonRua) {
		this.hasBonRua = hasBonRua;
	}

	public double getSucChua() {
		return sucChua;
	}

	public void setSucChua(double sucChua) {
		this.sucChua = sucChua;
	}

	@Override
	protected boolean checkDatChuan() {
		// Kiểm tra điều kiện đạt chuẩn: đủ ánh sáng và có bồn rửa
		return (dienTich / soBongDen <= 10) && hasBonRua;
	}

	@Override
	public String toString() {
		return String.format("Phong Thi Nghiem: %-15s, Dãy Nhà: %-15s, Diện Tích: %.2f\t, Số Bóng Đèn: %d\t, Chuyên Ngành: %-15s, Sức Chứa: %.2f\t, Có Bồn Rửa: %-15s\n",
				getMaPhong(), getDayNha(), getDienTich(), getSoBongDen(), chuyenNganh, sucChua, hasBonRua);
	}
}