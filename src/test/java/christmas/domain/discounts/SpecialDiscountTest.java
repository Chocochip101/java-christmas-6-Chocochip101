package christmas.domain.discounts;

import static christmas.global.EventUtil.GIFT_DISCOUNT_NAME;
import static christmas.global.EventUtil.SPECIAL_DISCOUNT_NAME;
import static christmas.global.EventUtil.STAR_DISCOUNT_AMOUNT;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Reservation;
import christmas.domain.menus.Gift;
import christmas.fixture.ReservationFixture;
import christmas.global.DateUtil.STAR;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDiscountTest {
    Reservation reservation = ReservationFixture.createReservationWithStar();

    @Test
    @DisplayName("특별 이벤트 할인을 검증한다.")
    public void testSpecialDiscount() {
        //given
        LocalDate currentDate = reservation.getScheduleLocalDate();

        int expectedDiscount = 0;
        if (STAR.isStarDate(currentDate)) {
            expectedDiscount = STAR_DISCOUNT_AMOUNT;
        }

        // when
        Discount discount = new SpecialDiscount(reservation);

        //then
        assertEquals(discount.getDiscountName(), SPECIAL_DISCOUNT_NAME);
        assertEquals(discount.getDiscount(), expectedDiscount);
    }
}