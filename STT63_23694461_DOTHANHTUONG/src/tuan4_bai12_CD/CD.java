package tuan4_bai12_CD;

public class CD {
    
    private static final int DEFAULT_MA_CD = 999999;
    private static final String DEFAULT_TUA_CD = "chưa xác định";
    private static final int DEFAULT_SO_BAI_HAT = 1;
    private static final double DEFAULT_GIA_THANH = 1.0;

    
    private int maCD;
    private String tuaCD;
    private int soBaiHat;
    private double giaThanh;

    
    public CD() {
        this.maCD = DEFAULT_MA_CD;
        this.tuaCD = DEFAULT_TUA_CD;
        this.soBaiHat = DEFAULT_SO_BAI_HAT;
        this.giaThanh = DEFAULT_GIA_THANH;
    }

    
    public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
        setMaCD(maCD);
        setTuaCD(tuaCD);
        setSoBaiHat(soBaiHat);
        setGiaThanh(giaThanh);
    }

    
    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        if (maCD > 0) {
            this.maCD = maCD;
        } else {
            this.maCD = DEFAULT_MA_CD;
        }
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        if (tuaCD != null && !tuaCD.trim().isEmpty()) {
            this.tuaCD = tuaCD;
        } else {
            this.tuaCD = DEFAULT_TUA_CD;
        }
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat > 0) {
            this.soBaiHat = soBaiHat;
        } else {
            this.soBaiHat = DEFAULT_SO_BAI_HAT;
        }
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if (giaThanh > 0) {
            this.giaThanh = giaThanh;
        } else {
            this.giaThanh = DEFAULT_GIA_THANH;
        }
    }

    
    @Override
    public String toString() {
        return String.format("%-10d %-20s %-10d %-10.2f", maCD, tuaCD, soBaiHat, giaThanh);
    }
}