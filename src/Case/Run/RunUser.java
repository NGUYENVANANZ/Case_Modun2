package Case.Run;


import Case.DangNhap_DangKy.DangNhapDangKy;
import Case.Oject.NguoiDUng;
import Case.QuanLyNguoiDung.MenuNguoiDung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class RunUser extends Thread{

    public static NguoiDUng user = new NguoiDUng();

    static MenuNguoiDung menuNguoiDung = new MenuNguoiDung();
    @Override
    public void run() {
        Socket socket = menuNguoiDung.getSocket();
        BufferedReader br = null;
        while (true) {
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String reply = null;
            try {
                assert br != null;
                reply = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(reply);
        }
    }

    public static void main(String[] args) {
        menuNguoiDung.start();
        RunUser runUser = new RunUser();
        runUser.start();
    }
}
