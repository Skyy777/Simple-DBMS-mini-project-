import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RentService {
    public void payRent(Scanner scanner) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter tenant ID: ");
            int tenantId = scanner.nextInt();
            System.out.print("Enter property ID: ");
            int propertyId = scanner.nextInt();
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            String sql = "INSERT INTO rent_payments (tenant_id, property_id, amount_paid, payment_date) VALUES (?, ?, ?, CURDATE())";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tenantId);
            stmt.setInt(2, propertyId);
            stmt.setDouble(3, amount);
            stmt.executeUpdate();

            System.out.println("Rent paid successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}