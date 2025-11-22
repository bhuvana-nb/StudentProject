package com.StudentProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamManager {
	
	private Map<String, Student> students = new HashMap<>();
    private Map<String, Exam> exams = new HashMap<>();
    private List<Result> results = new ArrayList<>();

    public void addStudent(Student s) {
        students.put(s.getStudentId(), s);
        System.out.println("Student added successfully.");
    }

    public void addExam(Exam e) {
        exams.put(e.getExamId(), e);
        System.out.println("Exam added successfully.");
    }

    public Student getStudent(String id) { return students.get(id); }
    public Exam getExam(String id) { return exams.get(id); }

    public void recordMarks(Result r) {
        results.add(r);
        System.out.println("Marks recorded successfully.");
    }

    public void viewResult(String studentId, String examId) {
        for (Result r : results) {
            if (r.getStudentId().equals(studentId) && r.getExamId().equals(examId)) {
                Student s = students.get(studentId);
                Exam e = exams.get(examId);
                System.out.println("\n--- Result Sheet ---");
                System.out.println("Student: " + s.getName());
                System.out.println("Exam: " + e.getTitle());
                r.getMarks().forEach((sub, mark) ->
                    System.out.println(sub + ": " + mark));
                System.out.println("Total: " + r.getTotal());
                System.out.println("Percentage: " + r.getPercentage());
                System.out.println("Grade: " + r.getGrade());
                return;
            }
        }
        System.out.println("No result found!");
    }

    public void listToppers(String examId) {
        List<Result> filtered = new ArrayList<>();
        for (Result r : results) {
            if (r.getExamId().equals(examId)) filtered.add(r);
        }
        filtered.sort((a, b) -> Double.compare(b.getPercentage(), a.getPercentage()));
        System.out.println("\n--- Toppers for Exam: " + examId + " ---");
        int rank = 1;
        for (Result r : filtered) {
            System.out.println(rank++ + ". " + students.get(r.getStudentId()).getName() +
                    " - " + r.getPercentage() + "% (" + r.getGrade() + ")");
        }
    }

    public void listStudentsSummary() {
        System.out.println("\n--- Student Performance Summary ---");
        for (Student s : students.values())
            System.out.println(s);
    }

    public boolean studentExists(String id) { return students.containsKey(id); }
    public boolean examExists(String id) { return exams.containsKey(id); }


}
