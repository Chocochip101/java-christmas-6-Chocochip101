package christmas.domain.menus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiftTest {
    @Test
    @DisplayName("증정품의 이름을 검증한다.")
    public void testGiftName() {
        //given&when
        String champagne = "샴페인";

        //then
        assertAll(
                () -> assertEquals(Gift.CHAMPAGNE.getName(), champagne)
        );
    }

    @Test
    @DisplayName("증정품의 개수를 검증한다.")
    public void testGiftCount() {
        //given&when
        int champagne = 1;

        //then
        assertAll(
                () -> assertEquals(Gift.CHAMPAGNE.getCount(), champagne)
        );
    }
}