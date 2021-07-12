public class NhanVienFartTime extends NhanVien{
    private double soGioLam;

    public NhanVienFartTime(String id, String name, String address, String age, String phone, String email, double salary, boolean status, double soGioLam) {
        super(id, name, address, age, phone, email, salary, status);
        this.soGioLam = soGioLam;
    }

    public double getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(double soGioLam) {
        this.soGioLam = soGioLam;
    }

    @Override
    public double tongLuong() {
        return getSoGioLam()*getSalary();
    }

    @Override
    public String toString() {
        return "NhanVienPartTime{" +super.toString()+
                "hoursWord=" + soGioLam + " ," +"Tổng lương = "+tongLuong() + " }";
    }
}
