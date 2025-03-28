package com.example.library.main;

import com.example.library.service.BookService;
import java.util.Scanner;

public class LibraryApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        
        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                scanner.next(); // Consume invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    bookService.addBook(scanner);
                    break;
                case 2:
                    bookService.viewAllBooks();
                    break;
                case 3:
                    bookService.searchBook(scanner);
                    break;
                case 4:
                    bookService.updateBook(scanner);
                    break;
                case 5:
                    bookService.deleteBook(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n============================================");
        System.out.println("      Digital Library Management System      ");
        System.out.println("============================================");
        System.out.println("1. Add a Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book by ID or Title");
        System.out.println("4. Update Book Details");
        System.out.println("5. Delete a Book");
        System.out.println("6. Exit System");
        System.out.println("============================================");
    }
}
