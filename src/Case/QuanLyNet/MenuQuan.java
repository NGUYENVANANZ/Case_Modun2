package Case.QuanLyNet;

import Case.DangNhap_DangKy.DangNhapDangKy;

import java.util.Scanner;

public class MenuQuan {

    Scanner scanner = new Scanner(System.in);
    QuanLyDoAn quanLyDoAn = new QuanLyDoAn();

    QuanLyNguoiDung quanLyNguoiDung = new QuanLyNguoiDung();

    XuatHoaDon xuatHoaDon = new XuatHoaDon();


    public void Menu() {
        int choice = 0;
        while (true) {
            System.out.println("""
                    ==================(Xin Chào AdMin)==================
                    1. Quản lý Đồ Ăn
                    2. Quản lý Người Sử Dụng
                    3. Xem Doanh Thu
                    4. Đăng xuất
                    =====================================================""");
            while (choice > 4 || choice < 1)
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 4 || choice < 1) {
                        System.out.println("Vui lòng chọn từ 1 -> 4");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số");
                }
            switch (choice) {
                case 1 -> quanLyDoAn.show_Do_An();
                case 2 -> quanLyNguoiDung.show_Nguoi_Dung();
                case 3 -> xuatHoaDon.TongTien();
                case 4 -> DangNhapDangKy.dangNhapDangKy.luaChon();
            }
        }

    }


}
