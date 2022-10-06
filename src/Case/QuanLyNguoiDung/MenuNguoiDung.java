package Case.QuanLyNguoiDung;

import Case.DangNhap_DangKy.DangNhapDangKy;
import Case.Oject.HoaDon;
import Case.QuanLyNet.QuanLyDoAn;
import Case.QuanLyNet.QuanLyNguoiDung;
import Case.QuanLyNet.XuatHoaDon;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuNguoiDung {
    Scanner scanner = new Scanner(System.in);
    QuanLyNguoiDung quanLyNguoiDung = new QuanLyNguoiDung();

    QuanLyDoAn quanLyDoAn = new QuanLyDoAn();
    XuatHoaDon xuatHoaDon = new XuatHoaDon();

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
                case 1 -> MuaDoAn(user, pass);
                case 2 -> DoiMatKhau(user);
                case 3 -> ThongTin(user, pass);
                case 4 -> DangNhapDangKy.dangNhapDangKy.luaChon();
            }
        }
    }

    private void ThongTin(String user, String pass) {
        quanLyNguoiDung.HienThiThongTin(user, pass);
    }

    private void DoiMatKhau(String user) {
        System.out.println("Nập mật khẩu cũ");
        String pass = scanner.nextLine();
        if (quanLyNguoiDung.checkNguoiDung(user, pass)) {
            System.out.println("Nhập mật khẩu mói");
            String newPass = scanner.nextLine();
            quanLyNguoiDung.DoiMatKhau(user, pass, newPass);
        }
    }

    private void MuaDoAn(String user, String pass) {
        boolean check;
        double sum = 0;
        StringBuilder noiDUngHoaDon = new StringBuilder("Hóa Đơn: \n");
        int[] slMua = new int[quanLyDoAn.getDo_an_quan_nets().size()];

        do {
            quanLyDoAn.Hien_Thi();
            System.out.println("Bạn muốn mua món ?");
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 0 && choice < quanLyDoAn.getDo_an_quan_nets().size() + 1) {
                        break;
                    } else {
                        System.out.println("Không có món này !");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số !");
                }
            }
            System.out.println("Số lượng");
            int soluong;
            while (true) {
                try {
                    soluong = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số");
                }
            }
            slMua[choice - 1] += soluong;
            System.out.println("Bạn muốn gọi thêm món khác không ? y/n");
            String x = scanner.nextLine();
            check = x.equals("y");
        } while (check);
        HoaDon hoaDon = null;

        for (int i = 0; i < slMua.length; i++) {
            if (slMua[i] > 0) {
                hoaDon = new HoaDon(LocalDateTime.now(), quanLyDoAn.getDo_an_quan_nets().get(i).getTen_Mon_An(),slMua[i], quanLyDoAn.getDo_an_quan_nets().get(i).getGia(), user);
                xuatHoaDon.Them(hoaDon);
                noiDUngHoaDon.append(quanLyDoAn.getDo_an_quan_nets().get(i).getTen_Mon_An()).append(": ").append(slMua[i]).append("\n");
                sum += slMua[i] * quanLyDoAn.getDo_an_quan_nets().get(i).getGia();
            }
        }

        if (hoaDon != null) {
            System.out.println(hoaDon.getDate());
        }
        noiDUngHoaDon.append("Tổng : ").append(sum);
        System.out.println(noiDUngHoaDon);
        quanLyNguoiDung.TruTien(user, pass, sum);
    }
}
