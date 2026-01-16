import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        PropertyService propertyService = new PropertyService();
        RentService rentService = new RentService();
        ReportService reportService = new ReportService();

        while (true) {
            System.out.println("\n--- Rent Management System ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Property");
            System.out.println("3. Pay Rent");
            System.out.println("4. View Reports");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> userService.addUser(scanner);
                case 2 -> propertyService.addProperty(scanner);
                case 3 -> rentService.payRent(scanner);
                case 4 -> reportService.viewReports(scanner);
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

//javac -cp ".;mysql-connector-j-9.3.0.jar" *.java
//java -cp ".;mysql-connector-j-9.3.0.jar" Main
