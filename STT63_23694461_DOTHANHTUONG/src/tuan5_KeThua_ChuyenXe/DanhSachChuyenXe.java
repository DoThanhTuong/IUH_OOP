package tuan5_KeThua_ChuyenXe;

import java.util.ArrayList;

public class DanhSachChuyenXe {
    //attributes
    ArrayList luuCacLoaiDL;
    ArrayList<ChuyenXe> ds;
    //constructors
    public DanhSachChuyenXe(){
        ds = new ArrayList<ChuyenXe>();   // khoi tao mang
        // mảng động không phải mảng tĩnh nên không cần truyền tham số số đối tượng cần cấp phát
    }
    //methods
    public void them(ChuyenXe xe) throws Exception {
        if (ds.contains(xe) == false) { 		// kiem tra xem da ton tai doi tuong xe trong danh sach chua
            ds.add(xe);
        }else {
            throw new Exception("Mã chuyến xe đã trùng!");
        }
    }
    public void xoa(ChuyenXe xe) throws Exception{
        if (xe != null) {
            ds.remove(xe);
            throw new Exception("Xóa thành công!!");
        }else {
            throw new Exception("Mã chuyến xe không tồn tại!!");
        }
    }
    public int timKiemViTriChuyenXe(String maChuyenXe) {    //tim kiem va tra ve vi tri
        ChuyenXe xe = timKiemChuyenXe(maChuyenXe);
        if (xe != null) {
            return ds.indexOf(xe);  			// tra ve vi tri dau tien cua doi tuong xe trong danh sách
        }
        return -1;
    }
    public ChuyenXe timKiemChuyenXe(String maChuyenXe) { //tim kiem va tra ve doi tuong
        for (ChuyenXe xe : ds) {
            if (xe.getmaChuyenXe().equalsIgnoreCase(maChuyenXe)) {
                return xe;
            }
        }
        return null;
    }
    public ArrayList<ChuyenXeNgoaiThanh> getDSXeNgoaiThanh(){		//ham tra ve danh sach chuyen xe ngoai thanh
        ArrayList<ChuyenXeNgoaiThanh> dsXeNgoaiThanh = new ArrayList<ChuyenXeNgoaiThanh>();
        for (ChuyenXe xe : ds) {
            if (xe instanceof ChuyenXeNgoaiThanh) {
                dsXeNgoaiThanh.add((ChuyenXeNgoaiThanh) xe);
            }
        }
        return dsXeNgoaiThanh;
    }
    public ArrayList<ChuyenXeNoiThanh> getDSXeNoiThanh(){		//ham tra ve danh sach chuyen xe ngoai thanh
        ArrayList<ChuyenXeNoiThanh> dsXeNoiThanh = new ArrayList<ChuyenXeNoiThanh>();
        for (ChuyenXe xe : ds) {
            if (xe instanceof ChuyenXeNoiThanh) {
                dsXeNoiThanh.add((ChuyenXeNoiThanh) xe);
            }
        }
        return dsXeNoiThanh;
    }
    public ArrayList<ChuyenXe> getDS(){
        return ds;
    }
}
