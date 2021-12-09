package fa.training.entities;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import fa.training.utils.Utils;

public class Book extends Publication {
    private String isbn;
    private Set<String> author;
    private String publicationPlace;

    public String getIsbn() {
        return this.isbn;
    }

    public Set<String> getAuthor() {
        return this.author;
    }

    public Book() {
        super();
        this.author = new HashSet<String>();
    }

    public void display() {
        super.display();

        System.out.println("Isbn: " + this.isbn);
        System.out.println("Author: " + this.author);
        System.out.println("Publication Place: " + this.publicationPlace);
    }

    public void input() throws IOException, ParseException {
        super.input();
        Scanner in = new Scanner(System.in);

        System.out.println("Input author: ");
        String author = in.nextLine();
        System.out.println("Input publicationPlace: ");
        String publicationPlace = in.nextLine();

        do {
            System.out.println("Input isbn: ");
            this.isbn = in.next();
        }while (!Utils.validate(isbn));

        this.author.add(author);
        this.publicationPlace = publicationPlace;
    }
}
