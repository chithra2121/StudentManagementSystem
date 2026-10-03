
package Student_Management_System;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    private static final ArrayList<Student> students =
            new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    private static final String FILE_NAME = "students.txt";

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        loadStudents();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
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
                    saveStudents();
                    System.out.println("Thank you for using the application!");
                    scanner.close();
                    return;
            }
        }
    }

    // ================= INPUT VALIDATION =================

    private static int readInt(String prompt, int min, int max) {

        while (true) {

            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {

                int value = Integer.parseInt(input);

                if (value < min || value > max) {
                    System.out.println(
                            "Please enter a value between "
                                    + min + " and " + max + "."
                    );
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {

                System.out.println("Invalid input! Enter a whole number.");
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
                    "Input cannot be empty or contain the | character."
            );
        }
    }

    private static void validateMarks(int marks)
            throws InvalidMarksException {

        if (marks < 0 || marks > 100) {

            throw new InvalidMarksException(
                    "Invalid marks! Enter marks between 0 and 100."
            );
        }
    }

    private static int readMarks(String prompt) {

        while (true) {

            int marks = readInt(
                    prompt,
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE
            );

            try {

                validateMarks(marks);
                return marks;

            } catch (InvalidMarksException e) {

                System.out.println(e.getMessage());
            }
        }
    }

    // ================= FIND STUDENT =================

    private static Student findStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // ================= ADD STUDENT =================

    private static void addStudent() {

        System.out.println("\n===== ADD STUDENT =====");

        int id = readInt(
                "Enter Student ID: ",
                1,
                Integer.MAX_VALUE
        );

        if (findStudentById(id) != null) {

            System.out.println(
                    "A student with this ID already exists!"
            );
            return;
        }

        String name = readText("Enter Student Name: ");

        String department = readText("Enter Department: ");

        int javaMarks = readMarks("Enter Java Marks: ");

        int sqlMarks = readMarks("Enter SQL Marks: ");

        int webMarks = readMarks("Enter Web Marks: ");

        Student student = new Student(
                id,
                name,
                department,
                javaMarks,
                sqlMarks,
                webMarks
        );

        students.add(student);

        saveStudents();

        System.out.println("Student added successfully!");

        student.displayStudent();
    }

    // ================= VIEW ALL STUDENTS =================

    private static void viewAllStudents() {

        System.out.println("\n===== ALL STUDENTS =====");

        if (students.isEmpty()) {

            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {

            student.displayStudent();
            System.out.println("-----------------------------");
        }
    }

    // ================= SEARCH STUDENT =================

    private static void searchStudent() {

        System.out.println("\n===== SEARCH STUDENT =====");

        int id = readInt(
                "Enter Student ID: ",
                1,
                Integer.MAX_VALUE
        );

        Student student = findStudentById(id);

        if (student == null) {

            System.out.println("Student not found!");

        } else {

            student.displayStudent();
        }
    }

    // ================= UPDATE STUDENT =================

    private static void updateStudent() {

        System.out.println("\n===== UPDATE STUDENT =====");

        int id = readInt(
                "Enter Student ID to update: ",
                1,
                Integer.MAX_VALUE
        );

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

            int choice = readInt("Enter your choice: ", 1, 6);

            switch (choice) {

                case 1:
                    student.setName(readText("Enter new name: "));
                    saveStudents();
                    System.out.println("Name updated successfully!");
                    break;

                case 2:
                    student.setDepartment(
                            readText("Enter new department: ")
                    );
                    saveStudents();
                    System.out.println(
                            "Department updated successfully!"
                    );
                    break;

                case 3:
                    student.setJavaMarks(
                            readMarks("Enter new Java marks: ")
                    );
                    saveStudents();
                    System.out.println(
                            "Java marks updated successfully!"
                    );
                    break;

                case 4:
                    student.setSqlMarks(
                            readMarks("Enter new SQL marks: ")
                    );
                    saveStudents();
                    System.out.println(
                            "SQL marks updated successfully!"
                    );
                    break;

                case 5:
                    student.setWebMarks(
                            readMarks("Enter new Web marks: ")
                    );
                    saveStudents();
                    System.out.println(
                            "Web marks updated successfully!"
                    );
                    break;

                case 6:
                    System.out.println(
                            "\nStudent details updated successfully!"
                    );
                    student.displayStudent();
                    return;
            }
        }
    }

    // ================= DELETE STUDENT =================

    private static void deleteStudent() {

        System.out.println("\n===== DELETE STUDENT =====");

        int id = readInt(
                "Enter Student ID to delete: ",
                1,
                Integer.MAX_VALUE
        );

        Student student = findStudentById(id);

        if (student == null) {

            System.out.println("Student not found!");
            return;
        }

        student.displayStudent();

        System.out.print(
                "Are you sure you want to delete this student? (YES/NO): "
        );

        String confirmation = scanner.nextLine().trim();

        if (confirmation.equalsIgnoreCase("YES")) {

            students.remove(student);

            saveStudents();

            System.out.println("Student deleted successfully!");

        } else {

            System.out.println("Deletion cancelled.");
        }
    }

    // ================= SAVE STUDENTS TO FILE =================

    private static void saveStudents() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {

                writer.write(
                        student.getId() + "|"
                                + student.getName() + "|"
                                + student.getDepartment() + "|"
                                + student.getJavaMarks() + "|"
                                + student.getSqlMarks() + "|"
                                + student.getWebMarks()
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving student records: " + e.getMessage()
            );
        }
    }

    // ================= LOAD STUDENTS FROM FILE =================

    private static void loadStudents() {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            int loadedCount = 0;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|", -1);

                if (data.length != 6) {

                    System.out.println(
                            "Skipping malformed student record."
                    );
                    continue;
                }

                try {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String department = data[2];
                    int javaMarks = Integer.parseInt(data[3]);
                    int sqlMarks = Integer.parseInt(data[4]);
                    int webMarks = Integer.parseInt(data[5]);

                    if (id <= 0
                            || name.trim().isEmpty()
                            || department.trim().isEmpty()
                            || name.contains("|")
                            || department.contains("|")
                            || javaMarks < 0 || javaMarks > 100
                            || sqlMarks < 0 || sqlMarks > 100
                            || webMarks < 0 || webMarks > 100
                            || findStudentById(id) != null) {

                        System.out.println(
                                "Skipping invalid or duplicate student record."
                        );
                        continue;
                    }

                    Student student = new Student(
                            id,
                            name,
                            department,
                            javaMarks,
                            sqlMarks,
                            webMarks
                    );

                    students.add(student);
                    loadedCount++;

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Skipping student record with invalid numbers."
                    );
                }
            }

            System.out.println(
                    loadedCount + " student record(s) loaded."
            );

        } catch (IOException e) {

            System.out.println(
                    "No saved records found. Starting with an empty list."
            );
        }
    }
}