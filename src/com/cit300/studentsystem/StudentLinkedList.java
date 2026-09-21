package com.cit300.studentsystem;

public class StudentLinkedList {


    private class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public StudentLinkedList() {
        head = null;
        size = 0;
    }


    public boolean addStudent(Student student) {
        if (searchById(student.getStudentId()) != null) {
            System.out.println("Error: Student ID already exists!");
            return false;
        }
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    // 2. SEARCH by ID
    public Student searchById(String studentId) {
        Node current = head;
        while (current != null) {
            if (current.data.getStudentId().equals(studentId)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // 3. UPDATE
    public boolean updateStudent(String studentId, String name, String programme, double marks) {
        Student student = searchById(studentId);
        if (student == null) {
            System.out.println("Error: Student not found!");
            return false;
        }
        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);
        return true;
    }

    // 4. DELETE
    public boolean deleteStudent(String studentId) {
        if (head == null) return false;

        if (head.data.getStudentId().equals(studentId)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.getStudentId().equals(studentId)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        System.out.println("Error: Student not found!");
        return false;
    }

    // 5. DISPLAY ALL
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Node current = head;
        System.out.println("---- All Student Records ----");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }
}
