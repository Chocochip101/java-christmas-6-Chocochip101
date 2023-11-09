package christmas.global;

public class Validation {
    private static final String INVALID_INTEGER_ERROR = "유효하지 않은 정수입니다. 다시 입력해 주세요.";

    public static int getInteger(final String userInput) {
        checkInteger(userInput);
        return stringToInt(userInput);
    }

    private static void checkInteger(final String userInput) {
        try {
            stringToInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INTEGER_ERROR);
        }
    }

    private static int stringToInt(final String userInput) {
        return Integer.parseInt(userInput);
    }
}
