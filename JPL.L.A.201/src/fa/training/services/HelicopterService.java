package fa.training.services;

import fa.training.entities.FixedWing;
import fa.training.entities.Helicopter;

import java.util.ArrayList;
import java.util.Scanner;

class HelicopterAndAirport {
    private String airportId;
    private String airportName;
    private Helicopter helicopter;

    HelicopterAndAirport() {
    }

    HelicopterAndAirport(String airportId, String airportName, Helicopter helicopter) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.helicopter = helicopter;
    }
    public void display() {
        System.out.println("AirportId: " + this.airportId);
        System.out.println("AirportName: " + this.airportName);
        this.helicopter.display();
    }

    public Helicopter getHelicopter() {
        return this.helicopter;
    }
}

public class HelicopterService {
    private ArrayList<Helicopter> helicopters;
    private ArrayList<HelicopterAndAirport> helicopterAndAirports;

    public HelicopterService() {
        this.helicopters = new ArrayList<>();
        this.helicopterAndAirports = new ArrayList<>();
    }

    public void addHelicopter(Helicopter helicopter, String airportId, String airportName) {
        this.helicopters.add(helicopter);
        this.helicopterAndAirports.add(new HelicopterAndAirport(airportId, airportName, helicopter));
    }

    public void display() {
        if(this.helicopterAndAirports.size() == 0) {
            System.out.println("Empty HelicopterAndAirport");
            return;
        }
        for (HelicopterAndAirport helicopterAndAirport : this.helicopterAndAirports) {
            helicopterAndAirport.display();
        }
    }

    public void removeHelicopter() {
        Scanner in = new Scanner(System.in);

        System.out.println("Input id of Helicopter to remove: ");
        String id = in.nextLine();

        int index = -1;

        for (int i = 0; i < this.helicopters.size(); i++) {
            Helicopter helicopter = this.helicopters.get(i);
            if (helicopter.getId().equals(id)) {
                index = i;
            }
        }

        if (index > -1) {
            this.helicopters.remove(index);
        }
        else {
            System.out.println("Not found this id");
            return;
        }

        int index2 = -1;
        for (int i = 0; i < this.helicopterAndAirports.size(); i++) {
            HelicopterAndAirport helicopterAndAirport = this.helicopterAndAirports.get(i);
            if (helicopterAndAirport.getHelicopter().getId().equals(id)) {
                index2 = i;
            }
        }

        if (index2 > -1) {
            this.helicopterAndAirports.remove(index);
        }
    }

}
