package christmas.ui;

import static christmas.global.EventUtil.NO_DISCOUNT;
import static christmas.ui.InputCommand.*;
import static christmas.ui.OutputCommand.*;

import christmas.domain.Benefit;
import christmas.domain.Order;
import christmas.domain.Schedule;
import christmas.domain.discounts.Discount;
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
            printOneMenu(menu, orders.get(menu));
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
            printOneMenu(Gift.CHAMPAGNE.getGift(), Gift.CHAMPAGNE.getCount());
            printNewLine();
            return;
        }
        System.out.println(NOTHING_OUTPUT);
        printNewLine();
    }

    private static void printOneMenu(Menus menus, int menuCount) {
        System.out.println(String.format(ONE_ORDER_MENU_OUTPUT, menus.getName(), menuCount));
    }

    public static void printBenefit(Benefit benefit) {
        System.out.println(BENEFIT_COMMAND);
        printDiscounts(benefit);
        printNewLine();
    }

    private static void printDiscounts(Benefit benefit) {
        for (Discount discount : benefit.getDiscountInformation()) {
            if (discount.getDiscount() != 0) {
                printOneDiscount(discount);
            }
        }
    }

    private static void printOneDiscount(Discount discount) {
        System.out.println(String.format(ONE_DISCOUNT_OUTPUT, discount.getDiscountName(), discount.getDiscount()));
    }

    public static void printTotalBenefit(int totalBenefit) {
        System.out.println(TOTAL_BENEFIT_COMMAND);
        System.out.println(String.format(TOTAL_BENEFIT_OUTPUT, totalBenefit));
    }

    public static void printNothingBenefit() {
        System.out.println(BENEFIT_COMMAND);
        System.out.println(NOTHING_OUTPUT);
        printNewLine();
    }

    public static void printNothingTotalBenefit() {
        System.out.println(TOTAL_BENEFIT_COMMAND);
        System.out.println(String.format(TOTAL_PRICE_OUTPUT, NO_DISCOUNT));
    }

    private static void printNewLine() {
        System.out.println();
    }
}
