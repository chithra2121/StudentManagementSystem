
package Student_Management_System;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private int id;
    private String name;
    private String department;
    private int javaMarks;
    private int sqlMarks;
    private int webMarks;

    // Constructor
    public Student(int id, String name, String department,
                   int javaMarks, int sqlMarks, int webMarks) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.javaMarks = javaMarks;
        this.sqlMarks = sqlMarks;
        this.webMarks = webMarks;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getJavaMarks() {
        return javaMarks;
    }

    public void setJavaMarks(int javaMarks) {
        this.javaMarks = javaMarks;
    }

    public int getSqlMarks() {
        return sqlMarks;
    }

    public void setSqlMarks(int sqlMarks) {
        this.sqlMarks = sqlMarks;
    }

    public int getWebMarks() {
        return webMarks;
    }

    public void setWebMarks(int webMarks) {
        this.webMarks = webMarks;
    }

    // Calculate total marks
    public int calculateTotal() {
        return javaMarks + sqlMarks + webMarks;
    }

    // Calculate percentage
    public double calculatePercentage() {
        return calculateTotal() / 3.0;
    }

    // Calculate grade
    public String calculateGrade() {
        double percentage = calculatePercentage();

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // Check pass or fail
    public String getResult() {
        if (javaMarks >= 40 && sqlMarks >= 40 && webMarks >= 40) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    // Display student details
    public void displayStudent() {
        System.out.println("------------------------------------");
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Java Marks: " + javaMarks);
        System.out.println("SQL Marks: " + sqlMarks);
        System.out.println("Web Marks: " + webMarks);
        System.out.println("Total: " + calculateTotal());
        System.out.printf("Percentage: %.2f%%%n", calculatePercentage());
        System.out.println("Grade: " + calculateGrade());
        System.out.println("Result: " + getResult());
        System.out.println("------------------------------------");
    }

    // Read and validate integer input
    private static int readInt(Scanner scanner, String prompt,
                               int min, int max) {
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
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input. Please enter a whole number."
                );
            }
        }
    }

    // Read and validate text input
    private static String readText(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("This field cannot be empty.");
        }
    }

    // Main method
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            ArrayList<Student> students = new ArrayList<>();

            System.out.println("====================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");

            int numberOfStudents = readInt(
                scanner,
                "Enter the number of students: ",
                1,
                1000
            );

            // Enter details for multiple students
            for (int i = 1; i <= numberOfStudents; i++) {

                System.out.println("\nEnter details for Student " + i);

                int id = readInt(
                    scanner, "Enter Student ID: ",
                    1, Integer.MAX_VALUE
                );

                String name = readText(
                    scanner, "Enter Student Name: "
                );

                String department = readText(
                    scanner, "Enter Department: "
                );

                int javaMarks = readInt(
                    scanner, "Enter Java Marks (0-100): ",
                    0, 100
                );

                int sqlMarks = readInt(
                    scanner, "Enter SQL Marks (0-100): ",
                    0, 100
                );

                int webMarks = readInt(
                    scanner, "Enter Web Marks (0-100): ",
                    0, 100
                );

                Student student = new Student(
                    id, name, department,
                    javaMarks, sqlMarks, webMarks
                );

                students.add(student);

                System.out.println(
                    "Student details added successfully!"
                );
            }

            // Display reports for all students
            System.out.println("\n====================================");
            System.out.println("       STUDENT RESULT REPORTS");
            System.out.println("====================================");

            for (Student student : students) {
                student.displayStudent();
            }

            System.out.println(
                "\nTotal students processed: " + students.size()
            );

            System.out.println("Program completed successfully.");
        }
    }
}