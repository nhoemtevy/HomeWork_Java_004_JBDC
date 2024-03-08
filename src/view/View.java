package view;

import model.User;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;
import java.util.UUID;

public class View {
    private static final Scanner scanner = new Scanner(System.in);
    public static void ui(){
        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE , ShownBorders.SURROUND);
        table.addCell("1. Display All User");
        table.addCell("2. Create User");
        table.addCell("3. Update User");
        table.addCell("4. Delete User");
        table.addCell("5. Exit");
        System.out.println(table.render());
    }
    public static int option(){
        System.out.println("Choose Option: ");
        return new Scanner(System.in).nextInt();
    }

//    public User updateUser (){
//        System.out.print("Enter Id To Update :");
//        user.setUserId(Integer.parseInt(scanner.nextLine()));
//
//        return getUser();
//    }
//
//    private User getUser() {
//    }
//
//    public Integer deleteById (){
//        System.out.print("Enter Id to Delete");
//        try{
//            return Integer.parseInt(scanner.nextLine());
//
//        }catch (NumberFormatException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//public static User updateUser() {
//    System.out.print("Enter Id To Update : ");
//    int userId = scanner.nextInt();
//    scanner.nextLine(); // Consume newline character
//    return getUser();
//}

    public static int deleteById() {
        System.out.print("Enter Id to Delete: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            return -1; // Returning a negative value to indicate error
        }
    }

    public static User insertUserView (User user){
        System.out.print("Enter Username :");
        user.setUserName(scanner.nextLine());
        System.out.print("Enter Email :");
        user.setUserEmail(scanner.nextLine());
        System.out.print("Enter Password :");
        user.setUserPassword(scanner.nextLine());
        user.setUserUuid(UUID.randomUUID().toString());
        user.setIsDeleted(false);
        user.setIsVerified(false);
        return user;
    }



}
