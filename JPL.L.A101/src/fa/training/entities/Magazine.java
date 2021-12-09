package fa.training.entities;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Magazine extends Publication{
    private String author;
    private int volume;
    private int edition;

    public Magazine() {
        super();
    }

    public int getVolume() {
        return this.volume;
    }

    public void input() throws IOException, ParseException {
        super.input();

        Scanner in = new Scanner(System.in);
        System.out.println("Input Author: ");
        this.author = in.nextLine();
        System.out.println("Input volume: ");
        this.volume = in.nextInt();
        System.out.println("Input edition: ");
        this.edition = in.nextInt();
    }

    public void display() {
        super.display();

        System.out.println("Author: " + this.author);
        System.out.println("Volume: " + this.volume);
        System.out.println("Edition: " + this.edition);
    }
}
