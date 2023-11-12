package christmas.domain.discounts;

import static christmas.global.EventUtil.CHRISTMAS_DISCOUNT_NAME;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Reservation;
import christmas.fixture.ReservationFixture;
import christmas.global.DateUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasDdayDiscountTest {
    Reservation reservation = ReservationFixture.createReservationWithDiscount();

    @Test
    @DisplayName("크리스마스 디데이 할인을 검증한다.")
    public void testChristmasDdayDiscount() {
        //given
        int expectedDiscount = (reservation.getSchedule().getDay() - DateUtil.MIN_DAY) * 100 + 1000;

        // when
        Discount discount = new ChristmasDdayDiscount(reservation);

        //then
        assertEquals(discount.getDiscountName(), CHRISTMAS_DISCOUNT_NAME);
        assertEquals(discount.getDiscount(), expectedDiscount);
    }
}