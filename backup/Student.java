
package Student_Management_System;

public class Student {

	private int id;
	private String name;
	private String department;
	private int javaMarks;
	private int sqlMarks;
	private int webMarks;

	public Student(int id, String name, String department,
			int javaMarks, int sqlMarks, int webMarks) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.javaMarks = javaMarks;
		this.sqlMarks = sqlMarks;
		this.webMarks = webMarks;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public int getJavaMarks() {
		return javaMarks;
	}

	public int getSqlMarks() {
		return sqlMarks;
	}

	public int getWebMarks() {
		return webMarks;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setJavaMarks(int javaMarks) {
		this.javaMarks = javaMarks;
	}

	public void setSqlMarks(int sqlMarks) {
		this.sqlMarks = sqlMarks;
	}

	public void setWebMarks(int webMarks) {
		this.webMarks = webMarks;
	}

	// Calculate total
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

	// Calculate result
	public String getResult() {
		if (javaMarks >= 40 && sqlMarks >= 40
				&& webMarks >= 40) {
			return "Pass";
		}

		return "Fail";
	}

	// Display individual student report
	public void displayStudent() {
		System.out.println("------------------------------------");
		System.out.println("Student ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Department: " + department);
		System.out.println("Java Marks: " + javaMarks);
		System.out.println("SQL Marks: " + sqlMarks);
		System.out.println("Web Marks: " + webMarks);
		System.out.println("Total: " + calculateTotal());
		System.out.printf(
				"Percentage: %.2f%%%n", calculatePercentage());
		System.out.println("Grade: " + calculateGrade());
		System.out.println("Result: " + getResult());
		System.out.println("------------------------------------");
	}
}