import controller.UserController;
import model.User;
import repository.UserRepository;
import view.View;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    private static final UserController controller = new UserController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=".repeat(10) + "Welcome to Crud" + "=".repeat(10));
            View view = new View();
            view.displayMenu();
            int option = view.getOption();
            switch (option) {
                case 1 -> {
                    System.out.println(">> Display All Users");
                    controller.getAllUsers().forEach(System.out::println);
                }
                case 2 -> {
                    System.out.println(">> Create Users");
                    User user = view.insertUser();
                    controller.insertUser(user);
                }
                case 3 -> {
                    System.out.println(">> Update Users");
                    int userIdToUpdate = view.getUserIdToUpdate ();
                    System.out.print("Enter new username : ");
                    String newUserName = new Scanner(System.in).nextLine();
                    System.out.print("Enter new userEmail : ");
                    String newUserEmail = new Scanner(System.in).nextLine();
//                    User updatedUser = view.insertUser();
//                    updatedUser.setUserId(userIdToUpdate);
                     controller.updateUser(userIdToUpdate,new User(userIdToUpdate, UUID.randomUUID().toString(),newUserName,newUserEmail,UUID.randomUUID().toString()+"2324",false,false));



                }
                case 4 -> {

                    // Delete the user and get their ID
                    System.out.println(">> Delete Users");
                    int getUserIdToDelete = view.getUserIdToDelete();
                 int userToDelete =  controller.deleteUserByID(getUserIdToDelete);
                    if (userToDelete  != 0) {
                        System.out.println("Deleting user:");
                        System.out.println(userToDelete);
                        controller.deleteUserByID(userToDelete);
                    } else {
                        System.out.println("User not found.");
                    }
                }
                case 5 -> {
                    System.out.println(">> Exit");
                    view.closeScanner();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
