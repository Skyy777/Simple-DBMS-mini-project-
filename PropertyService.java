import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PropertyService {
    public void addProperty(Scanner scanner) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter property name: ");
            String name = scanner.nextLine();
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            System.out.print("Enter rent amount: ");
            double rent = scanner.nextDouble();
            System.out.print("Enter landlord ID: ");
            int landlordId = scanner.nextInt();
            scanner.nextLine();

            String sql = "INSERT INTO properties (name, address, rent_amount, landlord_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setDouble(3, rent);
            stmt.setInt(4, landlordId);
            stmt.executeUpdate();

            System.out.println("Property added successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
