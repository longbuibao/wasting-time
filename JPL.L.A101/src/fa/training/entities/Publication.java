package fa.training.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.IOException;
import java.util.Date;

public abstract class Publication {
    protected int publicationYear;
    protected String publisher;
    protected Date publicationDate;

    Publication() {
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void input() throws IOException, ParseException {
        Scanner in = new Scanner(System.in);
        System.out.println("Input Publisher: ");
        String publisher = in.nextLine();
        System.out.println("Input publicationYear: ");
        int publicationYear = in.nextInt();

        System.out.println("Input publicationDate: yyyy-MM-dd");

        String strDate = in.next();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);

        this.publicationDate = date;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
    }

    public void display() {
        System.out.println("publicationYear: " + this.publicationYear);
        System.out.println("publisher: " + this.publisher);
        System.out.println("publicationDate: " + this.publicationDate);
    }
}
