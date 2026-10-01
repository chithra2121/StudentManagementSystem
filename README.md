# Student Management System

## About the Project

The Student Management System is a Java console-based application
that helps users manage student records efficiently.

It allows users to add, view, search, update, and delete student
records. It also calculates total marks, percentage, grade, and
pass/fail results.

## Features

### Student Management

- Add new student records
- View all students
- Search students by ID
- Update student details
- Delete student records
- Prevent duplicate student IDs

### Marks and Results

- Store Java, SQL, and Web Technology marks
- Calculate total marks and percentage
- Calculate grades automatically
- Determine pass/fail status
- Validate marks within the range of 0 to 100

### Input Validation and Exception Handling

- Validate integer inputs
- Prevent empty name and department fields
- Handle invalid marks using a custom
  `InvalidMarksException`
- Display error messages for invalid marks
- Allow users to re-enter valid marks

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Scanner
- Exception Handling
- Git and GitHub

## Project Structure

StudentManagementSystem/
|
|-- Student.java
|-- StudentManagementSystem.java
|-- InvalidMarksException.java
|-- README.md

## Requirements

- Java Development Kit (JDK)
- Visual Studio Code or another Java IDE
- Git (optional, for version control)

## How to Run the Project

### 1. Open the Project Folder

Open the project folder in Visual Studio Code.

### 2. Compile the Java Files

Run the following command in the terminal:

javac -d . Student.java StudentManagementSystem.java InvalidMarksException.java

### 3. Run the Application

java Student_Management_System.StudentManagementSystem

## How to Use

1. Run the application.
2. Select an option from the main menu.
3. Add a student using a unique student ID.
4. View all student records or search by ID.
5. Update student details or marks when required.
6. Delete a student record after confirmation.
7. Select Exit to close the application.

## Validation Rules

- Student IDs must be unique and positive.
- Names and departments cannot be empty.
- Marks must be between 0 and 100.
- Invalid marks are rejected, and the user is
  asked to enter valid marks.

## Current Limitations

- Student records are stored in memory.
- Records are lost when the application closes.
- The application uses a console-based interface.
- Database integration and automated unit tests
  have not yet been implemented.

## Future Enhancements

- Save student records to a file
- Load saved records when the application starts
- Add automated unit tests
- Integrate MySQL using JDBC
- Implement login and access control
- Develop a graphical or web-based interface

## Author

B R Chithra Shree

## License

This project is intended for learning and educational purposes.
