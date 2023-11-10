package christmas.domain.menus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainMenuTest {
    @Test
    @DisplayName("메인메뉴의 이름을 검증한다.")
    public void testMainMenuName() {
        //given&when
        String tBornSteak = "티본스테이크";
        String bbqRibs = "바비큐립";
        String seafoodPasta = "해산물파스타";
        String christmasPasta = "크리스마스파스타";

        //then
        assertAll(
                () -> assertEquals(MainMenu.T_BONE_STEAK.getName(), tBornSteak),
                () -> assertEquals(MainMenu.BBQ_RIBS.getName(), bbqRibs),
                () -> assertEquals(MainMenu.SEAFOOD_PASTA.getName(), seafoodPasta),
                () -> assertEquals(MainMenu.CHRISTMAS_PASTA.getName(), christmasPasta)
        );
    }

    @Test
    @DisplayName("메인메뉴의 금액을 검증한다.")
    public void testMainMenuPrice() {
        //given&when
        int tBornSteak = 55000;
        int bbqRibs = 54000;
        int seafoodPasta = 35000;
        int christmasPasta = 25000;

        //then
        assertAll(
                () -> assertEquals(MainMenu.T_BONE_STEAK.getPrice(), tBornSteak),
                () -> assertEquals(MainMenu.BBQ_RIBS.getPrice(), bbqRibs),
                () -> assertEquals(MainMenu.SEAFOOD_PASTA.getPrice(), seafoodPasta),
                () -> assertEquals(MainMenu.CHRISTMAS_PASTA.getPrice(), christmasPasta)
        );
    }
}