package tuan6_QuanLyHangHoa;

import java.util.Scanner;

public class main_HangHoa {
	public static void main(String[] args) {
		QuanLyHangHoa ds = new QuanLyHangHoa();
		int chon=0;
		Scanner sc = new Scanner(System.in);

		do{
			System.out.println("=========Menu==========");
			System.out.println("1. Them Hang Hoa:");
			System.out.println("2. Xuat Hang Hoa:");
			System.out.println("3. Xoa Hang Hoa:");
			System.out.println("4. Xuat cac Hang Hoa kho ban:");
			chon = sc.nextInt();
			switch (chon){
				case 1:{
					ds.themHangHoa();
					break;
				}
			}


		}while(chon!=4);
		
	}
	public static void nhapThongTin(Scanner sc){
		S
	}

}