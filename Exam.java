package com.StudentProject;

import java.util.List;

public class Exam {
	
	 private String examId;
	    private String title;
	    private List<String> subjects;

	    public Exam(String examId, String title, List<String> subjects) {
	        this.examId = examId;
	        this.title = title;
	        this.subjects = subjects;
	    }

	    public String getExamId() { return examId; }
	    public String getTitle() { return title; }
	    public List<String> getSubjects() { return subjects; }

	    @Override
	    public String toString() {
	        return examId + " - " + title + " Subjects: " + subjects;
	    }


}
