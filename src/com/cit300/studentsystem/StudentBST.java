package com.cit300.studentsystem;

public class StudentBST {

    // Tree node
    private class Node {
        Student data;
        Node left, right;

        Node(Student data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    public StudentBST() {
        root = null;
    }


    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node current, Student student) {
        if (current == null) {
            return new Node(student);
        }

        int compare = student.getStudentId().compareTo(current.data.getStudentId());

        if (compare < 0) {
            current.left = insertRec(current.left, student);
        } else if (compare > 0) {
            current.right = insertRec(current.right, student);
        } else {
            System.out.println("Error: Student ID already exists in tree!");
        }
        return current;
    }

    // 2. SEARCH by Student ID
    public Student search(String studentId) {
        return searchRec(root, studentId);
    }

    private Student searchRec(Node current, String studentId) {
        if (current == null) {
            return null;
        }

        int compare = studentId.compareTo(current.data.getStudentId());

        if (compare == 0) {
            return current.data;
        } else if (compare < 0) {
            return searchRec(current.left, studentId);
        } else {
            return searchRec(current.right, studentId);
        }
    }

    // 3. DELETE
    public void delete(String studentId) {
        root = deleteRec(root, studentId);
    }

    private Node deleteRec(Node current, String studentId) {
        if (current == null) {
            return null;
        }

        int compare = studentId.compareTo(current.data.getStudentId());

        if (compare < 0) {
            current.left = deleteRec(current.left, studentId);
        } else if (compare > 0) {
            current.right = deleteRec(current.right, studentId);
        } else {

            if (current.left == null) return current.right;
            if (current.right == null) return current.left;


            Node smallest = findMin(current.right);
            current.data = smallest.data;
            current.right = deleteRec(current.right, smallest.data.getStudentId());
        }
        return current;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public void displayInOrder() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        System.out.println("---- Students (BST In-Order - sorted by ID) ----");
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.data);
            inOrderRec(node.right);
        }
    }
}