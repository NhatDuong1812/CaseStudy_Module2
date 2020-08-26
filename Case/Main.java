package Case;



import  java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
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
                    Method.show();
                    break;
                case 2:
                    Method.add();
                    break;
                case 3:
                    Method.update();
                    break;
                case 4:
                    Method.delete();
                    break;
                case 5:
                    Method.search();
                    break;
                case 6:
                    Method.readFile();
                    break;
                case 7:
                    Method.writeFile();
                    break;
                default :
                    System.out.println("lỗi mời nhập lại");
            }
        } while (true);
    }
}