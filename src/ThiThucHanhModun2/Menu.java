package ThiThucHanhModun2;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    QuanLySinhVien quanLySinhVien = new QuanLySinhVien();
    public void menu(){
        boolean check = true;
        while (check){
            System.err.println(" --------------------CHƯƠNG TRÌNH QUẢN LÍ SINH VIÊN---------------------------\n" );
            System.out.println( "Chọn chức năng theo số (để tiếp tục)!\n" +
                    "1. Xem danh sách nhân viên\n" +
                    "2. Thêm mới \n" +
                    "3. Cập nhật\n" +
                    "4. Xóa\n" +
                    "5. Sắp xếp\n" +
                    "6. Đọc từ file\n" +
                    "7. Ghi vào file\n" +
                    "8. Thoát \n" +
                    "Nhập lựa chọn của bạn: ");

            int choice = 0;
            while (true){
                try {
                    do {
                        choice = Integer.parseInt(scanner.nextLine());
                        if (choice < 1 || choice > 8){
                            System.out.println("VUI LÒNG CHỌN TỪ 1 -> 8");
                        }
                    }while (choice < 1 || choice > 8);

                    break;
                }catch (NumberFormatException e){
                    System.out.println("VUI LÒNG NHẬP SỐ !");
                }
            }


            switch (choice) {
                case 1 -> quanLySinhVien.hienThi();
                case 2 -> quanLySinhVien.themSinhVien();
                case 3 -> quanLySinhVien.capNhat();
                case 4 -> quanLySinhVien.xoaSinhVien();
                case 5 -> quanLySinhVien.sapXep();
                case 6 -> quanLySinhVien.docFile();
                case 7 -> quanLySinhVien.vietFile();
                case 8 -> check = false;
            }
        }
        System.out.println("Cảm Mơn Quý Khách !");
    }
}
