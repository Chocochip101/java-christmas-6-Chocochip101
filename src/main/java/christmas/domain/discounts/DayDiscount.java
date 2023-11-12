package christmas.domain.discounts;

import christmas.domain.Reservation;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayDiscount {
    public static Discount getDayDiscount(Reservation reservation) {
        LocalDate currentDate = LocalDate.of(
                reservation.getSchedule().getYear(),
                reservation.getSchedule().getMonth(),
                reservation.getSchedule().getDay()
        );
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        if (isWeekEnd(dayOfWeek)) {
            return new WeekEndDiscount(reservation);
        }
        return new WeekDayDiscount(reservation);
    }

    private static boolean isWeekEnd(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}