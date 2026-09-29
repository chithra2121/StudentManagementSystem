# Student Management System

## About the Project

The Student Management System is a Java-based application developed to manage student information and calculate academic performance.

The project demonstrates core Java programming concepts such as classes, objects, constructors, encapsulation, methods, conditional statements, and basic exception handling.

It stores student details such as student ID, name, department, and marks in three subjects. It calculates the total marks, percentage, grade, and pass/fail result, and displays the student's academic information.

## Features

- **Student Information:** Stores student ID, name, department, and subject marks.
- **Object-Oriented Programming:** Uses a `Student` class, constructor, private fields, getters, and setters.
- **Total Marks Calculation:** Calculates the combined marks in Java, SQL, and Web Development.
- **Percentage Calculation:** Calculates the average percentage across the three subjects.
- **Grade Calculation:** Assigns a grade based on the calculated percentage.
- **Pass/Fail Evaluation:** Checks whether the student has scored at least 40 marks in each subject.
- **Student Report:** Displays student details, subject marks, total, percentage, grade, and result.
- **Custom Exception Class:** Includes an `InvalidMarksException` class in the project.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Visual Studio Code
- Git and GitHub

## Project Structure

```text
StudentManagementSystem/
├── Student.java
├── InvalidMarksException.java
└── README.md
```

The Java source files declare the `Student_Management_System` package. The compilation command below creates the required package directory for the compiled classes.

## Grading Criteria

The application assigns grades based on the student's average percentage.

| Percentage       | Grade |
| ---------------- | ----- |
| 90% and above    | A+    |
| 80% to below 90% | A     |
| 70% to below 80% | B     |
| 60% to below 70% | C     |
| 50% to below 60% | D     |
| Below 50%        | F     |

A student passes only when they score at least 40 marks in each of the three subjects. Otherwise, the result is Fail.

## Prerequisites

Before running the project, ensure that you have:

- Java Development Kit (JDK) installed.
- Visual Studio Code or another Java-compatible editor.
- A terminal or command prompt.

Verify your Java installation using:

```bash
java -version
javac -version
```

## How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/chithra2121/StudentManagementSystem.git
```

### 2. Open the Project Directory

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

The program displays a sample student's details, subject marks, total marks, percentage, grade, and pass/fail result.

## Concepts Demonstrated

- Classes and Objects
- Constructors
- Encapsulation
- Getters and Setters
- Instance Methods
- Conditional Statements
- Arithmetic Operations
- Custom Exception Class

## Future Enhancements

The project can be extended with features such as:

- Adding multiple student records
- Searching for students by ID
- Updating and deleting student records
- Validating subject marks
- Integrating custom exception handling into marks validation
- Storing student information in a database
- Developing a menu-driven interface

## Author

**B R Chithra Shree**

## License

This project is available for learning and educational purposes.
