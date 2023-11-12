package christmas.domain.discounts;

import static christmas.global.EventUtil.CHRISTMAS_DISCOUNT_NAME;
import static christmas.global.EventUtil.NO_DISCOUNT;

import christmas.domain.Reservation;
import christmas.global.DateUtil;
import java.time.LocalDate;

public class ChristmasDdayDiscount implements Discount {
    private static final int BASIC_DISCOUNT_AMOUNT = 1000;
    private static final int DAILY_INCREMENT_AMOUNT = 100;
    private final int christmasDdayDiscount;

    public ChristmasDdayDiscount(Reservation reservation) {
        this.christmasDdayDiscount = initializeDiscount(reservation);
    }

    @Override
    public int initializeDiscount(Reservation reservation) {
        LocalDate currentDate = LocalDate.of(
                reservation.getSchedule().getYear(),
                reservation.getSchedule().getMonth(),
                reservation.getSchedule().getDay()
        );

        LocalDate discountStartDate = LocalDate.of(DateUtil.YEAR, DateUtil.MONTH, DateUtil.MIN_DAY);
        LocalDate discountEndDate = LocalDate.of(DateUtil.YEAR, DateUtil.MONTH, DateUtil.CHRISTMAS_DAY);

        if (currentDate.isAfter(discountStartDate) && currentDate.isBefore(
                discountEndDate.plusDays(DateUtil.DAY_EVENT_STEPS))) {
            int daysFromStart = (int) discountStartDate.until(currentDate, java.time.temporal.ChronoUnit.DAYS);
            return BASIC_DISCOUNT_AMOUNT + (daysFromStart * DAILY_INCREMENT_AMOUNT);
        }
        return NO_DISCOUNT;
    }

    @Override
    public int getDiscount() {
        return christmasDdayDiscount;
    }

    @Override
    public String getDiscountName() {
        return CHRISTMAS_DISCOUNT_NAME;
    }
}
