package tuan8_QuanLyPhongHoc;

import java.util.Scanner;

public class TestPhongHoc {
	public static Scanner sc = new Scanner(System.in);

	public static PhongLyThuyet nhapPhongLyThuyet() {
		String maPhong, dayNha, temp;
		double dienTich;
		int soBongDen;
		System.out.printf("Nhap ma phong: ");
		maPhong = sc.next();
		System.out.printf("Nhap day nha: ");
		dayNha = sc.next();
		System.out.printf("Nhap dien tich: ");
		dienTich = sc.nextDouble();
		System.out.printf("Nhap so bong den: ");
		soBongDen = sc.nextInt();
		System.out.printf("Phong hoc co may chieu khong (Co/Khong): ");
		temp = sc.next();

		return new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, temp.equalsIgnoreCase("co"));
	}

	public static PhongMayTinh nhapPhongMayTinh() {
		String maPhong, dayNha;
		double dienTich;
		int soBongDen, soMayTinh;
		System.out.printf("Nhap ma phong: ");
		maPhong = sc.next();
		System.out.printf("Nhap day nha: ");
		dayNha = sc.next();
		System.out.printf("Nhap dien tich: ");
		dienTich = sc.nextDouble();
		System.out.printf("Nhap so bong den: ");
		soBongDen = sc.nextInt();
		System.out.printf("Nhap so may tinh: ");
		soMayTinh = sc.nextInt();

		return new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
	}

	public static PhongThiNghiem nhapPhongThiNghiem() {
		String maPhong, dayNha, chuyenNganh, temp;
		double dienTich, sucChua;
		int soBongDen;
		System.out.printf("Nhap ma phong: ");
		maPhong = sc.next();
		System.out.printf("Nhap day nha: ");
		dayNha = sc.next();
		System.out.printf("Nhap dien tich: ");
		dienTich = sc.nextDouble();
		System.out.printf("Nhap so bong den: ");
		soBongDen = sc.nextInt();
		System.out.printf("Nhap chuyen nganh: ");
		chuyenNganh = sc.next();
		System.out.printf("Nhap suc chua: ");
		sucChua = sc.nextDouble();
		System.out.printf("Phong hoc co bon rua hay khong (Co/Khong): ");
		temp = sc.next();

		return new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, temp.equalsIgnoreCase("co"));
	}

	public static void main(String[] args) {
		DanhSachPhongHoc ds = new DanhSachPhongHoc();
		int choice;

		do {
			System.out.println("1. Them phong hoc vao danh sach");
			System.out.println("2. Tim kiem phong hoc theo ma phong");
			System.out.println("3. Lay thong tin toan bo danh sach cac phong hoc");
			System.out.println("4. Lay danh sach cac phong hoc dat chuan");
			System.out.println("5. Sap xep tang dan theo day nha");
			System.out.println("6. Sap xep giam dan theo dien tich");
			System.out.println("7. Sap xep tang dan theo so bong den");
			System.out.println("8. Cap nhat so may tinh theo ma phong");
			System.out.println("9. Xoa mot phong hoc theo ma phong");
			System.out.println("10. Tinh tong so phong hoc");
			System.out.println("11. Lay danh sach phong may co 60 may");
			System.out.println("0. Thoat");
			System.out.println();

			System.out.printf("Nhap vao lua chon cua ban: ");
			choice = sc.nextInt();
			sc.nextLine(); // Đọc dòng mới

			switch (choice) {
				case 1:
					nhapCung(ds);
					System.out.println("Chon loai phong hoc muon them vao");
					System.out.println("1. Phong hoc ly thuyet");
					System.out.println("2. Phong may tinh");
					System.out.println("3. Phong thi nghiem");
					int loaiPhong = sc.nextInt();
					sc.nextLine(); // Đọc dòng mới

					if (loaiPhong == 1) {
						PhongLyThuyet plt = nhapPhongLyThuyet();
						if (ds.themPhongHoc(plt)) {
							System.out.println("Them phong ly thuyet thanh cong!");
						} else {
							System.out.println("Phong da ton tai!");
						}
					} else if (loaiPhong == 2) {
						PhongMayTinh pmt = nhapPhongMayTinh();
						if (ds.themPhongHoc(pmt)) {
							System.out.println("Them phong may tinh thanh cong!");
						} else {
							System.out.println("Phong da ton tai!");
						}
					} else {
						PhongThiNghiem ptn = nhapPhongThiNghiem();
						if (ds.themPhongHoc(ptn)) {
							System.out.println("Them phong thi nghiem thanh cong!");
						} else {
							System.out.println("Phong da ton tai!");
						}
					}
					break;
				case 2:
					System.out.printf("Nhap ma phong hoc can tim: ");
					String maPhongTim = sc.next();
					Phonghoc ph = ds.timPhongHoc(maPhongTim);

					if (ph != null) {
						System.out.println(ph);
					} else {
						System.err.println("Khong tim thay phong hoc");
					}
					break;
				case 3:
					System.out.println(ds);
					break;
				case 4:
					System.out.println("Danh sach cac phong hoc dat chuan: ");
					System.out.println(ds.layDanhSachDatChuan());
					break;
				case 5:
					ds.sapXepTangTheoDayNha();
					System.out.println("Da sap xep tang dan theo day nha.");
					break;
				case 6:
					ds.sapXepGiamTheoDienTich();
					System.out.println("Da sap xep giam dan theo dien tich.");
					break;
				case 7:
					ds.sapXepTangTheoSoBongDen();
					System.out.println("Da sap xep tang dan theo so bong den.");
					break;
				case 8:
					System.out.printf("Nhap ma phong can cap nhat so may tinh: ");
					String maPhongCapNhat = sc.next();
					System.out.printf("Nhap so may tinh moi: ");
					int soMayTinh = sc.nextInt();
					if (ds.capNhatSoMayTinh(maPhongCapNhat, soMayTinh)) {
						System.out.println("Cap nhat so may tinh thanh cong!");
					} else {
						System.out.println("Khong tim thay phong may tinh!");
					}
					break;
				case 9:
					System.out.printf("Nhap ma phong can xoa: ");
					String maPhongXoa = sc.next();
					if (ds.xoaPhongHoc(maPhongXoa)) {
						System.out.println("Da xoa phong hoc!");
					} else {
						System.out.println("Khong tim thay phong hoc de xoa!");
					}
					break;
				case 10:
					System.out.println("Tong so phong hoc: " + ds.tongSoPhongHoc());
					break;
				case 11:
					System.out.println("Danh sach phong may co 60 may: " );
					for(Phonghoc phco60may :ds.layDanhSachPhongMayCo60May()) {
						System.out.println(phco60may);
					}
					break;
				case 0:
					System.out.println("Thoat!");
					break;
				default:
					System.out.println("Lua chon khong hop le!");
					break;
			}
		} while (choice != 0);
	}
	public static void nhapCung(DanhSachPhongHoc ds){
		PhongLyThuyet phongLyThuyet1 = new PhongLyThuyet("LT101", "A", 40, 5, true);
		PhongLyThuyet phongLyThuyet2 = new PhongLyThuyet("LT102", "A", 45, 6, false);
		ds.themPhongHoc(phongLyThuyet1);
		ds.themPhongHoc(phongLyThuyet2);

		// Tạo và thêm phòng máy tính
		PhongMayTinh phongMayTinh1 = new PhongMayTinh("MT201", "B", 30, 4, 25);
		PhongMayTinh phongMayTinh2 = new PhongMayTinh("MT202", "B", 35, 5, 60);
		ds.themPhongHoc(phongMayTinh1);
		ds.themPhongHoc(phongMayTinh2);

		// Tạo và thêm phòng thí nghiệm
		PhongThiNghiem phongThiNghiem1 = new PhongThiNghiem("TN301", "C", 50, 5, "Hóa học", 30, true);
		PhongThiNghiem phongThiNghiem2 = new PhongThiNghiem("TN302", "C", 55, 6, "Sinh học", 40, false);
		ds.themPhongHoc(phongThiNghiem1);
		ds.themPhongHoc(phongThiNghiem2);
	}
}