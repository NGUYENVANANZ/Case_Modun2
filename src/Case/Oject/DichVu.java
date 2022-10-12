package Case.Oject;

import java.io.Serializable;

public class DichVu implements Serializable {
    private String Ten_Mon_An;
    private double Gia;

    private int soLuong;

    public DichVu() {
    }

    public DichVu(String ten_Mon_An, double gia, int soLuong) {
        Ten_Mon_An = ten_Mon_An;
        Gia = gia;
        this.soLuong = soLuong;
    }

    public String getTen_Mon_An() {
        return Ten_Mon_An;
    }

    public void setTen_Mon_An(String ten_Mon_An) {
        this.Ten_Mon_An = ten_Mon_An;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        this.Gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "Tên Món: "+ Ten_Mon_An + "\t" + "Giá :" +Gia +"\t" + "Số Lượng :" + soLuong+ "\n";
    }
}
