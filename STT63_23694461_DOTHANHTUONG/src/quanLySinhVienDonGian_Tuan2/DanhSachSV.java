package quanLySinhVienDonGian_Tuan2;

import java.util.Scanner;

public class DanhSachSV {

    public static void main(String[] args) {
    	int choce;
 
        SinhVien sv1 = new SinhVien(0, null, 0f, 0f);
        SinhVien sv2 = new SinhVien(0, null, 0f, 0f);
        SinhVien sv3 = new SinhVien(0, null, 0f, 0f);

        
        
        
        do {
        	System.out.println("****SINH VIÊN****");
    		System.out.println("* 1/ Nhập Mền   *");
    		System.out.println("* 2/ Nhập Cứng  *");
    		System.out.println("* 3/ Thoát	    *");
    		System.out.println("*****************");
    		System.out.println("Nhập Lựa Chọn: ");
        	choce = nhapChoce();
        	switch(choce) {
	        	case 1:{
	        		String hoVaTen1 = "Do Thanh Tuong"; 
	                sv1 = new SinhVien(23694461, hoVaTen1, 8.5f, 10);
	                String hoVaTen2 = "Nguyen Huu Khang"; 
	                sv2 = new SinhVien(24694462, hoVaTen2, 10f, 9.0f);
	                String hoVaTen3 = "Dang Thi Hong Anh"; 
	                sv3 = new SinhVien(24694462, hoVaTen3, 10f, 10f);
	                xuatThongTin(sv1, sv2, sv3);
	                break;
	        	}
	        	case 2:{
	        		String hoVaTen1 = "Do Thanh Tuong"; 
	                sv1 = new SinhVien(23694461, hoVaTen1, 8.5f, 10);
	                String hoVaTen2 = "Nguyen Huu Khang"; 
	                sv2 = new SinhVien(24694462, hoVaTen2, 10f, 9.0f);
	        		sv3 = nhapThongTin();
	                xuatThongTin(sv1, sv2, sv3);
	                break;
	        	}
	        	
        	}
        }while(choce!=3);

    }
   public static SinhVien nhapThongTin() {
	   Scanner sn = new Scanner(System.in);
	   System.out.println("***THÔNG TIN SINH VIÊN***\n");
	   System.out.println("Nhập MSSV: ");
	   int mssv =sn.nextInt();
	   sn.nextLine();// Đọc bỏ dòng mới còn sót lại
	   
	   System.out.println("Nhập Họ và Tên: ");
	   String hoVaTen = sn.nextLine();
	   
	   
	   System.out.println("Nhập Điểm Lý Thuyết: ");
	   float diemLT;
	    do {
	    	diemLT =sn.nextFloat();   
	   }while(diemLT <0 || diemLT >10);
	   sn.nextLine();
	   
	   System.out.println("Nhập Điểm Thực Hành: ");
	   float diemTH;
	    do {
	    	diemTH =sn.nextFloat();   
	   }while(diemTH <0 || diemTH >10);
	   sn.nextLine();
	   
	   return new SinhVien(mssv,hoVaTen,diemLT,diemTH);
   }
   public static void xuatThongTin(SinhVien sv1, SinhVien sv2, SinhVien sv3) {
	   System.out.println("Danh sach sinh vien:");
       System.out.println("MSSV          Ho va ten        DiemLT     DiemTH     DiemTB");
       System.out.println(sv1);
       System.out.println(sv2);
       System.out.println(sv3);
   }
   public static int nhapChoce() {
	   int choce;
	   Scanner sn = new Scanner(System.in);
	   do {
		   choce = sn.nextInt();
		   
	   }while(choce>4 && choce <0);
	   
	   return choce;
	   
   }
}

