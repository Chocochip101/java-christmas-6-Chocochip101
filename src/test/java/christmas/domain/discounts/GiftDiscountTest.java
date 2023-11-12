package christmas.domain.discounts;

import static christmas.global.EventUtil.GIFT_DISCOUNT_NAME;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Reservation;
import christmas.domain.menus.Gift;
import christmas.fixture.ReservationFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiftDiscountTest {
    Reservation reservation = ReservationFixture.createReservationWithDiscount();

    @Test
    @DisplayName("증정 이벤트 할인을 검증한다.")
    public void testGiftDiscount() {
        //given
        int expectedDiscount = 0;
        if (reservation.hasGiftMenu()) {
            expectedDiscount = Gift.getTotalPriceOfGifts();
        }

        // when
        Discount discount = new GiftDiscount(reservation);

        //then
        assertEquals(discount.getDiscountName(), GIFT_DISCOUNT_NAME);
        assertEquals(discount.getDiscount(), expectedDiscount);
    }
}