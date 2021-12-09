package fa.training.utils;

public class Utils {
    public static boolean validate(String isbn) {
        if(isbn.length() > 17 || isbn.length() < 10) return false;

        String[] arrOfStr = isbn.split("-", 0);

        if (arrOfStr.length == 0) {
            System.out.println("Please include \"-\" character! ");
            return false;
        }

        for (int i = 0; i < arrOfStr.length; i++) {
            try {
                Integer.parseInt(arrOfStr[i]);
            } catch (java.lang.NumberFormatException error) {
                System.out.println("Please input with \"num-num-num\" format. Ex: 678-3-16-1486 ");
                return false;
            }
        }
        return true;
    }
}
