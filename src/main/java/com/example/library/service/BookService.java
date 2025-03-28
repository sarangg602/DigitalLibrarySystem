package com.example.library.service;

import com.example.library.dao.BookDAO;
import com.example.library.model.Book;
import java.util.List;
import java.util.Scanner;

public class BookService {
    private final BookDAO bookDAO = new BookDAO();

    public void addBook(Scanner scanner) {
        System.out.print("\nEnter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (bookDAO.getBookById(id) != null) {
            System.out.println("Error: Book ID already exists!");
            return;
        }

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability (Available / Checked Out): ");
        String availability = scanner.nextLine();

        Book book = new Book(id, title, author, genre, availability);
        bookDAO.addBook(book);
        System.out.println("Book added successfully!");
    }

    public void viewAllBooks() {
        List<Book> books = bookDAO.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("\nNo books available.");
        } else {
            System.out.println("\n=== Book List ===");
            for (Book book : books) {
                displayBookDetails(book);
            }
        }
    }

    public void searchBook(Scanner scanner) {
        System.out.println("\n=== Search Book ===");
        System.out.print("Search by (1) ID or (2) Title: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("\nEnter Book ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Book book = bookDAO.getBookById(id);
            if (book != null) {
                System.out.println("\nBook Found:");
                displayBookDetails(book);
            } else {
                System.out.println("\nBook not found.");
            }

        } else if (choice == 2) {
            System.out.print("\nEnter Book Title: ");
            String title = scanner.nextLine();

            List<Book> books = bookDAO.getBooksByTitle(title);
            if (books.isEmpty()) {
                System.out.println("\nNo books found with the given title.");
            } else {
                System.out.println("\nBooks Found:");
                for (Book book : books) {
                    displayBookDetails(book);
                }
            }
        } else {
            System.out.println("\nInvalid choice! Please select 1 or 2.");
        }
    }

    public void updateBook(Scanner scanner) {
        System.out.print("\nEnter Book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book book = bookDAO.getBookById(id);
        if (book == null) {
            System.out.println("Book ID not found.");
            return;
        }

        while (true) {
            System.out.println("\nWhat do you want to update?");
            System.out.println("1. Title");
            System.out.println("2. Author");
            System.out.println("3. Genre");
            System.out.println("4. Availability");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new Title: ");
                    book.setTitle(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter new Author: ");
                    book.setAuthor(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter new Genre: ");
                    book.setGenre(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter new Availability (Available / Checked Out): ");
                    book.setAvailability(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Exiting update menu.");
                    bookDAO.updateBook(book);
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public void deleteBook(Scanner scanner) {
        System.out.print("\nEnter Book ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (bookDAO.getBookById(id) == null) {
            System.out.println("Book ID not found.");
            return;
        }

        bookDAO.deleteBook(id);
        System.out.println("Book deleted successfully!");
    }

    private void displayBookDetails(Book book) {
        System.out.println("----------------------------------------");
        System.out.println("ID           : " + book.getId());
        System.out.println("Title        : " + book.getTitle());
        System.out.println("Author       : " + book.getAuthor());
        System.out.println("Genre        : " + book.getGenre());
        System.out.println("Availability : " + book.getAvailability());
        System.out.println("----------------------------------------");
    }
}
