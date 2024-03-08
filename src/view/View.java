package view;

import model.User;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;
import java.util.UUID;

public class View {
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.SURROUND);
        table.addCell("1. Display All User");
        table.addCell("2. Create User");
        table.addCell("3. Update User");
        table.addCell("4. Delete User");
        table.addCell("5. Exit");
        System.out.println(table.render());
    }

    public int getOption() {
        System.out.println("Choose Option: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid option. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public User insertUser() {
        User user = new User();
        System.out.print("Enter Username: ");
        user.setUserName(scanner.next());
        System.out.print("Enter Email: ");
        user.setUserEmail(scanner.next());
        System.out.print("Enter Password: ");
        user.setUserPassword(scanner.next());
        user.setUserUuid(UUID.randomUUID().toString());
        user.setIsDeleted(false);
        user.setIsVerified(false);
        return user;
    }

    public int getUserIdToUpdate() {
        System.out.print("Enter Id To Update: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid id. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public int getUserIdToDelete() {
        System.out.print("Enter Id to Delete: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid id. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}
