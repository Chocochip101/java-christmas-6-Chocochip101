package christmas.domain.menus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DessertTest {
    @Test
    @DisplayName("디저트의 이름을 검증한다.")
    public void testDessertName() {
        //given&when
        String chocoCake = "초코케이크";
        String iceCream = "아이스크림";

        //then
        assertAll(
                () -> assertEquals(Dessert.CHOCOLATE_CAKE.getName(), chocoCake),
                () -> assertEquals(Dessert.ICE_CREAM.getName(), iceCream)
        );
    }

    @Test
    @DisplayName("디저트의 금액을 검증한다.")
    public void testDessertPrice() {
        //given&when
        int chocoCake = 15000;
        int iceCream = 5000;

        //then
        assertAll(
                () -> assertEquals(Dessert.CHOCOLATE_CAKE.getPrice(), chocoCake),
                () -> assertEquals(Dessert.ICE_CREAM.getPrice(), iceCream)
        );
    }
}