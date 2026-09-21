package com.cit300.studentsystem;

public class Student {
    private String studentId;
    private String name;
    private String programme;
    private double marks;

    // Constructor
    public Student(String studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getProgramme() {
        return programme;
    }

    public double getMarks() {
        return marks;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Display purpose
    @Override
    public String toString() {
        return "ID: " + studentId +
                " | Name: " + name +
                " | Programme: " + programme +
                " | Marks: " + marks;
    }
}