package tuan4_bai12_CD;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CDList cdList = new CDList(100);
        int choice;

        do {
            displayMenu();
            choice = chon(sc);

            try {
                switch (choice) {
                    case 1:
                    	System.out.print("Nhập số lượng đĩa CD mới: ");
                        int n = sc.nextInt();

                        // Thêm các CD mới vào danh sách hiện tại
                        for (int i = 0; i < n; i++) {
                            System.out.println("Nhập thông tin CD thứ " + (i + 1) + ":");
                            cdList.addCD(nhapThongTin(sc));  // Thêm vào danh sách hiện có
                        }
                        break;
                    case 2:
                        System.out.println("Nhập Cứng");
                        
                        CD cd1 = new CD(001, "Album A", 10, 19000);
                        cdList.addCD(cd1);
                        CD cd2 = new CD(002, "Album B", 18, 100000);
                        cdList.addCD(cd2);
                        CD cd3 = new CD(003, "Album c", 30, 60000);
                        cdList.addCD(cd3);
            
                        break;

                    case 3:
                        System.out.println("Danh sách CD:");
                        CD[] cds = cdList.hienThiCD(); // Lấy mảng các CD
                        if (cds.length == 0) {
                            System.out.println("Danh sách CD hiện đang trống.");
                        } else {
                        	System.out.printf("%-10s %-18s %-12s %-10s\n", "maCD", "tuaCD", "soBaiHat", "giaThanh");
                            for (CD cd : cds) {
                                System.out.println(cd); // Hiển thị thông tin từng CD trong mảng
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Số lượng CD: " + cdList.getCount());
                        break;

                    case 5:
                        System.out.print("Nhập mã CD cần xóa: ");
                        int maCDXoa = sc.nextInt();
                        if (cdList.removeCDByCode(maCDXoa)) {
                            System.out.println("Xóa CD thành công.");
                        } else {
                            System.out.println("Không tìm thấy CD với mã đã cho.");
                        }
                        break;

                    case 6:
                        double[] sum = new double[1];
                        if (cdList.totalGiaThanh(sum)) {
                            System.out.println("Tổng giá thành của các CD: " + sum[0]);
                        } else {
                            System.out.println("Danh sách CD trống.");
                        }
                        break;

                    case 7:
                    	System.out.print("Nhập mã CD cần tìm: ");
                    	int maCDTim = sc.nextInt();
                    	CD foundCD = cdList.findCDByI(maCDTim);  // Tìm CD theo mã

                    	if (foundCD != null) {  // Kiểm tra nếu tìm thấy CD
                    	    System.out.println("Tìm thấy CD với mã: " + maCDTim);
                    	    System.out.printf("\n%-10s %-18s %-12s %-10s\n", "maCD", "tuaCD", "soBaiHat", "giaThanh");
                    	    System.out.println(foundCD);  // In ra thông tin CD
                    	} else {
                    	    System.out.println("Không tìm thấy CD với mã đã cho.");
                    	}

                        break;

                    case 8:
                        if (cdList.sortDescendingByGiaThanh()) {
                            System.out.println("Danh sách CD đã được sắp xếp giảm dần theo giá thành:");
                            System.out.printf("\n%-10s %-18s %-12s %-10s\n", "maCD", "tuaCD", "soBaiHat", "giaThanh");
                            CD[] sortedCDs = cdList.hienThiCD();
                            for (CD cd : sortedCDs) {
                                System.out.println(cd);
                            }
                        } else {
                            System.out.println("Không thể sắp xếp vì danh sách không đủ CD.");
                        }
                        break;

                    case 9:
                        if (cdList.sortAscendingByTuaCD()) {
                            System.out.println("Danh sách CD đã được sắp xếp tăng dần theo tựa CD:");
                            System.out.printf("\n%-10s %-18s %-12s %-10s\n", "maCD", "tuaCD", "soBaiHat", "giaThanh");
                            CD[] sortedCDs = cdList.hienThiCD();
                            for (CD cd : sortedCDs) {
                                System.out.println(cd);
                            }
                        } else {
                            System.out.println("Không thể sắp xếp vì danh sách không đủ CD.");
                        }
                        break;

                    case 10:
                        System.out.println("Thoát chương trình.");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }

        } while (choice != 10);

        sc.close();
    }

    public static void displayMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Thêm CD");
        System.out.println("2. Nhập Cứng");
        System.out.println("3. Hiển thị danh sách CD");
        System.out.println("4. Số lượng CD trong danh sách");
        System.out.println("5. Xóa CD theo mã");
        System.out.println("6. Tổng giá thành các CD");
        System.out.println("7. Tìm kiếm CD theo mã");
        System.out.println("8. Sắp xếp danh sách giảm dần theo giá thành");
        System.out.println("9. Sắp xếp danh sách tăng dần theo tựa CD");
        System.out.println("10. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public static int chon(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Lỗi: Vui lòng nhập số.");
            sc.nextLine(); // Clear invalid input
        }
        int chon = sc.nextInt();
        sc.nextLine(); // Consume newline
        return chon;
    }

    public static CD nhapThongTin(Scanner sc) {
        System.out.print("Nhập mã CD: ");
        int maCD = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập tựa CD: ");
        String tuaCD = sc.nextLine();

        System.out.print("Nhập số bài hát: ");
        int soBaiHat = sc.nextInt();

        System.out.print("Nhập giá thành: ");
        double giaThanh = sc.nextDouble();
        sc.nextLine();

        return new CD(maCD, tuaCD, soBaiHat, giaThanh);
    }
}
