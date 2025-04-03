package tuan8_QuanLyPhongHoc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DanhSachPhongHoc {
	private List<Phonghoc> danhSachPhongHoc;

	// Constructor khởi tạo danh sách
	public DanhSachPhongHoc() {
		this.danhSachPhongHoc = new ArrayList<>();
	}

	// Phương thức thêm một phòng học vào danh sách
	public boolean themPhongHoc(Phonghoc phong) {
		if (timPhongHoc(phong.getMaPhong()) == null) {
			danhSachPhongHoc.add(phong);
			return true; // Thêm thành công
		}
		return false; // Mã phòng đã tồn tại
	}

	// Phương thức tìm kiếm một phòng học theo mã phòng
	public Phonghoc timPhongHoc(String maPhong) {
		for (Phonghoc phong : danhSachPhongHoc) {
			if (phong.getMaPhong().equals(maPhong)) {
				return phong;
			}
		}
		return null; // Không tìm thấy
	}

	// Phương thức toString để lấy thông tin toàn bộ danh sách phòng học
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Danh sách phòng học:\n");
		for (Phonghoc phong : danhSachPhongHoc) {
			sb.append(phong.toString()).append("\n");
		}
		return sb.toString();
	}

	// Phương thức lấy danh sách các phòng học đạt chuẩn
	public List<Phonghoc> layDanhSachDatChuan() {
		List<Phonghoc> datChuan = new ArrayList<>();
		for (Phonghoc phong : danhSachPhongHoc) {
			if (phong.checkDatChuan()) {
				datChuan.add(phong);
			}
		}
		return datChuan;
	}

	// Phương thức sắp xếp danh sách tăng dần theo dãy nhà
	public void sapXepTangTheoDayNha() {
		danhSachPhongHoc.sort(Comparator.comparing(Phonghoc::getDayNha));
	}

	// Phương thức sắp xếp danh sách giảm dần theo diện tích
	public void sapXepGiamTheoDienTich() {
		danhSachPhongHoc.sort(Comparator.comparingDouble(Phonghoc::getDienTich).reversed());
	}

	// Phương thức sắp xếp danh sách tăng dần theo số bóng đèn
	public void sapXepTangTheoSoBongDen() {
		danhSachPhongHoc.sort(Comparator.comparingInt(Phonghoc::getSoBongDen));
	}

	// Phương thức cập nhật số máy tính cho một phòng máy tính
	public boolean capNhatSoMayTinh(String maPhong, int soMayTinh) {
		Phonghoc phong = timPhongHoc(maPhong);
		if (phong instanceof PhongMayTinh) {
			((PhongMayTinh) phong).setSoMayTinh(soMayTinh);
			return true; // Cập nhật thành công
		}
		return false; // Không tìm thấy phòng máy tính
	}

	// Phương thức xóa một phòng học
	public boolean xoaPhongHoc(String maPhong) {
		Optional<Phonghoc> phongToRemove = danhSachPhongHoc.stream()
				.filter(phong -> phong.getMaPhong().equals(maPhong))
				.findFirst();

		if (phongToRemove.isPresent()) {
			danhSachPhongHoc.remove(phongToRemove.get());
			return true; // Xóa thành công
		}
		return false; // Không tìm thấy phòng để xóa
	}

	// Phương thức tính tổng số phòng học
	public int tongSoPhongHoc() {
		return danhSachPhongHoc.size();
	}

	// Phương thức lấy danh sách các phòng máy có 60 máy
	public List<PhongMayTinh> layDanhSachPhongMayCo60May() {
		List<PhongMayTinh> danhSach60May = new ArrayList<>();
		for (Phonghoc phong : danhSachPhongHoc) {
			if (phong instanceof PhongMayTinh && ((PhongMayTinh) phong).getSoMayTinh() == 60) {
				danhSach60May.add((PhongMayTinh) phong);
			}
		}
		return danhSach60May;
	}
}