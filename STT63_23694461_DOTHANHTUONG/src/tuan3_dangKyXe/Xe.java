package tuan3_dangKyXe;

public class Xe {
	private String tenChuXe;
	private String loaiXe;
	private int dungTich;
	private double triGia;
	static final double THUEBE = 0.01;
	static final double THUETB = 0.03;
	static final double THUELON = 0.05;
	public Xe(String tenChuXe, String loaiXe, int dungTich, double triGia) {
		super();
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}
	public String getTenChuXe() {
		return tenChuXe;
	}
	public void setTenChuXe(String tenChuXe) {
		this.tenChuXe = tenChuXe;
	}
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public int getDungTich() {
		return dungTich;
	}
	public void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}
	public double getTriGia() {
		return triGia;
	}
	public void setTriGia(double triGia) {
		this.triGia = triGia;
	}
	public double thuePhaiNop() {
		if(dungTich<100) {
			return THUEBE*triGia;
		}else if(dungTich<200) {
			return THUETB*triGia;
		}else {
			return THUELON*triGia;
		}
	}
	 @Override
	    public String toString() {
	        return String.format("%-20s %-20s %10d %20.2f %20.2f", 
	            tenChuXe, loaiXe, dungTich, triGia, thuePhaiNop());
	    }
	

}
