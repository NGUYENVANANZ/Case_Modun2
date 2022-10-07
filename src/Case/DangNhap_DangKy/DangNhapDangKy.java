package Case.DangNhap_DangKy;

import Case.Oject.NguoiDUng;
import Case.QuanLyNet.MenuQuan;
import Case.QuanLyNet.QuanLyNguoiDung;
import Case.QuanLyNguoiDung.MenuNguoiDung;
import Case.Run.Run;

import java.util.Scanner;

public class DangNhapDangKy {
    Scanner scanner = new Scanner(System.in);
    MenuQuan quanLyNet;

    MenuNguoiDung menuNguoiDung = new MenuNguoiDung();
    QuanLyNguoiDung quanLyNguoiDung = new QuanLyNguoiDung();
    public static DangNhapDangKy dangNhapDangKy;

    public void luaChon() {
        System.out.println(
                """
                        =================================
                        1. Đăng Nhập
                        2. Đăng Ký
                        3. Thoát
                        ================================="""
        );
        int choice = 0;
        while (choice > 3 || choice < 1)
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 3 || choice < 1) {
                    System.out.println("Vui lòng chọn từ 1 -> 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        switch (choice) {
            case 1 -> Dang_Nhap();
            case 2 -> Dang_Ky();
            case 3 -> System.exit(0);
        }
    }


    public void Dang_Nhap() {

        System.out.println("==============(!LOGIN!)==================");
        while (true){
            System.out.println("Nhập userName :");
            String username = scanner.nextLine();
            System.out.println("Nhập passWord");
            String pass = scanner.nextLine();
            if (username.equals("Admin") && pass.equals("123")) {
                quanLyNet = new MenuQuan();
                quanLyNet.Menu();
            }else {
                if (quanLyNguoiDung.checkNguoiDung(username, pass)) {
                    System.out.println("Đăng nhập thành công !");
                    Run.user.setTen_Dang_Nhap(username);
                    Run.user.setMat_Khau(pass);
                    menuNguoiDung.Menu();
                } else {
                    System.out.println("Đăng nhập thất bại !");
                }
            }
        }
    }

    public void Dang_Ky() {
        quanLyNguoiDung.themNguoiDung();
        luaChon();
    }
}
