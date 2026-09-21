# University Student Record and Campus Route Management System

**Module:** CIT300 - Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 1 (Week 10)
**Contribution:** 10% of final module grade

## Project Description

This is a Java console application that manages university student records and represents
connections between campus locations. The system demonstrates the practical use of the
following data structures:

- Linked List
- Stack
- Queue
- Binary Search Tree (BST)
- Hashing
- Graph

## Group Members, Student IDs, Responsibilities and Contributions

| No. | Name | Student ID | Assigned Responsibility | Individual Contribution |
|-----|------|-----------|--------------------------|---------------------------|
| 1 | A. Asra | 23da2-0994 | Linked list implementation and student-record management (Student.java, StudentLinkedList.java) | Implemented Student class, StudentLinkedList with add/update/delete/search/display operations |
| 2 | MSF. Sasna | 23da2-0993 | Stack and queue implementation and related operations (ActionStack.java, RequestQueue.java) | Implemented ActionStack for recent actions/undo history and RequestQueue for service requests |
| 3 | AL. Farsana | 23da2-0661 | BST/AVL tree implementation and hashing/search functionality (StudentBST.java, StudentHashMap.java) | Implemented BST for sorted student records and hash table for fast ID search |
| 4 | AMF. Ilfa | 23da2-1121 | Graph implementation, campus locations, connections, and BFS/DFS traversal (CampusGraph.java) | Implemented CampusGraph with adjacency list, add/remove locations and connections, BFS and DFS traversal |

**All Members:** Integration, validation, testing, debugging, documentation, GitHub collaboration,
and completion of the entire project.

## System Requirements Implemented

1. Store student records containing Student ID, Name, Programme, and Marks
2. Linked list to store and manage student records
3. Stack to maintain recent actions/history (undo feature)
4. Queue to manage student service requests in order of arrival (FIFO)
5. BST to organize/search student records by Student ID
6. Hashing to support efficient student ID searching
7. Graph to represent campus locations and their connections
8. Graph represented using an adjacency list
9. Operations to add and remove campus locations and connections/roads
10. Display connected locations and the campus network
11. Graph traversal implemented: BFS and DFS
12. Add, update, delete, search, and display operations for student records
13. Menu-driven console interface with input validation
14. Handling of invalid inputs, duplicate IDs/locations, missing records, invalid marks

## Project Structure

```
src/com/cit300/studentsystem/
├── Main.java              - Menu-driven console interface (entry point)
├── Student.java           - Student data model
├── StudentLinkedList.java - Linked list for student records
├── ActionStack.java       - Stack for recent actions/undo
├── RequestQueue.java      - Queue for service requests
├── StudentBST.java        - Binary Search Tree for sorted records/search
├── StudentHashMap.java    - Hash table for fast ID search
└── CampusGraph.java       - Graph for campus locations and connections
```

## How to Run

1. Open the project in IntelliJ IDEA (or any Java IDE)
2. Ensure JDK 11 or above is installed
3. Run `Main.java`
4. Follow the on-screen menu (1-16) to use the system

## Menu Options

1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Records using Linked List
5. Add Service Request to Queue
6. Process Next Service Request
7. Display Recent Actions using Stack
8. Display Students using BST/AVL
9. Search Student using Hashing
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus Locations using BFS or DFS
16. Exit
