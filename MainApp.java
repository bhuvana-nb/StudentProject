package com.StudentProject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainApp {
	
	 private static Scanner sc = new Scanner(System.in);
	    private static ExamManager manager = new ExamManager();

	    public static void main(String[] args) {
	        while (true) {
	            System.out.println("\n====== Student Exam Management ======");
	            System.out.println("1. Add Student");
	            System.out.println("2. Add Exam");
	            System.out.println("3. Record Marks");
	            System.out.println("4. View Result");
	            System.out.println("5. List Toppers");
	            System.out.println("6. List All Students");
	            System.out.println("0. Exit");
	            System.out.print("Enter choice: ");
	            int ch = sc.nextInt();
	            sc.nextLine();

	            switch (ch) {
	                case 1 -> addStudent();
	                case 2 -> addExam();
	                case 3 -> recordMarks();
	                case 4 -> viewResult();
	                case 5 -> listToppers();
	                case 6 -> manager.listStudentsSummary();
	                case 0 -> { System.out.println("Goodbye!"); return; }
	                default -> System.out.println("Invalid choice!");
	            }
	        }
	    }

	    static void addStudent() {
	        System.out.print("Enter Student ID: ");
	        String id = sc.nextLine();
	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();
	        System.out.print("Enter Class/Grade: ");
	        String grade = sc.nextLine();
	        manager.addStudent(new Student(id, name, grade));
	    }

	    static void addExam() {
	        System.out.print("Enter Exam ID: ");
	        String id = sc.nextLine();
	        System.out.print("Enter Exam Title: ");
	        String title = sc.nextLine();
	        System.out.print("Enter subjects separated by commas: ");
	        List<String> subjects = Arrays.asList(sc.nextLine().split(","));
	        manager.addExam(new Exam(id, title, subjects));
	    }

	    static void recordMarks() {
	        System.out.print("Enter Student ID: ");
	        String sid = sc.nextLine();
	        if (!manager.studentExists(sid)) { System.out.println("Student not found!"); return; }

	        System.out.print("Enter Exam ID: ");
	        String eid = sc.nextLine();
	        if (!manager.examExists(eid)) { System.out.println("Exam not found!"); return; }

	        Exam e = manager.getExam(eid);
	        Map<String, Double> marks = new HashMap<>();
	        for (String subject : e.getSubjects()) {
	            System.out.print("Enter marks for " + subject + ": ");
	            double m = sc.nextDouble();
	            if (m < 0 || m > 100) { System.out.println("Invalid mark! Enter between 0–100"); return; }
	            marks.put(subject, m);
	        }
	        sc.nextLine();
	        manager.recordMarks(new Result(sid, eid, marks));
	    }

	    static void viewResult() {
	        System.out.print("Student ID: ");
	        String sid = sc.nextLine();
	        System.out.print("Exam ID: ");
	        String eid = sc.nextLine();
	        manager.viewResult(sid, eid);
	    }

	    static void listToppers() {
	        System.out.print("Exam ID: ");
	        String id = sc.nextLine();
	        manager.listToppers(id);
	    }


}
