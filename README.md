# Student Management System

## About the Project

The Student Management System is a console-based Java application that allows users to enter and manage student information and calculate academic results.

The application accepts details for multiple students, including student ID, name, department, and marks in Java, SQL, and Web Development. It automatically calculates total marks, percentage, grade, and pass/fail status for each student and displays an individual report.

This project demonstrates core Java programming concepts, including object-oriented programming, collections, loops, user input, conditional statements, and input validation.

## Features

- **Multiple Student Entry:** Enter details for multiple students in a single execution.
- **Student Information:** Collects student ID, name, department, and subject marks.
- **User Input:** Uses Java's `Scanner` class to accept information through the terminal.
- **Input Validation:** Checks that marks are between 0 and 100, rejects empty text fields, and validates numeric input.
- **Total Marks Calculation:** Calculates the total marks across three subjects.
- **Percentage Calculation:** Calculates the average percentage.
- **Grade Calculation:** Assigns a grade based on the percentage.
- **Pass/Fail Evaluation:** Checks whether the student has scored at least 40 marks in each subject.
- **Individual Student Reports:** Displays a separate academic report for every student.
- **Student Collection:** Uses an `ArrayList` to store student objects during program execution.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework (`ArrayList`)
- Visual Studio Code
- Git
- GitHub

## Subjects

The application currently accepts marks for the following subjects:

- Java
- SQL
- Web Development

Each subject is marked out of 100.

## Grading Criteria

Grades are assigned according to the calculated average percentage.

| Percentage       | Grade |
| ---------------- | ----- |
| 90% and above    | A+    |
| 80% to below 90% | A     |
| 70% to below 80% | B     |
| 60% to below 70% | C     |
| 50% to below 60% | D     |
| Below 50%        | F     |

### Pass/Fail Rule

A student passes only if they score at least 40 marks in all three subjects. If they score below 40 in any subject, their result is Fail.

## Project Structure

```text
StudentManagementSystem/
├── Student.java
├── InvalidMarksException.java
└── README.md
```

The Java source files use the `Student_Management_System` package. Compiled class files are generated in the appropriate package directory when the project is compiled.

## Prerequisites

Before running the application, install:

- Java Development Kit (JDK)
- Visual Studio Code or another Java-compatible editor
- Git (optional, for version control)

Verify your Java installation:

```bash
java -version
javac -version
```

## How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/chithra2121/StudentManagementSystem.git
```

### 2. Navigate to the Project Folder

```bash
cd StudentManagementSystem
```

### 3. Compile the Java Files

```bash
javac -d . Student.java InvalidMarksException.java
```

### 4. Run the Application

```bash
java Student_Management_System.Student
```

### 5. Enter Student Details

- Enter the number of students.
- Enter each student's ID, name, and department.
- Enter the Java, SQL, and Web Development marks for each student.
- Review the automatically generated reports.

The program displays each student's details, total marks, percentage, grade, and result.

## Concepts Demonstrated

- Classes and Objects
- Constructors
- Encapsulation
- Getters and Setters
- Methods
- `Scanner` for user input
- `ArrayList` for storing multiple objects
- Loops and conditional statements
- Input validation
- Arithmetic calculations
- Basic exception handling for invalid numeric input

## Future Enhancements

Possible improvements include:

- Search for students by ID
- Update and delete student records
- Prevent duplicate student IDs
- Integrate the custom `InvalidMarksException` class into marks validation
- Save student information permanently using file handling
- Integrate a database such as MySQL
- Add a menu-driven interface for managing student records

## Author

**Chithra Shree**

## License

This project is intended for learning and educational purposes.
