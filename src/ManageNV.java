import java.util.ArrayList;
import java.util.Scanner;

public class ManageNV {
    Scanner scanner = new Scanner(System.in);
    ArrayList<NhanVien> list = new ArrayList<>();

    public void add(String nameNhanVien) {
        NhanVien nhanViens = create(nameNhanVien);
        list.add(nhanViens);

    }

    public void show() {
        for (NhanVien nv : list) {
            System.out.println(nv);

        }
    }

    public void edit() {

    }

    public NhanVien create(String nameNhanVien) {
        String id = getID();
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
                        System.out.println("gmail đã tồn tại :");
                    }
                } else throw new Exception();

            } catch (Exception e) {
                System.out.println("bạn phải nhập đúng định dạng");
            }

        }
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
                System.out.println("nhập lại tuổi nhân viên");
            }
        }
    }

    private String getAddress() {
        System.out.println("nhập địa chỉ :");
        String address = scanner.nextLine();
        return address;
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

    private String getID() {
        while (true) {
            try {
                System.out.println("nhập id :");
                String id = scanner.nextLine();
                if (Regex.validateId(id)) {
                    for (NhanVien nv : list) {
                        if (nv.getId() == id) {
                            throw new Exception();
                        }
                    }
                    return id;
                }


            } catch (Exception e) {
                System.out.println("NHhập id trùng,bạn nhập lại xem còn trùng không!!!!");
            }
        }


    }

}

