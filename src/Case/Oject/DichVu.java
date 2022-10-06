package Case.Oject;

import java.io.Serializable;

public class DichVu implements Serializable {
    private String Ten_Mon_An;
    private double Gia;

    public DichVu() {
    }

    public DichVu(String ten_Mon_An, double gia) {
        this.Ten_Mon_An = ten_Mon_An;
        this.Gia = gia;
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

    @Override
    public String toString() {
        return "Tên Món: "+ Ten_Mon_An + "\t" + "Giá :" +Gia;
    }
}
