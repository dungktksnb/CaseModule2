import java.io.*;
import java.util.ArrayList;

public class DocGhiFile {
    public static ArrayList<NhanVien> docFile() throws Exception {
        File file = new File("nhiphan.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileInputStream fileInputStream = new FileInputStream("nhiphan.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<NhanVien> list = (ArrayList<NhanVien>) objectInputStream.readObject();
        objectInputStream.close();
        return list;
    }

    public static void ghiFile(ArrayList<NhanVien> list) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("nhiphan.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
    }

}
