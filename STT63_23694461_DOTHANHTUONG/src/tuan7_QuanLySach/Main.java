package tuan7_QuanLySach;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        DanhSachSach dsSach = new DanhSachSach();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale local = new Locale("vi", "VN");
        NumberFormat nf = NumberFormat.getCurrencyInstance(local);

        do {
            try {
                System.out.println("Menu:");
                System.out.println("1. Them mot cuon sach moi");
                System.out.println("2. Tinh tong thanh tien cac loai sach");
                System.out.println("3. Tim cac sach cua nha xuat ban X");
                System.out.println("4. Tim thanh tien cao nhat");
                System.out.println("5. In ra cac cuon sach hien tai");
                System.out.println("6. Nhap Cung du lieu (cứng)");
                System.out.println("7. Thoat");
                System.out.print("Nhap vao lua chon: ");
                luachon = sc.nextInt();
                sc.nextLine(); // Đọc bỏ newline

                switch (luachon) {
                    case 1:
                        System.out.print("Nhap ma sach: ");
                        String maSach = sc.nextLine();
                        System.out.print("Nhap ngay nhap (dd/MM/yyyy): ");
                        String ngayNhapStr = sc.nextLine();
                        LocalDate ngayNhap = LocalDate.parse(ngayNhapStr, dtf);
                        System.out.print("Nhap don gia: ");
                        double donGia = sc.nextDouble();
                        System.out.print("Nhap so luong: ");
                        int soLuong = sc.nextInt();
                        sc.nextLine();  // Đọc bỏ newline
                        System.out.print("Nhap nha xuat ban: ");
                        String nhaXuatBan = sc.nextLine();
                        System.out.print("Chon loai sach (1: Sach Giao Khoa, 2: Sach Tham Khao): ");
                        int loaiSach = sc.nextInt();
                        sc.nextLine();  // Đọc bỏ newline

                        if (loaiSach == 1) {
                            System.out.print("Nhap tinh trang sach (true, false): ");
                            boolean tinhTrang = sc.nextBoolean();
                            SachGiaoKhoa sachGiaoKhoa = new SachGiaoKhoa(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, tinhTrang);
                            dsSach.them(sachGiaoKhoa);
                            System.out.println("Them sach giao khoa thanh cong!");
                        } else if (loaiSach == 2) {
                            System.out.print("Nhap thue: ");
                            double thue = sc.nextDouble();
                            SachThamKhao sachThamKhao = new SachThamKhao(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, thue);
                            dsSach.them(sachThamKhao);
                            System.out.println("Them sach tham khao thanh cong!");
                        } else {
                            System.out.println("Loai sach khong hop le.");
                        }
                        break;

                    case 2:
                        System.out.println("Tong thanh tien cac sach giao khoa: " + nf.format(dsSach.tinhTongThanhTienSGK()));
                        System.out.println("Tong thanh tien cac sach tham khao: " + nf.format(dsSach.tinhTongThanhTienSTK()));
                        break;

                    case 3:
                        System.out.print("Nhap nha xuat ban can tim: ");
                        String nhaXuatBanTim = sc.nextLine();
                        List<Sach> sachGiaoKhoaTheoNXB = dsSach.timSachGiaoKhoaTheoNXB(nhaXuatBanTim);
                        if (sachGiaoKhoaTheoNXB.isEmpty()) {
                            System.out.println("Khong tim thay sach giao khoa cua nha xuat ban: " + nhaXuatBanTim);
                        } else {
                            System.out.println("Danh sach sach giao khoa cua nha xuat ban " + nhaXuatBanTim + ":");
                            for (Sach s : sachGiaoKhoaTheoNXB) {
                                System.out.println(s);
                            }
                        }
                        break;

                    case 4:
                        double sachMax = dsSach.timThanhTienCaoNhat();
                        if (sachMax == -1) {
                            System.out.println("Danh sách sách trống.");
                        } else {
                            System.out.printf("Sách có thành tiền cao nhất: %s\n", nf.format(sachMax));
                        }
                        break;

                    case 5:
                        List<String> danhSachSachs = dsSach.hienThiDanhSach();
                        for (String s : danhSachSachs) {
                            System.out.println(s);
                        }
                        break;

                    case 6:
                        SachGiaoKhoa sgk1 = new SachGiaoKhoa("SGK001", LocalDate.parse("01/06/2023", dtf), 120000, 10, "NXB Giáo Dục", true);
                        SachGiaoKhoa sgk2 = new SachGiaoKhoa("SGK002", LocalDate.parse("15/12/2024", dtf), 150000, 5, "NXB Giáo Dục", false);
                        SachThamKhao stk1 = new SachThamKhao("STK001", LocalDate.parse("05/05/2025", dtf), 200000, 8, "NXB Bách Khoa", 10000);
                        dsSach.them(sgk1);
                        dsSach.them(sgk2);
                        dsSach.them(stk1);
                        System.out.println("Đã nhập cứng 3 cuốn sách vào danh sách.");
                        break;

                    case 7:
                        System.out.println("Cảm ơn bạn đã sử dụng chương trình.");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                sc.nextLine(); // Đọc bỏ dòng lỗi nếu có
            }

        } while (luachon != 7);

        sc.close();
    }
}
