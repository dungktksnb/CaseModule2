public class NhanVienFullTime extends NhanVien{
    public NhanVienFullTime(String id, String name, String address, String age, String phone, String email, double salary, boolean status) {
        super(id, name, address, age, phone, email, salary, status);
    }

    @Override
    public double tongLuong() {
        return super.tongLuong();
    }

    @Override
    public String toString() {
        return "NhanVienFullTime{"+ super.toString()+
                "tổng lương"+ tongLuong() +" }";
    }
}
