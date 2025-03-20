package tuan6_QuanLyHangHoa;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

class QuanLyHangHoa {
    private List<HangHoa> danhSachHangHoa;

    public QuanLyHangHoa() {
        danhSachHangHoa = new ArrayList<>();
    }

    public void themHangHoa(HangHoa hangHoa) {
        for (HangHoa hh : danhSachHangHoa) {
            if (hh.maHang.equals(hangHoa.maHang)) {
                System.out.println("Mã hàng đã tồn tại");
                return;
            }
        }
        danhSachHangHoa.add(hangHoa);
    }

    public void xoaHangHoa(String maHang) {
        danhSachHangHoa.removeIf(hh -> hh.maHang.equals(maHang));
    }

    public void suaDonGia(String maHang, double donGiaMoi) {
        for (HangHoa hh : danhSachHangHoa) {
            if (hh.maHang.equals(maHang)) {
                hh.donGia = donGiaMoi;
                return;
            }
        }
    }

    public void hienThiDanhSach() {
        for (HangHoa hh : danhSachHangHoa) {
            System.out.println(hh);
        }
    }

    public void hienThiHangThucPhamKhoBan() {
        for (HangHoa hh : danhSachHangHoa) {
            if (hh instanceof HangThucPham && hh.danhGiaBanBuon().equals("Khó bán")) {
                System.out.println(hh);
            }
        }
    }
}