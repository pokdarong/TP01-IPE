import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Studentt {
    private int no;
    private int id;
    private String name;
    private int age;
    public Studentt(int no, int id, String name, int age) {
        this.no = no;
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return String.format("|%3d| %4d | %-20s |%4d |", no, id, name, age);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Studentt> students = new ArrayList<>();
        System.out.println("Enter student information (or 'exit' to quit)");
        while (true) {
            System.out.printf("Number#");
            int no = input.nextInt();
            System.out.printf("ID: ");
            int id = input.nextInt();
            input.nextLine(); // Consume newline
            System.out.printf("Name: ");
            String name = input.nextLine();
            System.out.printf("Age: ");
            int age = input.nextInt();
            students.add(new Studentt(no,id, name, age));
            System.out.printf("Do you want to add more (yes/no): ");
            String choice = input.next(); // Use input.next() to read a single word

            if (choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("exit")) {
                break;
            }
        }
        // Convert ArrayList to array
        Studentt[] studentArray = students.toArray(new Studentt[students.size()]);
        // Print the array
        System.out.println("=========================================");
        System.out.println("|No |  ID  |         Name         | Age |");
        System.out.println("=========================================");

        for (Studentt student : studentArray) {
            System.out.println(student);
        }
        System.out.println("=========================================");
    }
}