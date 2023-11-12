package christmas.domain.discounts;

import static christmas.global.EventUtil.DAY_DISCOUNT_AMOUNT;
import static christmas.global.EventUtil.NO_DISCOUNT;
import static christmas.global.EventUtil.WEEKDAY_DISCOUNT_NAME;

import christmas.domain.Reservation;
import christmas.domain.menus.Dessert;
import christmas.domain.menus.Menus;
import java.util.Map;

class WeekDayDiscount implements Discount {
    private final int weekDayDiscount;

    WeekDayDiscount(Reservation reservation) {
        this.weekDayDiscount = initializeDiscount(reservation);
    }

    @Override
    public int initializeDiscount(Reservation reservation) {
        int discountAmount = NO_DISCOUNT;
        Map<Menus, Integer> orders = reservation.getOrder().getOrders();

        for (Menus menu : orders.keySet()) {
            if (menu instanceof Dessert) {
                discountAmount += orders.get(menu) * DAY_DISCOUNT_AMOUNT;
            }
        }

        return discountAmount;
    }


    @Override
    public int getDiscount() {
        return weekDayDiscount;
    }

    @Override
    public String getDiscountName() {
        return WEEKDAY_DISCOUNT_NAME;
    }
}
