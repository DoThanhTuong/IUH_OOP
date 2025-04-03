package tuan7_QuanLySach;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SachThamKhao extends Sach {
    private double thue;

    // Constructor: Khởi tạo thông tin sách tham khảo với thuế
    public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    // Phương thức tính thành tiền (bao gồm thuế)
    @Override
    public double getThanhTien() {
        // Thành tiền là số lượng * đơn giá + thuế
        return getSoLuong() * getDonGia() + thue;
    }

    // Getter và setter cho thuế
    public double getThue() {
        return thue;
    }

    public final void setThue(double thue) {
        this.thue = thue;
    }

    // Cấu hình định dạng ngày tháng và tiền tệ
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Locale local = new Locale("vi", "VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(local);

    // Phương thức trả về thông tin sách tham khảo dưới dạng chuỗi
    @Override
    public String toString() {
        // Trả về thông tin sách cùng với thuế, giá trị thuế được hiển thị theo định dạng tiền tệ
        return super.toString() + String.format("|%-10s|%-10s",
                nf.format(thue), // Hiển thị thuế theo định dạng tiền tệ
                nf.format(getThanhTien()) // Hiển thị thành tiền (bao gồm thuế)
        );
    }
}
