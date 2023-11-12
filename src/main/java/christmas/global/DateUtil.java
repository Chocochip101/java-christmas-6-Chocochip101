package christmas.global;

import static christmas.global.ErrorMessage.INVALID_DATE_ERROR;

import java.time.LocalDate;
import java.util.Date;

public class DateUtil {
    public static final int YEAR = 2023;
    public static final int MONTH = 12;
    public static final int MIN_YEAR = 1970;
    public static final int MAX_YEAR = 2023;
    public static final int MIN_MONTH = 1;
    public static final int MAX_MONTH = 12;
    public static final int MIN_DAY = 1;
    public static final int CHRISTMAS_DAY = 25;
    public static final int DAY_EVENT_STEPS = 1;
    public static final int MAX_DAY = 31;

    public enum STAR {
        DEC_3(LocalDate.of(2023, 12, 3)),
        DEC_10(LocalDate.of(2023, 12, 10)),
        DEC_17(LocalDate.of(2023, 12, 17)),
        DEC_24(LocalDate.of(2023, 12, 24)),
        DEC_25(LocalDate.of(2023, 12, 25)),
        DEC_31(LocalDate.of(2023, 12, 31));

        private final LocalDate date;

        STAR(LocalDate date) {
            this.date = date;
        }

        public static boolean isStarDate(LocalDate date) {
            for (STAR star : STAR.values()) {
                if (star.date.equals(date)) {
                    return true;
                }
            }
            return false;
        }
    }

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
