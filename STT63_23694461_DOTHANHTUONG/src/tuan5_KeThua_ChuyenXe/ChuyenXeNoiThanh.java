package tuan5_KeThua_ChuyenXe;

public class ChuyenXeNoiThanh extends ChuyenXe {
    //attributes
    private double soKm;
    private String soTuyen;
    //constructors
    protected ChuyenXeNoiThanh() {
        super();
        soKm = 0;
        soTuyen = "";
    }
    protected ChuyenXeNoiThanh(String maChuyenXe, String hoTenTaiXe, String soXe, double doanhThu, double soKm, String soTuyen ) {
        super(maChuyenXe,hoTenTaiXe,soXe,doanhThu);
        this.soKm = soKm;
        this.soTuyen = soTuyen;
    }
    //methods
    protected double getSoKm() {
        return soKm;
    }
    protected String getSoTuyen() {
        return soTuyen;
    }
    protected void setSoKm(double soKm) {
        this.soKm = soKm;
    }
    protected void setSoTuyen(String soTuyen) {
        this.soTuyen = soTuyen;
    }
    public String toString() {
        return super.toString() + String.format("%10.3f %20s", soKm,soTuyen);
    }
}


