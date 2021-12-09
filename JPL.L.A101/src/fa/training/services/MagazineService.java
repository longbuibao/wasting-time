package fa.training.services;

import fa.training.entities.Magazine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MagazineService {
    private ArrayList<Magazine> magazines;

    public MagazineService() {
        this.magazines = new ArrayList<>();
    }

    public void addMagazine(Magazine magazine) {
        this.magazines.add(magazine);
    }

    public ArrayList<Magazine> samePublicationAndPublisher(int publicationYear, String publisher) {
        ArrayList<Magazine> temp = new ArrayList<>();
        temp.addAll(this.magazines);

        temp.removeIf(magazine -> (
                !(magazine.getPublisher().equals(publisher)) || (magazine.getPublicationYear() != publicationYear))
        );

        return temp;
    }

    public ArrayList<Magazine> topTenMagazine() {
        ArrayList<Magazine> temp = new ArrayList<>();

        temp.addAll(this.magazines);
        Collections.sort(temp, Comparator.comparing(Magazine::getVolume).reversed());

        return temp;
    }

    public static void displayMagazines(ArrayList<Magazine> magazines) {
        int size = magazines.size();
        for (int i = 0; i < size; i++) {
            magazines.get(i).display();
        }
    }
}
