package christmas.ui;

import static christmas.ui.InputCommand.*;
import static christmas.ui.OutputCommand.*;

import christmas.domain.Order;
import christmas.domain.Schedule;
import christmas.domain.menus.Gift;
import christmas.domain.menus.Menus;
import java.util.Map;

public class OutputView {
    public static void printWelcomeCommand() {
        System.out.println(WELCOME_COMMAND);
    }

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
        System.out.println(NOTHING_OUTPUT);
    }

    private static void printOneMenu(String menuName, int menuCount) {
        System.out.println(String.format(ONE_ORDER_MENU_OUTPUT, menuName, menuCount));
    }

    private static void printNewLine() {
        System.out.println();
    }
}
