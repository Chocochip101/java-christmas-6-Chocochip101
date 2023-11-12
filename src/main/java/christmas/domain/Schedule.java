package christmas.domain;

import static christmas.global.DateUtil.MAX_DAY;
import static christmas.global.DateUtil.MAX_MONTH;
import static christmas.global.DateUtil.MAX_YEAR;
import static christmas.global.DateUtil.MIN_DAY;
import static christmas.global.DateUtil.MIN_MONTH;
import static christmas.global.DateUtil.MIN_YEAR;
import static christmas.global.ErrorMessage.INVALID_DATE_ERROR;

import java.time.LocalDate;
import java.util.Objects;

public class Schedule {
    private final int year;
    private final int month;
    private final int day;

    public Schedule(final int year, final int month, final int day) {
        validate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private static void validate(final int year, final int month, final int day) {
        validYear(year);
        validMonth(month);
        validDay(day);
    }

    private static void validYear(final int year) {
        if (!isInRange(year, MIN_YEAR, MAX_YEAR)) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR.getMessage());
        }
    }

    private static void validMonth(final int month) {
        if (!isInRange(month, MIN_MONTH, MAX_MONTH)) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR.getMessage());
        }
    }

    private static void validDay(final int day) {
        if (!isInRange(day, MIN_DAY, MAX_DAY)) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR.getMessage());
        }
    }

    private static boolean isInRange(final int userDate, final int minDate, final int maxDate) {
        return minDate <= userDate && userDate <= maxDate;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Schedule schedule = (Schedule) o;
        return year == schedule.year && month == schedule.month && day == schedule.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
