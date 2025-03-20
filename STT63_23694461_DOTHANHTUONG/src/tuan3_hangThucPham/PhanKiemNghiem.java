package tuan3_hangThucPham;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import tuan3_dangKyXe.DanhSachXe;
import tuan3_dangKyXe.Xe;

public class PhanKiemNghiem {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DanhSachHangTP danhSach = new DanhSachHangTP();
        int chon;
        do {
			System.out.println("***MENU***");
			System.out.println("1/ Nhập Mền");
			System.out.println("2/ Nhập Cứng");
			System.out.println("3/ Chỉnh Sữa Danh Sách");
			System.out.println("4/ Xuất");
			System.out.println("5/ Thoát");
			chon = nhapChon();
			switch(chon) {
				case 1:{
					System.out.println("1/ Nhập Mền");
					HangThucPham htp = nhapThongTinHangTP();
					danhSach.themHTP(htp);
					break;
				}
				case 2:{
					System.out.println("2/ Nhập Cứng");
					try {
						// Thêm một số hàng thực phẩm vào danh sách
			            HangThucPham htp1 = new HangThucPham("H001", "Sữa Vinamilk", 15000, dateFormat.parse("01/01/2023"), dateFormat.parse("01/01/2024"));
			            HangThucPham htp2 = new HangThucPham("H002", "Mì gói Hảo Hảo", 3000, dateFormat.parse("15/12/2023"), dateFormat.parse("15/12/2026"));
			            HangThucPham htp3 = new HangThucPham("H003", "Trứng gà", 4000, dateFormat.parse("10/01/2023"), dateFormat.parse("20/01/2023"));

			            danhSach.themHTP(htp1);
			            danhSach.themHTP(htp2);
			            danhSach.themHTP(htp3);
					}catch (ParseException e) {
			            System.out.println("Lỗi định dạng ngày!");
			        }
					break;
				}
				case 3:{
					System.out.println("3/ Chỉnh Sữa Danh Sách");
					chinhsua(danhSach);
					break;
				}
				case 4:{
					System.out.println("4/ Xuất");
					// Hiển thị danh sách hàng thực phẩm
		            danhSach.hienThiDanhSachHTP();
					break;
				}
			}
		}while(chon!=5);
    }
    private static HangThucPham nhapThongTinHangTP() {
    	 Scanner scanner = new Scanner(System.in);
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

         String maHang;
         String tenHang;
         double donGia;
         String ngaySanXuatStr;
         String ngayHetHanStr;
         Date ngaySanXuat = null;
         Date ngayHetHan = null;

         // Nhập mã hàng
         System.out.print("Nhập mã hàng: ");
         maHang = scanner.nextLine();
         while (maHang.isEmpty()) {
             System.out.print("Mã hàng không được để trống. Nhập lại mã hàng: ");
             maHang = scanner.nextLine();
         }

         // Nhập tên hàng
         System.out.print("Nhập tên hàng: ");
         tenHang = scanner.nextLine();
         while (tenHang.isEmpty()) {
             System.out.print("Tên hàng không được để trống. Nhập lại tên hàng: ");
             tenHang = scanner.nextLine();
         }

         // Nhập đơn giá
         System.out.print("Nhập đơn giá: ");
         while (true) {
             try {
                 donGia = Double.parseDouble(scanner.nextLine());
                 if (donGia > 0) break;
                 else System.out.print("Đơn giá phải lớn hơn 0. Nhập lại đơn giá: ");
             } catch (NumberFormatException e) {
                 System.out.print("Đơn giá không hợp lệ. Nhập lại đơn giá: ");
             }
         }

         // Nhập ngày sản xuất
         System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
         while (true) {
             try {
                 ngaySanXuatStr = scanner.nextLine();
                 ngaySanXuat = dateFormat.parse(ngaySanXuatStr);
                 break;
             } catch (ParseException e) {
                 System.out.print("Ngày sản xuất không hợp lệ. Nhập lại (dd/MM/yyyy): ");
             }
         }

         // Nhập ngày hết hạn
         System.out.print("Nhập ngày hết hạn (dd/MM/yyyy): ");
         while (true) {
             try {
                 ngayHetHanStr = scanner.nextLine();
                 ngayHetHan = dateFormat.parse(ngayHetHanStr);
                 if (ngayHetHan.after(ngaySanXuat)) break;
                 else {
                     System.out.print("Ngày hết hạn phải sau ngày sản xuất. Nhập lại ngày hết hạn: ");
                 }
             } catch (ParseException e) {
                 System.out.print("Ngày hết hạn không hợp lệ. Nhập lại (dd/MM/yyyy): ");
             }
         }

         // Tạo đối tượng HangThucPham và trả về
         HangThucPham hangThucPham = new HangThucPham(maHang, tenHang, donGia, ngaySanXuat, ngayHetHan);
         return hangThucPham;
	}
	private static void chinhsua(DanhSachHangTP danhSach) {
		int chon;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1/ Nhập Tên Mã Để Tìm Hàng: ");
			System.out.println("2/ Nhập Tên Mã Để Xóa Hàng: ");
			System.out.println("3/ Thoát");
			chon=nhapChon();
			switch (chon) {
				case 1: {
					System.out.print("Nhập Mã Hàng: ");
				    String maHang = scanner.nextLine();
				 // Tìm kiếm một hàng thực phẩm
		            System.out.println("\nTìm kiếm hàng với mã:");
		            HangThucPham hTP = danhSach.timHTPTheoMa(maHang);
		            if (hTP != null) {
		            	System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n","Mã hàng","Tên hàng","Đơn giá","Ngày sản xuất","Ngày hết hạn","Hết hạn");
		                System.out.println("============================================================================================================");
		                System.out.println(hTP);
		            }
					break;
				}
				case 2:{
					System.out.print("Nhập Mã Hàng: ");
				    String maHang = scanner.nextLine();
				    danhSach.xoaHTP(maHang);
					break;
				}
			}
			
		}while(chon!=3);
	}
    
    private static int nhapChon() {
		int chon;
		Scanner sn = new Scanner(System.in);
		do {
			chon = sn.nextInt();
		}while(chon<0 || chon>5);
		return chon;
	}
}
