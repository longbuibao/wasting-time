package fa.training.services;

import java.util.ArrayList;

public class PublicationService {
    private BookService bookService;
    private MagazineService magazineService;

    public PublicationService(BookService bookService, MagazineService magazineService) {
        this.bookService = bookService;
        this.magazineService = magazineService;
    }

    public ArrayList<Object> booksAndMagazines(int publicationYear, String publisher) {
        ArrayList<Object> res = new ArrayList<>();
        res.addAll(this.bookService.samePublicationAndPublisher(publicationYear, publisher));
        res.addAll(this.magazineService.samePublicationAndPublisher(publicationYear, publisher));

        return res;
    }
}
