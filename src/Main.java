import controller.UserController;
import model.User;
import view.View;

import java.util.Scanner;

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
                    int userIdToUpdate = view.getUserIdToUpdate();
                    User updatedUser = view.insertUser();
                    updatedUser.setUserId(userIdToUpdate);
                    controller.updateUser(updatedUser);
                }
                case 4 -> {
                    System.out.println(">> Delete Users");
                    int userIdToDelete = view.getUserIdToDelete();
                    User userToDelete = controller.deleteById(userIdToDelete);
                    if (userToDelete != null) {
                        System.out.println("Deleting user:");
                        System.out.println(userToDelete);
                        controller.deleteById(userIdToDelete);
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
