package Case.Run;


import Case.DangNhap_DangKy.DangNhapDangKy;

public class RunUser {
    public static void main(String[] args) {
        DangNhapDangKy.dangNhapDangKy = new DangNhapDangKy();
        DangNhapDangKy.dangNhapDangKy.luaChon();
    }
}
