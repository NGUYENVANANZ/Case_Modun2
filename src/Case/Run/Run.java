package Case.Run;


import Case.DangNhap_DangKy.DangNhapDangKy;
import Case.Oject.NguoiDUng;

public class Run {
    public static NguoiDUng user = new NguoiDUng();
    public static void main(String[] args) {
        DangNhapDangKy.dangNhapDangKy = new DangNhapDangKy();
        DangNhapDangKy.dangNhapDangKy.luaChon();
    }
}
