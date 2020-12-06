import java.io.EOFException;
import java.util.FormatFlagsConversionMismatchException;

class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {

        try {
            return Double.parseDouble(input);
        } catch (RuntimeException exception) {
            //exception
            return 0;
        }
    }
}