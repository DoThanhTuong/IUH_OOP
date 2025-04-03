package tuan5_NhaDat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import tuan5_NhaDat.GiaoDichDat.LoaiDat;
import tuan5_NhaDat.GiaoDichNha.LoaiNha;

public class kiemThuQuanLyGiaoDichNhaDat {
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
					ds.sortTheoNgayGD();
					break;
				case 10:
					ds.sortTheoThanhTien();
					break;
				case 11:
					System.out.printf("Trung bình: %-10f",ds.trungBinhThanhTienGiaoDichDat());
					break;
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
		System.out.println("** 11. Trung bình thành tiền của giao dịch            **");
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

	public static void themGiaoDich(DanhSachGiaoDich ds) {
	    try {
	        int choice = -1;
	        String maGiaoDich, ngayGiaoDich;
	        double donGia, dienTich;
	
	        // Nhập mã giao dịch
	        System.out.print("Nhập mã giao dịch: ");
	        maGiaoDich = sc.nextLine();
	
	        // Kiểm tra nếu mã giao dịch đã tồn tại
	        if (ds.timKiemGiaoDich(maGiaoDich) == null) {
	            // Nhập ngày giao dịch
	            System.out.print("Nhập ngày tháng năm (dd/MM/yyyy): ");
	            ngayGiaoDich = sc.nextLine();
	
	            // Kiểm tra ngày tháng hợp lệ
	            if (!isValidDate(ngayGiaoDich)) {
	                throw new Exception("Ngày giao dịch không hợp lệ!");
	            }
	
	            // Nhập đơn giá
	            System.out.print("Nhập đơn giá: ");
	            donGia = sc.nextDouble();
	            if (donGia <= 0) {
	                throw new Exception("Đơn giá phải lớn hơn 0!");
	            }
	
	            // Nhập diện tích
	            System.out.print("Nhập diện tích: ");
	            dienTich = sc.nextDouble();
	            if (dienTich <= 0) {
	                throw new Exception("Diện tích phải lớn hơn 0!");
	            }
	
	            // Nhập lựa chọn giao dịch (1: Giao dịch đất, 2: Giao dịch nhà)
	            System.out.print("Nhập [1] Giao dịch đất hoặc [2] Giao dịch nhà: ");
	            choice = sc.nextInt();
	            sc.nextLine(); // Đọc dòng mới sau khi nhập số
	
	            // Thêm giao dịch đất
	            if (choice == 1) {
	                System.out.print("Nhập loại đất (A/B/C): ");
	                String loaiDatInput = sc.nextLine();
	                GiaoDichDat.LoaiDat loaiDat = GiaoDichDat.LoaiDat.valueOf(loaiDatInput.toUpperCase());
	
	                GiaoDichDat gdd = new GiaoDichDat(maGiaoDich, ngayGiaoDich, donGia, dienTich, loaiDat);
	
	                // Thêm giao dịch đất vào danh sách
	                if (ds.themGiaoDich(gdd)) {
	                    System.out.println("Thêm giao dịch đất thành công!!");
	                } else {
	                    throw new Exception("Không thể thêm giao dịch đất!");
	                }
	            }
	            // Thêm giao dịch nhà
	            else if (choice == 2) {
	                System.out.print("Nhập loại nhà (CAO_CAP/THUONG): ");
	                String loaiNhaInput = sc.nextLine();
	                GiaoDichNha.LoaiNha loaiNha = GiaoDichNha.LoaiNha.valueOf(loaiNhaInput.toUpperCase());
	
	                System.out.print("Nhập địa chỉ: ");
	                String diaChi = sc.nextLine();
	
	                GiaoDichNha gdn = new GiaoDichNha(maGiaoDich, ngayGiaoDich, donGia, dienTich, loaiNha, diaChi);
	
	                // Thêm giao dịch nhà vào danh sách
	                if (ds.themGiaoDich(gdn)) {
	                    System.out.println("Thêm giao dịch nhà thành công!!");
	                } else {
	                    throw new Exception("Không thể thêm giao dịch nhà!");
	                }
	            } else {
	                throw new Exception("Lựa chọn không hợp lệ! Chỉ có thể chọn 1 hoặc 2.");
	            }
	        } else {
	            throw new Exception("Mã giao dịch trùng!!");
	        }
	    } catch (Exception e) {
	        System.out.println("Lỗi: " + e.getMessage());
	    }
	}
	
	// Hàm kiểm tra ngày có đúng định dạng (dd/MM/yyyy) hay không
	public static boolean isValidDate(String date) {
	    try {
	        LocalDate.parse(date, DATE_FORMATTER);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}

	public static void xoaGiaoDich(DanhSachGiaoDich ds) {
	    try {
	        String maGiaoDich;
	        System.out.println("Nhập mã giao dịch cần xóa: ");
	        maGiaoDich = sc.nextLine();
	        
	        // Tìm kiếm giao dịch theo mã
	        GiaoDich gd = ds.timKiemGiaoDich(maGiaoDich);
	        
	        // Kiểm tra nếu giao dịch không tồn tại
	        if (gd == null) {
	            throw new Exception("Giao dịch không tồn tại!");
	        }

	        // Hỏi người dùng có chắc chắn muốn xóa không
	        System.out.println("Bạn có chắc muốn xóa giao dịch không? [y/n]: ");
	        String confirmation = sc.nextLine();

	        if (confirmation.equalsIgnoreCase("y")) {
	            // Thực hiện xóa giao dịch
	            if (ds.xoaGiaoDich(gd)) {
	                System.out.println("Xóa giao dịch thành công!");
	            } else {
	                throw new Exception("Không thể xóa giao dịch!");
	            }
	        } else {
	            System.out.println("Bạn đã hủy bỏ việc xóa giao dịch.");
	        }
	    } catch (Exception e) {
	        // Hiển thị thông báo lỗi nếu có
	        System.out.println("Lỗi: " + e.getMessage());
	    }
	}

	public static void suaGiaoDich(DanhSachGiaoDich ds) {
	    try {
	        int choice = -1;
	        String maGiaoDich;
	        System.out.println("Nhập mã giao dịch cần sửa: ");
	        maGiaoDich = sc.nextLine();
	        
	        // Kiểm tra nếu giao dịch tồn tại
	        GiaoDich gd = ds.timKiemGiaoDich(maGiaoDich);
	        
	        if (gd != null) {
	            // Kiểm tra xem là giao dịch đất hay giao dịch nhà
	            if (gd instanceof GiaoDichDat) {
	                GiaoDichDat gdd = (GiaoDichDat) gd;
	                System.out.println("Thông tin giao dịch đất trước khi sửa:");
	             
	                System.out.println(gdd);
	                menuSuaGDDat();
	                System.out.println("Nhập lựa chọn: ");
	                choice = sc.nextInt();
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
	                            LocalDate ngayGiaoDich = LocalDate.parse(sc.nextLine(), DATE_FORMATTER);
	                            gdd.setNgayGiaoDich(ngayGiaoDich);
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
	                            // Nhập loại đất (kiểm tra hợp lệ)
	                            System.out.println("Nhập loại đất (A/B/C): ");
	                            String loaiDatInput = sc.nextLine();
	                            try {
	                                GiaoDichDat.LoaiDat loaiDat = GiaoDichDat.LoaiDat.valueOf(loaiDatInput.toUpperCase());
	                                gdd.setLoaiDat(loaiDat);
	                            } catch (IllegalArgumentException e) {
	                                System.out.println("Loại đất không hợp lệ. Vui lòng nhập A, B hoặc C.");
	                            }
	                            break;
	                        default:
	                            System.out.println("Lỗi lựa chọn không hợp lệ!");
	                    }
	                    menuSuaGDDat();
	                    System.out.println("Nhập lựa chọn: ");
	                    choice = sc.nextInt();
	                    sc.nextLine();
	                }
	            } else if (gd instanceof GiaoDichNha) {
	                GiaoDichNha gdn = (GiaoDichNha) gd;
	                System.out.println("Thông tin giao dịch nhà trước khi sửa:");
	             
	                System.out.println(gdn);
	                menuSuaGDNha();
	                System.out.println("Nhập lựa chọn: ");
	                choice = sc.nextInt();
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
	                            LocalDate ngayGiaoDich = LocalDate.parse(sc.nextLine(), DATE_FORMATTER);
	                            gdn.setNgayGiaoDich(ngayGiaoDich);
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
	                            // Nhập loại nhà (kiểm tra hợp lệ)
	                            System.out.println("Nhập loại nhà (CAO_CAP/THUONG): ");
	                            String loaiNhaInput = sc.nextLine();
	                            try {
	                                GiaoDichNha.LoaiNha loaiNha = GiaoDichNha.LoaiNha.valueOf(loaiNhaInput.toUpperCase());
	                                gdn.setLoaiNha(loaiNha);
	                            } catch (IllegalArgumentException e) {
	                                System.out.println("Loại nhà không hợp lệ. Vui lòng nhập CAO_CAP hoặc THUONG.");
	                            }
	                            break;
	                        case 6:
	                            System.out.println("Nhập địa chỉ: ");
	                            gdn.setDiaChi(sc.nextLine());
	                            break;
	                        default:
	                            System.out.println("Lỗi lựa chọn không hợp lệ!");
	                    }
	                    menuSuaGDNha();
	                    System.out.println("Nhập lựa chọn: ");
	                    choice = sc.nextInt();
	                    sc.nextLine();
	                }
	            }
	        } else {
	            throw new Exception("Giao dịch không tồn tại.");
	        }
	    } catch (Exception e) {
	        System.out.println("Lỗi: " + e.getMessage());
	    }
	}

	public static void nhapCung(DanhSachGiaoDich ds) {
	    try {
	        // Thêm giao dịch cứng vào danh sách
	        GiaoDichDat gdd = new GiaoDichDat("GD001", "23/02/2018", 500000, 100,LoaiDat.A );
	        GiaoDichNha gdn = new GiaoDichNha("GD002", "10/05/2015", 1000000, 500,LoaiNha.CAO_CAP , "Quận 3");
	        GiaoDichDat gdd1 = new GiaoDichDat("GD003", "20/06/2010", 5000000, 200, LoaiDat.B);
	        GiaoDichNha gdn1 = new GiaoDichNha("GD004", "10/05/2025", 10000000, 300, LoaiNha.THUONG, "Quận 10");
	        
	        // Thêm các giao dịch vào danh sách
	        ds.themGiaoDich(gdd);
	        ds.themGiaoDich(gdn);
	        ds.themGiaoDich(gdd1);
	        ds.themGiaoDich(gdn1);

	        // Thông báo thành công mà không cần sử dụng ngoại lệ
	        System.out.println("Nhập cứng các giao dịch thành công!");
	    } catch (Exception e) {
	        System.out.println("Lỗi khi thêm giao dịch: " + e.getMessage());
	    }
	}
	
	public static void xuatDSGDĐat(DanhSachGiaoDich ds) {
	
		for (GiaoDichDat gdd : ds.getDSGiaoDichDat()) {
			System.out.println(gdd);
		}
	}
	
	public static void xuatDSGDNha(DanhSachGiaoDich ds) {
		
		for (GiaoDichNha gdn : ds.getDSGiaoDichNha()) {
			System.out.println(gdn);
		}
	}
	
	public static void xuatDS(DanhSachGiaoDich ds) {
		
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
			if (ds.getDSTheoNgayGD(ngayBD, ngayKT) == null) {
				throw new Exception("Lỗi ngày bắt đầu lớn hơn ngày kết thúc!");
			}else {
			
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
	
}