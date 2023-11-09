package christmas.ui;

public class OutputView {

    public static final String EVENT_DATE_INPUT_COMMAND = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printExpectedVisitDate() {
        System.out.println(EVENT_DATE_INPUT_COMMAND);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

}
