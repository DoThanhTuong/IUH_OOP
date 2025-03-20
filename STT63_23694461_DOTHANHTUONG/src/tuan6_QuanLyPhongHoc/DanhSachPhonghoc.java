package tuan6_QuanLyPhongHoc;


import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachPhonghoc {
	List<Phonghoc> ls;

	public DanhSachPhonghoc(int n) {
		ls = new ArrayList<Phonghoc>(n);
	}

	public void addPhonghoc(Phonghoc p) throws Exception {
		if (ls.contains(p)) {
			throw new Exception("Trung ma phong");
		} else {
			ls.add(p);
		}
	}

	public Phonghoc findPhonghoc(String maPhong) {
		for (Phonghoc phonghoc : ls) {
			if (phonghoc.getMaPhong().equals(maPhong)) {
				return phonghoc;
			}
		}

		return null;
	}

	public List<Phonghoc> getPhongDatChuan() {
		List<Phonghoc> listDatChuan = new ArrayList<Phonghoc>(ls.size());

		for (Phonghoc phonghoc : listDatChuan) {
			if (phonghoc.checkDatChuan()) {
				listDatChuan.add(phonghoc);
			}
		}

		return listDatChuan;
	}

	public void sortByDayNha() {
		Collections.sort(ls, new Comparator<Phonghoc>() {
			@Override
			public int compare(Phonghoc o1, Phonghoc o2) {
				return o1.dayNha.compareTo(o2.dayNha);
			}
		});
	}

	public void sortByDienTich() {
		Collections.sort(ls, new Comparator<Phonghoc>() {
			@Override
			public int compare(Phonghoc o1, Phonghoc o2) {
				if (o1.dienTich < o2.dienTich) {
					return 1;
				} else if (o1.dienTich == o2.dienTich) {
					return 0;
				} else {
					return -1;
				}
			}
		});
	}

	public void sortBySoBongDen() {
		Collections.sort(ls, new Comparator<Phonghoc>() {
			@Override
			public int compare(Phonghoc o1, Phonghoc o2) {
				if (o1.soBongDen < o2.soBongDen) {
					return -1;
				} else if (o1.soBongDen == o2.soBongDen) {
					return 0;
				} else {
					return 1;
				}
			}
		});
	}

	public void updatePhongMayTinh(String maPhong, int soMayTinh) throws Exception {
		PhongMayTinh ph = (PhongMayTinh) findPhonghoc(maPhong);

		if (ph != null) {
			ph.setSoMayTinh(soMayTinh);
		} else {
			throw new Exception("Khong tim thay phong hoc ");
		}
	}

	public void xoaPhonghoc(String maPhonghoc) throws Exception {
		Phonghoc ph = findPhonghoc(maPhonghoc);

		if (ph != null) {
			ls.remove(ph);
		} else {
			throw new Exception("Khong tim thay phong hoc");
		}
	}

	public int getSoPhonghoc() {
		return ls.size();
	}

	public List<PhongMayTinh> getPhongMT() {
		List<PhongMayTinh> listPMT = new ArrayList<PhongMayTinh>(ls.size());

		for (PhongMayTinh phongMayTinh : listPMT) {
			if (phongMayTinh.getSoMayTinh() == 60) {
				listPMT.add(phongMayTinh);
			}
		}

		return listPMT;
	}

	@Override
	public String toString() {
		String s = "";
		s += String.format("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n", "Ma phong", "Day nha",
				"Dien tich", "So bong", "May chieu", "So may tinh", "Chuyen nganh", "Suc chua", "Bon rua");
		for (Phonghoc phonghoc : ls) {
			s += phonghoc.toString();
			s += "\n";
		}
		return s;
	}
}
