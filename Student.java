package com.StudentProject;

public class Student {
	
	private String studentId;
    private String name;
    private String classOrGrade;

    public Student(String studentId, String name, String classOrGrade) {
        this.studentId = studentId;
        this.name = name;
        this.classOrGrade = classOrGrade;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getClassOrGrade() { return classOrGrade; }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Class: " + classOrGrade;
    }


}
