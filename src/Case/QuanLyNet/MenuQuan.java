package Case.QuanLyNet;

import Case.QuanLyNguoiDung.XuatHoaDon;
import Case.Run.RunAdmin;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MenuQuan{

    Scanner scanner = new Scanner(System.in);
    QuanLyDoAn quanLyDoAn = new QuanLyDoAn();

    QuanLyNguoiDung quanLyNguoiDung = new QuanLyNguoiDung();

    XuatHoaDon xuatHoaDon = new XuatHoaDon();

    RunAdmin runAdmin;

    public void Menu() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("""
                    ==================(Xin Chào AdMin)==================
                    1. Quản lý Đồ Ăn
                    2. Quản lý Người Sử Dụng
                    3. Xem Doanh Thu
                    4.Chat
                    5. Đăng xuất
                    =====================================================""");
            while (choice > 5 || choice < 1)
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 5) {
                        return;
                    }
                    if (choice > 5 || choice < 1) {
                        System.out.println("Vui lòng chọn từ 1 -> 4");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số");
                }
            switch (choice) {
                case 1 -> quanLyDoAn.show_Do_An();
                case 2 -> quanLyNguoiDung.show_Nguoi_Dung();
                case 3 -> xuatHoaDon.TongTien();
                case 4 -> NhanTinNhan();
            }
            choice = 0;
        }

    }

    public void NhanTinNhan(){
        runAdmin = new RunAdmin();
        runAdmin.handleChat();
    }
}
