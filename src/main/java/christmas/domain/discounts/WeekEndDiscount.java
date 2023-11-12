package christmas.domain.discounts;

import static christmas.global.EventUtil.DAY_DISCOUNT_AMOUNT;
import static christmas.global.EventUtil.NO_DISCOUNT;
import static christmas.global.EventUtil.WEEKEND_DISCOUNT_NAME;

import christmas.domain.Reservation;
import christmas.domain.menus.MainMenu;
import christmas.domain.menus.Menus;
import java.util.Map;

class WeekEndDiscount implements Discount {
    private final int weekendDiscount;

    WeekEndDiscount(Reservation reservation) {
        this.weekendDiscount = initializeDiscount(reservation);
    }

    @Override
    public int initializeDiscount(Reservation reservation) {
        int discountAmount = NO_DISCOUNT;
        Map<Menus, Integer> orders = reservation.getOrder().getOrders();

        for (Menus menu : orders.keySet()) {
            if (menu instanceof MainMenu) {
                discountAmount += orders.get(menu) * DAY_DISCOUNT_AMOUNT;
            }
        }

        return discountAmount;
    }

    @Override
    public int getDiscount() {
        return weekendDiscount;
    }

    @Override
    public String getDiscountName() {
        return WEEKEND_DISCOUNT_NAME;
    }
}

