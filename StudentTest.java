
package Student_Management_System;

public class StudentTest {

    public static void main(String[] args) {

        int passed = 0;
        int failed = 0;

        // Test 1: Total marks calculation
        Student student1 = new Student(
            101, "Arun", "CSE", 80, 70, 90);

        if (student1.calculateTotal() == 240) {
            System.out.println("PASS: Total marks calculation");
            passed++;
        } else {
            System.out.println("FAIL: Total marks calculation");
            failed++;
        }

        // Test 2: Percentage calculation
        if (student1.calculatePercentage() == 80.0) {
            System.out.println("PASS: Percentage calculation");
            passed++;
        } else {
            System.out.println("FAIL: Percentage calculation");
            failed++;
        }

        // Test 3: Student passes when all subjects
        // have marks of at least 40
        if ("Pass".equalsIgnoreCase(student1.getResult())) {
            System.out.println("PASS: Pass result calculation");
            passed++;
        } else {
            System.out.println("FAIL: Pass result calculation");
            failed++;
        }

        // Test 4: Student fails when one subject
        // has marks below 40
        Student student2 = new Student(
            102, "Priya", "IT", 80, 35, 90
        );

        if ("Fail".equalsIgnoreCase(student2.getResult())) {
            System.out.println("PASS: Fail result calculation");
            passed++;
        } else {
            System.out.println("FAIL: Fail result calculation");
            failed++;
        }

        // Display test summary
        System.out.println("\n===== TEST SUMMARY =====");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
    }
}