package view;

import controller.ContactManager;
import javafx.scene.Parent;
import model.Contact;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ContactManager contactManager = new ContactManager();

        showMenu();
        int choice = scanner.nextInt();

        while (true) {
            switch (choice) {
                case 1:
                    contactManager.showAllContact();
                    break;
                case 2:
                    Contact contact = creatContact();
                    if (contact==null){
                        break;
                    }
                    contactManager.addNewContact(contact);
                    break;
                case 3:
                    System.out.println("Nhập vào số điện thoại muốn xóa");
                    String number1 = scanner.nextLine();
                    while (true){

                        String phoneRegex = "^(\\d{11})|(\\d{10})$";
                        Pattern pattern = Pattern.compile(phoneRegex);
                        Matcher matcher = pattern.matcher(number1);
                        if (matcher.matches()){
                            break;
                        } else {
                            System.out.println("Định dạng sđt sai! Vui lòng nhập lại");
                        }
                        number1 = scanner.nextLine();
                    }
                    int phoneNumber2 = Integer.parseInt(number1);
                    Contact contact1 = editContact(phoneNumber2);
                    contactManager.editContact(contact1);
                    break;
                case 4:
                    System.out.println("Nhập vào số điện thoại muốn xóa");
                    String phoneNumber = scanner.nextLine();
                    while (true){

                        String phoneRegex = "^(\\d{11})|(\\d{10})$";
                        Pattern pattern = Pattern.compile(phoneRegex);
                        Matcher matcher = pattern.matcher(phoneNumber);
                        if (matcher.matches()){
                            break;
                        } else {
                            System.out.println("Định dạng sđt sai! Vui lòng nhập lại");
                        }
                        phoneNumber = scanner.nextLine();
                    }
                    int phoneNumber1 = Integer.parseInt(phoneNumber);
                    contactManager.deleteContact(phoneNumber1);

                    break;
                case 5:
                    System.out.println("Nhập vào số điện thoại muốn tìm");
                    String number = scanner.nextLine();
                    while (true){

                        String phoneRegex = "^(\\d{11})|(\\d{10})$";
                        Pattern pattern = Pattern.compile(phoneRegex);
                        Matcher matcher = pattern.matcher(number);
                        if (matcher.matches()){
                            break;
                        } else {
                            System.out.println("Định dạng sđt sai! Vui lòng nhập lại");
                        }
                        number = scanner.nextLine();
                    }
                    int phoneNumber3 = Integer.parseInt(number);
                    contactManager.findContact(phoneNumber3);
                    break;
                case 6:
                    contactManager.readToFile();
                    break;
                case 7:
                    contactManager.writeToFile();
                    break;
                case 0:
                    System.exit(0);

            }
            showMenu();
            choice = scanner.nextInt();

        }


    }


    public static void showMenu() {
        System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ-----");
        System.out.println("Chọn các chức năng theo số (để tiếp tục): ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public static Contact creatContact() {
        System.out.print("Nhập vào Số điện thoại: ");
        scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.equals("")){
            return null;
        }
        while (true){

            String phoneRegex = "^(\\d{11})|(\\d{10})$";
            Pattern pattern = Pattern.compile(phoneRegex);
            Matcher matcher = pattern.matcher(phoneNumber);
            if (matcher.matches()){
                break;
            } else {
                System.out.println("Định dạng sđt sai! Vui lòng nhập lại");
            }
            phoneNumber = scanner.nextLine();
        }
        int phoneNumber1 = Integer.parseInt(phoneNumber);
        System.out.print("Nhóm: ");
        String group = scanner.nextLine();
        System.out.print("Họ và tên: ");
        String name = scanner.nextLine();
        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        while (true){

            String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                break;
            } else {
                System.out.println("Định dạng email sai! Vui lòng nhập lại");
            }
            email = scanner.nextLine();
        }

        Contact contact = new Contact(phoneNumber1,group,name,gender,address,dateOfBirth,email  );
        return contact;
    }


    public static Contact editContact(int phoneNumber1) {

        System.out.print("Nhóm: ");
        String group = scanner.nextLine();
        System.out.print("Họ và tên: ");
        String name = scanner.nextLine();
        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        while (true){

            String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                break;
            } else {
                System.out.println("Định dạng email sai! Vui lòng nhập lại");
            }
            email = scanner.nextLine();
        }

        Contact contact = new Contact(phoneNumber1,group,name,gender,address,dateOfBirth,email  );
        return contact;
    }
}