package fa.training.entities;

import fa.training.utils.FixedWingValidation;
import fa.training.utils.HelicopterValidation;

import java.util.ArrayList;
import java.util.Scanner;

public class Helicopter extends Airplane {
    private float range;

    public float getMaxTakeOffWeight() {
        return this.maxTakeOffWeight;
    }

    public String getId() {
        return this.id;
    }

    public float getEmptyWeight() {
        return this.emptyWeight;
    }

    public void fly() {
        System.out.println("Rotated Wing");
    }

    @Override
    public void land(String airportId, ArrayList<Airports> airports) {
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getId().equals(airportId)) {
                airports.get(i).addHelicopter(this);
            }
        }
    }

    public void input(Airports airports) {
        super.input();

        Scanner in = new Scanner(System.in);

        System.out.println("Input range: ");
        this.range = in.nextFloat();

        String id= "";

        do {
            System.out.println("Input id: ");
            id = in.next();
        } while (!HelicopterValidation.idValidating(id) || !HelicopterValidation.isIdUnique(airports, id));
        this.id = id;

        if(!HelicopterValidation.maxTakeOffValidating(this)) {
            do {
                System.out.println("Input maxTakeOffWeight: ");
                this.maxTakeOffWeight = in.nextFloat();
            } while (!HelicopterValidation.maxTakeOffValidating(this));
        }
    }

    @Override
    public void display() {
        super.display();

        System.out.println("range: " + this.range);
        System.out.println("=====================================================");
    }
}
