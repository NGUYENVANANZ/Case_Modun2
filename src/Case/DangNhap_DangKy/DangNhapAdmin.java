package Case.DangNhap_DangKy;

import Case.QuanLyNet.MenuQuan;

import java.util.Scanner;

public class DangNhapAdmin {
    Scanner scanner = new Scanner(System.in);

    public static DangNhapAdmin dangNhapAdmin;
    MenuQuan quanLyNet;
    public void Dang_Nhap() {

            System.out.println("==============(!LOGIN_ADMIN!)==================");
            System.out.println("Nhập userName :");
            String user = scanner.nextLine();
            System.out.println("Nhập passWord");
            String pass = scanner.nextLine();
            if (user.equals("Admin") && pass.equals("123")) {
                quanLyNet = new MenuQuan();
                quanLyNet.Menu();
            }

    }
}
