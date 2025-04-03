package tuan7_QuanLyLuong;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachNhanVien dsNhanVien = new DanhSachNhanVien();
        int luaChon;

        do {
            System.out.println("Chương trình quản lý nhân viên");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Xóa nhân viên");
            System.out.println("3. Sửa thông tin nhân viên");
            System.out.println("4. Xuất danh sách nhân viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng mới

            switch (luaChon) {
                case 1:
                	dsNhanVien.themNhanVien(new NhanVienCoDinh("Nguyen", "An", "123-45-6789", 1000.00));
                    dsNhanVien.themNhanVien(new NhanVienLamViecTheoGio("Tran", "Binh", "987-65-4321", 40, 15.00));
                    dsNhanVien.themNhanVien(new NhanVienHoaHong("Le", "Chi", "456-78-9012", 5000, 0.1));
                    dsNhanVien.themNhanVien(new NhanVienCoBanHoaHong("Hoang", "Dai", "321-54-9876", 3000, 0.2, 500));
                    System.out.println("Thêm nhân viên:");
                    System.out.println("1. Nhân viên cố định");
                    System.out.println("2. Nhân viên theo giờ");
                    System.out.println("3. Nhân viên hoa hồng");
                    System.out.println("4. Nhân viên cơ bản hoa hồng");
                    System.out.print("Chọn loại nhân viên: ");
                    int loaiNhanVien = sc.nextInt();
                    sc.nextLine(); // Đọc bỏ dòng mới

                    System.out.print("Nhập họ: ");
                    String ho = sc.nextLine();
                    System.out.print("Nhập tên: ");
                    String ten = sc.nextLine();
                    System.out.print("Nhập số CMND: ");
                    String cmnd = sc.nextLine();

                    switch (loaiNhanVien) {
                        case 1: // Nhân viên cố định
                            System.out.print("Nhập lương hàng tuần: ");
                            double luongHangTuan = sc.nextDouble();
                            dsNhanVien.themNhanVien(new NhanVienCoDinh(ho, ten, cmnd, luongHangTuan));
                            break;
                        case 2: // Nhân viên theo giờ
                            System.out.print("Nhập số giờ làm: ");
                            double soGioLam = sc.nextDouble();
                            System.out.print("Nhập mức lương theo giờ: ");
                            double luongTheoGio = sc.nextDouble();
                            dsNhanVien.themNhanVien(new NhanVienLamViecTheoGio(ho, ten, cmnd, soGioLam, luongTheoGio));
                            break;
                        case 3: // Nhân viên hoa hồng
                            System.out.print("Nhập doanh thu: ");
                            double doanhThu = sc.nextDouble();
                            System.out.print("Nhập tỷ lệ hoa hồng: ");
                            double tyLeHoaHong = sc.nextDouble();
                            dsNhanVien.themNhanVien(new NhanVienHoaHong(ho, ten, cmnd, doanhThu, tyLeHoaHong));
                            break;
                        case 4: // Nhân viên cơ bản hoa hồng
                            System.out.print("Nhập doanh thu: ");
                            double doanhThuBase = sc.nextDouble();
                            System.out.print("Nhập tỷ lệ hoa hồng: ");
                            double tyLeHoaHongBase = sc.nextDouble();
                            System.out.print("Nhập lương cơ bản: ");
                            double luongCoBan = sc.nextDouble();
                            dsNhanVien.themNhanVien(new NhanVienCoBanHoaHong(ho, ten, cmnd, doanhThuBase, tyLeHoaHongBase, luongCoBan));
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;
                case 2:
                    System.out.print("Nhập chỉ số nhân viên cần xóa: ");
                    int xoaIndex = sc.nextInt();
                    dsNhanVien.xoaNhanVien(xoaIndex);
                    break;
                case 3:
                    System.out.print("Nhập chỉ số nhân viên cần sửa: ");
                    int suaIndex = sc.nextInt();
                    sc.nextLine(); // Đọc bỏ dòng mới
                    System.out.print("Nhập họ mới: ");
                    String hoMoi = sc.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String tenMoi = sc.nextLine();
                    System.out.print("Nhập số CMND mới: ");
                    String cmndMoi = sc.nextLine();
                    System.out.print("Nhập lương mới: ");
                    double luongMoi = sc.nextDouble();
                    // Giả sử sửa nhân viên cố định, bạn có thể điều chỉnh cho các loại khác
                    dsNhanVien.suaNhanVien(suaIndex, new NhanVienCoDinh(hoMoi, tenMoi, cmndMoi, luongMoi));
                    break;
                case 4:
                    System.out.println("Danh sách nhân viên:");
                    dsNhanVien.xuatDanhSach();
                    break;
                case 5:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 5);

        sc.close();
    }
}