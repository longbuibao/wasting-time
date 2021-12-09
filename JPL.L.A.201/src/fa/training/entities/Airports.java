package fa.training.entities;

import fa.training.utils.AirportValidation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Airports {
    private String id;
    private String name;
    private float runwaySize;
    private int maxFixedWingParking;
    private int maxRotateWingParking;

    private ArrayList<String> listOfFixedWingId = new ArrayList<>();
    private ArrayList<String> listOfHelicopterId = new ArrayList<>();

    public String getId() {
        return this.id;
    }

    public ArrayList<String> getListOfFixedWingId() {
        return this.listOfFixedWingId;
    }

    public ArrayList<String> getListOfHelicopterId() {
        return this.listOfHelicopterId;
    }

    public Airports() {
    }

    public Airports(String id, String name, float runwaySize, int maxFixedWingParking, int maxRotateWingParking) {
        this.id = id;
        this.name = name;
        this.runwaySize = runwaySize;
        this.maxFixedWingParking = maxFixedWingParking;
        this.maxRotateWingParking = maxRotateWingParking;
    }

    public void input() {
        Scanner in = new Scanner(System.in);

        String id;
        do {
            System.out.println("Input id: ");
            id = in.nextLine();
        } while (!AirportValidation.idValidating(id));

        this.id = id;

        System.out.println("Input name: ");
        String name = in.next();
        this.name = name;

        try {
            System.out.println("Input maxFixedWingParking: ");
            this.maxFixedWingParking = Integer.parseInt(in.next());
        } catch (InputMismatchException error) {
            System.out.println("Please input an Integer");
            return;
        }

        try {
            System.out.println("Input maxRotateWingParking: ");
            this.maxRotateWingParking = Integer.parseInt(in.next());
        } catch (InputMismatchException error) {
            System.out.println("Please input an Integer");
            return;
        }

    }

    public String getName() {
        return this.name;
    }

    public void display() {
        System.out.println("=====================================================");
        System.out.println("Id: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("maxFixWingParking: " + this.maxFixedWingParking);
        System.out.println("maxRotateWingParking: " + this.maxRotateWingParking);
        System.out.println("=====================================================");
    }

    public void addFixedWing(FixedWing fixedWing) {
        int size;
        if (this.listOfFixedWingId == null) {
            size = 0;
        } else size = this.listOfFixedWingId.size();
        if (fixedWing.getMinNeededRunway() < this.runwaySize && size < this.maxFixedWingParking)
            this.listOfFixedWingId.add(fixedWing.getId());
        else System.out.println("Fulled, cannot park!");
    }

    public void addHelicopter(Helicopter helicopter) {
        int size;
        if (this.listOfHelicopterId == null) {
            size = 0;
        } else size = this.listOfHelicopterId.size();
        if (size < this.maxFixedWingParking)
            this.listOfFixedWingId.add(helicopter.getId());
        else System.out.println("Fulled, cannot park!");
    }

}
