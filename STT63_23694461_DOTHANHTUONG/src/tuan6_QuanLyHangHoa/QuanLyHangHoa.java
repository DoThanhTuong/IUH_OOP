package tuan6_QuanLyHangHoa;

import java.time.LocalDate;
import java.util.Arrays;

public class QuanLyHangHoa {
    private HangHoa[] danhSachHang; // Mảng lưu trữ danh sách hàng hóa
    private int count; // Số lượng hàng hóa hiện có trong danh sách

    // Constructor khởi tạo danh sách với n phần tử
    public QuanLyHangHoa(int n) {
        this.danhSachHang = new HangHoa[n];
        this.count = 0;
    }

    // Phương thức thêm hàng hóa vào danh sách
    public boolean themHang(HangHoa hang) {
        if (count < danhSachHang.length) {
            for (int i = 0; i < count; i++) {
                if (danhSachHang[i].getMaHang().equals(hang.getMaHang())) {
                    return false; // Trùng mã hàng
                }
            }
            danhSachHang[count++] = hang; // Thêm hàng hóa và tăng số lượng
            return true; // Thêm thành công
        }
        return false; // Danh sách đầy
    }

    // Phương thức lấy thông tin toàn bộ danh sách hàng hóa
    public void hienThiDanhSach() {
        for (int i = 0; i < count; i++) {
            System.out.println(danhSachHang[i]);
        }
    }

    // Phương thức lấy thông tin từng loại hàng hóa
    public void hienThiHangThucPham() {
        for (int i = 0; i < count; i++) {
            if (danhSachHang[i] instanceof HangThucPham) {
                System.out.println(danhSachHang[i]);
            }
        }
    }

    public void hienThiHangDienMay() {
        for (int i = 0; i < count; i++) {
            if (danhSachHang[i] instanceof HangDienMay) {
                System.out.println(danhSachHang[i]);
            }
        }
    }

    public void hienThiHangSanhSu() {
        for (int i = 0; i < count; i++) {
            if (danhSachHang[i] instanceof HangSanhSu) {
                System.out.println(danhSachHang[i]);
            }
        }
    }

    // Phương thức tìm kiếm hàng hóa theo mã hàng
    public HangHoa timHang(String maHang) {
        for (int i = 0; i < count; i++) {
            if (danhSachHang[i].getMaHang().equals(maHang)) {
                return danhSachHang[i]; // Trả về hàng hóa tìm thấy
            }
        }
        return null; // Không tìm thấy
    }

    // Phương thức sắp xếp hàng hóa theo tên hàng tăng dần
    public void sapXepTheoTen() {
        Arrays.sort(danhSachHang, 0, count, (h1, h2) -> h1.getTenHang().compareTo(h2.getTenHang()));
    }

    // Phương thức sắp xếp hàng hóa theo số lượng tồn giảm dần
    public void sapXepTheoSoLuongTon() {
        Arrays.sort(danhSachHang, 0, count, (h1, h2) -> h2.getSoLuongTon() - h1.getSoLuongTon());
    }

    // Phương thức lấy thông tin các hàng thực phẩm khó bán
    public void hienThiHangThucPhamKhoBan() {
        for (int i = 0; i < count; i++) {
            if (danhSachHang[i] instanceof HangThucPham) {
                HangThucPham thucPham = (HangThucPham) danhSachHang[i];
                if (thucPham.getSoLuongTon() > 0 && thucPham.getNgayHetHan().isBefore(LocalDate.now())) {
                    System.out.println(thucPham);
                }
            }
        }
    }

    // Phương thức xóa hàng hóa theo mã hàng
    public boolean xoaHang(String maHang) {
        for (int i = 0; i < count; i++) {
            if (danhSachHang[i].getMaHang().equals(maHang)) {
                // Di chuyển các phần tử phía sau lên một vị trí
                for (int j = i; j < count - 1; j++) {
                    danhSachHang[j] = danhSachHang[j + 1];
                }
                danhSachHang[--count] = null; // Giảm số lượng và xóa tham chiếu cuối
                return true; // Xóa thành công
            }
        }
        return false; // Không tìm thấy mã hàng
    }

    // Phương thức sửa thông tin đơn giá hàng hóa theo mã hàng
    public boolean suaDonGia(String maHang, double donGia) {
        HangHoa hang = timHang(maHang);
        if (hang != null) {
            try {
                hang.setDonGia(donGia);
                return true; // Sửa thành công
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false; // Không tìm thấy mã hàng
    }

}