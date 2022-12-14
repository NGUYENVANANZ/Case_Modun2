package Case.QuanLyNguoiDung;

import Case.DinhDangChuoi.DinhDang;
import Case.IO.DocVietFileNhiPhan;
import Case.Oject.DichVu;
import Case.Oject.HoaDon;
import Case.Oject.NguoiDUng;
import Case.QuanLyNet.QuanLyDoAn;
import Case.QuanLyNet.QuanLyNguoiDung;
import Case.Run.RunUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class XuatHoaDon {
    Scanner scanner = new Scanner(System.in);

    QuanLyDoAn quanLyDoAn = new QuanLyDoAn();
    QuanLyNguoiDung quanLyNguoiDung = new QuanLyNguoiDung();
    DinhDang dinhDang = new DinhDang();


    DocVietFileNhiPhan<HoaDon> hoaDonDocVietFileNhiPhan = new DocVietFileNhiPhan<>();

    ArrayList<HoaDon> hoaDons = hoaDonDocVietFileNhiPhan.reader("C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\hoaDonAll.txt");


    public void MuaDoAn() {
        hoaDons = hoaDonDocVietFileNhiPhan.reader("C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\hoaDonAll.txt");
        boolean check = true;
        ArrayList<DichVu> dichVus = new ArrayList<>();
        DichVu dichVu;
        int soluong = 0;
        int choice = 0;
        HoaDon hoaDon = new HoaDon();
        double tongTienTru = 0;
        while (check) {
            quanLyDoAn.Hien_Thi();
            System.out.println("Bạn muốn mua món ?" + "\n" + "(Nhập số thứ tự để mua :#)");
            while (true) {

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 0) {
                        MenuNguoiDung.menuNguoiDung = new MenuNguoiDung();
                        MenuNguoiDung.menuNguoiDung.Menu();
                    }
                    if (choice < 0 && choice > quanLyDoAn.getDo_an_quan_nets().size() + 1) {
                        System.out.println("Không có món này !");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số !");
                }
            }
            double checkgia;
            System.out.println("Số lượng");
            while (true) {
                try {
                    do {
                        do {
                            soluong = Integer.parseInt(scanner.nextLine());
                            checkgia = quanLyDoAn.getDo_an_quan_nets().get(choice - 1).getGia() * soluong;
                        } while (!quanLyNguoiDung.CheckTienTaiKhoan(RunUser.user.getTen_Dang_Nhap(), RunUser.user.getMat_Khau(), checkgia));
                    } while (!TruSoLuong(soluong, quanLyDoAn.getDo_an_quan_nets().get(choice - 1).getTen_Mon_An()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số");
                }
            }

            dichVu = new DichVu(quanLyDoAn.getDo_an_quan_nets().get(choice - 1).getTen_Mon_An(), quanLyDoAn.getDo_an_quan_nets().get(choice - 1).getGia(), soluong);
            dichVus.add(dichVu);
            System.out.println("Bạn muốn gọi thêm món khác không ?");
            System.out.println("Nhấn y để mua thêm !");
            String x = scanner.nextLine();
            if (dinhDang.Yes_or_No(x)) {
                check = false;
            }
            tongTienTru += dichVu.getGia()*dichVu.getSoLuong();
            if (!quanLyNguoiDung.CheckTienTaiKhoan(RunUser.user.getTen_Dang_Nhap(), RunUser.user.getMat_Khau(), tongTienTru)){
                check = false;
            }
        }
        hoaDon = new HoaDon(LocalDateTime.now(), dichVus, soluong, RunUser.user.getTen_Dang_Nhap());
        System.out.println(hoaDon);
        quanLyNguoiDung.TruTien(RunUser.user.getTen_Dang_Nhap(), RunUser.user.getMat_Khau(), tongTienTru);

        hoaDons.add(hoaDon);


        hoaDonDocVietFileNhiPhan.write(hoaDons, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\hoaDonAll.txt");


    }

    public void TongTien() {
        hoaDons = hoaDonDocVietFileNhiPhan.reader("C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\hoaDonAll.txt");
        double sum = TinhTienMay();
        for (HoaDon x : hoaDons) {
            sum += x.Tongtien();
        }
        System.out.println("Tổng doanh thu :" + sum);
    }

    public double TinhTienMay() {
        quanLyNguoiDung = new QuanLyNguoiDung();
        double sum = 0;
        for (NguoiDUng x : quanLyNguoiDung.getNguoiDUngs()) {
            sum += x.getTien_Trong_Tai_Khoan();
        }
        return sum;
    }

    public boolean TruSoLuong(int soluong, String name) {
        int new_soluong;
        for (int i = 0; i < quanLyDoAn.getDo_an_quan_nets().size(); i++) {
            if (quanLyDoAn.getDo_an_quan_nets().get(i).getTen_Mon_An().equals(name)) {
                new_soluong = quanLyDoAn.getDo_an_quan_nets().get(i).getSoLuong() - soluong;
                if (new_soluong >= 0) {
                    quanLyDoAn.getDo_an_quan_nets().get(i).setSoLuong(new_soluong);
                    quanLyDoAn.getDocVietFile().write(quanLyDoAn.getDo_an_quan_nets(), "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\doAn.txt");
                    return true;
                } else {
                    System.out.println("Hết hàng !");
                }
            }
        }
        return false;
    }
}
