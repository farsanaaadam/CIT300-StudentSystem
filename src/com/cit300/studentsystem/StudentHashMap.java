package com.cit300.studentsystem;

import java.util.LinkedList;

public class StudentHashMap {

    private static final int SIZE = 10; // hash table size (buckets)
    private LinkedList<Student>[] table;

    @SuppressWarnings("unchecked")
    public StudentHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int hashFunction(String studentId) {
        int hash = Math.abs(studentId.hashCode());
        return hash % SIZE;
    }

    // 1. INSERT
    public void insert(Student student) {
        int index = hashFunction(student.getStudentId());
        LinkedList<Student> bucket = table[index];

        // Duplicate check
        for (Student s : bucket) {
            if (s.getStudentId().equals(student.getStudentId())) {
                System.out.println("Error: Student ID already exists in hash table!");
                return;
            }
        }
        bucket.add(student);
    }

    // 2. SEARCH
    public Student search(String studentId) {
        int index = hashFunction(studentId);
        LinkedList<Student> bucket = table[index];

        for (Student s : bucket) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }

    // 3. DELETE
    public boolean delete(String studentId) {
        int index = hashFunction(studentId);
        LinkedList<Student> bucket = table[index];

        for (Student s : bucket) {
            if (s.getStudentId().equals(studentId)) {
                bucket.remove(s);
                return true;
            }
        }
        return false;
    }


    public void displayTable() {
        System.out.println("---- Hash Table Contents ----");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("empty");
            } else {
                for (Student s : table[i]) {
                    System.out.print("[" + s.getStudentId() + "] ");
                }
                System.out.println();
            }
        }
    }
}