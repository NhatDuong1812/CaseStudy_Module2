package Case;



import  java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static List<Contract> contractList = new ArrayList<>();
    //static Contract contract = new Contract();
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
                case 1:
                    show();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    readFile();
                    break;
                case 7:
                    writeFile();
                    break;
                default :
                    System.out.println("lỗi mời nhập lại");
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
        System.out.println("Nhập vào thông tin: ");
        System.out.print("\n- ID của hs: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("\n- Họ tên: ");
        String name = sc.nextLine();
        System.out.print("\n- Lớp: ");
        String lop = sc.nextLine();
        System.out.print("\n- Địa chỉ: ");
        String address = sc.nextLine();
        System.out.print("\n- Ngày sinh: ");
        String dateOfBirth = sc.nextLine();
        do {
            System.out.print("\n- Số điện thoại: ");
            phoneNumber = sc.nextLine();
            if (!validPhone(phoneNumber)) {
                System.out.println("\nSố điện thoại không khả dụng. Vui lòng nhập lại");
            }
        } while (!validPhone(phoneNumber));
        do {
            System.out.print("\n- Email: ");
            emailAddress = sc.nextLine();
            if (!validEmail(emailAddress)) {
                System.out.println("\nEmail không khả dụng. Vui lòng nhập lại: ");
            }
        } while (!validEmail(emailAddress));
        Contract contract = new Contract(phoneNumber, id, name, lop, address, dateOfBirth, emailAddress);
        contractList.add(contract);
        System.out.println("Thêm thành công");
    }

    public static void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID của học sinh cần tìm: ");
        int searchId = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < contractList.size(); i++) {
            Contract c = contractList.get(i);
            if (searchId == c.getId()) {
                System.out.println(contractList.get(i));
                break;
            }
        }
    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID học sinh cần sửa: ");
        int searchId = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < contractList.size(); i++) {
         //   if (searchPhone.equals(contractList.get(i).getName())) {
            if (searchId == contractList.get(i).getId()){
                System.out.print("Id mới: ");
                int newId = Integer.parseInt(sc.nextLine());
                contractList.get(i).setId(newId);
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
        System.out.println("Nhập ID học sinh cần xóa: ");
        int searchId = Integer.parseInt(sc.nextLine());
        for (int i = 1; i < contractList.size(); i++) {
           // if (searchName.equals(contractList.get(i).getName())) {
            if (searchId == contractList.get(i).getId()){
                System.out.println("Bạn có chắc muốn xóa " + contractList.get(i).getName() + " không? Nhập Y(Yes) hoặc N(No)");
                String choice = sc.nextLine();
                if (choice.equals("Y")) {
                    contractList.remove(i);
                    System.out.println("Xóa thành công học sinh khỉ danh sách");
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
        FileWriter writer = new FileWriter("contract.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        //bufferedWriter.write(contract.toString());
        bufferedWriter.write(contractList.toString());
        bufferedWriter.close();
        System.out.println("Thêm thành công");
    }


    public static void readFile() throws IOException{
        FileReader frr = new FileReader("contract.csv");
        BufferedReader br = new BufferedReader(frr);
        String text;
        while ((text = br.readLine()) != null){
            System.out.println(text);
        }
        br.close();
    }

}