package fa.training.entities;

import fa.training.utils.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Airplane {
    protected String id;
    protected String model;
    protected float cruseSpeed;
    protected float emptyWeight;
    protected float maxTakeOffWeight;

    public abstract void fly();

    public abstract void land(String airportId, ArrayList<Airports> airports);

    public Airplane() {
    }

    public void input() {
        Scanner in = new Scanner(System.in);

        String model = "";

        do {
            System.out.println("Input model: ");
            model = in.nextLine();
        } while (!Validate.validateModel(model));

        this.model = model;

        System.out.println("Input cruseSpeed: ");
        this.cruseSpeed = in.nextFloat();

        System.out.println("Input emptyWeight: ");
        this.emptyWeight = in.nextFloat();

        System.out.println("Input maxTakeOffWeight: ");
        this.maxTakeOffWeight = in.nextFloat();

    }

    public void display() {
        System.out.println("=====================================================");
        System.out.println("Id: " + this.id);
        System.out.println("Model: " + this.model);
        System.out.println("cruseSpeed: " + this.cruseSpeed);
        System.out.println("emptyWeight: " + this.emptyWeight);
        System.out.println("maxTakeOffWeight: " + this.maxTakeOffWeight);
    }
}
