package Case.QuanLyNet;

import Case.IO.DocVietFileNhiPhan;
import Case.Oject.DichVu;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyDoAn {
    Scanner scanner = new Scanner(System.in);
    DocVietFileNhiPhan<DichVu> docVietFile = new DocVietFileNhiPhan<>();
    ArrayList<DichVu> do_an_quan_nets = docVietFile.reader("C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\doAn.txt");

    public ArrayList<DichVu> getDo_an_quan_nets() {
        return do_an_quan_nets;
    }

    public void show_Do_An() {
        Hien_Thi();
        System.out.println("Bạn Muốn Thay Đổi Gì Không?");
        System.out.println("Nhấp 'y' để thực hiện thay đổi");
        String choice = scanner.nextLine();
        if (choice.equals("y")) {
            ChucNang();
        }
    }

    public void ChucNang() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("""
                    ==========================================
                    1. Xem Menu
                    2. Thêm
                    3. Sửa
                    4. Xóa
                    5.Quay Lại Menu Chính
                    ===========================================""");
            try {
                do {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 5 || choice < 0) {
                        System.out.println("Vui lòng chọn từ 1 -> 4");
                    }
                } while (choice > 5 || choice < 0);

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số !");
            }

            switch (choice) {
                case 1 -> Hien_Thi();
                case 2 -> Them();
                case 3 -> Sua();
                case 4 -> Xoa();
            }
        }

    }

    public void Them() {
        double gia;
        String tenMon;
        System.out.println("Nhập Món");
        do {
            tenMon = scanner.nextLine();
            if (XetTrungSanPham(tenMon) == -1){
                System.out.println("Đã có trong menu");
            }
        }while (XetTrungSanPham(tenMon) == -1);

        System.out.println("Nhập Giá");
        while (true) {
            try {
                gia = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }
        System.out.println("Thêm món thành công !");

        do_an_quan_nets.add(new DichVu(tenMon, gia));
        docVietFile.write(do_an_quan_nets, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\doAn.txt");
    }

    public void Sua() {
        int choice;
        System.out.println("Bạn muốn sửa món?");
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (0 < choice && choice < do_an_quan_nets.size() + 1) {
                    break;
                }else {
                    System.out.println("Không có món này !");
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số !");
            }
        }

        int index = choice - 1;
        double gia;
        for (int i = 0; i < do_an_quan_nets.size(); i++) {
            if (i == index) {
                System.out.println("Nhập Món");
                String mon = scanner.nextLine();
                System.out.println("Nhập Giá");
                while (true) {
                    try {
                        gia = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập số");
                    }
                }
                DichVu doAnQuanNet = new DichVu(mon, gia);
                do_an_quan_nets.set(i, doAnQuanNet);
            }
        }
        System.out.println("Sửa thành công !");

        docVietFile.write(do_an_quan_nets, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\doAn.txt");
    }

    public void Xoa() {
        int choice;
        System.out.println("Bạn muốn bỏ món?");
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (0 < choice && choice < do_an_quan_nets.size() + 1) {
                    break;
                }else {
                    System.out.println("Không có món này !");
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số !");
            }
        }
        int index = choice - 1;
        for (int i = 0; i < do_an_quan_nets.size(); i++) {
            if (i == index) {
                do_an_quan_nets.remove(i);
            }
        }
        System.out.println("Xóa thành công !");
        docVietFile.write(do_an_quan_nets, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\doAn.txt");
    }

    public void Hien_Thi() {
        int i = 1;
        for (DichVu x : do_an_quan_nets) {
            System.out.println(i + ":" + x);
            ++i;
        }
        docVietFile.write(do_an_quan_nets, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\doAn.txt");
    }

    public int XetTrungSanPham(String name){
        for (DichVu x : do_an_quan_nets) {
            if (x.getTen_Mon_An().equals(name)) {
                return 1;
            }
        }
        return -1;
    }


}
