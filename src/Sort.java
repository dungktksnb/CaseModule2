import java.util.Comparator;

public class Sort implements Comparator<NhanVien> {


    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
