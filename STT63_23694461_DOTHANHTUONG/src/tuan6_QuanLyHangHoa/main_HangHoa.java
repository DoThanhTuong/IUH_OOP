package tuan6_QuanLyHangHoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class main_HangHoa {
	public static void main(String[] args) throws IllegalAccessException {
		QuanLyHangHoa ds = new QuanLyHangHoa(100); // Giả sử tối đa 100 mặt hàng
		int chon = 0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("========= Menu ==========");
			System.out.println("1. Thêm Hàng Hóa");
			System.out.println("2. Xuất Hàng Hóa");
			System.out.println("3. Xóa Hàng Hóa");
			System.out.println("4. Xuất các Hàng Hóa khó bán");
			System.out.println("5. Tìm kiếm Hàng Hóa");
			System.out.println("6. Sửa Đơn Giá Hàng Hóa");
			System.out.println("7. Sắp xếp Hàng Hóa theo Tên");
			System.out.println("8. Sắp xếp Hàng Hóa theo Số Lượng Tồn");
			System.out.println("9. Xuất Hàng Sành Sứ");
			System.out.println("10. Xuất Hàng Điện Máy");
			System.out.println("11. Xuất Hàng Thực Phâm");
			System.out.println("12. Thoát");
			System.out.print("Chọn: ");
			chon = sc.nextInt();
			sc.nextLine(); // Đọc dòng mới

			switch (chon) {
				case 1:
//					themHangHoa(ds, sc);
					HangThucPham thucPham1 = new HangThucPham("TP001", "Gạo", 20000, 50, "Công ty A", LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1));
					HangThucPham thucPham2 = new HangThucPham("TP002", "Thịt heo", 150000, 30, "Công ty B", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 6, 1));

					// Tạo đối tượng hàng điện máy
					HangDienMay dienMay1 = new HangDienMay("DM001", "Tivi", 5000000, 10, 24, 150);
					HangDienMay dienMay2 = new HangDienMay("DM002", "Máy giặt", 7000000, 2, 12, 500);

					// Tạo đối tượng hàng sành sứ
					HangSanhSu sanhSu1 = new HangSanhSu("SS001", "Chén sứ", 5000, 100, "Công ty X", LocalDate.of(2023, 2, 1));
					HangSanhSu sanhSu2 = new HangSanhSu("SS002", "Đĩa sứ", 10000, 60, "Công ty Y", LocalDate.of(2023, 1, 15));

					// Thêm các đối tượng vào danh sách
					ds.themHang(thucPham1);
					ds.themHang(thucPham2);
					ds.themHang(dienMay1);
					ds.themHang(dienMay2);
					ds.themHang(sanhSu1);
					ds.themHang(sanhSu2);
					break;
				case 2:
					ds.hienThiDanhSach();
					break;
				case 3:
					xoaHangHoa(ds, sc);
					break;
				case 4:
					ds.hienThiHangThucPhamKhoBan();
					break;
				case 5:
					timHangHoa(ds, sc);
					break;
				case 6:
					suaDonGia(ds, sc);
					break;
				case 7:
					ds.sapXepTheoTen();
					System.out.println("Danh sách đã được sắp xếp theo tên.");
					break;
				case 8:
					ds.sapXepTheoSoLuongTon();
					System.out.println("Danh sách đã được sắp xếp theo số lượng tồn.");
					break;
				case 9:
					System.out.println("Danh sách Hàng Sành Sứ.");
					ds.hienThiHangSanhSu();
					break;
				case 10:
					System.out.println("Danh sách Hàng Điện Máy.");
					ds.hienThiHangDienMay();
					break;
				case 11:
					System.out.println("Danh sách Hàng Thực Phẩm.");
					ds.hienThiHangThucPham();
					break;

				case 12:
					System.out.println("Thoát chương trình.");
					break;

				default:
					System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
			}

		} while (chon != 12);

		sc.close();
	}

	public static void themHangHoa(QuanLyHangHoa ds, Scanner sc) throws IllegalAccessException {
		System.out.print("Chọn loại hàng (1: Thực phẩm, 2: Điện máy, 3: Sành sứ): ");
		int loaiHang = sc.nextInt();
		sc.nextLine(); // Đọc dòng mới

		String maHang, tenHang;
		double donGia;
		int soLuongTon;

		System.out.print("Nhập mã hàng: ");
		maHang = sc.nextLine();
		System.out.print("Nhập tên hàng: ");
		tenHang = sc.nextLine();
		System.out.print("Nhập đơn giá: ");
		donGia = sc.nextDouble();
		System.out.print("Nhập số lượng tồn: ");
		soLuongTon = sc.nextInt();
		sc.nextLine(); // Đọc dòng mới

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ngaySanXuat = null;
		LocalDate ngayHetHan = null;
		LocalDate ngayNhapKho = null;

		switch (loaiHang) {
			case 1: // Hàng thực phẩm
				System.out.print("Nhập nhà cung cấp: ");
				String nhaCungCap = sc.nextLine();
				while (ngaySanXuat == null) {
					System.out.print("Nhập ngày sản xuất : ");
					String dateInput = sc.nextLine();
					try {
						ngaySanXuat = LocalDate.parse(dateInput, formatter);
					} catch (DateTimeParseException e) {
						System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
					}
				}
				while (ngayHetHan == null) {
					System.out.print("Nhập ngày hết hạn : ");
					String dateInput = sc.nextLine();
					try {
						ngayHetHan = LocalDate.parse(dateInput, formatter);
						if (!ngayHetHan.isAfter(ngaySanXuat)) {
							System.out.println("Ngày hết hạn phải sau ngày sản xuất. Vui lòng nhập lại.");
							ngayHetHan = null; // Đặt lại để yêu cầu nhập lại
						}
					} catch (DateTimeParseException e) {
						System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
					}
				}
				HangThucPham thucPham = new HangThucPham(maHang, tenHang, donGia, soLuongTon, nhaCungCap, ngaySanXuat, ngayHetHan);
				if (ds.themHang(thucPham)) {
					System.out.println("Thêm hàng thực phẩm thành công.");
				} else {
					System.out.println("Mã hàng đã tồn tại.");
				}
				break;

			case 2: // Hàng điện máy
				System.out.print("Nhập thời gian bảo hành (tháng): ");
				int thoiGianBaoHanh = sc.nextInt();
				System.out.print("Nhập công suất (KW): ");
				double congSuat = sc.nextDouble();
				HangDienMay dienMay = new HangDienMay(maHang, tenHang, donGia, soLuongTon, thoiGianBaoHanh, congSuat);
				if (ds.themHang(dienMay)) {
					System.out.println("Thêm hàng điện máy thành công.");
				} else {
					System.out.println("Mã hàng đã tồn tại.");
				}
				break;

			case 3: // Hàng sành sứ
				System.out.print("Nhập nhà sản xuất: ");
				String nhaSanXuat = sc.nextLine();
				while (ngayNhapKho == null) {
					System.out.print("Nhập ngày nhập kho: ");
					String dateInput = sc.nextLine();
					try {
						ngayNhapKho = LocalDate.parse(dateInput, formatter);
						if (!ngayNhapKho.isBefore(LocalDate.now())) {
							System.out.println("Ngày nhập kho phải trước ngày hiện tại. Vui lòng nhập lại.");
							ngayNhapKho = null; // Đặt lại để yêu cầu nhập lại
						}
					} catch (DateTimeParseException e) {
						System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
					}
				}
				HangSanhSu sanhSu = new HangSanhSu(maHang, tenHang, donGia, soLuongTon, nhaSanXuat, ngayNhapKho);
				if (ds.themHang(sanhSu)) {
					System.out.println("Thêm hàng sành sứ thành công.");
				} else {
					System.out.println("Mã hàng đã tồn tại.");
				}
				break;

			default:
				System.out.println("Loại hàng không hợp lệ.");
		}
	}

	public static void xoaHangHoa(QuanLyHangHoa ds, Scanner sc) {
		System.out.print("Nhập mã hàng để xóa: ");
		String maHang = sc.nextLine();
		if (ds.xoaHang(maHang)) {
			System.out.println("Xóa hàng thành công.");
		} else {
			System.out.println("Không tìm thấy mã hàng.");
		}
	}

	public static void timHangHoa(QuanLyHangHoa ds, Scanner sc) {
		System.out.print("Nhập mã hàng để tìm: ");
		String maHang = sc.nextLine();
		HangHoa hang = ds.timHang(maHang);
		if (hang != null) {
			System.out.println("Thông tin hàng hóa tìm thấy: " + hang);
		} else {
			System.out.println("Không tìm thấy mã hàng.");
		}
	}

	public static void suaDonGia(QuanLyHangHoa ds, Scanner sc) {
		System.out.print("Nhập mã hàng để sửa đơn giá: ");
		String maHang = sc.nextLine();
		System.out.print("Nhập đơn giá mới: ");
		double donGiaMoi = sc.nextDouble();
		if (ds.suaDonGia(maHang, donGiaMoi)) {
			System.out.println("Sửa đơn giá thành công.");
		} else {
			System.out.println("Không tìm thấy mã hàng.");
		}
	}
}