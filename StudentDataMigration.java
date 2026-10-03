
package Student_Management_System;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDataMigration {

    private static final String FILE_NAME = "students.txt";
    private static final String URL =
            "jdbc:mysql://localhost:3306/student_management";
    private static final String USER = "root";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter MySQL root password: ");
        String password = scanner.nextLine();

        String sql = "INSERT INTO students "
                + "(id, name, department, java_marks, sql_marks, web_marks) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        int imported = 0;
        int skipped = 0;

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, password);
             BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME));
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|", -1);

                if (data.length != 6) {
                    System.out.println("Skipping malformed record.");
                    skipped++;
                    continue;
                }

                try {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1].trim();
                    String department = data[2].trim();
                    int javaMarks = Integer.parseInt(data[3]);
                    int sqlMarks = Integer.parseInt(data[4]);
                    int webMarks = Integer.parseInt(data[5]);

                    if (id <= 0
                            || name.isEmpty()
                            || department.isEmpty()
                            || name.contains("|")
                            || department.contains("|")
                            || javaMarks < 0 || javaMarks > 100
                            || sqlMarks < 0 || sqlMarks > 100
                            || webMarks < 0 || webMarks > 100) {
                        System.out.println("Skipping invalid record.");
                        skipped++;
                        continue;
                    }

                    statement.setInt(1, id);
                    statement.setString(2, name);
                    statement.setString(3, department);
                    statement.setInt(4, javaMarks);
                    statement.setInt(5, sqlMarks);
                    statement.setInt(6, webMarks);

                    statement.executeUpdate();
                    imported++;

                } catch (NumberFormatException e) {
                    System.out.println(
                            "Skipping record with invalid numbers.");
                    skipped++;
                } catch (SQLException e) {
                    if ("23000".equals(e.getSQLState())) {
                        System.out.println(
                                "Skipping duplicate student ID.");
                        skipped++;
                    } else {
                        throw e;
                    }
                }
            }

            connection.commit();

            System.out.println("\nMigration completed!");
            System.out.println("Records imported: " + imported);
            System.out.println("Records skipped: " + skipped);

        } catch (IOException | SQLException e) {
            System.out.println("Migration failed: " + e.getMessage());
            System.out.println(
                    "Check MySQL and the source file before retrying.");
        }

        scanner.close();
    }
}