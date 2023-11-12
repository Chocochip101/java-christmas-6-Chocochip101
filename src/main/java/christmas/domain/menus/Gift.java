package christmas.domain.menus;

import java.util.Arrays;

public enum Gift {
    CHAMPAGNE(Drink.CHAMPAGNE, 1);
    private final Menus gift;
    private final int count;

    Gift(Menus gift, int count) {
        this.gift = gift;
        this.count = count;
    }

    public Menus getGift() {
        return gift;
    }

    public int getCount() {
        return count;
    }

    public static int getTotalPriceOfGifts() {
        return Arrays.stream(Gift.values())
                .mapToInt(gift -> gift.getGift().getPrice() * gift.getCount())
                .sum();
    }
}
