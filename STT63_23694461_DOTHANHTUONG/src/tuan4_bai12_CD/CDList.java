package tuan4_bai12_CD;

import java.util.Arrays;

public class CDList {
    private CD[] list;
    private int count;

    public CDList(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive number.");
        }
        list = new CD[n];
        count = 0;
    }
    public int getCount() {
    	return count ;
    }

    public boolean addCD(CD cd) {
        if (cd == null || findCDByCode(cd.getMaCD())) {
            return false;
        }
        if (count >= list.length) {
            list = Arrays.copyOf(list, list.length + 10);
        }
        list[count++] = cd;
        return true;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean removeCDByCode(int maCD) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (list[i].getMaCD() == maCD) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;

        for (int i = index; i < count - 1; i++) {
            list[i] = list[i + 1];
        }
        list[--count] = null;
        return true;
    }

    public boolean totalGiaThanh(double[] sum) {
        if (count == 0) return false;
        sum[0] = 0;
        for (int i = 0; i < count; i++) {
            sum[0] += list[i].getGiaThanh();
        }
        return true;
    }

    public boolean findCDByCode(int maCD) {
        for (int i = 0; i < count; i++) {
            if (list[i].getMaCD() == maCD) {
                return true;
            }
        }
        return false;
    }
    public CD findCDByI(int maCD) {
        for (int i = 0; i < count; i++) {
            if (list[i].getMaCD() == maCD) {
                return list[i];  // Trả về đối tượng CD nếu tìm thấy
            }
        }
        return null;  // Trả về null nếu không tìm thấy
    }

    public boolean sortDescendingByGiaThanh() {
        if (count <= 1) return false;
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (list[i].getGiaThanh() < list[j].getGiaThanh()) {
                    CD temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        return true;
    }

    public boolean sortAscendingByTuaCD() {
        if (count <= 1) return false;
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (list[i].getTuaCD().compareToIgnoreCase(list[j].getTuaCD()) > 0) {
                    CD temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        return true;
    }

    // Hàm xuất danh sách CD, trả về một mảng các đối tượng CD
    public CD[] hienThiCD() {
        if (count == 0) {
            return new CD[0]; // Trả về mảng rỗng nếu không có CD nào
        }

        CD[] result = new CD[count];
        System.arraycopy(list, 0, result, 0, count); // Sao chép các đối tượng CD vào mảng mới
        return result;
    }
}
