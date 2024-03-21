import java.util.Scanner;
class Book {
    int ISBN;
    String title;
    double price;
    Book(int ISBN, String title, double price) {
        this.ISBN = ISBN;
        this.price = price;
        this.title = title;
    }
    void displayBook() {
        System.out.printf("|%-15d|%-20s|%-10f|\n", ISBN, title, price);
    }
}
public class Lab04_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[100];
        int bookCount = 0;
        int choiceBook;
        do {
            System.out.println("=== Menu ====");
            System.out.println("1. View all books");
            System.out.println("2. Add a new book");
            System.out.println("3. Update a book");
            System.out.println("4. Quit");
            System.out.print("Choose your option: ");
            choiceBook = scanner.nextInt();
            switch (choiceBook) {
                case 1:
                    viewAllBooks(books, bookCount);
                    break;
                case 2:
                    addBook(books, scanner, bookCount);
                    bookCount++;
                    break;
                case 3:
                    updateBook(books, scanner, bookCount);
                    break;
                case 4:
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("Please try again! Incorrect option.");
            }
        } while (choiceBook != 4);
    }
    public static void viewAllBooks(Book[] books, int bookCount) {
        System.out.println("\t\t=== All Books ===");
        System.out.println("=================================================");
        System.out.printf("|%-15s|%-20s|%-10s|\n", "ISBN", "Title", "Price");
        for (int i = 0; i < bookCount; i++) {
            books[i].displayBook();
        }
    }
    public static void addBook(Book[] books, Scanner scanner, int bookCount) {
        scanner.nextLine();
        System.out.println("==== Add Book ====");
        System.out.print("Input ISBN of book: ");
        int ISBN = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Input title of book: ");
        String title = scanner.nextLine();
        System.out.print("Input Price of book: ");
        double price = scanner.nextDouble();

        Book newBook = new Book(ISBN, title, price);
        books[bookCount] = newBook;
        System.out.println("Book added successfully");
    }
    public static void updateBook(Book[] books, Scanner scanner, int bookCount) {
        System.out.println("==== Update Book ====");
        System.out.print("Input ISBN to update: ");
        int isbnFound = scanner.nextInt();
        int foundIndexBook = -1;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].ISBN == isbnFound) {
                foundIndexBook = i;
                break;
            }
        }
        if (foundIndexBook != -1) {
            System.out.println("Please update the following:");
            System.out.print("New ISBN: ");
            int newISBN = scanner.nextInt();
            scanner.nextLine();
            System.out.print("New Title: ");
            String newTitle = scanner.nextLine();
            System.out.print("New Price: ");
            double newPrice = scanner.nextDouble();
            books[foundIndexBook] = new Book(newISBN, newTitle, newPrice);
            System.out.println("Book updated successfully");
        } else {
            System.out.println("Book not found. Try again");
        }
    }
}