package tuan6_QuanLyPhongHoc;

public class PhongLyThuyet extends Phonghoc {
	private boolean hasMayChieu; // Có máy chiếu không

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean hasMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.hasMayChieu = hasMayChieu;
	}

	public boolean isHasMayChieu() {
		return hasMayChieu;
	}

	public void setHasMayChieu(boolean hasMayChieu) {
		this.hasMayChieu = hasMayChieu;
	}

	@Override
	protected boolean checkDatChuan() {
		// Kiểm tra điều kiện đạt chuẩn: đủ ánh sáng và có máy chiếu
		return (dienTich / soBongDen <= 10) && hasMayChieu;
	}

	@Override
	public String toString() {
		return String.format("Phong Ly Thuyet: %-15s, Dãy Nhà: %-15s, Diện Tích: %.2f\t, Số Bóng Đèn: %d\t, Có Máy Chiếu: %-15s\n",
				getMaPhong(), getDayNha(), getDienTich(), getSoBongDen(), hasMayChieu);
	}
}