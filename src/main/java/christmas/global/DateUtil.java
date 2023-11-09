package christmas.global;

public class DateUtil {
    private static final String INVALID_DATE_ERROR = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    public static int convertInputToDate(final String userInput) {
        return getInteger(userInput);
    }

    private static void checkDateInRange(final int userDate) {
        if (!isInDateRange(userDate)) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR);
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
            throw new IllegalArgumentException(INVALID_DATE_ERROR);
        }
    }

    private static int stringToInt(final String userInput) {
        return Integer.parseInt(userInput);
    }
}