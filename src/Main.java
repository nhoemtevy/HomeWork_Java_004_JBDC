import controller.UserController;
import model.User;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;
import view.View;

import java.util.Scanner;

public class Main {
    private final static UserController Controller = new UserController();
    private static final Scanner scanner = new Scanner(System.in);
    private static final User user = new User();
    public static void main(String[] args) {
//        controller.getAllUsers();
        while (true){
            System.out.println("=".repeat(10)+"Welcome to Crud"+"=".repeat(10));
            View.ui();
            switch (View.option()){
                case 1->{
                    System.out.println(">> Display All Users");
                    Controller.getAllUsers().forEach(System.out::println);
                }
                case 2->{
                    System.out.println(">> Create Users");
                    UserController.insertUser(View.insertUserView(user));
                 }
                case 3->{
                    System.out.println(">> Update Users");
                    System.out.print("Enter Id To Update :");
                    user.setUserId(Integer.parseInt(scanner.nextLine()));
//                    return getUser();
                }
                case 4->{
                    System.out.println(">> Delete Users");
                    System.out.print("Enter Id to Delete");
//                    try{
//                        return Integer.parseInt(scanner.nextLine());
//
//                    }catch (NumberFormatException e) {
//                        System.out.println(e.getMessage());
//                    }
//                    return null;
                }
                case 5->{
                    System.out.println(">> Exit");
                    return;
                }
                default -> {
                    System.out.println("No option.");
                }
            }
        }
    }

}