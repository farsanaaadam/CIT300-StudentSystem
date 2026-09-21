package com.cit300.studentsystem;

import java.util.Scanner;

public class Main {
    static StudentLinkedList studentList = new StudentLinkedList();
    static ActionStack actionStack = new ActionStack();
    static RequestQueue requestQueue = new RequestQueue();
    static StudentBST bst = new StudentBST();
    static StudentHashMap hashMap = new StudentHashMap();
    static CampusGraph graph = new CampusGraph();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1: addStudent(); break;
                case 2: updateStudent(); break;
                case 3: deleteStudent(); break;
                case 4: studentList.displayAll(); break;
                case 5: addServiceRequest(); break;
                case 6: requestQueue.processNextRequest(); break;
                case 7: actionStack.displayActions(); break;
                case 8: bst.displayInOrder(); break;
                case 9: searchStudentHashing(); break;
                case 10: addCampusLocation(); break;
                case 11: removeCampusLocation(); break;
                case 12: addCampusConnection(); break;
                case 13: removeCampusConnection(); break;
                case 14: graph.displayConnections(); break;
                case 15: traverseCampus(); break;
                case 16: System.out.println("Exiting... Thank you!"); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        } while (choice != 16);

        sc.close();
    }

    static void printMenu() {
        System.out.println("========= University Student Record & Campus Route Management System =========");
        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Records using Linked List");
        System.out.println("5. Add Service Request to Queue");
        System.out.println("6. Process Next Service Request");
        System.out.println("7. Display Recent Actions using Stack");
        System.out.println("8. Display Students using BST/AVL");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS or DFS");
        System.out.println("16. Exit");
        System.out.println("=================================================================================");
    }

    // ---------- STUDENT RECORD OPERATIONS ----------

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("Error: Student ID cannot be empty!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty!");
            return;
        }

        System.out.print("Enter Programme: ");
        String programme = sc.nextLine().trim();

        double marks = getDoubleInput("Enter Marks (0-100): ");
        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks must be between 0 and 100!");
            return;
        }

        Student student = new Student(id, name, programme, marks);
        boolean added = studentList.addStudent(student);

        if (added) {
            bst.insert(new Student(id, name, programme, marks));
            hashMap.insert(new Student(id, name, programme, marks));
            actionStack.pushAction("Added student: " + id);
            System.out.println("Student added successfully!");
        }
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = sc.nextLine().trim();

        if (studentList.searchById(id) == null) {
            System.out.println("Error: Student not found!");
            return;
        }

        System.out.print("Enter new Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter new Programme: ");
        String programme = sc.nextLine().trim();
        double marks = getDoubleInput("Enter new Marks (0-100): ");

        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks must be between 0 and 100!");
            return;
        }

        boolean updated = studentList.updateStudent(id, name, programme, marks);
        if (updated) {
            actionStack.pushAction("Updated student: " + id);
            System.out.println("Student updated successfully!");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine().trim();

        boolean deleted = studentList.deleteStudent(id);
        if (deleted) {
            bst.delete(id);
            hashMap.delete(id);
            actionStack.pushAction("Deleted student: " + id);
            System.out.println("Student deleted successfully!");
        }
    }

    static void searchStudentHashing() {
        System.out.print("Enter Student ID to search: ");
        String id = sc.nextLine().trim();
        Student result = hashMap.search(id);
        if (result != null) {
            System.out.println("Found: " + result);
        } else {
            System.out.println("Student not found!");
        }
    }

    // ---------- QUEUE OPERATIONS ----------

    static void addServiceRequest() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine().trim();
        System.out.print("Enter Request Details: ");
        String details = sc.nextLine().trim();
        requestQueue.addRequest(id, details);
    }

    // ---------- CAMPUS GRAPH OPERATIONS ----------

    static void addCampusLocation() {
        System.out.print("Enter Location Name: ");
        String location = sc.nextLine().trim();
        boolean added = graph.addLocation(location);
        if (added) {
            actionStack.pushAction("Added location: " + location);
        }
    }

    static void removeCampusLocation() {
        System.out.print("Enter Location Name to remove: ");
        String location = sc.nextLine().trim();
        graph.removeLocation(location);
    }

    static void addCampusConnection() {
        System.out.print("Enter first Location: ");
        String loc1 = sc.nextLine().trim();
        System.out.print("Enter second Location: ");
        String loc2 = sc.nextLine().trim();
        boolean added = graph.addConnection(loc1, loc2);
        if (added) {
            actionStack.pushAction("Added connection: " + loc1 + " <-> " + loc2);
        }
    }

    static void removeCampusConnection() {
        System.out.print("Enter first Location: ");
        String loc1 = sc.nextLine().trim();
        System.out.print("Enter second Location: ");
        String loc2 = sc.nextLine().trim();
        graph.removeConnection(loc1, loc2);
    }

    static void traverseCampus() {
        System.out.print("Enter starting Location: ");
        String start = sc.nextLine().trim();
        System.out.print("Choose traversal (1 = BFS, 2 = DFS): ");
        int option = getIntInput("");

        if (option == 1) {
            graph.bfs(start);
        } else if (option == 2) {
            graph.dfs(start);
        } else {
            System.out.println("Invalid option!");
        }
    }

    // ---------- INPUT VALIDATION HELPERS ----------

    static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
}