import java.io.Serializable;

public class NhanVien implements Serializable {
    private  String id;
    private String name;
    private String address;
    private String age;

    private  String phone;
    private String email;
    private double salary;
    private boolean status;

    public NhanVien(String id, String name, String address, String age,String phone, String email, double salary, boolean status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.status = status;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }
    public  String status(){
        String status=null;
        if(this.status==true){
            status="đang làm việc";

        }else {
            status="đang nghỉ";

        }return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public double tongLuong(){
        return salary;
    }

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", status=" + status +" , ";
    }
}
