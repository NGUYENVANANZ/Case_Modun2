package Case.Oject;

import java.io.Serializable;

public class NguoiDUng implements Serializable {
    private String ten_Dang_Nhap;
    private String mat_Khau;

    private double tien_Trong_Tai_Khoan;

    public NguoiDUng() {
    }

//    public NguoiDUng(String ten_Dang_Nhap, String mat_Khau) {
//        this.ten_Dang_Nhap = ten_Dang_Nhap;
//        this.mat_Khau = mat_Khau;
//    }

    public NguoiDUng(String ten_Dang_Nhap, String mat_Khau, double tien_Trong_Tai_Khoan) {
        this.ten_Dang_Nhap = ten_Dang_Nhap;
        this.mat_Khau = mat_Khau;
        this.tien_Trong_Tai_Khoan = tien_Trong_Tai_Khoan;
    }

    public double getTien_Trong_Tai_Khoan() {
        return tien_Trong_Tai_Khoan;
    }

    public void setTien_Trong_Tai_Khoan(double tien_Trong_Tai_Khoan) {
        this.tien_Trong_Tai_Khoan = tien_Trong_Tai_Khoan;
    }

    public String getTen_Dang_Nhap() {
        return ten_Dang_Nhap;
    }

    public void setTen_Dang_Nhap(String ten_Dang_Nhap) {
        this.ten_Dang_Nhap = ten_Dang_Nhap;
    }

    public String getMat_Khau() {
        return mat_Khau;
    }

    public void setMat_Khau(String mat_Khau) {
        this.mat_Khau = mat_Khau;
    }

    @Override
    public String toString() {
        return "Tài Khoản: "+ ten_Dang_Nhap + "\t" + "Mật Khẩu :" +mat_Khau + "\t" +tien_Trong_Tai_Khoan+ "VND" ;
    }
}
