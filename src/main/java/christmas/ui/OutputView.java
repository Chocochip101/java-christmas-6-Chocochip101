package christmas.ui;

import christmas.domain.Order;
import christmas.domain.Schedule;
import christmas.domain.menus.Gift;
import christmas.domain.menus.Menus;
import java.util.Map;

public class OutputView {

    private static final String EVENT_DATE_INPUT_COMMAND = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_MENU_INPUT_COMMAND = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String EVENT_PREVIEW = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_OUTPUT_COMMAND = "<주문 메뉴>";
    private static final String TOTAL_PRICE_WITHOUT_DISCOUNT_COMMAND = "<할인 전 총주문 금액>";
    private static final String GIFT_MENU_COMMAND = "<증정 메뉴>";
    private static final String TOTAL_PRICE_OUTPUT = "%,d원";
    private static final String ONE_ORDER_MENU_OUTPUT = "%s %d개";
    private static final String NOTHING = "없음";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printExpectedVisitDate() {
        System.out.println(EVENT_DATE_INPUT_COMMAND);
    }

    public static void printOrderMenu() {
        System.out.println(ORDER_MENU_INPUT_COMMAND);
    }

    public static void printEventPreview(Schedule schedule) {
        System.out.println(String.format(EVENT_PREVIEW, schedule.getMonth(), schedule.getDay()));
        printNewLine();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public static void printOrderMenus(Order order) {
        System.out.println(ORDER_MENU_OUTPUT_COMMAND);
        printAllMenus(order);
    }

    private static void printAllMenus(Order order) {
        Map<Menus, Integer> orders = order.getOrders();
        for (Menus menu : orders.keySet()) {
            printOneMenu(menu.getName(), orders.get(menu));
        }
        printNewLine();
    }

    public static void printTotalWithoutDiscount(int totalPrice) {
        System.out.println(TOTAL_PRICE_WITHOUT_DISCOUNT_COMMAND);
        System.out.println(String.format(TOTAL_PRICE_OUTPUT, totalPrice));
        printNewLine();
    }

    public static void printGiftMenu(boolean hasGiftMenu) {
        System.out.println(GIFT_MENU_COMMAND);
        if (hasGiftMenu) {
            printOneMenu(Gift.CHAMPAGNE.getName(), Gift.CHAMPAGNE.getCount());
            return;
        }
        System.out.println(NOTHING);
    }

    private static void printOneMenu(String menuName, int menuCount) {
        System.out.println(String.format(ONE_ORDER_MENU_OUTPUT, menuName, menuCount));
    }

    private static void printNewLine() {
        System.out.println();
    }
}
