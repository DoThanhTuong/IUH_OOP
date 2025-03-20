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
	    
	    // Lấy số lượng hiện tại
	    public int getSoLuongHT() {
	        return soLuongHT;
	    }
	    
	    // In ra danh sách tất cả tài khoản
	    public void xuatDanhSach() {
	        for (int i = 0; i < soLuongHT; i++) {
	            System.out.println(ds[i]);
	        }
	    }
}
