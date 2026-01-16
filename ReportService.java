import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReportService {
    public void viewReports(Scanner scanner) {
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT u.username, p.name, r.amount_paid, r.payment_date FROM rent_payments r JOIN users u ON r.tenant_id = u.id JOIN properties p ON r.property_id = p.id");

            System.out.println("\n--- Rent Payment Report ---");
            while (rs.next()) {
                System.out.println("Tenant: " + rs.getString("username") +
                        ", Property: " + rs.getString("name") +
                        ", Amount: Rs." + rs.getDouble("amount_paid") +
                        ", Date: " + rs.getDate("payment_date"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}