package tuan3_hangThucPham;

import java.util.ArrayList;

import tuan3_dangKyXe.Xe;

public class DanhSachHangTP {
    // Danh sách hàng thực phẩm
    private ArrayList<HangThucPham> danhSachHTP;

    // Constructor để khởi tạo danh sách
    public DanhSachHangTP() {
        this.danhSachHTP = new ArrayList<>();
    }

    // Phương thức thêm hàng thực phẩm
    public boolean themHTP(HangThucPham hTP) {
    	for (HangThucPham x : danhSachHTP) {
            if (x.getMaHang().equalsIgnoreCase(hTP.getMaHang())) {
                return false; // Xe đã tồn tại
            }
        }
    	danhSachHTP.add(hTP);
        return true;
    }

    // Phương thức xóa hàng thực phẩm theo mã
    public boolean xoaHTP(String maHTP) {
        for (HangThucPham hTP : danhSachHTP) {
            if (hTP.getMaHang().equalsIgnoreCase(maHTP)) {
                return danhSachHTP.remove(hTP);
            }
        }
        return false;
    }
    // Phương thức kiểm tra danh sách có rỗng hay không
    public boolean hienThiDanhSachHTP() {
        return !danhSachHTP.isEmpty();
    }
    // Phương thức hiển thị danh sách hàng thực phẩm
    public ArrayList<HangThucPham> getDanhSachHTP() {
        return this.danhSachHTP;
    }

    // Phương thức tìm hàng thực phẩm theo mã
    public HangThucPham timHTPTheoMa(String maHTP) {
        for (HangThucPham hTP : danhSachHTP) {
            if (hTP.getMaHang().equalsIgnoreCase(maHTP)) {
                return hTP;
            }
        }
        return null;
    }
}
