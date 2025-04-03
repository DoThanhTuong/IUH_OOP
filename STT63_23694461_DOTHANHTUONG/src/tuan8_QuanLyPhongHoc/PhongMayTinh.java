package tuan8_QuanLyPhongHoc;

public class PhongMayTinh extends Phonghoc {
	private int soMayTinh; // Số máy tính

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMayTinh = soMayTinh;
	}

	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) {
		this.soMayTinh = soMayTinh;
	}

	@Override
	protected boolean checkDatChuan() {
		// Kiểm tra điều kiện đạt chuẩn: đủ ánh sáng và đủ diện tích cho máy tính
		return (dienTich / soBongDen <= 10) && (dienTich / soMayTinh >= 1.5);
	}

	@Override
	public String toString() {
		return String.format("Phong May Tinh: %-15s, Dãy Nhà: %-15s, Diện Tích: %.2f\t, Số Bóng Đèn: %d\t, Số Máy Tính: %d\n",
				getMaPhong(), getDayNha(), getDienTich(), getSoBongDen(), soMayTinh);
	}
}