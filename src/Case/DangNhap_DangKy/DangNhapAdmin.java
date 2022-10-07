package Case.DangNhap_DangKy;

import Case.QuanLyNet.MenuQuan;

import java.util.Scanner;

public class DangNhapAdmin extends Thread {
    Scanner scanner = new Scanner(System.in);
    MenuQuan quanLyNet;

    @Override
    public void run() {
        DangNhap();
    }

    public void DangNhap(){
        System.out.println("==============(!LOGIN!)==================");
        System.out.println("Nhập userName :");
        String username = scanner.nextLine();
        System.out.println("Nhập passWord");
        String pass = scanner.nextLine();
        if (username.equals("Admin") && pass.equals("123")) {
            quanLyNet = new MenuQuan();
            quanLyNet.Menu();
        }
    }
}
