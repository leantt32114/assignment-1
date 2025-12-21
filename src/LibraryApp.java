import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> printBooks();
                case 2 -> addBook();
                case 3 -> searchByTitle();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 7 -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void printMenu() {
        System.out.println("""
                1. Print all books
                2. Add new book
                3. Search books by title
                4. Borrow a book
                5. Return a book
                6. Delete a book by id
                7. Quit
                """);
    }

    private void printBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void addBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        books.add(new Book(title, author, year));
    }

    private void searchByTitle() {
        System.out.print("Enter title: ");
        String query = scanner.nextLine().toLowerCase();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query)) {
                System.out.println(book);
            }
        }
    }

    private void borrowBook() {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isAvailable()) {
                    book.markAsBorrowed();
                } else {
                    System.out.println("Book already borrowed");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void returnBook() {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isAvailable()) {
                    book.markAsReturned();
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void deleteBook() {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        books.removeIf(book -> book.getId() == id);
    }
}
