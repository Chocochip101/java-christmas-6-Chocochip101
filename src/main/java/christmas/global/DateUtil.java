package christmas.global;

import static christmas.global.ErrorMessage.INVALID_DATE_ERROR;

import java.util.Date;

public class DateUtil {
    public static final int YEAR = 2023;
    public static final int MONTH = 12;
    public static final int MIN_YEAR= 1970;
    public static final int MAX_YEAR = 2023;
    public static final int MIN_MONTH= 1;
    public static final int MAX_MONTH = 12;
    public static final int MIN_DAY= 1;
    public static final int MAX_DAY = 31;

    public static int convertInputToDate(final String userInput) {
        return getInteger(userInput);
    }

    private static int getInteger(final String userInput) {
        checkInteger(userInput);
        return stringToInt(userInput);
    }

    private static void checkInteger(final String userInput) {
        try {
            stringToInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR.getMessage());
        }
    }

    private static int stringToInt(final String userInput) {
        return Integer.parseInt(userInput);
    }
}
