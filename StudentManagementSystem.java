
package Student_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagementSystem {

    private static final Scanner scanner = new Scanner(System.in);
    private static Connection connection;

    private static final String URL =
            "jdbc:mysql://localhost:3306/student_management";
    private static final String USER = "root";

    public static void main(String[] args) {

        System.out.print("Enter MySQL root password: ");
        String password = scanner.nextLine();

        try {
            connection = DriverManager.getConnection(
                    URL, USER, password);

            System.out.println("Connected to MySQL successfully!");

            while (true) {
                System.out.println(
                        "\n===== STUDENT MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");

                int choice = readInt("Enter your choice: ", 1, 6);

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewAllStudents();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        updateStudent();
                        break;
                    case 5:
                        deleteStudent();
                        break;
                    case 6:
                        System.out.println(
                                "Thank you for using the application!");
                        return;
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection failed: "
                    + e.getMessage());
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(
                        "Error closing database connection.");
            }
            scanner.close();
        }
    }

    // ================= INPUT VALIDATION =================

    private static int readInt(
            String prompt, int min, int max) {

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (value < min || value > max) {
                    System.out.println(
                            "Please enter a value between "
                                    + min + " and " + max + ".");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input! Enter a whole number.");
            }
        }
    }

    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty() && !input.contains("|")) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty or contain the | character.");
        }
    }

    private static int readMarks(String prompt) {
        return readInt(prompt, 0, 100);
    }

    // ================= FIND STUDENT =================

    private static Student findStudentById(int id)
            throws SQLException {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("department"),
                            rs.getInt("java_marks"),
                            rs.getInt("sql_marks"),
                            rs.getInt("web_marks"));
                }
            }
        }

        return null;
    }

    // ================= ADD STUDENT =================

    private static void addStudent() {

        System.out.println("\n===== ADD STUDENT =====");

        int id = readInt(
                "Enter Student ID: ", 1, Integer.MAX_VALUE);

        String name = readText("Enter Student Name: ");
        String department = readText("Enter Department: ");
        int javaMarks = readMarks("Enter Java Marks: ");
        int sqlMarks = readMarks("Enter SQL Marks: ");
        int webMarks = readMarks("Enter Web Marks: ");

        String sql = "INSERT INTO students "
                + "(id, name, department, java_marks, "
                + "sql_marks, web_marks) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, department);
            statement.setInt(4, javaMarks);
            statement.setInt(5, sqlMarks);
            statement.setInt(6, webMarks);

            statement.executeUpdate();

            System.out.println("Student added successfully!");

            new Student(id, name, department,
                    javaMarks, sqlMarks, webMarks).displayStudent();

        } catch (SQLException e) {
            if ("23000".equals(e.getSQLState())) {
                System.out.println(
                        "A student with this ID already exists.");
            } else {
                System.out.println(
                        "Error adding student: " + e.getMessage());
            }
        }
    }

    // ================= VIEW ALL STUDENTS =================

    private static void viewAllStudents() {

        System.out.println("\n===== ALL STUDENTS =====");

        String sql = "SELECT * FROM students ORDER BY id";

        try (PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            boolean found = false;

            while (rs.next()) {
                found = true;

                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getInt("java_marks"),
                        rs.getInt("sql_marks"),
                        rs.getInt("web_marks"));

                student.displayStudent();
            }

            if (!found) {
                System.out.println("No student records found.");
            }

        } catch (SQLException e) {
            System.out.println(
                    "Error viewing students: " + e.getMessage());
        }
    }

    // ================= SEARCH STUDENT =================

    private static void searchStudent() {

        System.out.println("\n===== SEARCH STUDENT =====");

        int id = readInt(
                "Enter Student ID: ", 1, Integer.MAX_VALUE);

        try {
            Student student = findStudentById(id);

            if (student == null) {
                System.out.println("Student not found!");
            } else {
                student.displayStudent();
            }

        } catch (SQLException e) {
            System.out.println(
                    "Error searching student: " + e.getMessage());
        }
    }

    // ================= UPDATE STUDENT =================

    private static void updateStudent() {

        System.out.println("\n===== UPDATE STUDENT =====");

        int id = readInt(
                "Enter Student ID to update: ",
                1, Integer.MAX_VALUE);

        try {
            Student student = findStudentById(id);

            if (student == null) {
                System.out.println("Student not found!");
                return;
            }

            while (true) {
                System.out.println("\n===== UPDATE MENU =====");
                System.out.println("1. Update Name");
                System.out.println("2. Update Department");
                System.out.println("3. Update Java Marks");
                System.out.println("4. Update SQL Marks");
                System.out.println("5. Update Web Marks");
                System.out.println("6. Finish Updating");

                int choice = readInt(
                        "Enter your choice: ", 1, 6);

                switch (choice) {
                    case 1: {
                        String value =
                                readText("Enter new name: ");
                        if (updateField("name", value, id)) {
                            student.setName(value);
                            System.out.println(
                                    "Name updated successfully!");
                        }
                        break;
                    }
                    case 2: {
                        String value =
                                readText("Enter new department: ");
                        if (updateField("department", value, id)) {
                            student.setDepartment(value);
                            System.out.println(
                                    "Department updated successfully!");
                        }
                        break;
                    }
                    case 3: {
                        int value =
                                readMarks("Enter new Java marks: ");
                        if (updateField("java_marks", value, id)) {
                            student.setJavaMarks(value);
                            System.out.println(
                                    "Java marks updated successfully!");
                        }
                        break;
                    }
                    case 4: {
                        int value =
                                readMarks("Enter new SQL marks: ");
                        if (updateField("sql_marks", value, id)) {
                            student.setSqlMarks(value);
                            System.out.println(
                                    "SQL marks updated successfully!");
                        }
                        break;
                    }
                    case 5: {
                        int value =
                                readMarks("Enter new Web marks: ");
                        if (updateField("web_marks", value, id)) {
                            student.setWebMarks(value);
                            System.out.println(
                                    "Web marks updated successfully!");
                        }
                        break;
                    }
                    case 6:
                        student.displayStudent();
                        return;
                }
            }

        } catch (SQLException e) {
            System.out.println(
                    "Error updating student: " + e.getMessage());
        }
    }

    // Only fixed column names from the update menu are passed here.
    private static boolean updateField(
            String column, Object value, int id) {

        String sql = "UPDATE students SET "
                + column + " = ? WHERE id = ?";

        try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setObject(1, value);
            statement.setInt(2, id);

            if (statement.executeUpdate() > 0) {
                return true;
            }

            System.out.println("No student record was updated.");
            return false;

        } catch (SQLException e) {
            System.out.println(
                    "Database update failed: " + e.getMessage());
            return false;
        }
    }

    // ================= DELETE STUDENT =================

    private static void deleteStudent() {

        System.out.println("\n===== DELETE STUDENT =====");

        int id = readInt(
                "Enter Student ID to delete: ",
                1, Integer.MAX_VALUE);

        try {
            Student student = findStudentById(id);

            if (student == null) {
                System.out.println("Student not found!");
                return;
            }

            student.displayStudent();

            System.out.print(
                    "Are you sure you want to delete this student? (YES/NO): ");

            String confirmation = scanner.nextLine().trim();

            if (!confirmation.equalsIgnoreCase("YES")) {
                System.out.println("Deletion cancelled.");
                return;
            }

            String sql = "DELETE FROM students WHERE id = ?";

            try (PreparedStatement statement =
                         connection.prepareStatement(sql)) {

                statement.setInt(1, id);

                if (statement.executeUpdate() > 0) {
                    System.out.println(
                            "Student deleted successfully!");
                } else {
                    System.out.println("Student not found!");
                }
            }

        } catch (SQLException e) {
            System.out.println(
                    "Error deleting student: " + e.getMessage());
        }
    }
}