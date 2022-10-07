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
        while (check){
            quanLyDoAn.Hien_Thi();
            System.out.println("Bạn muốn mua món ?" + "\n" + "(Nhập số thứ tự để mua :#)");
            while (true) {

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 0){
                        MenuNguoiDung.menuNguoiDung = new MenuNguoiDung();
                        MenuNguoiDung.menuNguoiDung.Menu();
                    }
                    if (choice > 0 && choice <= quanLyDoAn.getDo_an_quan_nets().size()+1) {
                        dichVu = new DichVu(quanLyDoAn.getDo_an_quan_nets().get(choice-1).getTen_Mon_An(), quanLyDoAn.getDo_an_quan_nets().get(choice-1).getGia());
                        dichVus.add(dichVu);
                        break;
                    } else {
                        System.out.println("Không có món này !");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số !");
                }
            }
            System.out.println("Số lượng");
            while (true) {
                try {
                    soluong = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số");
                }
            }
            System.out.println("Bạn muốn gọi thêm món khác không ?");
            System.out.println("Nhấn y để thay đổi !");
            String x = scanner.nextLine();

            if (dinhDang.Yes_or_No(x)) {
                check = false;
            }
        }
        HoaDon hoaDon = new HoaDon(LocalDateTime.now(),dichVus, soluong, RunUser.user.getTen_Dang_Nhap());
        System.out.println(hoaDon);
        hoaDons.add(hoaDon);
        hoaDonDocVietFileNhiPhan.write(hoaDons,"C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\hoaDonAll.txt");
        quanLyNguoiDung.TruTien(RunUser.user.getTen_Dang_Nhap(), RunUser.user.getMat_Khau(), hoaDon.Tongtien());

    }
    public void TongTien(){
        hoaDons = hoaDonDocVietFileNhiPhan.reader("C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\hoaDonAll.txt");
        double sum = TinhTienMay();
        for (HoaDon x:hoaDons) {
            sum += x.Tongtien();
        }
        System.out.println("Tổng doanh thu :" + sum);
    }
    public double TinhTienMay(){
        quanLyNguoiDung = new QuanLyNguoiDung();
        double sum = 0;
        for (NguoiDUng x: quanLyNguoiDung.getNguoiDUngs()) {
            sum += x.getTien_Trong_Tai_Khoan();
        }
        return sum;
    }

}
