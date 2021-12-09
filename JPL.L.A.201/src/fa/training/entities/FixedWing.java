package fa.training.entities;

import fa.training.utils.FixedWingValidation;
import fa.training.utils.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public class FixedWing extends Airplane {
    private String planeType;
    private float minNeededRunway;

    public FixedWing() {
        super();
    }

    public void fly() {
        System.out.println("Fixed Wing Took-off");
    }

    public String getPlaneType() {
        return this.planeType;
    }

    public String getModel() {
        return this.model;
    }

    public String getId() {
        return this.id;
    }

    public float getMinNeededRunway() {
        return minNeededRunway;
    }

    public void changeTypeAndMinNeeded(){
        Scanner in = new Scanner(System.in);
        String type;
        float minNeeded;
        do {
            System.out.println("Input Type: ");
            type = in.next();

            System.out.println("Input MinNeeded: ");
            minNeeded = in.nextInt();
        } while (!FixedWingValidation.typeValidating(this));

        this.planeType = type;
        this.minNeededRunway = minNeeded;
    }

    @Override
    public void land(String airportId, ArrayList<Airports> airports) {
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getId().equals(airportId)) {
                airports.get(i).addFixedWing(this);
            }
        }
    }

    public void input(Airports airports) {
        super.input();

        Scanner in = new Scanner(System.in);

        System.out.println("Input minNeededRunway: ");
        this.minNeededRunway = in.nextFloat();

        do {
            System.out.println("Input planeType: ");
            this.planeType = in.next();
        } while (!FixedWingValidation.typeValidating(this));

        String id= "";

        do {
            System.out.println("Input id: ");
            id = in.next();
        } while (!FixedWingValidation.idValidating(id) || !FixedWingValidation.isIdUnique(airports, id));
        this.id = id;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("planeType: " + this.planeType);
        System.out.println("minNeededRunway: " + this.minNeededRunway);
        System.out.println("=====================================================");
    }
}
