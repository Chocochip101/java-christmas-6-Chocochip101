package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.discounts.ChristmasDdayDiscount;
import christmas.domain.discounts.DayDiscount;
import christmas.domain.discounts.GiftDiscount;
import christmas.domain.discounts.SpecialDiscount;
import christmas.fixture.ReservationFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitTest {
    Reservation reservation = ReservationFixture.createReservationWithDiscount();

    @Test
    @DisplayName("혜택 생성에 성공한다.")
    public void createBenefitTest() {
        //given&when
        Benefit benefit = new Benefit(reservation);

        //then
        assertEquals(benefit.getDiscountInformation().size(), 4);
    }

    @Test
    @DisplayName("총 혜택 금액 반환에 성공한다.")
    public void createBenefitTotalPriceTest() {
        //given
        int total1 = new ChristmasDdayDiscount(reservation).getDiscount();
        int total2 = DayDiscount.getDayDiscount(reservation).getDiscount();
        int total3 = new GiftDiscount(reservation).getDiscount();
        int total4 = new SpecialDiscount(reservation).getDiscount();
        int expectedTotal = total1 + total2 + total3 + total4;

        // when
        Benefit benefit = new Benefit(reservation);

        //then
        assertEquals(benefit.getTotalBenefit(), expectedTotal);
    }

    @Test
    @DisplayName("총 할인 금액 반환에 성공한다.")
    public void testTotalDiscount() throws Exception {
        //given
        int total1 = new ChristmasDdayDiscount(reservation).getDiscount();
        int total2 = DayDiscount.getDayDiscount(reservation).getDiscount();
        int total3 = new SpecialDiscount(reservation).getDiscount();
        int expectedTotal = total1 + total2 + total3;

        // when
        Benefit benefit = new Benefit(reservation);

        //then
        assertEquals(benefit.getTotalDiscount(), expectedTotal);
    }
}