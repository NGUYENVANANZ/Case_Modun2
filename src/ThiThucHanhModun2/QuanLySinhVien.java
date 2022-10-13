package ThiThucHanhModun2;

import ThiThucHanhModun2.SapXep.TangDan;
import ThiThucHanhModun2.SapXep.GiamDan;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySinhVien {
    Scanner scanner = new Scanner(System.in);
    ArrayList<SinhVien> sinhViens = new ArrayList<>();

    public SinhVien nhapThongTin() {
        System.out.println("Nhập Mã Sinh Viên :");
        String maSinhVien = scanner.nextLine();
        System.out.println("Nhập Họ Và Tên Sinh Viên :");
        String hoVaTen = scanner.nextLine();
        System.out.println("Nhập Tuổi :");
        int tuoi;
        while (true){
            try {
                do {
                    tuoi = Integer.parseInt(scanner.nextLine());
                    if (tuoi < 0 || tuoi > 100){
                        System.out.println("Đừng có nhâyy");
                    }
                }while (tuoi < 0 || tuoi > 100);

                break;
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số !");
            }
        }



        System.out.println("Nhập Giới Tính");
        String gioiTinh = scanner.nextLine();
        System.out.println("Nhập Địa Chỉ");
        String diaChi = scanner.nextLine();
        System.out.println("Nhập Điểm Trung Bình :");
        double diemTrungBinh;
        while (true){
            try {
                do {
                    diemTrungBinh= Double.parseDouble(scanner.nextLine());
                    if (diemTrungBinh < 0 || diemTrungBinh > 10){
                        System.out.println("Điểm trung bình chỉ từ 0 đến 10");
                    }
                }while (diemTrungBinh < 0 || diemTrungBinh > 10);
                break;
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số !");
            }
        }


        return new SinhVien(maSinhVien, hoVaTen, tuoi, gioiTinh, diaChi, diemTrungBinh);
    }

    public void hienThi() {
        for (SinhVien x : sinhViens) {
            System.out.println(x.toString());
        }
    }

    public void themSinhVien() {
        SinhVien sinhVien = nhapThongTin();
        sinhViens.add(sinhVien);
    }

    public void capNhat() {
        int choice = 0;
        while (choice == 0) {
            System.out.println("Nhập Mã Sinh Viên Muốn Cập Nhật");
            String maSinhVien = scanner.nextLine();
            if (maSinhVien.equals("")) {
                break;
            }
            for (int i = 0; i < sinhViens.size(); i++) {
                if (sinhViens.get(i).getMaSinhVien().equals(maSinhVien)) {
                    sinhViens.set(i, nhapThongTin());
                    ++choice;
                }
            }
            if (choice == 0) {
                System.out.println("Không tìm được sinh viên với mã sinh viên trên !");
            }
        }

    }

    public void xoaSinhVien() {
        int choice = 0;
        while (choice == 0) {
            System.out.println("Nhập Mã Sinh Viên Muốn Xóa");
            String maSinhVien = scanner.nextLine();
            if (maSinhVien.equals("")) {
                break;
            }
            for (int i = 0; i < sinhViens.size(); i++) {
                if (sinhViens.get(i).getMaSinhVien().equals(maSinhVien)) {
                    System.out.println("Bạn có muốn xóa sinh viên này không ?(Nhấn y để xóa)");
                    String check = scanner.nextLine();
                    if (check.equals("y") || check.equals("Y")) {
                        sinhViens.remove(sinhViens.get(i));
                    }
                    ++choice;
                }
            }
            if (choice == 0) {
                System.out.println("Không tìm được sinh viên với mã sinh viên trên !");
            }
        }
    }

    public void sapXep() {
        System.out.println("Bạn muốn sắp xếp theo hướng nào ?");
        System.out.println("1. Sắp xếp điểm trung bình giảm dần");
        System.out.println("2. Sắp xếp điểm trung bình tăng dần");
        System.out.println("3. Hủy bỏ sắp xếp");
        int choice;
        while (true){
            try {
                do {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > 3){
                        System.out.println("Chọn 1 hoặc 2");
                    }
                }while (choice < 1 || choice > 3);
               break;
            }catch (NumberFormatException e){
                System.out.println("Vui Lòng Nhập Số");
            }
        }


        switch (choice) {
            case 1 -> sinhViens.sort(new GiamDan());
            case 2 -> sinhViens.sort(new TangDan());

        }
    }

    public void docFile(){
        sinhViens = IO.reader();
        System.out.println("Đọc File Thành Công");
    }

    public void vietFile(){
        IO.write(sinhViens);
        System.out.println("Viết File Thành Công");
    }
}
