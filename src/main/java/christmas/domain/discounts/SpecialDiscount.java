package christmas.domain.discounts;

import static christmas.global.EventUtil.NO_DISCOUNT;
import static christmas.global.EventUtil.SPECIAL_DISCOUNT_NAME;
import static christmas.global.EventUtil.STAR_DISCOUNT_AMOUNT;

import christmas.domain.Reservation;
import christmas.global.DateUtil.STAR;
import java.time.LocalDate;

public class SpecialDiscount implements Discount {
    private final int specialDiscount;

    public SpecialDiscount(Reservation reservation) {
        this.specialDiscount = initializeDiscount(reservation);
    }

    @Override
    public int initializeDiscount(Reservation reservation) {
        LocalDate currentDate = LocalDate.of(
                reservation.getSchedule().getYear(),
                reservation.getSchedule().getMonth(),
                reservation.getSchedule().getDay()
        );

        if (STAR.isStarDate(currentDate)) {
            return STAR_DISCOUNT_AMOUNT;
        }
        return NO_DISCOUNT;
    }

    @Override
    public int getDiscount() {
        return specialDiscount;
    }

    @Override
    public String getDiscountName() {
        return SPECIAL_DISCOUNT_NAME;
    }
}
