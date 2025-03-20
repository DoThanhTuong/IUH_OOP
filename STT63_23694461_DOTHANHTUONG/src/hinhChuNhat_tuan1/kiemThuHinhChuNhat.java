package hinhChuNhat_tuan1;

import java.util.Scanner;

public class kiemThuHinhChuNhat {
	public static void main(String[] args) {
		int r;
		HinhChuNhat cn1 = new HinhChuNhat(0, 0);
		HinhChuNhat cn2 = new HinhChuNhat(0,0);
		System.out.println("**** HÌNH CHỮ NHẬT****");
		System.out.println("* 1/ Nhập Mền        *");
		System.out.println("* 2/ Nhập Cứng       *");
		System.out.println("**********************");
		System.out.println("1/ Nhập Mền");
		cn1.setChieuDai(3);
		cn1.setChieuRong(6);
		System.out.println("HÌNH CHỮ NHẬT 1: "+ cn1+"\n");
		System.out.println("2/ Nhập Cứng");
		cn2.setChieuDai(8);
		r=nhapInt("Nhập Chiều Rộng:");
		cn2.setChieuRong(r);
		System.out.println("HÌNH CHỮ NHẬT 2: "+ cn2);
		
	}
	static int nhapInt(String str) {
		int r;
		Scanner sn = new Scanner(System.in);
		System.out.println(str);
		r = sn.nextInt();
		return r;
	}
}

