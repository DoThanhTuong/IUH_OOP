package tuan3_dangKyXe;

import java.util.Scanner;

public class KiemTraXe {
    public static void main(String[] args) {
        int chon;
        DanhSachXe dsx = new DanhSachXe();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n*** MENU ***");
            System.out.println("1/ Nhập mềm");
            System.out.println("2/ Nhập cứng");
            System.out.println("3/ Chỉnh sửa danh sách");
            System.out.println("4/ Xuất danh sách");
            System.out.println("5/ Thoát");
            System.out.print("Chọn chức năng: ");
            chon = nhapChon(scanner);

            switch (chon) {
                case 1 -> {
                    System.out.println("\n--- Nhập mềm ---");
                    dsx.themXe(nhapThongTinXe(scanner));
                }
                case 2 -> {
                    System.out.println("\n--- Nhập cứng ---");
                    dsx.themXe(new Xe("Nguyễn Thu Loan", "Future Neo", 100, 35000000));
                    dsx.themXe(new Xe("Lê Minh Tịnh", "Ford Ranger", 3000, 250000000));
                    dsx.themXe(new Xe("Nguyễn Minh Triết", "Landscape", 1500, 1000000000));
                    System.out.println("Đã thêm dữ liệu mẫu!");
                }
                case 3 -> {
                    System.out.println("\n--- Chỉnh sửa danh sách ---");
                    chinhsua(dsx, scanner);
                }
                case 4 -> {
                    System.out.println("\n--- Danh sách xe ---");
                    hienThiDanhSachXe(dsx);
                }
            }
        } while (chon != 5);

        System.out.println("Chương trình kết thúc.");
        scanner.close();
    }

    private static int nhapChon(Scanner scanner) {
        int chon;
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Nhập sai! Vui lòng nhập số từ 1-5: ");
                scanner.next();
            }
            chon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm
        } while (chon < 1 || chon > 5);
        return chon;
    }

    private static Xe nhapThongTinXe(Scanner scanner) {
        System.out.print("Nhập tên chủ xe: ");
        String tenChuXe = scanner.nextLine();

        System.out.print("Nhập loại xe: ");
        String loaiXe = scanner.nextLine();

        int dungTich;
        do {
            System.out.print("Nhập dung tích (cc): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Sai định dạng! Nhập lại dung tích (số nguyên): ");
                scanner.next();
            }
            dungTich = scanner.nextInt();
            scanner.nextLine();
        } while (dungTich <= 0);

        double triGia;
        do {
            System.out.print("Nhập trị giá (VND): ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Sai định dạng! Nhập lại trị giá (số thực): ");
                scanner.next();
            }
            triGia = scanner.nextDouble();
            scanner.nextLine();
        } while (triGia <= 0);

        return new Xe(tenChuXe, loaiXe, dungTich, triGia);
    }

    private static void chinhsua(DanhSachXe dsx, Scanner scanner) {
        int chon;
        do {
            System.out.println("\n--- Chỉnh sửa danh sách ---");
            System.out.println("1/ Tìm xe theo tên chủ");
            System.out.println("2/ Xóa xe theo tên chủ");
            System.out.println("3/ Quay lại");
            System.out.print("Chọn chức năng: ");
            chon = nhapChon(scanner);

            switch (chon) {
                case 1 -> {
                    System.out.print("Nhập tên chủ xe: ");
                    String tenChuXe = scanner.nextLine();
                    Xe xe = dsx.timXeTheoTenChuXe(tenChuXe);
                    if (xe != null) {
                        System.out.printf("%-20s %-20s %10s %20s %20s\n", "Tên Chủ Xe", "Loại Xe", "Dung tích", "Trị giá", "Thuế phải nộp");
                        System.out.println("==============================================================================================");
                        System.out.println(xe);
                    } else {
                        System.out.println("Không tìm thấy xe của chủ xe: " + tenChuXe);
                    }
                }
                case 2 -> {
                    System.out.print("Nhập tên chủ xe: ");
                    String tenChuXe = scanner.nextLine();
                    if (dsx.xoaXe(tenChuXe)) {
                        System.out.println("Đã xóa xe của chủ xe: " + tenChuXe);
                    } else {
                        System.out.println("Không tìm thấy xe để xóa.");
                    }
                }
            }
        } while (chon != 3);
    }

    private static void hienThiDanhSachXe(DanhSachXe dsx) {
        try {
            System.out.printf("%-20s %-20s %10s %20s %20s\n", "Tên Chủ Xe", "Loại Xe", "Dung tích", "Trị giá", "Thuế phải nộp");
            System.out.println("==============================================================================================");
            for (Xe xe : dsx.hienThiDanhSachXe()) {
                System.out.println(xe);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
