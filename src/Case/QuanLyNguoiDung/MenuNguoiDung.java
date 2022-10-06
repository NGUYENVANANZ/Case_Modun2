package Case.QuanLyNguoiDung;

import Case.DangNhap_DangKy.DangNhapDangKy;

import Case.DinhDangChuoi.DinhDang;
import Case.Oject.NguoiDUng;
import Case.QuanLyNet.QuanLyNguoiDung;

import java.util.Scanner;

public class MenuNguoiDung {
    Scanner scanner = new Scanner(System.in);
    QuanLyNguoiDung quanLyNguoiDung = new QuanLyNguoiDung();

    XuatHoaDon xuatHoaDon = new XuatHoaDon();
    DinhDang dinhDang = new DinhDang();

    public void Menu(String user, String pass) {
        int choice = 0;
        while (true) {
            System.out.println("""
                    ==================(Xin Chào User)==================
                    1. Mua Đồ Ăn
                    2. Đổi Mật Khẩu
                    3. Xem thông tin tài khoản
                    4. Đăng xuất
                    ===========================================""");
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
                case 1 -> xuatHoaDon.MuaDoAn(user, pass);
                case 2 -> DoiMatKhau(user);
                case 3 -> ThongTin(user, pass);
                case 4 -> DangNhapDangKy.dangNhapDangKy.luaChon();
            }
            choice = 0;
        }
    }

    private void ThongTin(String user, String pass) {
        for (NguoiDUng x : quanLyNguoiDung.getNguoiDUngs()) {
            if (x.getTen_Dang_Nhap().equals(user) && x.getMat_Khau().equals(pass)) {
                System.out.println(x);
            }
        }

    }

    private void DoiMatKhau(String user) {
        System.out.println("Nhập mật khẩu cũ");
        String pass = scanner.nextLine();
        String newPass = "";
        if (quanLyNguoiDung.checkNguoiDung(user, pass)) {
            do {
                System.out.println("Nhập mật khẩu mới");
                newPass = scanner.nextLine();
                newPass = dinhDang.DinhDang_KyPass(newPass);
                if (pass == null) {
                    System.out.println("Nhập lại !");
                }
            } while (pass == null);
            quanLyNguoiDung.DoiMatKhau(user, pass, newPass);
        }
    }

}
