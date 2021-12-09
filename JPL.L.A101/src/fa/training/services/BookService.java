package fa.training.services;

import fa.training.entities.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class BookService {
    private ArrayList<Book> books;

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public BookService() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        Iterator<Book> iterator = this.books.iterator();

        while (iterator.hasNext()) {
            Book temp = iterator.next();
            if (temp.getIsbn().equals(book.getIsbn())) {
                System.out.println("Already has that isbn");
                return;
            }
        }
        this.books.add(book);
    }

    public static void displayBooks(ArrayList<Book> books) {
        int size = books.size();
        for (int i = 0; i < size; i++) {
            books.get(i).display();
        }
    }

    public ArrayList<Book> samePublicationAndPublisher(int publicationYear, String publisher) {
        ArrayList<Book> temp = new ArrayList<>();
        temp.addAll(this.books);

        temp.removeIf(book ->
                !(book.getPublisher().equals(publisher)) || (book.getPublicationYear() != publicationYear)
        );

        return temp;
    }

    public String addAuthor(String isbn, String author) {
        Iterator<Book> iterator = this.books.iterator();

        Book res = new Book();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                res = book;
            }
        }
        if(res.getAuthor() == null) {
            return "Not found this isbn";
        }
        if (res.getAuthor().contains(author)) {
            return "Author existed";
        } else {
            res.getAuthor().add(author);
            return "Add successfully";
        }
    }

    public ArrayList<Book> searchByIsbn(String isbn) {
        ArrayList<Book> temp = new ArrayList<>();
        temp.addAll(this.books);

        temp.removeIf(book ->
                !(book.getIsbn().equals(isbn))
        );

        Collections.sort(temp, Comparator.comparing(Book::getIsbn));

        return temp;
    }

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> temp = new ArrayList<>();
        temp.addAll(this.books);

        temp.removeIf(book ->
                !book.getAuthor().contains(author)
        );

        Collections.sort(temp, Comparator.comparing(Book::getIsbn));

        return temp;
    }

    public ArrayList<Book> searchByPublisher(String publisher) {
        ArrayList<Book> temp = new ArrayList<>();
        temp.addAll(this.books);

        temp.removeIf(book ->
                !book.getPublisher().equals(publisher)
        );

        Collections.sort(temp, Comparator.comparing(Book::getIsbn));

        return temp;
    }
}
