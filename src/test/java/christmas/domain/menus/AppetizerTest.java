package christmas.domain.menus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppetizerTest {
    @Test
    @DisplayName("애피타이저의 이름을 검증한다.")
    public void testAppetizerName() {
        //given&when
        String tapas = "타파스";
        String caesarSalad = "시저샐러드";
        String mushroomSoup = "양송이수프";

        //then
        assertAll(
                () -> assertEquals(Appetizer.TAPAS.getName(), tapas),
                () -> assertEquals(Appetizer.CAESAR_SALAD.getName(), caesarSalad),
                () -> assertEquals(Appetizer.MUSHROOM_SOUP.getName(), mushroomSoup)
        );
    }

    @Test
    @DisplayName("애피타이저의 금액을 검증한다.")
    public void testAppetizerPrice() {
        //given&when
        int tapas = 5500;
        int caesarSalad = 8000;
        int mushroomSoup = 6000;

        //then
        assertAll(
                () -> assertEquals(Appetizer.TAPAS.getPrice(), tapas),
                () -> assertEquals(Appetizer.CAESAR_SALAD.getPrice(), caesarSalad),
                () -> assertEquals(Appetizer.MUSHROOM_SOUP.getPrice(), mushroomSoup)
        );
    }
}