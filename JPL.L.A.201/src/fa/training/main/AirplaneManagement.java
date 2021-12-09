package fa.training.main;

import fa.training.entities.Airports;
import fa.training.entities.FixedWing;
import fa.training.entities.Helicopter;
import fa.training.services.AirportService;
import fa.training.services.FixedWingService;
import fa.training.services.HelicopterService;
import fa.training.utils.AirportValidation;
import fa.training.utils.Validate;

import java.util.*;

public class AirplaneManagement {
    public static void main(String[] args) {

        ArrayList<Airports> arr = new ArrayList<>();
        FixedWingService fixedWingService = new FixedWingService();
        HelicopterService helicopterService = new HelicopterService();

        for (int i = 0; i < 4; i++) {
            Airports airports = new Airports(
                    "AP0000" + i,
                    "A" + i,
                    10,
                    10,
                    10
            );
            arr.add(airports);
        }

        int selection = -1;
        String choice = "y";
        do {
            System.out.println("====== AIRPLANE MANAGEMENT SYSTEM ======");
            System.out.println("1. Display list of all airports information, sorted by airport ID");
            System.out.println("2. Display the status of one airport, selected by airport ID");
            System.out.println("3. Display list of all fixed wing airplanes with its parking airport ID and name");
            System.out.println("4. Display list of all helicopters with its parking airport ID and name");
            System.out.println("5. Input airports");
            System.out.println("6. Input FixedWing to airports");
            System.out.println("7. Input Helicopter to airports");
            System.out.println("8. Remove FixedWing from airports");
            System.out.println("9. Remove Helicopter from airports");
            System.out.println("0. Write to text file and exit");
            System.out.println("========================================");

            Scanner in = new Scanner(System.in);

            System.out.println("Input Your Choice: ");
            try {
                selection = in.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println(" ==========================");
                System.out.println(" | PLEASE INPUT AN INTEGER |");
                System.out.println(" ==========================");
                continue;
            }

            switch (selection) {
                case 0:
                    System.exit(0);
                case 1:
                    AirportService.displayAllAirports(arr);
                    break;
                case 2:
                    AirportService.displayOneAirport(arr);
                    break;
                case 3:
                    fixedWingService.display();
                    break;
                case 4:
                    helicopterService.display();
                    break;
                case 5:
                    AirportService.inputAirports(arr);
                    break;
                case 6:
                    AirportService.inputFixedWing(arr, fixedWingService);
                    break;
                case 7:
                    AirportService.inputHelicopter(arr, helicopterService);
                    break;
                case 8:
                    fixedWingService.removeFixedWing();
                    break;
                case 9:
                    helicopterService.removeHelicopter();
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
            System.out.println("Do you want to continue? (Press y/n)");
            choice = in.next();
        } while (choice.equals("y"));

    }
}
