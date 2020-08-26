package Case;

import Case.Contract;

import  java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static List<Contract> contractList = new ArrayList<>();
    static Contract contract = new Contract();
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String PHONE_REGEX = "^(0|84)?[0-9]{9}$";

    public static boolean validEmail(String regex) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validPhone(String regex) {
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ HỌC SINH CỦA HND ---");
            System.out.println("Chọn chức năng theo số để tiếp tục: ");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> show();
                case 2 -> add();
                case 3 -> update();
                case 4 -> delete();
                case 5 -> search();
                case 6 -> readFile();
                case 7 -> writeFile();
                default -> System.out.println("Lỗi. Mời nhập lại");
            }


        } while (choice != 8);

    }

    public static void show() {
        for ( int i = 0; i<contractList.size();i++){
            Contract c = contractList.get(i);
            System.out.println(c.toString());
        }
    }

    public static void add() {
        Scanner sc = new Scanner(System.in);
        String phoneNumber = "";
        String emailAddress = "";
        System.out.println("Thông tin của danh sách: ");
        do {
            System.out.print("- Số điện thoại: ");
            phoneNumber = sc.nextLine();
            if (!validPhone(phoneNumber)) {
                System.out.println("\nSố điện thoại không khả dụng. Vui lòng nhập lại");
            }
        } while (!validPhone(phoneNumber));
        System.out.print("\n- Nhóm của hs: ");
        String groupName = sc.nextLine();
        System.out.print("\n- Họ tên: ");
        String name = sc.nextLine();
        System.out.print("\n- Lớp: ");
        String lop = sc.nextLine();
        System.out.print("\n- Địa chỉ: ");
        String address = sc.nextLine();
        System.out.print("\n- Ngày sinh: ");
        String dateOfBirth = sc.nextLine();
        do {
            System.out.print("\n- Email: ");
            emailAddress = sc.nextLine();
            if (!validEmail(emailAddress)) {
                System.out.println("\nEmail không khả dụng. Vui lòng nhập lại: ");
            }
        } while (!validEmail(emailAddress));
        Contract contract = new Contract(phoneNumber, groupName, name, lop, address, dateOfBirth, emailAddress);
        contractList.add(contract);
        System.out.println("Thêm thành công");
    }

    public static void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên của học sinh cần tìm: ");
        String searchName = sc.nextLine();
        for (int i = 0; i < contractList.size(); i++) {
            Contract c = contractList.get(i);
            if (searchName.equals(c.getName())) {
                System.out.println(contractList.get(i));
                break;
            }
        }
    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên học sinh cần sửa: ");
        String searchPhone = sc.nextLine();
        for (int i = 0; i < contractList.size(); i++) {
            if (searchPhone.equals(contractList.get(i).getName())) {
                System.out.print("Nhóm của danh bạ mới: ");
                String newGroup = sc.nextLine();
                contractList.get(i).setGroupName(newGroup);
                System.out.print("\nHọ tên: ");
                String newName = sc.nextLine();
                contractList.get(i).setName(newName);
                System.out.print("\nLớp: ");
                String newlop = sc.nextLine();
                contractList.get(i).setLop(newlop);
                System.out.print("\nĐịa chỉ: ");
                String newAddress = sc.nextLine();
                contractList.get(i).setAddress(newAddress);
                System.out.println("\nNgày sinh: ");
                String newDateOfBirth = sc.nextLine();
                contractList.get(i).setDateOfBirth(newDateOfBirth);
                System.out.println("\nEmail: ");
                String newEmail = sc.nextLine();
                contractList.get(i).setEmailAdress(newEmail);
//                contractList.add(contract);
                System.out.println(" Update thành công ");
                break;
            }
        }
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên học sinh cần xóa: ");
        String searchName = sc.nextLine();
        for (int i = 0; i < contractList.size(); i++) {
            if (searchName.equals(contractList.get(i).getName())) {
                System.out.println("Bạn có chắc muốn xóa không? Nhập Y(Yes) hoặc N(No)");
                String choice = sc.nextLine();
                if (choice.equals("Y")) {
                    contractList.remove(i);
                    System.out.println("Xóa thành công học sinh");
                    break;
                } else if (choice.equals("N")) {
                    break;
                } else {
                    System.out.println("Lỗi");
                    break;
                }
            }
        }
    }

    public static void writeFile() throws IOException {
        FileWriter writer = new FileWriter("src/contract.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(contract.toString());
        bufferedWriter.write(contractList.toString());
        bufferedWriter.close();
        System.out.println("Thêm thành công");
    }


    public static void readFile() throws IOException{
        FileReader frr = new FileReader("src/contract.csv");
        BufferedReader br = new BufferedReader(frr);
        String text;
        while ((text = br.readLine()) != null){
            System.out.println(text);
        }
        br.close();
    }

}