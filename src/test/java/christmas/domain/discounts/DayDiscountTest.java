package christmas.domain.discounts;

import static christmas.global.EventUtil.DAY_DISCOUNT_AMOUNT;
import static christmas.global.EventUtil.WEEKDAY_DISCOUNT_NAME;
import static christmas.global.EventUtil.WEEKEND_DISCOUNT_NAME;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Reservation;
import christmas.domain.menus.Dessert;
import christmas.domain.menus.MainMenu;
import christmas.domain.menus.Menus;
import christmas.fixture.ReservationFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DayDiscountTest {
    Reservation reservationWeekDay = ReservationFixture.createReservationWithDiscount();
    Reservation reservationWeekEnd = ReservationFixture.createReservationWeekEnd();

    @Test
    @DisplayName("평일 할인을 검증한다.")
    public void testWeekDayDiscount() {
        //given
        int expectedDiscount = 0;
        for (Menus menu : reservationWeekDay.getOrder().getOrders().keySet()) {
            if (menu instanceof Dessert) {
                expectedDiscount += reservationWeekDay.getOrder().getOrders().get(menu) * DAY_DISCOUNT_AMOUNT;
            }
        }

        // when
        Discount discount = DayDiscount.getDayDiscount(reservationWeekDay);

        //then
        assertEquals(discount.getDiscountName(), WEEKDAY_DISCOUNT_NAME);
        assertEquals(discount.getDiscount(), expectedDiscount);
    }

    @Test
    @DisplayName("주말 할인을 검증한다.")
    public void testWeekEndDiscount() {
        //given
        int expectedDiscount = 0;
        for (Menus menu : reservationWeekEnd.getOrder().getOrders().keySet()) {
            if (menu instanceof MainMenu) {
                expectedDiscount += reservationWeekEnd.getOrder().getOrders().get(menu) * DAY_DISCOUNT_AMOUNT;
            }
        }

        // when
        Discount discount = DayDiscount.getDayDiscount(reservationWeekEnd);

        //then
        assertEquals(discount.getDiscountName(), WEEKEND_DISCOUNT_NAME);
        assertEquals(discount.getDiscount(), expectedDiscount);
    }
}