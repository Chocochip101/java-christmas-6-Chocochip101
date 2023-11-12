package christmas.domain.discounts;

import static christmas.global.EventUtil.GIFT_DISCOUNT_NAME;
import static christmas.global.EventUtil.NO_DISCOUNT;

import christmas.domain.Reservation;
import christmas.domain.menus.Gift;

public class GiftDiscount implements Discount {
    private final int giftDiscount;

    public GiftDiscount(Reservation reservation) {
        this.giftDiscount = initializeDiscount(reservation);
    }

    @Override
    public int initializeDiscount(Reservation reservation) {
        if (reservation.hasGiftMenu()) {
            return Gift.getTotalPriceOfGifts();
        }
        return NO_DISCOUNT;
    }

    @Override
    public int getDiscount() {
        return giftDiscount;
    }

    @Override
    public String getDiscountName() {
        return GIFT_DISCOUNT_NAME;
    }
}
