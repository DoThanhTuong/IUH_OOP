package tuan1_hinhChuNhat;

public class HinhChuNhat {
	private int chieuDai, chieuRong;
	
 // constructor
	public HinhChuNhat(int chieuCao, int chieuRong) {
		this.chieuDai = chieuCao;
		this.chieuRong = chieuRong;
	}
//gettes and setters
	public int getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(int chieuCao) {
		this.chieuDai = chieuCao;
	}

	public int getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(int chieuRong) {
		this.chieuRong = chieuRong;
	}
	
	public int chuVi() {
		return (this.chieuDai + this.chieuRong)* 2;
	}
	public int dienTich() {
		return this.chieuDai * this.chieuRong;
	}
	@Override
	public String toString() {
		
		return super.toString().format("%-10d %-10d %-10d %-10d",chieuDai,chieuRong,chuVi(),dienTich());
	}
	
}
