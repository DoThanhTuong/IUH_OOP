package tuan5_KeThua_ChuyenXe;

import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
public class KiemThuDanhSachChuyenXe {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        DanhSachChuyenXe ds = new DanhSachChuyenXe();
        int choice = -1;
        while (choice != 0) {
            menu();
            System.out.println("Nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 0:
                    System.out.println("Thoát thành công!!");
                    break;
                case 1:
                    themChuyenXe(ds);
                    break;
                case 2:
                    xoaChuyenXe(ds);
                    break;
                case 3:
                    suaChuyenXe(ds);
                    break;
                case 4:
                    nhapCung(ds);
                    break;
                case 5:
                    xuatDSCXNoiThanh(ds);
                    break;
                case 6:
                    xuatDSCXNgoaiThanh(ds);
                    break;
                case 7:
                    xuatDS(ds);
                    break;
                case 8:
                    sortTheoTen(ds);
                    break;
                case 9:
                    sortTheoDoanhThu(ds);
                    break;
                default:
                    System.out.println("Lỗi lựa chọn không hợp lệ!!");
            }
        }
    }
    public static void menu() {
        System.out.println("********************************************************");
        System.out.println("** Chương trình quản lý danh sách chuyến xe           **");
        System.out.println("** 0. Thoát                                           **");
        System.out.println("** 1. Thêm chuyến xe                                  **");
        System.out.println("** 2. Xóa chuyến xe theo mã                           **");
        System.out.println("** 3. Sửa chuyến xe                                   **");
        System.out.println("** 4. Nhập cứng                                       **");
        System.out.println("** 5. Xuất danh sách chuyến xe nội thành              **");
        System.out.println("** 6. Xuất danh sách chuyến xe ngoại thành            **");
        System.out.println("** 7. Xuất danh sách tất cả chuyến xe                 **");
        System.out.println("** 8. Sắp xếp danh sách theo tên                      **");
        System.out.println("** 9. Sắp xếp danh sách theo doanh thu                **");
        System.out.println("********************************************************");
    }
    public static void menuSuaChuyenXeNT() {
        System.out.println("********************************************************");
        System.out.println("** Chương trình chỉnh sửa thông tin chuyến xe         **");
        System.out.println("** 0. Thoát                                           **");
        System.out.println("** 1. Mã chuyến xe                                    **");
        System.out.println("** 2. Họ tên tài xế                                   **");
        System.out.println("** 3. Số xe                                           **");
        System.out.println("** 4. Doanh thu                                       **");
        System.out.println("** 5. Số Km                                           **");
        System.out.println("** 6. Số tuyến                                        **");
        System.out.println("********************************************************");
    }
    public static void menuSuaChuyenXeNGT() {
        System.out.println("********************************************************");
        System.out.println("** Chương trình chỉnh sửa thông tin chuyến xe         **");
        System.out.println("** 0. Thoát                                           **");
        System.out.println("** 1. Mã chuyến xe                                    **");
        System.out.println("** 2. Họ tên tài xế                                   **");
        System.out.println("** 3. Số xe                                           **");
        System.out.println("** 4. Doanh thu                                       **");
        System.out.println("** 5. Nơi đến                                         **");
        System.out.println("** 6. Số ngày                                         **");
        System.out.println("********************************************************");
    }
    public static void themChuyenXe(DanhSachChuyenXe ds) {
        try {
            String maChuyenXe,hoTen,soXe;
            double doanhThu;
            System.out.println("Nhập mã chuyến xe: "); maChuyenXe = sc.nextLine();
            if (ds.timKiemViTriChuyenXe(maChuyenXe) == -1) {
                System.out.println("Nhập họ tên tài xế : "); hoTen = sc.nextLine();
                System.out.println("Nhập số xe: "); soXe = sc.nextLine();
                System.out.println("Nhập doanh thu: "); doanhThu = sc.nextDouble();
                System.out.println("Nhập [1]xe nội thành hoặc [2]xe ngoại thành: ");
                if (sc.nextInt() == 1) {
                    double soKm;
                    String soTuyen;
                    System.out.println("Nhập số km: "); soKm = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Nhập số tuyến: "); soTuyen = sc.nextLine();
                    ChuyenXe xe = new ChuyenXeNoiThanh(maChuyenXe,hoTen,soXe,doanhThu,soKm,soTuyen);
                    ds.them(xe);
                }else {
                    String noiDen;
                    int soNgay;
                    sc.nextLine();
                    System.out.println("Nhập nơi đến: "); noiDen = sc.nextLine();
                    System.out.println("Nhập số ngày: "); soNgay = sc.nextInt();
                    ChuyenXe xe = new ChuyenXeNgoaiThanh(maChuyenXe,hoTen,soXe,doanhThu,noiDen,soNgay);
                    ds.them(xe);
                }
                throw new Exception("Thêm chuyến xe thành công!!");
            }else {
                throw new Exception("Lỗi mã chuyến xe trùng!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void xoaChuyenXe(DanhSachChuyenXe ds) {
        try {
            String maChuyenXe;
            System.out.println("Nhập mã chuyến xe cần xóa: "); maChuyenXe = sc.nextLine();
            ChuyenXe xe = ds.timKiemChuyenXe(maChuyenXe);
            System.out.println("Bạn có chắc muốn xóa chuyến xe không?[y/n]:");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                ds.xoa(xe);
            }else {
                throw new Exception("Bạn đã giữ lại chuyến xe thành công!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void suaChuyenXe(DanhSachChuyenXe ds) {
        try {
            int choice = -1;
            String maChuyenXe;
            System.out.println("Nhập mã chuyến xe cần sửa: "); maChuyenXe = sc.nextLine();
            ChuyenXe xe = ds.timKiemChuyenXe(maChuyenXe);
            if (ds.timKiemViTriChuyenXe(maChuyenXe) != -1) {
                System.out.println("Thông tin chuyến xe trước khi sửa");
                if (xe instanceof ChuyenXeNoiThanh) {
                    ChuyenXeNoiThanh xe1 = (ChuyenXeNoiThanh) xe;
                    tieuDeDSCXNoiThanh();
                    System.out.println(xe1);
                    menuSuaChuyenXeNT();
                    System.out.println("Nhập lựa chọn: "); choice = sc.nextInt();
                    sc.nextLine();
                    while (choice != 0) {
                        switch (choice) {
                            case 0:
                                System.out.println("Thoát thành công!!");
                                break;
                            case 1:
                                System.out.println("Nhập mã chuyến xe:");
                                xe1.setmaChuyenXe(sc.nextLine());
                                break;
                            case 2:
                                System.out.println("Nhập họ tên tài xế:");
                                xe1.setHoTenTaiXe(sc.nextLine());
                                break;
                            case 3:
                                System.out.println("Nhập số xe:");
                                xe1.setSoXe(sc.nextLine());
                                break;
                            case 4:
                                System.out.println("Nhập doanh thu: ");
                                xe1.setDoanhThu(sc.nextDouble());
                                break;
                            case 5:
                                System.out.println("Nhập số Km: ");
                                xe1.setSoKm(sc.nextDouble());
                                break;
                            case 6:
                                System.out.println("Nhập số tuyến:");
                                xe1.setSoTuyen(sc.nextLine());
                                break;
                            default:
                                System.out.println("Lỗi lựa chọn không hợp lệ!");
                        }
                    }
                }else {
                    ChuyenXeNgoaiThanh xe1 = (ChuyenXeNgoaiThanh) xe;
                    tieuDeDSCXNgoaiThanh();
                    System.out.println(xe1);
                    menuSuaChuyenXeNGT();
                    System.out.println("Nhập lựa chọn: "); choice = sc.nextInt();
                    sc.nextLine();
                    while (choice != 0) {
                        switch (choice) {
                            case 0:
                                System.out.println("Thoát thành công!!");
                                break;
                            case 1:
                                System.out.println("Nhập mã chuyến xe:");
                                xe1.setmaChuyenXe(sc.nextLine());
                                break;
                            case 2:
                                System.out.println("Nhập họ tên tài xế:");
                                xe1.setHoTenTaiXe(sc.nextLine());
                                break;
                            case 3:
                                System.out.println("Nhập số xe:");
                                xe1.setSoXe(sc.nextLine());
                                break;
                            case 4:
                                System.out.println("Nhập doanh thu: ");
                                xe1.setDoanhThu(sc.nextDouble());
                                break;
                            case 5:
                                System.out.println("Nhập nơi đến: ");
                                xe1.setNoiDen(sc.nextLine());
                                break;
                            case 6:
                                System.out.println("Nhập số ngày:");
                                xe1.setSoNgay(sc.nextInt());
                                break;
                            default:
                                System.out.println("Lỗi lựa chọn không hợp lệ!");
                        }
                    }
                }
            }else {
                throw new Exception("Lỗi mã chuyến xe không tồn tại");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void nhapCung(DanhSachChuyenXe ds) {
        try {
            ChuyenXe nt = new ChuyenXeNoiThanh("CX001","Võ Văn Tám","8888",500000,1,"Thủ đức - Quận 3");
            ChuyenXe ngt = new ChuyenXeNgoaiThanh("CX002","Trần thị C","6666",1000000,"Nha Trang",3);
            ChuyenXe nt1 = new ChuyenXeNoiThanh("CX003","Nguyễn thị B","7777",250000,1,"Quận 10 - Quận 1");
            ChuyenXe ngt1 = new ChuyenXeNgoaiThanh("CX004","Nguyễn Văn A","9999",5000000,"Long an",1);
            ds.them(nt);
            ds.them(ngt);
            ds.them(nt1);
            ds.them(ngt1);
            throw new Exception("Nhập cứng thành công!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void tieuDeDSCXNgoaiThanh(){
        System.out.println(String.format("%15s %25s %10s %15s %15s %10s","Mã chuyến xe","Họ tên","Số xe","Doanh thu","Nơi đến","Số ngày"));
    }
    public static void tieuDeDSCXNoiThanh(){
        System.out.println(String.format("%15s %25s %10s %15s %10s %20s","Mã chuyến xe","Họ tên","Số xe","Doanh thu","Số Km","Số tuyến"));
    }
    public static void xuatDSCXNgoaiThanh(DanhSachChuyenXe ds) {
        System.out.println("Danh sách chuyến xe ngoại thành");
        tieuDeDSCXNgoaiThanh();
        for (ChuyenXeNgoaiThanh xe : ds.getDSXeNgoaiThanh()) {
            System.out.println(xe);
        }
    }
    public static void xuatDSCXNoiThanh(DanhSachChuyenXe ds) {
        System.out.println("Danh sách chuyến xe nội thành");
        tieuDeDSCXNoiThanh();
        for (ChuyenXeNoiThanh xe : ds.getDSXeNoiThanh()) {
            System.out.println(xe);
        }
    }
    public static void xuatDS(DanhSachChuyenXe ds) {
        System.out.println("Danh sách chuyến xe");
        for (ChuyenXe xe : ds.getDS()) {
            System.out.println(xe);
        }
    }
    //Collections.sort(): Phương thức này sử dụng Collections.sort()
    // để sắp xếp danh sách theo một tiêu chí so sánh được định nghĩa trong Comparator<...>.
    //compareTo() là một phương thức trong lớp String, dùng để so sánh chuỗi (tên tài xế) theo thứ tự từ điển.
    //Phương thức này sẽ sắp xếp danh sách chuyến xe (ds.getDS()) theo tên tài xế theo thứ tự từ điển (a-z).
    public static void sortTheoTen(DanhSachChuyenXe ds) {
        Collections.sort(ds.getDS(), new Comparator<ChuyenXe>() {
            public int compare(ChuyenXe xe1, ChuyenXe xe2) {
                return xe1.getTenTaiXe().compareTo(xe2.getTenTaiXe());
            }
        });
    }
    //Phương thức compare() nhận hai đối tượng ChuyenXe và so sánh chúng theo doanh thu.
    public static void sortTheoDoanhThu(DanhSachChuyenXe ds) {
        Collections.sort(ds.getDS(), new Comparator<ChuyenXe>() {
            @Override
            public int compare(ChuyenXe xe1, ChuyenXe xe2) {
                // So sánh theo doanh thu
                return Double.compare(xe1.getDoanhThu(), xe2.getDoanhThu());

            }
        });

    }
}
