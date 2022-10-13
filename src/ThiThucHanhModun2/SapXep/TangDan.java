package ThiThucHanhModun2.SapXep;

import ThiThucHanhModun2.SinhVien;

import java.util.Comparator;

public class TangDan implements Comparator<SinhVien> {
    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        if (o1.getDiemTrungBinh() == o2.getDiemTrungBinh()){
            return 0;
        }else if (o1.getDiemTrungBinh() >  o2.getDiemTrungBinh()) {
            return 1;
        } else {
            return -1;
        }
    }
}
