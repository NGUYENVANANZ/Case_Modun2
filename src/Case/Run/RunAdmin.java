package Case.Run;


import Case.DangNhap_DangKy.DangNhapAdmin;

public class RunAdmin extends Thread {

    public static void main(String[] args) {
        DangNhapAdmin.dangNhapAdmin = new DangNhapAdmin();
        DangNhapAdmin.dangNhapAdmin.Dang_Nhap();
    }
}