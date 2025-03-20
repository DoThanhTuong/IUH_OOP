package tuan3_dangKyXe;

import java.util.ArrayList;

public class DanhSachXe {
    // List to hold all vehicles
    private ArrayList<Xe> danhSachXe;

    // Constructor to initialize the list
    public DanhSachXe() {
        this.danhSachXe = new ArrayList<>();
    }

    // Method to add a new vehicle
    public void themXe(Xe xe) {
        danhSachXe.add(xe);
        System.out.println("Đã thêm xe thành công: " + xe.getTenChuXe());
    }

    // Method to remove a vehicle by its owner's name
    public boolean xoaXe(String tenChuXe) {
        for (Xe xe : danhSachXe) {
            if (xe.getTenChuXe().equalsIgnoreCase(tenChuXe)) {
                danhSachXe.remove(xe);
                System.out.println("Đã xóa xe của chủ xe: " + tenChuXe);
                return true;
            }
        }
        System.out.println("Không tìm thấy xe của chủ xe: " + tenChuXe);
        return false;
    }

    // Method to display all vehicles in the list
    public void hienThiDanhSachXe() {
        if (danhSachXe.isEmpty()) {
            System.out.println("Danh sách xe hiện đang trống.");
        } else {
            System.out.println("Danh sách các xe:");
            System.out.printf("%-20s %-20s %10s %20s %20s\n", "Tên Chủ Xe", "Loại Xe", "Dung tích", "Trị giá", "Thuế phải nộp");
            System.out.println("==============================================================================================");
            for (Xe xe : danhSachXe) {
                System.out.println(xe);
            }
        }
    }

    // Method to search for a vehicle by its owner's name
    public Xe timXeTheoTenChuXe(String tenChuXe) {
    	System.out.println("RRRRRRRRRRRRRRRRRRR");
        for (Xe xe : danhSachXe) {
            if (xe.getTenChuXe().equalsIgnoreCase(tenChuXe)) {
                return xe;
            }
        }
        return null; // Return null if no matching vehicle is found
    }
}
