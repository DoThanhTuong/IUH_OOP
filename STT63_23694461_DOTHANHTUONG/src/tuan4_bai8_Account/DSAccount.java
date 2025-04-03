package tuan4_bai8_Account;

public class DSAccount {
    private TaiKhoan[] ds;
    private int soLuongHT; // số lượng tài khoản hiện tại

    // Constructor - khởi tạo danh sách với kích thước tối đa tuỳ ý (ví dụ 100)
    public DSAccount() {
        ds = new TaiKhoan[100];
        soLuongHT = 0;
    }

    // Thêm 1 tài khoản vào danh sách
    public boolean them(TaiKhoan tk) {
        if (soLuongHT < ds.length) {
            ds[soLuongHT] = tk;
            soLuongHT++;
            return true;
        }
        return false;
    }

    // Tìm kiếm vị trí trong mảng theo số tài khoản, trả về chỉ số (index)
    // Nếu không thấy trả về -1
    public int timKiemVT(long soAC) {
        for (int i = 0; i < soLuongHT; i++) {
            if (ds[i].getSoTaiKhoan() == soAC) {
                return i;
            }
        }
        return -1;
    }

    // Tìm kiếm và trả về chính đối tượng tài khoản
    public TaiKhoan timKiemACC(long soAC) {
        for (int i = 0; i < soLuongHT; i++) {
            if (ds[i].getSoTaiKhoan() == soAC) {
                return ds[i];
            }
        }
        return null; // không tìm thấy
    }

    // Lấy số lượng tài khoản hiện tại
    public int getSoLuongHT() {
        return soLuongHT;
    }

    // Trả về mảng danh sách tài khoản
    public TaiKhoan[] xuatDanhSach() {
        TaiKhoan[] result = new TaiKhoan[soLuongHT];
        System.arraycopy(ds, 0, result, 0, soLuongHT);
        return result;  // Trả về mảng chứa các tài khoản đã nhập
    }
}
