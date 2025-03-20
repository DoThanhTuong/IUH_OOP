package tuan3_hangThucPham;

import java.util.ArrayList;

public class DanhSachHangTP {
    // Danh sách hàng thực phẩm
    private ArrayList<HangThucPham> danhSachHTP;

    // Constructor để khởi tạo danh sách
    public DanhSachHangTP() {
        this.danhSachHTP = new ArrayList<>();
    }

    // Phương thức thêm hàng thực phẩm
    public void themHTP(HangThucPham hTP) {
        danhSachHTP.add(hTP);
        System.out.println("Đã thêm hàng thành công với mã: " + hTP.getMaHang());
    }

    // Phương thức xóa hàng thực phẩm theo mã
    public boolean xoaHTP(String maHTP) {
        for (HangThucPham hTP : danhSachHTP) {
            if (hTP.getMaHang().equalsIgnoreCase(maHTP)) {
                danhSachHTP.remove(hTP);
                System.out.println("Đã xóa hàng có mã: " + maHTP);
                return true;
            }
        }
        System.out.println("Không tìm thấy hàng có mã: " + maHTP);
        return false;
    }

    // Phương thức hiển thị danh sách hàng thực phẩm
    public void hienThiDanhSachHTP() {
    	 if (danhSachHTP.isEmpty()) {
            System.out.println("Danh sách hàng thực phẩm hiện đang trống.");
        } else {
            System.out.println("Danh sách các hàng thực phẩm:");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n","Mã hàng","Tên hàng","Đơn giá","Ngày sản xuất","Ngày hết hạn","Hết hạn");
            System.out.println("============================================================================================================");
           
            for (HangThucPham hTP : danhSachHTP) {
                System.out.println(hTP);
            }
        }
    }

    // Phương thức tìm hàng thực phẩm theo mã
    public HangThucPham timHTPTheoMa(String maHTP) {
        for (HangThucPham hTP : danhSachHTP) {
            if (hTP.getMaHang().equalsIgnoreCase(maHTP)) {
                return hTP;
            }
        }
        System.out.println("Không tìm thấy hàng có mã: " + maHTP);
        return null;
    }
}
