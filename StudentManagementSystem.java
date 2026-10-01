
package Student_Management_System;

import java.util.ArrayList;
import java.util.Scanner;

import Student_Management_System.InvalidMarksException;
import Student_Management_System.Student;

public class StudentManagementSystem {

    private static final ArrayList<Student> students = new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    private static void validateMarks(int marks)
            throws InvalidMarksException {

        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException(
                    "Invalid marks! Enter marks between 0 and 100.");
        }
    }

    private static int readMarks(String prompt) {

        while (true) {
            int marks = readInt(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);

            try {
                validateMarks(marks);
                return marks;
            } catch (InvalidMarksException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        boolean running = true;

        System.out.println("====================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("====================================");

        while (running) {
            displayMenu();

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
                    running = false;
                    System.out.println(
                            "Thank you for using the Student Management System!");
                    break;
            }
        }

        scanner.close();
    }

    // Display menu
    private static void displayMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.println("===============================");
    }

    // Read a valid integer within a specified range
    private static int readInt(
            String prompt, int min, int max) {

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (value < min || value > max) {
                    System.out.println(
                            "Enter a number between "
                                    + min + " and " + max + ".");
                } else {
                    return value;
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a whole number.");
            }
        }
    }

    // Read non-empty text
    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("This field cannot be empty.");
        }
    }

    // Find student by ID
    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // Add a new student
    private static void addStudent() {
        System.out.println("\n--- Add Student ---");

        int id = readInt(
                "Enter Student ID: ", 1, Integer.MAX_VALUE);

        if (findStudentById(id) != null) {
            System.out.println(
                    "A student with this ID already exists.");
            return;
        }

        String name = readText("Enter Name: ");
        String department = readText("Enter Department: ");

        int javaMarks = readMarks("Enter Java marks: ");
        int sqlMarks = readMarks("Enter SQL marks: ");
        int webMarks = readMarks("Enter Web marks: ");

        Student student = new Student(
                id, name, department,
                javaMarks, sqlMarks, webMarks);

        students.add(student);

        System.out.println("Student added successfully!");
        student.displayStudent();
    }

    // Display all students
    private static void viewAllStudents() {
        System.out.println("\n--- All Student Reports ---");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }

        System.out.println(
                "Total students: " + students.size());
    }

    // Search student by ID
    private static void searchStudent() {
        System.out.println("\n--- Search Student ---");

        int id = readInt(
                "Enter Student ID to search: ",
                1, Integer.MAX_VALUE);

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found!");
            student.displayStudent();
        }
    }

    // Update student information

    private static void updateStudent() {

        int id = readInt(
                "Enter Student ID to update: ",
                1,
                Integer.MAX_VALUE);

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        while (true) {

            System.out.println("\n===== UPDATE STUDENT =====");
            System.out.println("1. Update Name");
            System.out.println("2. Update Department");
            System.out.println("3. Update Java Marks");
            System.out.println("4. Update SQL Marks");
            System.out.println("5. Update Web Marks");
            System.out.println("6. Finish Updating");

            int choice = readInt("Enter your choice: ", 1, 6);

            switch (choice) {

                case 1:
                    String name = readText("Enter new name: ");
                    student.setName(name);
                    System.out.println("Name updated successfully!");
                    break;

                case 2:
                    String department = readText("Enter new department: ");
                    student.setDepartment(department);
                    System.out.println(
                            "Department updated successfully!");
                    break;

                case 3:
                    int javaMarks = readMarks("Enter new Java marks: ");
                    student.setJavaMarks(javaMarks);
                    System.out.println(
                            "Java marks updated successfully!");
                    break;

                case 4:
                    int sqlMarks = readMarks("Enter new SQL marks: ");
                    student.setSqlMarks(sqlMarks);
                    System.out.println(
                            "SQL marks updated successfully!");
                    break;

                case 5:
                    int webMarks = readMarks("Enter new Web marks: ");
                    student.setWebMarks(webMarks);
                    System.out.println(
                            "Web marks updated successfully!");
                    break;

                case 6:
                    System.out.println(
                            "\nStudent details updated successfully!");
                    student.displayStudent();
                    return;
            }
        }
    }

    // Delete a student
    private static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");

        int id = readInt(
                "Enter Student ID to delete: ",
                1, Integer.MAX_VALUE);

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.displayStudent();

        String confirmation = readText(
                "Type YES to confirm deletion: ");

        if (confirmation.equalsIgnoreCase("YES")) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
}