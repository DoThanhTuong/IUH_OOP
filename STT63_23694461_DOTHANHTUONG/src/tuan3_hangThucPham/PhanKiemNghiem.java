package tuan3_hangThucPham;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhanKiemNghiem {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DanhSachHangTP danhSach = new DanhSachHangTP();
        int chon;
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("***MENU***");
            System.out.println("1/ Nhập Mềm");
            System.out.println("2/ Nhập Cứng");
            System.out.println("3/ Chỉnh Sửa Danh Sách");
            System.out.println("4/ Xuất");
            System.out.println("5/ Thoát");
            chon = nhapChon(scanner);
            
            switch (chon) {
                case 1:
                    System.out.println("1/ Nhập Mềm");
                    HangThucPham htp = nhapThongTinHangTP(scanner, dateFormat);
                    if (htp != null) {
                        danhSach.themHTP(htp);
                    }
                    break;
                case 2:
                    System.out.println("2/ Nhập Cứng");
                    try {
                        // Thêm một số hàng thực phẩm vào danh sách
                        HangThucPham htp1 = new HangThucPham("H001", "Sữa Vinamilk", 15000, dateFormat.parse("01/01/2023"), dateFormat.parse("01/01/2024"));
                        HangThucPham htp2 = new HangThucPham("H002", "Mì gói Hảo Hảo", 3000, dateFormat.parse("15/12/2023"), dateFormat.parse("15/12/2026"));
                        HangThucPham htp3 = new HangThucPham("H003", "Trứng gà", 4000, dateFormat.parse("10/01/2023"), dateFormat.parse("20/01/2023"));
                        danhSach.themHTP(htp1);
                        danhSach.themHTP(htp2);
                        danhSach.themHTP(htp3);
                    } catch (ParseException e) {
                        System.out.println("Lỗi định dạng ngày!");
                    }
                    break;
                case 3:
                    System.out.println("3/ Chỉnh Sửa Danh Sách");
                    chinhsua(danhSach, scanner);
                    break;
                case 4:
                    System.out.println("4/ Xuất");
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Mã hàng", "Tên hàng", "Đơn giá", "Ngày sản xuất", "Ngày hết hạn");
                    System.out.println("============================================================================================================");
                    if (danhSach.hienThiDanhSachHTP()) {
                        // Hiển thị danh sách hàng thực phẩm
                        for (HangThucPham hTP : danhSach.getDanhSachHTP()) {
                            System.out.println(hTP);
                        }
                    } else {
                        System.out.println("Danh sách hàng thực phẩm trống.");
                    }
                    break;
            }
        } while (chon != 5);
        
        scanner.close();
    }

    private static HangThucPham nhapThongTinHangTP(Scanner scanner, SimpleDateFormat dateFormat) {
        String maHang, tenHang;
        double donGia;
        Date ngaySanXuat = null, ngayHetHan = null;
        
        System.out.print("Nhập mã hàng: ");
        maHang = scanner.nextLine();
        while (maHang.isEmpty()) {
            System.out.print("Mã hàng không được để trống. Nhập lại mã hàng: ");
            maHang = scanner.nextLine();
        }

        System.out.print("Nhập tên hàng: ");
        tenHang = scanner.nextLine();
        while (tenHang.isEmpty()) {
            System.out.print("Tên hàng không được để trống. Nhập lại tên hàng: ");
            tenHang = scanner.nextLine();
        }

        System.out.print("Nhập đơn giá: ");
        while (true) {
            try {
                donGia = Double.parseDouble(scanner.nextLine());
                if (donGia > 0) break;
                else System.out.print("Đơn giá phải lớn hơn 0. Nhập lại đơn giá: ");
            } catch (NumberFormatException e) {
                System.out.print("Đơn giá không hợp lệ. Nhập lại đơn giá: ");
            }
        }

        System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
        while (true) {
            try {
                String ngaySanXuatStr = scanner.nextLine();
                ngaySanXuat = dateFormat.parse(ngaySanXuatStr);
                break;
            } catch (ParseException e) {
                System.out.print("Ngày sản xuất không hợp lệ. Nhập lại (dd/MM/yyyy): ");
            }
        }

        System.out.print("Nhập ngày hết hạn (dd/MM/yyyy): ");
        while (true) {
            try {
                String ngayHetHanStr = scanner.nextLine();
                ngayHetHan = dateFormat.parse(ngayHetHanStr);
                if (ngayHetHan.after(ngaySanXuat)) break;
                else {
                    System.out.print("Ngày hết hạn phải sau ngày sản xuất. Nhập lại ngày hết hạn: ");
                }
            } catch (ParseException e) {
                System.out.print("Ngày hết hạn không hợp lệ. Nhập lại (dd/MM/yyyy): ");
            }
        }

        return new HangThucPham(maHang, tenHang, donGia, ngaySanXuat, ngayHetHan);
    }

    private static void chinhsua(DanhSachHangTP danhSach, Scanner scanner) {
        int chon;
        do {
            System.out.println("1/ Nhập Tên Mã Để Tìm Hàng: ");
            System.out.println("2/ Nhập Tên Mã Để Xóa Hàng: ");
            System.out.println("3/ Thoát");
            chon = nhapChon(scanner);
            switch (chon) {
                case 1: {
                    System.out.print("Nhập Mã Hàng: ");
                    String maHang = scanner.nextLine();
                    HangThucPham hTP = danhSach.timHTPTheoMa(maHang);
                    if (hTP != null) {
                        System.out.println(hTP);
                    } else {
                        System.out.println("Không tìm thấy hàng!");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Nhập Mã Hàng: ");
                    String maHang = scanner.nextLine();
                    if (danhSach.xoaHTP(maHang)) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy hàng để xóa!");
                    }
                    break;
                }
            }
        } while (chon != 3);
    }

    private static int nhapChon(Scanner scanner) {
        int chon;
        do {
            System.out.print("Chọn: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Nhập số hợp lệ: ");
                scanner.next();
            }
            chon = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
        } while (chon < 1 || chon > 5);
        return chon;
    }
}
