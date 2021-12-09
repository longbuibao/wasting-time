package fa.training.utils;

public class Validate {
    public static boolean validateId(String id, String predit) {
        if(id.length() < 7) return false;

        if (id.charAt(0) == predit.charAt(0) && id.charAt(1) == predit.charAt(1)) {
            String digits = id.substring(2, 7);
            try {
                int number = Integer.parseInt(digits);
            } catch (NumberFormatException error) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean validateModel(String model) {
        return model.length() <= 40 && model.length() >= 0;
    }
}
