package tuan4_bai8_Account;

import java.util.Scanner;

public class Main {
    static DSAccount ds = new DSAccount();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm vài tài khoản mẫu vào danh sách
        ds.them(new TaiKhoan(1001, "Nguyen Van A", 200000));
        ds.them(new TaiKhoan(1002, "Le Thi B", 500000));
        ds.them(new TaiKhoan(1003, "Tran Van C", 1000000));

        int chon;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Them tai khoan");
            System.out.println("2. Nap tien");
            System.out.println("3. Rut tien");
            System.out.println("4. Chuyen tien");
            System.out.println("5. Xem danh sach tai khoan");
            System.out.println("0. Thoat");
            System.out.print("Moi ban chon: ");
            chon = sc.nextInt();
            try {
                switch (chon) {
                    case 1:
                        themTaiKhoan();
                        break;
                    case 2:
                        napTien();
                        break;
                    case 3:
                        rutTien();
                        break;
                    case 4:
                        chuyenTien();
                        break;
                    case 5:
                        xuatDanhSachTaiKhoan();
                        break;
                    case 0:
                        System.out.println("Thoat chuong trinh.");
                        break;
                    default:
                        System.out.println("Vui long chon dung chuc nang!");
                }
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        } while (chon != 0);

        sc.close();
    }

    // Thêm tài khoản mới
    public static void themTaiKhoan() {
        System.out.print("Nhap so tai khoan: ");
        long soTK = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhap ten chu tai khoan: ");
        String ten = sc.nextLine();
        System.out.print("Nhap so du ban dau: ");
        double soDu = sc.nextDouble();

        TaiKhoan tk = new TaiKhoan(soTK, ten, soDu);
        boolean ok = ds.them(tk);
        if (ok) {
            System.out.println("Them tai khoan thanh cong!");
        } else {
            System.out.println("Them that bai (danh sach da day hoac so tai khoan da ton tai)!");
        }
    }

    // Nạp tiền vào tài khoản
    public static void napTien() {
        System.out.print("Nhap so tai khoan muon nap: ");
        long soTK = sc.nextLong();
        TaiKhoan tk = ds.timKiemACC(soTK);

        if (tk == null) {
            System.out.println("Khong tim thay tai khoan!");
            return;
        }

        System.out.print("Nhap so tien muon nap: ");
        double soTien = sc.nextDouble();
        boolean ok = tk.napTien(soTien);
        if (ok) {
            System.out.println("Nap tien thanh cong!");
        } else {
            System.out.println("So tien khong hop le!");
        }
    }

    // Rút tiền từ tài khoản
    public static void rutTien() {
        System.out.print("Nhap so tai khoan muon rut: ");
        long soTK = sc.nextLong();
        TaiKhoan tk = ds.timKiemACC(soTK);

        if (tk == null) {
            System.out.println("Khong tim thay tai khoan!");
            return;
        }

        System.out.print("Nhap so tien muon rut: ");
        double soTien = sc.nextDouble();
        boolean ok = tk.rutTien(soTien);
        if (ok) {
            System.out.println("Rut tien thanh cong!");
        } else {
            System.out.println("So du khong du hoac so tien khong hop le!");
        }
    }

    // Chuyển tiền giữa các tài khoản
    public static void chuyenTien() {
        System.out.print("Nhap so tai khoan gui: ");
        long soTKGui = sc.nextLong();
        TaiKhoan accGui = ds.timKiemACC(soTKGui);

        if (accGui == null) {
            System.out.println("Khong tim thay tai khoan gui!");
            return;
        }

        System.out.print("Nhap so tai khoan nhan: ");
        long soTKNhan = sc.nextLong();
        TaiKhoan accNhan = ds.timKiemACC(soTKNhan);

        if (accNhan == null) {
            System.out.println("Khong tim thay tai khoan nhan!");
            return;
        }

        System.out.print("Nhap so tien can chuyen: ");
        double soTien = sc.nextDouble();

        try {
            boolean ok = accGui.transfer(accNhan, soTien);
            if (ok) {
                System.out.println("Chuyen tien thanh cong!");
            }
        } catch (Exception e) {
            System.out.println("Chuyen tien that bai: " + e.getMessage());
        }
    }

    // Xuất danh sách tài khoản
    public static void xuatDanhSachTaiKhoan() {
        TaiKhoan[] danhSach = ds.xuatDanhSach();
        for (TaiKhoan tk : danhSach) {
            System.out.println(tk);
        }
    }
}
