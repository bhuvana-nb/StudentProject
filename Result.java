package com.StudentProject;

import java.util.Map;

public class Result {
	
	private String studentId;
    private String examId;
    private Map<String, Double> marks;

    public Result(String studentId, String examId, Map<String, Double> marks) {
        this.studentId = studentId;
        this.examId = examId;
        this.marks = marks;
    }

    public String getStudentId() { return studentId; }
    public String getExamId() { return examId; }
    public Map<String, Double> getMarks() { return marks; }

    public double getTotal() {
        return marks.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public double getPercentage() {
        return getTotal() / marks.size();
    }

    public String getGrade() {
        double p = getPercentage();
        if (p >= 90) return "A";
        if (p >= 75) return "B";
        if (p >= 60) return "C";
        if (p >= 45) return "D";
        return "F";
    }


}
