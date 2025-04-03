package tuan7_QuanLyLuong;

import java.util.*;

// Lớp danh sách nhân viên
class DanhSachNhanVien {
    private List<Employee> danhSach = new ArrayList<>();

    // Thêm nhân viên
    public void themNhanVien(Employee nv) {
        danhSach.add(nv);
    }

    // Xóa nhân viên theo chỉ số
    public void xoaNhanVien(int index) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.remove(index);
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
    }

    // Sửa thông tin nhân viên
    public void suaNhanVien(int index, Employee nvMoi) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.set(index, nvMoi);
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
    }

    // Xuất danh sách nhân viên
    public void xuatDanhSach() {
        for (Employee nv : danhSach) {
            System.out.println(nv);
            System.out.printf("Lương: %.2f\n\n", nv.tinhLuong());
        }
    }
}

