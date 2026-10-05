# Student Management System

A console-based Student Management System developed using Java and MySQL. This application helps manage student records, maintain academic details, and calculate student results. JDBC (Java Database Connectivity) is used to connect the Java application to the MySQL database.

## Features

- **Add Student:** Add new student records with ID, name, department, and subject marks.
- **View All Students:** Display all student records stored in the database.
- **Search Student:** Search for a student using their unique ID.
- **Update Student:** Update student details, including name, department, and subject marks.
- **Delete Student:** Delete a student record from the database after confirmation.
- **Calculate Total Marks:** Calculate the total marks obtained in Java, SQL, and Web Development.
- **Calculate Percentage:** Calculate the student's overall percentage.
- **Calculate Grade:** Assign a grade based on the percentage.
- **Pass/Fail Result:** Determine whether a student passes or fails based on subject marks.
- **Input Validation:** Validate marks and handle invalid marks using a custom exception.
- **MySQL Database Integration:** Store and retrieve student information using JDBC.
- **Data Migration:** Import existing student records from a text file into MySQL.

## Technologies Used

- **Programming Language:** Java
- **Database:** MySQL 8.0
- **Database Connectivity:** JDBC
- **JDBC Driver:** MySQL Connector/J 9.3.0
- **IDE:** Visual Studio Code
- **Terminal:** Windows PowerShell

## Project Structure

```text
StudentManagementSystem/
│
├── Student.java
├── StudentManagementSystem.java
├── InvalidMarksException.java
├── StudentTest.java
├── DBConnectionTest.java
├── StudentDataMigration.java
├── students.txt
├── students_backup.txt
├── README.md
│
├── lib/
│   └── mysql-connector-j-9.3.0.jar
│
└── backup/
    ├── Student.java
    └── StudentManagementSystem.java
```

## Database Configuration

### 1. Install MySQL

Install MySQL Server and make sure the MySQL service is running.

### 2. Create the Database

Open MySQL and execute:

```sql
CREATE DATABASE IF NOT EXISTS student_management;

USE student_management;
```

### 3. Create the Students Table

```sql
CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    java_marks INT NOT NULL,
    sql_marks INT NOT NULL,
    web_marks INT NOT NULL
);
```

### 4. Verify the Database

To display all student records:

```sql
SELECT * FROM students;
```

To count the records:

```sql
SELECT COUNT(*) FROM students;
```

## Prerequisites

Before running the project, make sure you have:

1. Java Development Kit (JDK) installed.
2. MySQL Server installed and running.
3. Visual Studio Code or another Java-compatible IDE.
4. MySQL Connector/J downloaded and placed in the `lib` folder.
5. The `student_management` database and `students` table created.

## How to Compile and Run

Run the following commands from the project root directory in Windows PowerShell.

### Step 1: Open the Project Directory

```powershell
cd "C:\Users\CHANDANA B R\OneDrive\Desktop\StudentManagementSystem"
```

### Step 2: Compile the Application

```powershell
javac -cp ".;lib\mysql-connector-j-9.3.0.jar" -d . StudentManagementSystem.java Student.java InvalidMarksException.java
```

### Step 3: Run the Application

```powershell
java -cp ".;lib\mysql-connector-j-9.3.0.jar" Student_Management_System.StudentManagementSystem
```

### Step 4: Connect to MySQL

When prompted, enter your MySQL root password. The application will attempt to connect to the `student_management` database.

After a successful connection, the Student Management System menu will appear.

## Application Menu

The application provides the following menu options:

```text
===== STUDENT MANAGEMENT SYSTEM =====
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
0. Exit
```

Choose an option by entering the corresponding number.

## Database Connection Test

The `DBConnectionTest.java` file can be used to check whether the application can connect to MySQL.

Compile the test:

```powershell
javac -cp ".;lib\mysql-connector-j-9.3.0.jar" -d . DBConnectionTest.java
```

Run the test:

```powershell
java -cp ".;lib\mysql-connector-j-9.3.0.jar" Student_Management_System.DBConnectionTest
```

Enter your MySQL root password when prompted.

## Student Data Migration

The `StudentDataMigration.java` utility imports existing student records from `students.txt` into the MySQL database.

The expected text-file format is:

```text
id|name|department|javaMarks|sqlMarks|webMarks
```

Each record should contain six fields separated by the `|` character.

**Important:** Run the migration utility only when you intend to import records. If student IDs already exist in MySQL, duplicate primary-key IDs may be skipped.

## Validation and Exception Handling

- Student IDs must be unique and positive.
- Student names and departments cannot be empty.
- Marks must be between 0 and 100.
- Invalid marks are handled using `InvalidMarksException`.
- Database operations use JDBC prepared statements to pass input values to SQL queries.

## Academic Result Calculation

The application calculates:

- **Total Marks:** Sum of Java, SQL, and Web Development marks.
- **Percentage:** Total marks divided by three.
- **Grade:** Assigned according to the percentage ranges implemented in `Student.java`.
- **Result:** A student passes only if each subject mark is at least 40.

## Backup and Data Safety

- `students_backup.txt` can be retained as a backup of the original text-file data.
- The `backup` directory can contain copies of earlier Java source files.
- Student records are stored in the MySQL database when using the JDBC-integrated application.
- Keep a separate backup of important database records.

## Security Notes

- Do not hard-code your MySQL password into source code.
- Do not commit passwords or other sensitive information to GitHub.
- Use appropriate MySQL account permissions when deploying the application.
- Keep the JDBC driver available locally when compiling and running the application.

## Future Improvements

- Add a graphical user interface using Java Swing or JavaFX.
- Add login authentication and role-based access.
- Generate student reports.
- Export records to CSV or PDF.
- Improve database transaction handling and logging.
- Add automated unit and integration tests.

## Author

B R Chithra Shree

## License

This project is intended for educational and learning purposes. Add a specific open-source license if you decide to distribute it under one.
