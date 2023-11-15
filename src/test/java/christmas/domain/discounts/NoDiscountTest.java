package christmas.domain.discounts;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Reservation;
import christmas.fixture.ReservationFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NoDiscountTest {
    Reservation reservation = ReservationFixture.createReservationWithDiscount();

    @Test
    @DisplayName("이벤트 없음을 검증한다.")
    public void testNoDiscount() {
        //given
        int expectedDiscount = 0;

        // when
        Discount discount = new NoDiscount();

        //then
        assertEquals(discount.getDiscountName(), "없음");
        assertEquals(discount.getDiscount(), expectedDiscount);
        assertEquals(discount.initializeDiscount(reservation), 0);
    }
}