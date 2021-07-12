import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ManageNV manageNV = new ManageNV();

        while (true) {
            menu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("1:thêm nhân viên parttime");
                    System.out.println("2 thêm nhân viên fullTime");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1:
                            manageNV.add("NhanvienFarttime");
                            break;
                        case 2:
                            manageNV.add("NhanvienFullTime");
                            break;
                    }
                    break;
                case 2:
                    manageNV.show();
                    break;
                case 3:
                    System.out.println("---bạn có muốn sửa không?---");
                    System.out.println("---1:có---");
                    System.out.println("---2:không---");
                    int choice3=Integer.parseInt(scanner.nextLine());
                    switch (choice3){
                        case 1:
                            manageNV.editByName();
                            break;
                        case 2:
                            break;
                    }


                    break;
                case 4:
                    System.out.println("--bạn có muốn xóa không--");
                    System.out.println("1:xóa");
                    System.out.println("2:không");
                    int choice2=Integer.parseInt(scanner.nextLine());
                    switch (choice2){
                        case 1:
                            manageNV.removeId();
                            break;
                        case 2:
                            break;
                    }

                    break;
                case 5:
                    System.out.println("bạn muốn sửa trạng thái nhân viên không???");
                    System.out.println("1:có");
                    System.out.println("2:không");
                    int choice4=Integer.parseInt(scanner.nextLine());
                    if (choice4==1){
                        manageNV.editStatusNv();
                    }else break;
                    break;

                case 6:
                    System.out.println("--------Thông tin tài khoản--------");
                    manageNV.findByName();
                    break;
                case 7:
                    manageNV.SortNv();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("nhập sai");
                    break;

            }

        }

    }

    public static void menu() {
        System.out.println("Menu quản lý nhân viên ");
        System.out.println("1:thêm nhân viên");
        System.out.println("2:Show nhân viên ");
        System.out.println("3:Sửa nhân viên ");
        System.out.println("4:xóa nhân viên");
        System.out.println("5:thay đổi trang thái nhân viên ");
        System.out.println("6:thông tin tài khoản.");
        System.out.println("7:sắp xếp nhân viên theo tên");
        System.out.println("8:exit");
    }

}
