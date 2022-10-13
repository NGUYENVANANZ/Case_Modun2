package ThiThucHanhModun2.SapXep;

import ThiThucHanhModun2.SinhVien;

import java.util.Comparator;

public class SapXepTangDan implements Comparator<SinhVien> {
    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        if (o2.getDiemTrungBinh() == o1.getDiemTrungBinh()){
            return 0;
        }else if (o2.getDiemTrungBinh() >  o1.getDiemTrungBinh()) {
            return 1;
        } else {
            return -1;
        }
    }
}
