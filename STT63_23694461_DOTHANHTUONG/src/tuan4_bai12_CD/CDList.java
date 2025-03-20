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

    
    public boolean addCD(CD cd) {
        if (cd == null) {
            throw new IllegalArgumentException("CD cannot be null.");
        }
        if (count >= list.length) {
        	int newlist = list.length * 2; 
            list = Arrays.copyOf(list, newlist); 
        }
        if (findCDByCode(cd.getMaCD()) != null) {
            return false; 
        }
        list[count++] = cd;
        return true;
    }

   
    public void hienThiCD() {
        if (count <= 0) {
            System.out.println("Danh sách CD hiện đang trống.");
        } else {
            System.out.println("Danh sách các CD:");
            System.out.printf("%-10s %-20s %-15s %-10s\n", "MÃ CD", "Tựa CD", "Số bài hát", "Giá Thành");
            System.out.println("==============================================================");
            for (int i = 0; i < count; i++) {
                System.out.println(list[i]);
            }
        }
    }

    
    public int getCount() {
        return count;
    }

    
    public boolean removeCDByCode(int maCD) {
        if (count == 0) {
            return false; 
        }
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (list[i].getMaCD() == maCD) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false; 
        }
        
        for (int i = index; i < count - 1; i++) {
            list[i] = list[i + 1];
        }
        list[count - 1] = null;
        count--;
        return true;
    }

    
    public double totalGiaThanh() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += list[i].getGiaThanh();
        }
        return sum;
    }

    
    public CD findCDByCode(int maCD) {
        for (int i = 0; i < count; i++) {
            if (list[i].getMaCD() == maCD) {
                return list[i];
            }
        }
        return null;
    }

    
    public void sortDescendingByGiaThanh() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (list[i].getGiaThanh() < list[j].getGiaThanh()) {
                    CD temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    
    public void sortAscendingByTuaCD() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (list[i].getTuaCD().compareToIgnoreCase(list[j].getTuaCD()) > 0) {
                    CD temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
}