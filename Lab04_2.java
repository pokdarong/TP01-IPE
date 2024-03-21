import java.util.Scanner;
class Student {
    int age;
    int id;
    String name;
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public void display() {
        System.out.printf("|%-5d|%-20s|%-4d |\n", id, name, age);
    }
}
public class Lab04_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[100];
        int studentCount = 0;
        int choice;
        do {
            System.out.println("==== Menu ===");
            System.out.println("1. View all students");
            System.out.println("2. Add a new student");
            System.out.println("3. Delete a student");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    view(students, studentCount);
                    break;
                case 2:
                    addNewStudent(students, scanner, studentCount);
                    studentCount++;
                    break;
                case 3:
                    deleteStudent(students, scanner, studentCount);
                    studentCount--;
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid number, please choose again!");
            }
        } while (choice != 4);
    }
    public static void view(Student[] students, int count) {
        System.out.println("\t==== All Students ====");
        System.out.println("=====================================");
        System.out.println("| ID |         Name         | Age |");
        System.out.println("=====================================");
        for (int i = 0; i < count; i++) {
            students[i].display();
        }
    }
    public static void addNewStudent(Student[] students, Scanner scanner, int count) {
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student id: ");
        int id = scanner.nextInt();
        Student newStudent = new Student(id, name, age);
        students[count] = newStudent;
        System.out.println("Student added successfully");
    }
    public static void deleteStudent(Student[] students, Scanner scanner, int count) {
        System.out.println("=== Delete a student ===");
        System.out.print("Input student ID: ");
        int deleteID = scanner.nextInt();
        int foundIndex = -1;
        for (int i = 0; i < count; i++) {
            if (students[i].id == deleteID) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) {
            System.out.println("The following student has been deleted: ");
            students[foundIndex].display();

            for (int i = foundIndex; i < count - 1; i++) {
                students[i] = students[i + 1];
            }
            students[count - 1] = null;
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found. Try again.");
        }
    }
}