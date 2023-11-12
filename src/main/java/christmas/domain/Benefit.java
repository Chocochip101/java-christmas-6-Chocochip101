package christmas.domain;

import christmas.domain.discounts.ChristmasDdayDiscount;
import christmas.domain.discounts.DayDiscount;
import christmas.domain.discounts.Discount;
import christmas.domain.discounts.GiftDiscount;
import christmas.domain.discounts.SpecialDiscount;
import java.util.List;

public class Benefit {
    private final List<Discount> discountInformation;

    public Benefit(Reservation reservation) {
        discountInformation = List.of(
                new ChristmasDdayDiscount(reservation),
                DayDiscount.getDayDiscount(reservation),
                new SpecialDiscount(reservation),
                new GiftDiscount(reservation)
        );
    }

    public List<Discount> getDiscountInformation() {
        return discountInformation;
    }
}

