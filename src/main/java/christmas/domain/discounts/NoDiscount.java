package christmas.domain.discounts;

import christmas.domain.Reservation;
import christmas.global.EventUtil;

public class NoDiscount implements Discount {
    @Override
    public int initializeDiscount(Reservation reservation) {
        return EventUtil.NO_DISCOUNT;
    }

    @Override
    public int getDiscount() {
        return EventUtil.NO_DISCOUNT;
    }

    @Override
    public String getDiscountName() {
        return EventUtil.NOTHING;
    }
}
