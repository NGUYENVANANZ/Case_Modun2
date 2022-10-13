package ThiThucHanhModun2;

import java.io.*;
import java.util.ArrayList;

public class IO {
    static File file = new File("C:\\C0722G1\\Case_Modun_2\\src\\ThiThucHanhModun2\\fileSinhVien.txt");

    public static void write(ArrayList<SinhVien> sinhViens) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(sinhViens);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<SinhVien> reader() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<SinhVien>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
