package fa.training.services;

import fa.training.entities.FixedWing;

import java.util.ArrayList;
import java.util.Scanner;

class FixedWingAndAirport {
    private String airportId;
    private String airportName;
    private FixedWing fixedWing;

    FixedWingAndAirport() {
    }

    FixedWingAndAirport(String airportId, String airportName, FixedWing fixedWing) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.fixedWing = fixedWing;
    }

    public FixedWing getFixedWing() {
        return this.fixedWing;
    }

    public void display() {
        System.out.println("AirportId: " + this.airportId);
        System.out.println("AirportName: " + this.airportName);
        this.fixedWing.display();
    }
}

public class FixedWingService {
    private ArrayList<FixedWing> fixedWings;
    private ArrayList<FixedWingAndAirport> fixedWingAndAirports;

    public FixedWingService() {
        fixedWings = new ArrayList<>();
        fixedWingAndAirports = new ArrayList<>();
    }

    public void addFixedWing(FixedWing fixedWing, String airportId, String airportName) {
        this.fixedWings.add(fixedWing);
        this.fixedWingAndAirports.add(new FixedWingAndAirport(airportId, airportName, fixedWing));
    }

    public void display() {
        System.out.println(this.fixedWingAndAirports.size());

        if (this.fixedWingAndAirports.size() == 0) {
            System.out.println("Empty fixedWingAndAirports");
            return;
        }

        for (int i = 0; i < this.fixedWingAndAirports.size(); i++) {
            this.fixedWingAndAirports.get(i).display();
        }
    }

    public void removeFixedWing() {
        Scanner in = new Scanner(System.in);

        System.out.println("Input id of FixedWing to remove: ");
        String id = in.nextLine();

        int index = -1;

        for (int i = 0; i < this.fixedWings.size(); i++) {
            FixedWing fixedWing = this.fixedWings.get(i);
            if (fixedWing.getId().equals(id)) {
                index = i;
            }
        }

        if (index > -1) {
            this.fixedWings.remove(index);
        }
        else {
            System.out.println("Not found this id");
            return;
        }

        int index2 = -1;
        for (int i = 0; i < this.fixedWingAndAirports.size(); i++) {
            FixedWingAndAirport fixedWingAndAirport = this.fixedWingAndAirports.get(i);
            if (fixedWingAndAirport.getFixedWing().getId().equals(id)) {
                index2 = i;
            }
        }

        if (index2 > -1) {
            this.fixedWingAndAirports.remove(index);
        }
    }

}

