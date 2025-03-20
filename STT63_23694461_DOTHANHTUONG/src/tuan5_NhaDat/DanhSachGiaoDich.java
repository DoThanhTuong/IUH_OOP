package tuan5_NhaDat;
import java.util.ArrayList;
public class DanhSachGiaoDich {
	//attributes
	ArrayList<GiaoDich> ds;
	//Constructors
	public DanhSachGiaoDich() {
		ds = new ArrayList<GiaoDich>();
	}
	//methods
	public boolean themGiaoDich(GiaoDich gd) {
		if (!ds.contains(gd)) {
			ds.add(gd);
			return true;
		}else {
			return false;
		}
	}
	public boolean xoaGiaoDich(GiaoDich gd) {
		return ds.remove(gd); 
	}
	public int timKiemViTriGiaoDich(String maGiaoDich) {
		GiaoDich x = timKiemGiaoDich(maGiaoDich);
		if (x != null) {
			return ds.indexOf(x);
		}
		return -1;
	}
	public GiaoDich timKiemGiaoDich(String maGiaoDich){
		for (GiaoDich x : ds) {
			if (x.getMaGiaoDich().equalsIgnoreCase(maGiaoDich)) return x;
		}
		return null;
	}
	public ArrayList<GiaoDichDat> getDSGDD(){
		ArrayList<GiaoDichDat> dsgdd = new ArrayList<GiaoDichDat>();
		for (GiaoDich gd : ds) {
			if (gd instanceof GiaoDichDat) {
				dsgdd.add((GiaoDichDat)gd);
			}
		}
		return dsgdd;
	}
	public ArrayList<GiaoDichNha> getDSGDN(){
		ArrayList<GiaoDichNha> dsgdn = new ArrayList<GiaoDichNha>();
		for (GiaoDich gd : ds) {
			if (gd instanceof GiaoDichNha) {
				dsgdn.add((GiaoDichNha)gd);
			}
		}
		return dsgdn;
	}
	public ArrayList<GiaoDich> getDSTheoNgayGD(String ngayBD, String ngayKT) {
		if (compareDate(ngayBD, ngayKT) == 1) {
			return null;  // Trả về null nếu ngày bắt đầu lớn hơn ngày kết thúc
		} else {
			ArrayList<GiaoDich> ds_new = new ArrayList<GiaoDich>();
			for (GiaoDich gd : ds) {  // Duyệt qua tất cả các giao dịch trong danh sách
				// Kiểm tra xem ngày giao dịch có nằm trong khoảng ngày bắt đầu và ngày kết thúc không
				if (compareDate(ngayBD, gd.getNgayGiaoDich()) == -1 && compareDate(gd.getNgayGiaoDich(), ngayKT) == -1) {
					ds_new.add(gd);
				} else if (compareDate(ngayBD, gd.getNgayGiaoDich()) == 0) {
					ds_new.add(gd);
				} else if (compareDate(gd.getNgayGiaoDich(), ngayKT) == 0) {
					ds_new.add(gd);
				}
			}
			return ds_new;  // Trả về danh sách giao dịch theo khoảng thời gian
		}
	}

	public ArrayList<GiaoDich> getDS() {
		return ds;
	}
	public static int compareDate(String ngayBD, String ngayKT) {
		if (ngayBD.substring(6, 10).compareTo(ngayKT.substring(6, 10)) > 0) {
			return 1;  // Năm của ngày bắt đầu lớn hơn năm của ngày kết thúc
		} else if (ngayBD.substring(6, 10).compareTo(ngayKT.substring(6, 10)) < 0) {
			return -1;  // Năm của ngày bắt đầu nhỏ hơn năm của ngày kết thúc
		} else {
			if (ngayBD.substring(3, 5).compareTo(ngayKT.substring(3, 5)) > 0) {
				return 1;  // Tháng của ngày bắt đầu lớn hơn tháng của ngày kết thúc
			} else if (ngayBD.substring(3, 5).compareTo(ngayKT.substring(3, 5)) < 0) {
				return -1;  // Tháng của ngày bắt đầu nhỏ hơn tháng của ngày kết thúc
			} else {
				if (ngayBD.substring(0, 2).compareTo(ngayKT.substring(0, 2)) > 0) {
					return 1;  // Ngày của ngày bắt đầu lớn hơn ngày của ngày kết thúc
				} else if (ngayBD.substring(0, 2).compareTo(ngayKT.substring(0, 2)) < 0) {
					return -1;  // Ngày của ngày bắt đầu nhỏ hơn ngày của ngày kết thúc
				} else {
					return 0;  // Ngày bắt đầu bằng ngày kết thúc
				}
			}
		}
	}

}
