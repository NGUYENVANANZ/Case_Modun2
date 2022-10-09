package Case.Run;

import Case.DangNhap_DangKy.DangNhapAdmin;
import Case.DangNhap_DangKy.DangNhapDangKy;
import Case.Oject.NguoiDUng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RunAdmin extends Thread{
    static ServerSocket sever;

    static {
        try {
            sever = new ServerSocket(2006);
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

    public void handleChat() {
        Scanner scanner = new Scanner(System.in);
        PrintStream ps = null;
        try {
            ps = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inbox = "";
        System.out.println("NHẬP TIN NHẮN : ");
        inbox = scanner.nextLine();
        assert ps != null;
        ps.println("Chủ Quán : " + inbox);
    }

    public static void main(String[] args) {
        DangNhapAdmin dangNhapAdmin = new DangNhapAdmin();
        RunAdmin runAdmin = new RunAdmin();
        runAdmin.start();
        dangNhapAdmin.start();
    }
}
