package tuan5_NhaDat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachGiaoDich {
    // Danh sách chứa các giao dịch
    private ArrayList<GiaoDich> ds;

    // Định dạng ngày tháng theo "dd/MM/yyyy"
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Constructor khởi tạo danh sách giao dịch
    public DanhSachGiaoDich() {
        ds = new ArrayList<>();
    }

    // Thêm một giao dịch vào danh sách (kiểm tra trùng lặp mã giao dịch)
    public boolean themGiaoDich(GiaoDich gd) {
        if (!ds.contains(gd)) {
            ds.add(gd);
            return true;
        }
        return false;
    }

    // Xóa giao dịch khỏi danh sách
    public boolean xoaGiaoDich(GiaoDich gd) {
        return ds.remove(gd);
    }

    // Tìm vị trí của giao dịch theo mã giao dịch
    public int timKiemViTriGiaoDich(String maGiaoDich) {
        GiaoDich giaoDich = timKiemGiaoDich(maGiaoDich);
        return giaoDich != null ? ds.indexOf(giaoDich) : -1;
    }

    // Tìm kiếm một giao dịch theo mã giao dịch
    public GiaoDich timKiemGiaoDich(String maGiaoDich) {
        for (GiaoDich gd : ds) {
            if (gd.maGiaoDich.equalsIgnoreCase(maGiaoDich)) {
                return gd;
            }
        }
        return null;
    }

    // Lấy danh sách các giao dịch đất
    public ArrayList<GiaoDichDat> getDSGiaoDichDat() {
        ArrayList<GiaoDichDat> dsGDD = new ArrayList<>();
        for (GiaoDich gd : ds) {
            if (gd instanceof GiaoDichDat) {
                dsGDD.add((GiaoDichDat) gd);
            }
        }
        return dsGDD;
    }

    // Lấy danh sách các giao dịch nhà
    public ArrayList<GiaoDichNha> getDSGiaoDichNha() {
        ArrayList<GiaoDichNha> dsGDN = new ArrayList<>();
        for (GiaoDich gd : ds) {
            if (gd instanceof GiaoDichNha) {
                dsGDN.add((GiaoDichNha) gd);
            }
        }
        return dsGDN;
    }

    // Lọc danh sách giao dịch trong khoảng thời gian từ ngày bắt đầu đến ngày kết thúc
    public ArrayList<GiaoDich> getDSTheoNgayGD(String ngayBD, String ngayKT) {
        LocalDate startDate = LocalDate.parse(ngayBD, DATE_FORMATTER);
        LocalDate endDate = LocalDate.parse(ngayKT, DATE_FORMATTER);

        // Nếu ngày bắt đầu lớn hơn ngày kết thúc thì trả về danh sách rỗng
        if (startDate.isAfter(endDate)) {
            return new ArrayList<>();
        }

        ArrayList<GiaoDich> dsTrongKhoang = new ArrayList<>();
        for (GiaoDich gd : ds) {
            LocalDate ngayGiaoDich = gd.ngayGiaoDich;
            if ((ngayGiaoDich.isEqual(startDate) || ngayGiaoDich.isAfter(startDate)) &&
                (ngayGiaoDich.isEqual(endDate) || ngayGiaoDich.isBefore(endDate))) {
                dsTrongKhoang.add(gd);
            }
        }
        return dsTrongKhoang;
    }

    // Getter danh sách giao dịch
    public ArrayList<GiaoDich> getDS() {
        return ds;
    }

 // Phương thức so sánh ngày giao dịch
    public static int compareDate(LocalDate date1, LocalDate date2) {
        return date1.compareTo(date2); // so sánh hai LocalDate
    }

    public void sortTheoNgayGD() {
        Collections.sort(ds, new Comparator<GiaoDich>() {
            public int compare(GiaoDich gd1, GiaoDich gd2) {
                return DanhSachGiaoDich.compareDate(gd1.getNgayGiaoDich(), gd2.getNgayGiaoDich());
            }
        });
    }
    public void sortTheoThanhTien() {
        Collections.sort(ds, new Comparator<GiaoDich>() {
            public int compare(GiaoDich gd1, GiaoDich gd2) {
                return Double.compare(gd1.thanhTien(), gd2.thanhTien());
            }
        });
       
    }
    public double trungBinhThanhTienGiaoDichDat() {
        double tongThanhTien = 0;
        int count = 0;

        for (GiaoDich gd : ds) {
            if (gd instanceof GiaoDichDat) {
                tongThanhTien += gd.thanhTien(); // Thêm thành tiền của giao dịch đất vào tổng
                count++;
            }
        }

        if (count > 0) {
            double trungBinh = tongThanhTien / count;
             return trungBinh;
        } else {
        	return 0;
        }
    }




}
