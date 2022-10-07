package Case.QuanLyNet;

import Case.DinhDangChuoi.DinhDang;
import Case.IO.DocVietFileNhiPhan;
import Case.Oject.NguoiDUng;
import Case.Run.Run;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNguoiDung {
    Scanner scanner = new Scanner(System.in);
    DocVietFileNhiPhan<NguoiDUng> docVietFile = new DocVietFileNhiPhan<>();
    DinhDang dinhDang = new DinhDang();
    ArrayList<NguoiDUng> nguoiDUngs = docVietFile.reader("C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\Nguoidung.txt");


    public ArrayList<NguoiDUng> getNguoiDUngs() {
        return nguoiDUngs;
    }

    public void show_Nguoi_Dung() {
        Hien_Thi();
        System.out.println("Bạn Muốn Thay Đổi Gì Không? y/n ");
        String choice = scanner.nextLine();
        if (!dinhDang.Yes_or_No(choice)) {
            ChucNang();
        }
    }

    public void ChucNang() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("""
                    ==========================================
                    1. Xem tài khoản người dùng
                    2. Thêm Tài Khoản
                    3. Nạp Tiền
                    4. Xóa Tài Khoản
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
                case 3 -> NapTien();
                case 4 -> Xoa();
            }
        }

    }

    private void NapTien() {
        int choice;
        System.out.println("Chọn tài khoản muốn nạp? \n (Nhập Số thứ tự tài khoản)");

        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (0 < choice && choice < nguoiDUngs.size() + 1) {
                    break;
                } else {
                    System.out.println("Không tồn tại tài khoản này !");
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số !");
            }
        }
        int index = choice - 1;
        double tien_Trong_Tai_Khoan;
        double tien_Nap;
        for (int i = 0; i < nguoiDUngs.size(); i++) {
            if (i == index) {
                System.out.println("Nạp vào :");
                while (true) {
                    try {
                        tien_Nap = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập số");
                    }
                }
                tien_Trong_Tai_Khoan = tien_Nap + nguoiDUngs.get(i).getTien_Trong_Tai_Khoan();
                nguoiDUngs.get(i).setTien_Trong_Tai_Khoan(tien_Trong_Tai_Khoan);
            }
        }
        System.out.println("Nạp thành công !");
        docVietFile.write(nguoiDUngs, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\Nguoidung.txt");
    }

    private void Xoa() {
        int choice;
        System.out.println("Bạn muốn xóa tài khoản nào?");
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (0 < choice && choice < nguoiDUngs.size() + 1) {

                    break;
                } else {
                    System.out.println("Không có món này !");
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số !");
            }
        }
        int index = choice - 1;
        for (int i = 0; i < nguoiDUngs.size(); i++) {
            if (i == index) {
                nguoiDUngs.remove(i);
            }
        }
        System.out.println("Xóa thành công !");
        docVietFile.write(nguoiDUngs, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\Nguoidung.txt");
    }


    public void Hien_Thi() {
        int i = 1;
        for (NguoiDUng x : nguoiDUngs) {
            System.out.println(i + ":" + x);
            ++i;
        }
    }

    public void Them() {
        String user;
        do {
            System.out.println("Nhập userName :");
            user = scanner.nextLine();
            user = dinhDang.DinhDang_KyUser(user);
            if (user == null || XetTrungTaiKhoan(user) == -1) {
                System.out.println("Nhập lại !");
            }
        } while (user == null || XetTrungTaiKhoan(user) == -1);

        String pass;
        do {
            System.out.println("Nhập passWord");
            pass = scanner.nextLine();
            pass = dinhDang.DinhDang_KyPass(pass);
            if (pass == null) {
                System.out.println("Nhập lại !");
            }
        } while (pass == null);
        NguoiDUng nguoiDUng = new NguoiDUng(user, pass, 1000);
        nguoiDUngs.add(nguoiDUng);
        docVietFile.write(nguoiDUngs, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\Nguoidung.txt");
    }

    public void themNguoiDung() {

        String user;
        do {
            System.out.println("Nhập userName :");
            user = scanner.nextLine();
            user = dinhDang.DinhDang_KyUser(user);
            if (user == null) {
                System.out.println("Nhập lại !");
            }
        } while (user == null || XetTrungTaiKhoan(user) == -1);

        String pass;
        do {
            System.out.println("Nhập passWord");
            pass = scanner.nextLine();
            pass = dinhDang.DinhDang_KyPass(pass);
            if (pass == null) {
                System.out.println("Nhập lại !");
            }
        } while (pass == null);
        boolean check = true;
        while (check) {
            System.out.println("Xác nhận passWord");
            String passx = scanner.nextLine();
            if (!pass.equals(passx)) {
                System.out.println("Xác nhận thất bại !" + "\n" + "Vui lòng xác nhận lại");
            } else {
                System.out.println("Tạo tài khoản thành công");
                check = false;
            }
        }
        NguoiDUng nguoiDUng = new NguoiDUng(user, pass, 1000);
        nguoiDUngs.add(nguoiDUng);
        docVietFile.write(nguoiDUngs, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\Nguoidung.txt");
    }

    public boolean checkNguoiDung(String user, String pass) {
        for (NguoiDUng x : nguoiDUngs) {
            if (x.getTen_Dang_Nhap().equals(user) && x.getMat_Khau().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public void DoiMatKhau(String user, String pass, String newpass) {

        for (int i = 0; i < nguoiDUngs.size(); i++) {
            if (nguoiDUngs.get(i).getTen_Dang_Nhap().equals(user) && nguoiDUngs.get(i).getMat_Khau().equals(pass)) {
                NguoiDUng nguoiDUng = new NguoiDUng(user, newpass, nguoiDUngs.get(i).getTien_Trong_Tai_Khoan());
                nguoiDUngs.set(i, nguoiDUng);
                Run.user = nguoiDUng;
            }
        }

        docVietFile.write(nguoiDUngs, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\Nguoidung.txt");
    }

    public void TruTien(String user, String pass, double sum) {
        for (NguoiDUng x : nguoiDUngs) {
            if (x.getTen_Dang_Nhap().equals(user) && x.getMat_Khau().equals(pass)) {
                double Tien_Trong_Tai_Khoan = x.getTien_Trong_Tai_Khoan() - sum;
                if (Tien_Trong_Tai_Khoan < 0) {
                    System.out.println("Không thể thực hiện giao dịch");
                } else {
                    x.setTien_Trong_Tai_Khoan(Tien_Trong_Tai_Khoan);
                }
            }
        }

        docVietFile.write(nguoiDUngs, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\Nguoidung.txt");
    }


    public int XetTrungTaiKhoan(String name) {
        for (NguoiDUng x : nguoiDUngs) {
            if (x.getTen_Dang_Nhap().equals(name)) {
                System.out.println("Tài khoản đã tồn tại");
                return -1;
            }
        }
        return 1;
    }
}
