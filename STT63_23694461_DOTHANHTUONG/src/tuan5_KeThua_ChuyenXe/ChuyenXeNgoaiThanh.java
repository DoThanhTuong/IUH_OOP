package tuan5_KeThua_ChuyenXe;

public class ChuyenXeNgoaiThanh extends ChuyenXe {
    //ATTRIBUTES
    private String noiDen;
    private int soNgay;
    //CONSTRUCTOR
    protected ChuyenXeNgoaiThanh() {
        super();
        noiDen = "";
        soNgay = 0;
    }

    protected ChuyenXeNgoaiThanh(String maChuyenXe, String hoTenTaiXe, String soXe, double doanhThu, String noiDen, int soNgay) {
        super(maChuyenXe,hoTenTaiXe,soXe,doanhThu);
        this.noiDen = noiDen;
        this.soNgay = soNgay;
    }
    //METHODS
    protected void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }
    protected void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }
    protected String getNoiDen() {
        return this.noiDen;
    }
    protected int getSoNgay() {
        return this.soNgay;
    }
    public String toString() {
        return super.toString() + String.format("%15s %10d",noiDen,soNgay);
    }
}
