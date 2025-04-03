package tuan7_QuanLySach;

import java.util.ArrayList;
import java.util.List;

public class DanhSachSach {
    private List<Sach> listSach = new ArrayList<>();
    private int count = 0;

    public boolean checkMaSach(String maSachCheck) {
        for (Sach s : listSach) {
            if (s.getMaSach().equalsIgnoreCase(maSachCheck)) {
                return true;
            }
        }
        return false;
    }

    public boolean them(Sach sach) {
        if (!checkMaSach(sach.getMaSach())) {
            listSach.add(sach);
            count++;
            return true;
        }
        return false;
    }

    public double tinhTongThanhTienSGK() {
        double sum = 0;
        for (Sach s : listSach) {
            if (s instanceof SachGiaoKhoa) {
                sum += s.getThanhTien();
            }
        }
        return sum;
    }

    public double tinhTongThanhTienSTK() {
        double sum = 0;
        for (Sach s : listSach) {
            if (s instanceof SachThamKhao) {
                sum += s.getThanhTien();
            }
        }
        return sum;
    }

    public List<Sach> timSachGiaoKhoaTheoNXB(String findName) {
        List<Sach> listSachHopLe = new ArrayList<>();
        for (Sach s : listSach) {
            if (s.getNhaXuatBan().equalsIgnoreCase(findName) && s instanceof SachGiaoKhoa) {
                listSachHopLe.add(s);
            }
        }
        return listSachHopLe;
    }

    public double timThanhTienCaoNhat() {
        if (listSach.isEmpty()) {
            return -1;
        }

        double max = listSach.get(0).getThanhTien();
        for (Sach s : listSach) {
            if (s.getThanhTien() > max) {
                max = s.getThanhTien();
            }
        }
        return max;
    }

    public List<String> hienThiDanhSach() {
        List<String> result = new ArrayList<>();
        if (count == 0) {
            result.add("Danh sách sách hiện tại rỗng.");
        } else {
            for (Sach sach : listSach) {
                result.add(sach.toString());
            }
        }
        return result;
    }
}
