package Case.QuanLyNguoiDung;

import Case.DangNhap_DangKy.DangNhapDangKy;

import Case.DinhDangChuoi.DinhDang;
import Case.Oject.NguoiDUng;
import Case.QuanLyNet.QuanLyNguoiDung;
import Case.Run.Run;

import java.util.Scanner;

public class MenuNguoiDung {
    Scanner scanner = new Scanner(System.in);
    QuanLyNguoiDung quanLyNguoiDung = new QuanLyNguoiDung();

    XuatHoaDon xuatHoaDon = new XuatHoaDon();
    DinhDang dinhDang = new DinhDang();

    public static MenuNguoiDung menuNguoiDung;

    public void Menu() {
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
                case 1 -> xuatHoaDon.MuaDoAn();
                case 2 -> DoiMatKhau();
                case 3 -> ThongTin();
                case 4 -> DangNhapDangKy.dangNhapDangKy.luaChon();
            }
            choice = 0;
        }
    }

    private void ThongTin() {
        quanLyNguoiDung = new QuanLyNguoiDung();
        for (NguoiDUng x : quanLyNguoiDung.getNguoiDUngs()) {
            if (x.getTen_Dang_Nhap().equals(Run.user.getTen_Dang_Nhap()) && x.getMat_Khau().equals(Run.user.getMat_Khau())) {
                System.out.println(x);
            }
        }

    }

    private void DoiMatKhau() {
        System.out.println("Nhập mật khẩu cũ");
        String pass = scanner.nextLine();
        String newPass = "";
        if (quanLyNguoiDung.checkNguoiDung(Run.user.getTen_Dang_Nhap(), pass)) {
            do {
                System.out.println("Nhập mật khẩu mới");
                newPass = scanner.nextLine();
                newPass = dinhDang.DinhDang_KyPass(newPass);
                if (pass == null) {
                    System.out.println("Nhập lại !");
                }
            } while (pass == null);
            quanLyNguoiDung.DoiMatKhau(Run.user.getTen_Dang_Nhap(), pass, newPass);
        }else {
            System.out.println("Sai mật khẩu");
        }
    }

}
