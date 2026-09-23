package Student_Management_System;

public class Student {
	
	
	private int id;
	private String name;
	private String department;
	 
	private int javaMarks;
	private int sqlMarks;
	private int webMarks;
	public Student(int id,String name,String department,int javaMarks,int sqlMarks,int webMarks) {
		super();
		this.id=id;
		this.name=name;
		this.department=department;
		this.javaMarks=javaMarks;
		this.sqlMarks=sqlMarks;
		this.webMarks=webMarks;
	}
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department=department;
	}
	public int getJavaMarks() {
		return javaMarks;
	}
	public void setJavaMarks(int javaMarks) {
		this.javaMarks=javaMarks;
	}
	public int getSqlMarks() {
		return sqlMarks;
	}
	public void setSqlMarks(int sqlMarks) {
		this.sqlMarks=sqlMarks;
	}
	public int getWebMarks() {
		return webMarks;
	}
	public void setWebMarks(int webMarks) {
		this.webMarks=webMarks;
	}
	public int calculateTotal() {
		return javaMarks+sqlMarks+webMarks;
	}
	public double calculatePercentage() {
		return calculateTotal()/3.0;
	}
	public String calculateGrade() {
		double percentage= calculatePercentage();
		if(percentage>=90) {
			return "A+";
		}
		else if(percentage>=80) {
			return"A";
		}
		else if(percentage>=70) {
			return"B";
		}
		else if(percentage>=60) {
			return"C";
		}
		else if(percentage>=50) {
			return"D";
		}
		else {
			return "F";
		}
		
		
	}
	public String getResult() {
		if(javaMarks>=40 && sqlMarks>=40 && webMarks>=40) {
			return "Pass";
		}
		else {
			return "Fail";
		}
	}
    public void displayStudent() {
	System.out.println("------------------------------------");
	System.out.println("Student id:"+id);
	System.out.println("Name:"+name);
	System.out.println("Deparment:"+department);
	System.out.println("Java Marks:"+javaMarks);
	System.out.println("SQL Marks:"+sqlMarks);
	System.out.println("Web Marks:"+webMarks);
	System.out.println("Total:"+calculateTotal());
	System.out.println("Percentage:"+calculatePercentage());
	System.out.println("Grade:"+calculateGrade());
	System.out.println("Result:"+getResult());
	System.out.println("------------------------------------");

	
}
    
	

}
