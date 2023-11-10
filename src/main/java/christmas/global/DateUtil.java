package christmas.global;

import static christmas.global.ErrorMessage.INVALID_DATE_ERROR;

public class DateUtil {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    public static int convertInputToDate(final String userInput) {
        return getInteger(userInput);
    }

    private static void checkDateInRange(final int userDate) {
        if (!isInDateRange(userDate)) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR.getMessage());
        }
    }

    private static boolean isInDateRange(final int userDate) {
        return MIN_DATE <= userDate && userDate <= MAX_DATE;
    }

    private static int getInteger(final String userInput) {
        checkInteger(userInput);
        int userDate = stringToInt(userInput);
        checkDateInRange(userDate);
        return userDate;
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
