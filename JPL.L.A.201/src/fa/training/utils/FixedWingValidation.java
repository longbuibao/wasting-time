package fa.training.utils;

import fa.training.entities.Airports;
import fa.training.entities.FixedWing;

import java.util.ArrayList;

public class FixedWingValidation {
    enum types {CAG, LGR, PRV}

    ;

    public static boolean idValidating(String id) {
        return Validate.validateId(id, "FW");
    }

    public static boolean typeValidating(FixedWing fixedWing) {
        String type = fixedWing.getPlaneType();
        try {
            types typeVal = types.valueOf(type);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        ;
        return true;
    }

    public static boolean isIdUnique(Airports airports, String id) {
        ArrayList<String> temp = new ArrayList<>();

        if (airports.getListOfFixedWingId() == null) return true;

        temp.addAll(airports.getListOfFixedWingId());

        if (temp.indexOf(id) >= 0) return false;
        return true;
    }
}
