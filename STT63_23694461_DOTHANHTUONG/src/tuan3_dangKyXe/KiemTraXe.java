package tuan3_dangKyXe;
import java.util.Scanner;
public class KiemTraXe {
	public static void main(String[] args) {
		int chon;
		DanhSachXe dsx = new DanhSachXe();
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
					dsx.themXe(nhapThongTinXe());
					break;
				}
				case 2:{
					System.out.println("2/ Nhập Cứng");
					Xe xe1 = new Xe("Nguyễn Thu Loan", "Future Neo", 100, 35000000);
			        Xe xe2 = new Xe("Lê Minh Tịnh", "Ford Ranger", 3000, 250000000);
			        Xe xe3 = new Xe("Nguyễn Minh Triết", "Landscape", 1500, 1000000000);
			        dsx.themXe(xe1);
			        dsx.themXe(xe2);
			        dsx.themXe(xe3);
					break;
				}
				case 3:{
					System.out.println("3/ Chỉnh Sữa Danh Sách");
					chinhsua(dsx);
					break;
				}
				case 4:{
					System.out.println("4/ Xuất");
					dsx.hienThiDanhSachXe();
					break;
				}
			}
		}while(chon!=5);
	}

	private static int nhapChon() {
		int chon;
		Scanner sn = new Scanner(System.in);
		do {
			chon = sn.nextInt();
		}while(chon<0 || chon>5);
		return chon;
	}
	private static Xe nhapThongTinXe() {
		Scanner scanner = new Scanner(System.in);

	    // Nhập thông tin từ người dùng
	    System.out.print("Nhập tên chủ xe: ");
	    String tenChuXe = scanner.nextLine();

	    System.out.print("Nhập loại xe: ");
	    String loaiXe = scanner.nextLine();

	    System.out.print("Nhập dung tích (cc): ");
	    int dungTich = scanner.nextInt();

	    System.out.print("Nhập trị giá (VND): ");
	    double triGia = scanner.nextDouble();

	    // Tạo đối tượng Xe
	    Xe xe = new Xe(tenChuXe, loaiXe, dungTich, triGia);

	    // Trả về đối tượng Xe
	    return xe;
		
	}
	private static void chinhsua(DanhSachXe dsx) {
		int chon;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1/ Nhập Tên Chủ Để Tìm Xe: ");
			System.out.println("2/ Nhập Tên Chủ Để Xóa Xe: ");
			System.out.println("3/ Thoát");
			chon=nhapChon();
			switch (chon) {
				case 1: {
					System.out.print("Nhập tên chủ xe: ");
				    String tenChuXe = scanner.nextLine();
				    Xe xe = dsx.timXeTheoTenChuXe(tenChuXe);
				    System.out.printf("%-20s %-20s %10s %20s %20s\n", "Tên Chủ Xe", "Loại Xe", "Dung tích", "Trị giá", "Thuế phải nộp");
		            System.out.println("==============================================================================================");
				    System.out.print(xe);
					break;
				}
				case 2:{
					System.out.print("Nhập tên chủ xe: ");
				    String tenChuXe = scanner.nextLine();
				    dsx.xoaXe(tenChuXe);
					break;
				}
			}
			
		}while(chon!=3);
	}

}
