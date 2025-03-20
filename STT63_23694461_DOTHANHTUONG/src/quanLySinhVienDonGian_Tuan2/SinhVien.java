package quanLySinhVienDonGian_Tuan2;

public class SinhVien {
	private int mssv;
	private String hoVaTen;
	private float diemLT,diemTH;
	
	

//	public SinhVien() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public SinhVien(int mssv, String hoVaTen, float diemLT, float diemTH) {
		super();
		this.mssv = mssv;
		this.hoVaTen = hoVaTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public int getMssv() {
		return mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public float getDiemLT() {
		if(diemLT <0 && diemLT >10) {
			return diemLT;
		}
			return 0;
	}

	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}

	public float getDiemTH() {
		if(diemTH <0 && diemTH >10) {
			return diemTH;
		}
			return 0;
	}

	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}
	
	public float diemTB() {
		return (this.diemLT + this.diemTH)/2;
	}

//	@Override
//	public String toString() {
//		return toString().format("%-10d %-10d %-10d %-10d %-10d",mssv,hoVaTen,diemLT,diemTH,diemTB() );
//	}
//	
	
	@Override
    public String toString() {
        return String.format("%-10d %-20s %-10.1f %-10.1f %-10.1f",mssv,String.join(" ", hoVaTen),diemLT,diemTH,diemTB() );
//                       		mssv, 
//                             String.join(" ", hoVaTen), 
//                             diemLT, 
//                             diemTH, 
//                             diemTB());
   }
	
	
	
}
