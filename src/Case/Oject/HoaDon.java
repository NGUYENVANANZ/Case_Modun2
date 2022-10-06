package Case.Oject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class HoaDon implements Serializable {
    private LocalDateTime date;
    private String tenSanPham;
    private int soLuong;
    private double donGia;
    private String tenKhach;

    public HoaDon() {
    }

    public HoaDon(LocalDateTime date, String tenSanPham, int soLuong, double donGia, String tenKhach) {
        this.date = date;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tenKhach = tenKhach;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public double tinhTongTien(){
        return soLuong*donGia;
    }

    @Override
    public String toString() {
        return date + " : "+ tenKhach +" : "+ tenSanPham +", "+ soLuong +", "+ donGia;
    }
}
