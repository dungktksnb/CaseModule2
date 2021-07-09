import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ManageNV manageNV=new ManageNV();
        while (true){
            menu();
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("1:thêm nhân viên parttime");
                    System.out.println("2 thêm nhân viên fullTime");
                    int choice1=Integer.parseInt(scanner.nextLine());
                    switch (choice1){
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
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("nhập sai");


            }

        }

    }
    public static void menu(){
        System.out.println("Menu quản lý nhân viên ");
        System.out.println("1:show nhân viên");
        System.out.println("2:Thêm nhân viên ");
        System.out.println("3:Sửa nhân viên ");
        System.out.println("4:xóa nhân viên");
        System.out.println("5:");
    }

}
