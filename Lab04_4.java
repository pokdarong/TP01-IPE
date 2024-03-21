import java.util.Locale;
import java.util.Scanner;
class Video {
    private String title;
    private int uploader;
    private int length;
    private String type;
    public Video(String title, int uploader, int length, String type) {
        this.title = title;
        this.uploader = uploader;
        this.length = length;
        this.type = type;
    }
    public String getTitle() {
        return title;
    }
    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", uploader=" + uploader +
                ", length=" + length +
                ", type='" + type + '\'' +
                '}';
    }
}
public class Lab04_4 {
    private static Video[] videos = new Video[100];
    private static int numVideos = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayMenu();
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        while (choice != 4) {
            switch (choice) {
                case 1:
                    viewAllVideos();
                    break;
                case 2:
                    addVideo(scanner);
                    break;
                case 3:
                    searchVideo(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        }
        System.out.println("Goodbye!");
    }
    private static void displayMenu() {
        System.out.println("==== Menu ====");
        System.out.println("1. View all videos");
        System.out.println("2. Add video");
        System.out.println("3. Search video");
        System.out.println("4. Quit");
        System.out.print("Choose an option: ");
    }
    private static void viewAllVideos() {
        for (int i = 0; i < numVideos; i++) {
            System.out.println(videos[i]);
        }
    }
    private static void addVideo(Scanner scanner) {
        System.out.print("Enter video title: ");
        String title = scanner.nextLine();
        System.out.print("Enter video uploader: ");
        int uploader = scanner.nextInt();
        System.out.print("Enter video length: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter video type: ");
        String type = scanner.nextLine();
        videos[numVideos++] = new Video(title, uploader, length, type);
        System.out.println("Video added successfully!");
    }
    private static void searchVideo(Scanner scanner) {
        System.out.print("Enter video title to search: ");
        String title = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < numVideos; i++) {
            if (videos[i].getTitle().toLowerCase().contains(title)) {
                found = true;
                System.out.println("Video found: " + videos[i]);
                break;
            }
        }
        if (!found) {
            System.out.println("Video not found.");
        }
    }
}
