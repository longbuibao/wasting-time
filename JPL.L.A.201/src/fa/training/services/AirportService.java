package fa.training.services;

import fa.training.entities.Airports;
import fa.training.entities.FixedWing;
import fa.training.entities.Helicopter;
import fa.training.utils.AirportValidation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AirportService {
    public static void displayAllAirports(ArrayList<Airports> arr) {
        int count = 0;

        for (Airports value : arr) {
            if (value.getId() == null) {
                ++count;
            }
        }
        if (count == 4) {
            System.out.println("Empty Airports");
            return;
        }


        arr.sort(Comparator.comparing(Airports::getId));

        for (Airports airports : arr) {
            airports.display();
        }
    }

    public static void displayOneAirport(ArrayList<Airports> arr) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input Id Of Airport: ");
        String id = in.next();

        for (Airports airports : arr) {
            if (airports.getId() == null) {
                System.out.println("There is no airport with this id or empty AirportList");
                return;
            }
            if (airports.getId().equals(id)) {
                airports.display();
            }
        }
    }

    public static void inputAirports(ArrayList<Airports> arr) {
        for (int i = 0; i < arr.size(); i++) {
            String id = "";
            do {
                arr.get(i).input();
                id = arr.get(i).getId();
            } while (!AirportValidation.isUnique(arr, id));
        }
    }

    public static void inputFixedWing(ArrayList<Airports> arr, FixedWingService fixedWingService) {
        Scanner in = new Scanner(System.in);
        if (arr.size() == 0) {
            System.out.println("Airport is empty!");
        } else {
            System.out.println("Input Id Of Airport: ");
            String idAir = in.next();

            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId().equals(idAir)) {
                    FixedWing fixedWing = new FixedWing();
                    fixedWing.input(arr.get(i));
                    fixedWingService.addFixedWing(fixedWing, arr.get(i).getId(), arr.get(i).getName());
                    fixedWing.land(arr.get(i).getId(), arr);
                    return;
                }
            }
            System.out.println("Not found this airport id!");
        }
    }

    public static void inputHelicopter(ArrayList<Airports> arr, HelicopterService helicopterService) {
        Scanner in = new Scanner(System.in);
        if (arr.size() == 0) {
            System.out.println("Airport is empty!");
        } else {
            System.out.println("Input Id Of Airport: ");
            String idAir = in.next();

            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId().equals(idAir)) {
                    Helicopter helicopter = new Helicopter();
                    helicopter.input(arr.get(i));
                    helicopterService.addHelicopter(helicopter, arr.get(i).getId(), arr.get(i).getName());
                    helicopter.land(arr.get(i).getId(), arr);
                    return;
                }
            }
            System.out.println("Not found this airport id!");
        }
    }
}
