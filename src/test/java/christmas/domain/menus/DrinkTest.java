package christmas.domain.menus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrinkTest {
    @Test
    @DisplayName("음료의 이름을 검증한다.")
    public void testDrinkName() {
        //given&when
        String zeroCoke = "제로콜라";
        String redWine = "레드와인";
        String champagne = "샴페인";

        //then
        assertAll(
                () -> assertEquals(Drink.ZERO_COKE.getName(), zeroCoke),
                () -> assertEquals(Drink.RED_WINE.getName(), redWine),
                () -> assertEquals(Drink.CHAMPAGNE.getName(), champagne)
        );
    }

    @Test
    @DisplayName("음료의 금액을 검증한다.")
    public void testDrinkPrice() {
        //given&when
        int zeroCoke = 3000;
        int redWine = 60000;
        int champagne = 25000;

        //then
        assertAll(
                () -> assertEquals(Drink.ZERO_COKE.getPrice(), zeroCoke),
                () -> assertEquals(Drink.RED_WINE.getPrice(), redWine),
                () -> assertEquals(Drink.CHAMPAGNE.getPrice(), champagne)
        );
    }
}