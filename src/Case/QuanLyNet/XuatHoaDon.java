package Case.QuanLyNet;

import Case.IO.DocVietFileNhiPhan;
import Case.Oject.HoaDon;
import Case.Oject.NguoiDUng;

import java.util.ArrayList;

public class XuatHoaDon {
    QuanLyNguoiDung quanLyNguoiDung = new QuanLyNguoiDung();
   DocVietFileNhiPhan<HoaDon> hoaDonDocVietFileNhiPhan = new DocVietFileNhiPhan<>();
    ArrayList<HoaDon> hoaDons = hoaDonDocVietFileNhiPhan.reader("C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\hoaDonAll.txt");

    public void Them(HoaDon hoaDon){
        hoaDons.add(hoaDon);
        hoaDonDocVietFileNhiPhan.write(hoaDons, "C:\\C0722G1\\Case_Modun_2\\src\\Case\\File\\hoaDonAll.txt");
    }

    public void TongTien(){
        double sum = TinhTienMay();
        for (HoaDon x:hoaDons) {
          sum +=  x.tinhTongTien();
        }
        System.out.println("Tổng doanh thu :" + sum);
    }

    public double TinhTienMay(){
        double sum = 0;
        for (NguoiDUng x: quanLyNguoiDung.getNguoiDUngs()) {
            sum += x.getTien_Trong_Tai_Khoan();
        }
        return sum;
    }

}
