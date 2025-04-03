package tuan3_dangKyXe;

import java.util.ArrayList;

public class DanhSachXe {
    private ArrayList<Xe> danhSachXe;

    public DanhSachXe() {
        this.danhSachXe = new ArrayList<>();
    }

    public boolean themXe(Xe xe) {
        for (Xe x : danhSachXe) {
            if (x.getTenChuXe().equalsIgnoreCase(xe.getTenChuXe())) {
                return false; // Xe đã tồn tại
            }
        }
        danhSachXe.add(xe);
        return true;
    }

    public boolean xoaXe(String tenChuXe) {
        for (int i = 0; i < danhSachXe.size(); i++) {
            if (danhSachXe.get(i).getTenChuXe().equalsIgnoreCase(tenChuXe)) {
                danhSachXe.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Xe> hienThiDanhSachXe() {
        if (danhSachXe.isEmpty()) {
            throw new IllegalArgumentException("Danh sách rỗng");
        }
        return new ArrayList<>(danhSachXe); // Trả về bản sao tránh sửa trực tiếp danh sách gốc
    }

    public Xe timXeTheoTenChuXe(String tenChuXe) {
        for (Xe xe : danhSachXe) {
            if (xe.getTenChuXe().equalsIgnoreCase(tenChuXe)) {
                return xe;
            }
        }
        return null;
    }
}
