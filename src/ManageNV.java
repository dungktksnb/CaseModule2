import java.util.ArrayList;
import java.util.Scanner;

public class ManageNV {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<NhanVien> list = new ArrayList<>();

    static {
        try {
          list = DocGhiFile.docFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(String nameNhanVien) {
        NhanVien nhanViens = create(nameNhanVien);
        list.add(nhanViens);
        try {
            DocGhiFile.ghiFile(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void show() {
        for (NhanVien nv : list) {
            System.out.println(nv);
            System.out.println("_______________");

        }
    }
    public  void findByName(){

        System.out.println("nhập tên cần tìm ");
        String name=scanner.nextLine();
        int check=-1;
        for (int i=0;i<list.size();i++){
            if(list.get(i).getName().equals(name)){
                check=i;

            }
        }
        if (check<0){
            System.out.println("Tên không tồn tại");

        }else System.out.println(list.get(check));
    }
    public  void editByName(){

        System.out.println("nhập tên nhân viên cần sửa");
        String namer=scanner.nextLine();
        int check=-1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(namer)){
                check=i;

            }

        }if (check<0){
            System.out.println("tên không có trong list");
        }else {
            String id = getIDD();
            String name = getName();
            String address = getAddress();
            String age = getAge();
            String phone = getPhone();
            String email = getEmail();
            double salary = getSalary();
            boolean status = getStatus();
            list.get(check).setId(id);
            list.get(check).setName(name);
            list.get(check).setAddress(address);
            list.get(check).setAge(age);
            list.get(check).setPhone(phone);
            list.get(check).setEmail(email);
            list.get(check).setSalary(salary);
            list.get(check).setStatus(status);
            if (list.get(check) instanceof NhanVienFartTime){
                System.out.println("nhập số giờ làm việc");

                double soGioLam=Double.parseDouble(scanner.nextLine());
                ((NhanVienFartTime) list.get(check)).setSoGioLam(soGioLam);
            }

        }
    }


    public void removeId() {
        System.out.println("nhập id cần xóa :");
        String id=scanner.nextLine();
        int check=-1;
        for (int i=0;i<list.size();i++){
            if(list.get(i).getId().equals(id)){
                check=i;
            }
        }
        if (check<0){
            System.out.println("id không tồn tại");
        }else {
            list.remove(check);
        }

    }
    public  void editStatusNv(){
        System.out.println("nhập tên nhân viên cần thay đổi trạng thái ");
        String names=scanner.nextLine();
        int check=-1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(names)){
                check=i;
            }

        }
        if (check<=0){
            System.out.println("không có tên trong danh sách");
        }else {
            if (list.get(check).isStatus()){
                list.get(check).setStatus(false);
            }else {
                list.get(check).setStatus(true);
            }
        }
    }

    public NhanVien create(String nameNhanVien) {
        String id = getIDD();
        String name = getName();
        String address = getAddress();
        String age = getAge();
        String phone = getPhone();
        String email = getEmail();
        double salary = getSalary();
        boolean status = getStatus();
        if (nameNhanVien == "NhanvienFarttime") {
            System.out.println("nhập số giờ làm:");
            double soGioLam = Double.parseDouble(scanner.nextLine());
            return new NhanVienFartTime(id, name, address, age, phone, email, salary, status, soGioLam);

        } else {
            return new NhanVienFullTime(id, name, address, age, phone, email, salary, status);
        }


    }

    private boolean getStatus() {
        while (true) {
            try {
                System.out.println("nhập Status đang làm:true, đang nghỉ:false");
                boolean status = false;
                String statuss = scanner.nextLine();
                if (statuss.equals("true")) {
                    status = true;
                } else if (statuss.equals("false")) {
                    status = false;
                } else {
                    throw new Exception();
                }
                return status;
            } catch (Exception e) {
                System.out.println("nhập lỗi:");
            }
        }
    }

    private double getSalary() {
        System.out.println("nhập lương");
        double salary = Double.parseDouble(scanner.nextLine());
        return salary;
    }

    private String getEmail() {
        while (true) {
            try {
                System.out.println("nhập email");
                String email = scanner.nextLine();
                if (Regex.validateEmail(email)) {
                    boolean check = true;
                    for (NhanVien nv : list) {
                        if (nv.getEmail().equals(email)) {
                            check = false;
                            break;
                        }

                    }
                    if (check) {
                        return email;
                    } else {
                        System.out.println("email đã tồn tại");
                    }
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("nhập sai định dạng vui lòng nhập lại email");
            }
        }
    }

    private String getPhone() {
        while (true) {
            try {
                System.out.println("nhập số điện thoại :");
                String phone = scanner.nextLine();
                if (Regex.validatePhone(phone)) {
                    boolean check = true;
                    for (NhanVien nv : list) {
                        if (nv.getPhone().equals(phone)) {
                            check = false;
                            break;
                        }

                    }
                    if (check) {
                        return phone;
                    } else {
                        System.out.println("số điên thoại đã tồn tại :");
                    }
                } else throw new Exception();

            } catch (Exception e) {
                System.out.println("bạn phải nhập đúng định dạng 10 số.....");
            }

        }
    }
    public void SortNv(){
        Sort sort=new Sort();
        list.sort(sort);

    }

    private String getAge() {
        while (true) {
            try {
                System.out.println("nhập tuổi nhân viên:");
                String age = scanner.nextLine();
                if (Integer.parseInt(age) < 15 || Integer.parseInt(age) > 60) {
                    throw new Exception();
                } else return age;
            } catch (Exception e) {
                System.out.println("nhập lại tuổi nhân viên từ 15 tuổi đến 59 tuổi");
            }
        }
    }


    private String getAddress() {

        System.out.println("nhập địa chỉ :");
       return scanner.nextLine();
    }

    private String getName() {
        while (true) {
            try {
                System.out.println("nhập name:");
                String name = scanner.nextLine();
                if (Regex.validateName(name)) {
                    return name;
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("name phải đúng định dạng :");
            }
        }

    }

    private String getIDD() {
        while (true) {
            try {
                System.out.println("nhập id :");
                String id = scanner.nextLine();
                if (Regex.validateId(id)) {

                    for (NhanVien nv : list) {
                        if (nv.getId().equals(id)) {
                            throw new Exception();

                        }
                        break;
                    }
                    return id;
                }else System.out.println("id nhập đúng định dạng là số (0-9)");
            } catch (Exception e) {
                System.out.println("NHhập id trùng,bạn nhập lại xem còn trùng không!!!!");
            }
        }


    }

}

