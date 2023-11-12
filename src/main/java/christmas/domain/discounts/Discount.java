package christmas.domain.discounts;

import christmas.domain.Reservation;

public interface Discount {

    int initializeDiscount(Reservation reservation);

    int getDiscount();

    String getDiscountName();
}
