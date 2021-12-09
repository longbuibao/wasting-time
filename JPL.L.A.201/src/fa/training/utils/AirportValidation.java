package fa.training.utils;

import fa.training.entities.Airports;

import java.util.ArrayList;
import java.util.Iterator;

public class AirportValidation {
    public static boolean idValidating(String iD) {
        return Validate.validateId(iD, "AP");
    }

    public static boolean isUnique(ArrayList<Airports> airports, String id) {
        int count = 0;
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getId() != null) {
                if (airports.get(i).getId().equals(id)) {
                    count += 1;
                }

            }
        }

        return count == 1;
    }
}
