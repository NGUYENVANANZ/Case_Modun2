package ThiThucHanhModun2;

import ThiThucHanhModun2.SapXep.SapXepGiamDan;
import ThiThucHanhModun2.SapXep.SapXepTangDan;

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
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Giới Tính");
        String gioiTinh = scanner.nextLine();
        System.out.println("Nhập Địa Chỉ");
        String diaChi = scanner.nextLine();
        System.out.println("Nhập Điểm Trung Bình :");
        double diemTrungBinh = Double.parseDouble(scanner.nextLine());

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
            for (SinhVien x : sinhViens) {
                if (x.getMaSinhVien().equals(maSinhVien)) {
                    System.out.println("Bạn có muốn xóa sinh viên này không ?(Nhấn y để xóa)");
                    String check = scanner.nextLine();
                    if (check.equals("y")) {
                        sinhViens.remove(x);
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
        System.out.println("1. Sắp xếp điểm trung bình tăng dần");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> sinhViens.sort(new SapXepTangDan());
            case 2 -> sinhViens.sort(new SapXepGiamDan());
        }
    }

    public void docFile(){
        sinhViens = IO.reader();
    }

    public void vietFile(){
        IO.write(sinhViens);
    }
}
