package christmas.global;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.menus.Menus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuUtilTest {
    @Test
    @DisplayName("메뉴를 Enum으로 변경하는데 성공한다.")
    public void testStringToMenu() {
        //given
        String menuName1 = "양송이수프";
        String menuName2 = "초코케이크";
        String menuName3 = "레드와인";
        String menuName4 = "크리스마스파스타";

        //when
        Menus menu1 = MenuUtil.convertToMenu(menuName1);
        Menus menu2 = MenuUtil.convertToMenu(menuName2);
        Menus menu3 = MenuUtil.convertToMenu(menuName3);
        Menus menu4 = MenuUtil.convertToMenu(menuName4);

        //then
        assertAll(
                () -> assertEquals(menu1.getName(), menuName1),
                () -> assertEquals(menu2.getName(), menuName2),
                () -> assertEquals(menu3.getName(), menuName3),
                () -> assertEquals(menu4.getName(), menuName4)
        );
    }

    @DisplayName("존재하지 않은 메뉴 입력 시, 예외가 발생한다.")
    @ValueSource(strings = {"양송이 수프", "아우스크림", "레드 와인", "티ㅋ본스테이크"})
    @ParameterizedTest
    public void testInvalidString(String menu) {
        //given&when&then
        assertThatThrownBy(() -> MenuUtil.convertToMenu(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }
}