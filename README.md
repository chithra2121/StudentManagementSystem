# Student Management System

## About the Project

The Student Management System is a Java console-based application
that allows users to manage student records efficiently.

The application supports student registration, searching, updating,
deleting, marks validation, grade calculation, and persistent storage
using file handling.

## Features

### Student Management

- Add new students
- View all student records
- Search students by ID
- Update student details
- Delete student records
- Prevent duplicate student IDs

### Marks and Results

- Store Java, SQL, and Web Technology marks
- Calculate total marks and percentage
- Calculate grades automatically
- Determine pass/fail results
- Validate marks between 0 and 100

### Exception Handling

- Custom InvalidMarksException
- Validate integer inputs
- Reject empty names and departments
- Handle invalid marks with meaningful messages

### File Persistence

- Save student records to students.txt
- Load saved records when the application starts
- Preserve records after the application closes
- Save changes after adding, updating, or deleting students
- Skip malformed, invalid, or duplicate records during loading

### Automated Testing

- Basic automated tests for total marks
- Percentage calculation tests
- Pass/fail result tests

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Scanner
- Exception Handling
- Java File Handling
- Git and GitHub

## Project Structure

StudentManagementSystem/
|
|-- Student.java
|-- StudentManagementSystem.java
|-- InvalidMarksException.java
|-- StudentTest.java
|-- students.txt
|-- README.md

Note: students.txt is created when student records are saved.

## Requirements

- Java Development Kit (JDK)
- Visual Studio Code or another Java IDE
- Git (optional, for version control)

## How to Run

### 1. Open the Project Folder

Open the project folder in Visual Studio Code.

### 2. Compile the Java Files

javac -d . Student.java StudentManagementSystem.java InvalidMarksException.java StudentTest.java

### 3. Run the Application

java Student_Management_System.StudentManagementSystem

### 4. Run the Basic Tests

java Student_Management_System.StudentTest

## How to Use

1. Run the application.
2. Choose an option from the main menu.
3. Add a student with a unique ID.
4. View all records or search by ID.
5. Update student details or marks.
6. Delete records after confirmation.
7. Exit the application.

Student records are saved in students.txt and loaded
automatically when the application starts.

## Current Limitations

- The application uses a console-based interface.
- Records are stored in a local text file.
- The basic test runner is not a JUnit test suite.
- MySQL database integration is not yet implemented.

## Future Enhancements

- Integrate MySQL using JDBC
- Add JUnit automated testing
- Implement login and access control
- Develop a graphical user interface
- Create a web-based interface

## Author

B R Chithra Shree

## License

This project is intended for educational and learning purposes.
