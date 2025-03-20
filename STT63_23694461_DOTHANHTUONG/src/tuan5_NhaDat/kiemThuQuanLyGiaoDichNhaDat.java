package tuan5_NhaDat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class kiemThuQuanLyGiaoDichNhaDat {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		DanhSachGiaoDich ds = new DanhSachGiaoDich();
		int choice = -1;
		while (choice != 0) {
			menu();
			System.out.println("Nhập lựa chọn: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
				case 0:
					System.out.println("Thoát thành công!!");
					break;
				case 1:
					themGiaoDich(ds);
					break;
				case 2:
					xoaGiaoDich(ds);
					break;
				case 3:
					suaGiaoDich(ds);
					break;
				case 4:
					nhapCung(ds);
					break;
				case 5:
					xuatDSGDĐat(ds);
					break;
				case 6:
					xuatDSGDNha(ds);
					break;
				case 7:
					xuatDS(ds);
					break;
				case 8:
					xuatDSTheoNgayGD(ds);
					break;
				case 9:
					sortTheoNgayGD(ds);
					break;
				case 10:
				default: 
					System.out.println("Lỗi lựa chọn không hợp lệ!!");
			}
		}
	}
	public static void menu() {
		System.out.println("********************************************************");
		System.out.println("** Chương trình quản lý giao dịch                     **");
		System.out.println("** 0. Thoát                                           **");
		System.out.println("** 1. Thêm giao dịch                                  **");
		System.out.println("** 2. Xóa giao dịch theo mã                           **");
		System.out.println("** 3. Sửa giao dịch                                   **");
		System.out.println("** 4. Nhập cứng                                       **");
		System.out.println("** 5. Xuất danh sách giao dịch đất                    **");
		System.out.println("** 6. Xuất danh sách giao dịch nhà                    **");
		System.out.println("** 7. Xuất danh sách tất cả giao dịch                 **");
		System.out.println("** 8. Xuất danh sách giao dịch theo ngày giao dịch    **");
		System.out.println("** 9. Sắp xếp danh sách theo ngày giao dịch           **");
		System.out.println("** 10. Sắp xếp danh sách theo thành tiền              **");
		System.out.println("** 11. Trung bình thành tiền của giao dịch đất        **");
		System.out.println("********************************************************");
	}
	public static void menuSuaGDDat() {
		System.out.println("********************************************************");
		System.out.println("** Chương trình chỉnh sửa thông tin giao dịch đất     **");
		System.out.println("** 0. Thoát                                           **");
		System.out.println("** 1. Mã giao dịch                                    **");
		System.out.println("** 2. Ngày giao dịch                                  **");
		System.out.println("** 3. Đơn giá                                         **");
		System.out.println("** 4. Diện tích                                       **");
		System.out.println("** 5. Loại đất                                        **");
		System.out.println("********************************************************");
	}
	public static void menuSuaGDNha() {
		System.out.println("********************************************************");
		System.out.println("** Chương trình chỉnh sửa thông tin giao dịch nhà     **");
		System.out.println("** 0. Thoát                                           **");
		System.out.println("** 1. Mã giao dịch                                    **");
		System.out.println("** 2. Ngày giao dịch                                  **");
		System.out.println("** 3. Đơn giá                                         **");
		System.out.println("** 4. Diện tích                                       **");
		System.out.println("** 5. Loại nhà                                        **");
		System.out.println("** 6. Địa chỉ                                         **");
		System.out.println("********************************************************");
	}
	public static void tieuDeDSGDDat(){
		System.out.println(String.format("%15s %20s %15s %10s %15s","Mã giao dịch","Ngày giao dịch","Đơn giá","Diện tích","Loại đất"));
	}
	public static void tieuDeDSGDNha(){
		System.out.println(String.format("%15s %20s %15s %10s %15s %20s","Mã giao dịch","Ngày giao dịch","Đơn giá","Diện tích","Loại nhà","Địa chỉ"));
	}
	public static void tieuDeDSGD(){
		System.out.println(String.format("%15s %20s %15s %10s %15s %20s","Mã giao dịch","Ngày giao dịch","Đơn giá","Diện tích","Loại nhà/đất","Địa chỉ(Giao dịch đất)"));
	}
	public static void themGiaoDich(DanhSachGiaoDich ds) {
		try {
			int choice = -1;
			String maGiaoDich,ngayGiaoDich;
			double donGia,dienTich;
			System.out.println("Nhập mã giao dịch"); maGiaoDich = sc.nextLine();
			if (ds.timKiemGiaoDich(maGiaoDich) == null) {
				System.out.println("Nhập ngày tháng năm(dd/mm/yyyy): "); ngayGiaoDich = sc.nextLine();
				System.out.println("Nhập đơn giá: "); donGia = sc.nextDouble();
				System.out.println("Nhập diện tích: "); dienTich = sc.nextDouble();
				System.out.println("Nhập [1]Giao dịch đất hoặc [2]Giao dịch nhà: "); 				choice = sc.nextInt();
				sc.nextLine();
				if (choice == 1) {
					GiaoDichDat gdd = new GiaoDichDat();
					gdd.setMaGiaoDich(maGiaoDich);
					gdd.setNgayGiaoDich(ngayGiaoDich);
					gdd.setDonGia(donGia);
					gdd.setDienTich(dienTich);
					System.out.println("Nhập loại đất: "); gdd.setLoaiDat(sc.nextLine());
					if (ds.themGiaoDich(gdd)) {
						throw new Exception("Thêm giao dịch đất thành công!!");
					}
				}else {
					GiaoDichNha gdn = new GiaoDichNha();
					gdn.setMaGiaoDich(maGiaoDich);
					gdn.setNgayGiaoDich(ngayGiaoDich);
					gdn.setDonGia(donGia);
					gdn.setDienTich(dienTich);
					System.out.println("Nhập loại nhà: "); gdn.setLoaiNha(sc.nextLine());
					System.out.println("Nhập địa chỉ: "); gdn.setDiaChi(sc.nextLine());
					if (ds.themGiaoDich(gdn)) {
						throw new Exception("Thêm giao dịch nhà thành công");
					}
				}
			}else {
				throw new Exception("Mã giao dịch trùng!!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void xoaGiaoDich(DanhSachGiaoDich ds) {
		try {
			String maGiaoDich;
			System.out.println("Nhập mã giao dịch cần xóa: "); maGiaoDich = sc.nextLine();
			GiaoDich gd = ds.timKiemGiaoDich(maGiaoDich);
			System.out.println("Bạn có chắc muốn xóa giao dịch không?[y/n]:");
			if (sc.nextLine().equalsIgnoreCase("y")) {
				ds.xoaGiaoDich(gd);
			}else {
				throw new Exception("Bạn đã giữ lại giao dịch thành công!!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void suaGiaoDich(DanhSachGiaoDich ds) {
		try {
			int choice = -1;
			String maGiaoDich;
			System.out.println("Nhập mã giao dịch cần sửa: "); maGiaoDich = sc.nextLine();
			GiaoDich gd = ds.timKiemGiaoDich(maGiaoDich);
			if (ds.timKiemViTriGiaoDich(maGiaoDich) != -1) {
				System.out.println("Thông tin giao dịch đất trước khi sửa");
				if (gd instanceof GiaoDichDat) {
					GiaoDichDat gdd = (GiaoDichDat) gd;
					tieuDeDSGDDat();
					System.out.println(gdd);
					menuSuaGDDat();
					System.out.println("Nhập lựa chọn: "); choice = sc.nextInt();
					sc.nextLine();
					while (choice != 0) {
						switch (choice) {
							case 0:
								System.out.println("Thoát thành công!!");
								break;
							case 1:
								System.out.println("Nhập mã giao dịch:");
								gdd.setMaGiaoDich(sc.nextLine());
								break;
							case 2:
								System.out.println("Nhập ngày giao dịch:");
								gdd.setNgayGiaoDich(sc.nextLine());
								break;
							case 3:
								System.out.println("Nhập đơn giá:");
								gdd.setDonGia(sc.nextDouble());
								break;
							case 4:
								System.out.println("Nhập diện tích: ");
								gdd.setDienTich(sc.nextDouble());
								break;
							case 5:
								System.out.println("Nhập loại đất: ");
								gdd.setLoaiDat(sc.nextLine());
								break;
							default:
								System.out.println("Lỗi lựa chọn không hợp lệ!");
						}
					}
				}else {
					GiaoDichNha gdn = (GiaoDichNha) gd;
					System.out.println("Thông tin giao dịch đất trước khi sửa");
					tieuDeDSGDNha();
					System.out.println(gdn);
					menuSuaGDNha();
					System.out.println("Nhập lựa chọn: "); choice = sc.nextInt();
					sc.nextLine();
					while (choice != 0) {
						switch (choice) {
						case 0:
							System.out.println("Thoát thành công!!");
							break;
						case 1:
							System.out.println("Nhập mã giao dịch:");
							gdn.setMaGiaoDich(sc.nextLine());
							break;
						case 2:
							System.out.println("Nhập ngày giao dịch:");
							gdn.setNgayGiaoDich(sc.nextLine());
							break;
						case 3:
							System.out.println("Nhập đơn giá:");
							gdn.setDonGia(sc.nextDouble());
							break;
						case 4:
							System.out.println("Nhập diện tích: ");
							gdn.setDienTich(sc.nextDouble());
							break;
						case 5:
							System.out.println("Nhập loại nhà: ");
							gdn.setLoaiNha(sc.nextLine());
							break;
						case 6:
							System.out.println("Nhập địa chỉ: ");
							gdn.setDiaChi(sc.nextLine());
							break;
						default:
								System.out.println("Lỗi lựa chọn không hợp lệ!");
						}
					}
				}
			}else {
				throw new Exception("Lỗi mã chuyến xe không tồn tại");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void nhapCung(DanhSachGiaoDich ds) {
		try {
			GiaoDichDat gdd = new GiaoDichDat("GD001","23/02/2018",500000,100,"A");
			GiaoDichNha gdn = new GiaoDichNha("GD002","10/05/2015",1000000,500,"cao cấp","Quận 3");
			GiaoDichDat gdd1 = new GiaoDichDat("GD003","20/06/2010",5000000,200,"A");
			GiaoDichNha gdn1 = new GiaoDichNha("GD004","10/05/2025",10000000,300,"thường","Quận 10");
			ds.themGiaoDich(gdd);
			ds.themGiaoDich(gdn);
			ds.themGiaoDich(gdd1);
			ds.themGiaoDich(gdn1);
			throw new Exception("Nhập cứng thành công!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void xuatDSGDĐat(DanhSachGiaoDich ds) {
		tieuDeDSGDDat();
		for (GiaoDichDat gdd : ds.getDSGDD()) {
			System.out.println(gdd);
		}
	}
	public static void xuatDSGDNha(DanhSachGiaoDich ds) {
		tieuDeDSGDNha();
		for (GiaoDichNha gdn : ds.getDSGDN()) {
			System.out.println(gdn);
		}
	}
	public static void xuatDS(DanhSachGiaoDich ds) {
		tieuDeDSGD();
		for (GiaoDich gd : ds.getDS()) {
			if (gd instanceof GiaoDichDat) {
				System.out.println((GiaoDichDat)gd);
			}else {
				System.out.println((GiaoDichNha)gd);
			}
		}
	}
	public static void xuatDSTheoNgayGD(DanhSachGiaoDich ds) {
		try {
			System.out.println("Nhập ngày bắt đầu(dd/mm/yyyy): ");
			String ngayBD = sc.nextLine();
			System.out.println("Nhập ngày kết thúc(dd/mm/yyyy): ");
			String ngayKT = sc.nextLine();
			if (DanhSachGiaoDich.compareDate(ngayBD, ngayKT) == 1) {
				throw new Exception("Lỗi ngày bắt đầu lớn hơn ngày kết thúc!");
			}else {
				tieuDeDSGD();
				for (GiaoDich gd : ds.getDSTheoNgayGD(ngayBD, ngayKT)) {
					if (gd instanceof GiaoDichDat) {
						System.out.println((GiaoDichDat)gd);
					}else {
						System.out.println((GiaoDichNha)gd);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void sortTheoNgayGD(DanhSachGiaoDich ds) {
		Collections.sort(ds.getDS(), new Comparator<GiaoDich>() {
            public int compare(GiaoDich gd1, GiaoDich gd2) {
                return DanhSachGiaoDich.compareDate(gd1.getNgayGiaoDich(), gd2.getNgayGiaoDich());
            }
        });
	}
}
