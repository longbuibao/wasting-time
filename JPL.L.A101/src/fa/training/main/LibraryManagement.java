package fa.training.main;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import fa.training.entities.Magazine;
import fa.training.entities.Book;
import fa.training.services.MagazineService;
import fa.training.services.BookService;

public class LibraryManagement {
    public static void displayBooksAndMagazines(
            MagazineService magazineService, BookService bookService, String publisher, int publicationYear
    ) {
        MagazineService.displayMagazines(magazineService.samePublicationAndPublisher(publicationYear, publisher));
        BookService.displayBooks(bookService.samePublicationAndPublisher(publicationYear, publisher));
    }

    public static void main(String args[]) throws IOException, ParseException {

        MagazineService magazineService = new MagazineService();
        BookService bookService = new BookService();


        int selection = -1;
        String choice = "y";
        do {
            System.out.println("====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add a book");
            System.out.println("2. Add a magazine");
            System.out.println("3. Display books and magazines");
            System.out.println("4. Add author to book");
            System.out.println("5. Display top 10 of magazines by volume");
            System.out.println("6. Search book by isbn");
            System.out.println("7. Search book by author");
            System.out.println("8. Search book by publisher");
            System.out.println("0. Exit");

            Scanner in = new Scanner(System.in);

            System.out.println("Input Your Choice: ");
            selection = in.nextInt();

            switch (selection) {
                case 1:
                    Book book = new Book();
                    book.input();
                    bookService.addBook(book);
                    break;
                case 2:
                    Magazine magazine = new Magazine();
                    magazine.input();
                    magazineService.addMagazine(magazine);
                    break;
                case 3:
                    System.out.println("Input Year: ");
                    int year = in.nextInt();
                    System.out.println("Input Publisher: ");
                    String publisher = in.nextLine();
                    LibraryManagement.displayBooksAndMagazines(magazineService, bookService, publisher, year);
                    break;
                case 4:
                    System.out.println("Input isbn: ");
                    String isbn = in.next();

                    System.out.println("Input Author: ");
                    String author = in.next();
                    System.out.println(bookService.addAuthor(isbn, author));
                    break;
                case 5:
                    MagazineService.displayMagazines(magazineService.topTenMagazine());
                    break;
                case 6:
                    System.out.println("Input isbn: ");
                    String isbn2 = in.next();
                    BookService.displayBooks(bookService.searchByIsbn(isbn2));
                    break;
                case 7:
                    System.out.println("Input author: ");
                    String author2 = in.next();
                    BookService.displayBooks(bookService.searchByAuthor(author2));
                    break;
                case 8:
                    System.out.println("Input publisher: ");
                    String publisher2 = in.next();
                    BookService.displayBooks(bookService.searchByPublisher(publisher2));
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
            System.out.println("Do you want to continue? (Press y/n)");
            choice = in.next();
        } while (choice.equals("y"));
    }
}
