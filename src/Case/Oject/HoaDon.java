package Case.Oject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class HoaDon implements Serializable {
    private LocalDateTime date;

    private ArrayList<DichVu> sanpham;
    private int soLuong;

    private String tenKhach;

    public HoaDon() {
    }

    public HoaDon(LocalDateTime date, ArrayList<DichVu> sanpham, int soLuong, String tenKhach) {
        this.date = date;
        this.sanpham = sanpham;
        this.soLuong = soLuong;
        this.tenKhach = tenKhach;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }



    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }


    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public double Tongtien(){
        double sum = 0;
        for (DichVu x:sanpham) {
            sum += x.getGia()*soLuong;
        }
        return sum;
    }



    @Override
    public String toString() {
        return date +": " + tenKhach +"\n"+ sanpham +"\n"+ "Tổng hóa đơn là :" + Tongtien();
    }
}
