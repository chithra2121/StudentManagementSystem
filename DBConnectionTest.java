
package Student_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnectionTest {

    public static void main(String[] args) {

        String url =
            "jdbc:mysql://localhost:3306/student_management";
        String username = "root";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter MySQL root password: ");
        String password = scanner.nextLine();

        try (Connection connection =
                 DriverManager.getConnection(url, username, password)) {

            System.out.println("Connected to MySQL successfully!");
            System.out.println("Database: student_management");

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            System.out.println("Reason: " + e.getMessage());
        }

        scanner.close();
    }
}