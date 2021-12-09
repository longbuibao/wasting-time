package fa.training.utils;

import fa.training.entities.Airports;
import fa.training.entities.Helicopter;

import java.util.ArrayList;

public class HelicopterValidation {
    public static boolean idValidating(String iD) {
        return Validate.validateId(iD, "RW");
    }

    public static boolean maxTakeOffValidating(Helicopter helicopter) {
        return helicopter.getMaxTakeOffWeight() <= 1.5 * helicopter.getEmptyWeight() ? true : false;
    }

    public static boolean isIdUnique(Airports airports, String id) {
        ArrayList<String> temp = new ArrayList<>();

        if (airports.getListOfHelicopterId() == null) return true;

        temp.addAll(airports.getListOfHelicopterId());

        if (temp.indexOf(id) >= 0) return false;
        return true;
    }
}
