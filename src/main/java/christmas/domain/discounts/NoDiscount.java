package christmas.domain.discounts;

import christmas.domain.Reservation;

public class NoDiscount implements Discount {
    @Override
    public int initializeDiscount(Reservation reservation) {
        return 0;
    }

    @Override
    public int getDiscount() {
        return 0;
    }

    @Override
    public String getDiscountName() {
        return "없음";
    }
}
