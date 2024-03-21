import java.util.Scanner;
class Student1 {
    int id;
    String name;
    char gender;
    int age;
    char grade;
    // Constructor
    public Student1(int id, String name, char gender, int age, char grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.grade = grade;
    }
    // Display method
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Gender: " +
                gender + ", Age: " + age + ", Grade: " + grade);
    }
}
class StudentList {
    private StudentNode head;
    // Inner class representing a node in the linked list
    private static class StudentNode {
        Student1 data;
        StudentNode next;
        public StudentNode(Student1 data) {
            this.data = data;
            this.next = null;
        }
    }
    // Method to add a student to the end of the list
    public void add(Student1 student) {
        StudentNode newNode = new StudentNode(student);
        if (head == null) {
            head = newNode;
        } else {
            StudentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    // Method to remove a student at a specific index
    public void remove(int index) {
        if (head == null || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        StudentNode current = head;
        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    // Method to remove the last student from the list
    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        StudentNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
    // Method to display all students in the list
    public void displayAll() {
        StudentNode current = head;
        while (current != null) {
            current.data.display();
            current = current.next;
        }
    }
    // Clear all the student in the list
    public void clear(){
        head = null;
    }

    // Check if the student list is empty or not
    public boolean isEmpty(){
        return head == null;
    }
}
public class Lab04_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();
        //variable to input student from user
        int id;
        String name;
        char gender;
        int age;
        char grade;
        //index of student
        int index;
        // Adding students
        studentList.add(new Student1(1, "Makara", 'M', 20, 'A'));
        studentList.add(new Student1(2, "Jane", 'F', 19, 'C'));
        studentList.add(new Student1(3, "Bob", 'M', 20, 'B'));
        while (2>1) {
            System.out.println("===== Menu =====");
            System.out.println("1. Add student to the last");
            System.out.println("2. Remove specific student");
            System.out.println("3. Remove the last student");
            System.out.println("4. Clear all the student list");
            System.out.println("5. Display all student list");
            System.out.println("6. Quit");
            System.out.println("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("===== Add student to the last =====");
                    System.out.println("ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Name:");
                    name = scanner.nextLine();
                    System.out.println("Gender: ");
                    gender = scanner.nextLine().charAt(0);
                    System.out.println("Age:");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Grade: ");
                    grade = scanner.nextLine().charAt(0);
                    studentList.add(new Student1(id, name, gender, age, grade));
                    break;
                case 2:
                    System.out.println("===== Remove specifice student =====");
                    System.out.println("Enter the index to remove specific student: ");
                    index = scanner.nextInt();
                    scanner.nextLine();
                    studentList.remove(index);
                    System.out.println("Student " + index + " is removed.");
                    break;
                case 3:
                    System.out.println("===== Remove the last student =====");
                    studentList.removeLast();
                    System.out.println("The last student is deleted.");
                    break;
                case 4:
                    System.out.println("===== Clear all student list =====");
                    System.out.println("Student List has been cleared!");
                    studentList.clear();
                    break;
                case 5:
                    System.out.println("===== Display all student list =====");
                    studentList.displayAll();
                    if(studentList.isEmpty()){
                        System.out.println("List is empty!");
                    }
                    break;
                case 6:
                    System.out.println("===== Exit the program =====");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input! Try again!");
                    break;
            }
        }
    }
}
