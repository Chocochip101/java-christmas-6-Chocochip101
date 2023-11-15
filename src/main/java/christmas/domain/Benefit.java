package christmas.domain;

import christmas.domain.discounts.ChristmasDdayDiscount;
import christmas.domain.discounts.DayDiscount;
import christmas.domain.discounts.Discount;
import christmas.domain.discounts.GiftDiscount;
import christmas.domain.discounts.NoDiscount;
import christmas.domain.discounts.SpecialDiscount;
import christmas.global.EventUtil;
import java.util.List;

public class Benefit {
    private final List<Discount> discountInformation;

    public Benefit(Reservation reservation) {
        if (isBiggerThanEventPrice(reservation)) {
            discountInformation = List.of(
                    new ChristmasDdayDiscount(reservation),
                    DayDiscount.getDayDiscount(reservation),
                    new SpecialDiscount(reservation),
                    new GiftDiscount(reservation)
            );
            return;
        }
        discountInformation = List.of(new NoDiscount(), new NoDiscount(), new NoDiscount(), new NoDiscount());
    }

    private static boolean isBiggerThanEventPrice(Reservation reservation) {
        return reservation.getTotalWithoutDiscount() >= EventUtil.EVENT_MINIMUM_PRICE;
    }

    public List<Discount> getDiscountInformation() {
        return discountInformation;
    }

    public int getTotalBenefit() {
        return discountInformation.stream().mapToInt(Discount::getDiscount).sum();
    }

    public int getTotalDiscount() {
        return discountInformation.stream()
                .limit(discountInformation.size() - 1)
                .mapToInt(Discount::getDiscount)
                .sum();
    }
}

