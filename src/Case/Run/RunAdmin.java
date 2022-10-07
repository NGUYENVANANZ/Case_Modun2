package Case.Run;

import Case.DangNhap_DangKy.DangNhapDangKy;
import Case.Oject.NguoiDUng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class RunAdmin extends Thread{
    static ServerSocket sever;
    static {
        try {
            sever = new ServerSocket(2004);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static Socket socket;

    static {
        try {
            socket = sever.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String reply = br.readLine();
                System.out.println(reply);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static NguoiDUng admin = new NguoiDUng();
    public static void main(String[] args) {
        DangNhapDangKy.dangNhapDangKy = new DangNhapDangKy();
        DangNhapDangKy.dangNhapDangKy.luaChon();
    }
}
