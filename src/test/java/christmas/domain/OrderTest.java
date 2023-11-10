package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.menus.Appetizer;
import christmas.domain.menus.Dessert;
import christmas.domain.menus.MainMenu;
import christmas.domain.menus.Menus;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    @Test
    @DisplayName("주문 생성에 성공한다.")
    public void testOrder() {
        //given
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, 1);
        orderResult.put(menu2, 2);
        orderResult.put(menu3, 1);

        //when
        Order order = new Order(orderResult);

        //then
        assertEquals(1, order.getOrders().get(menu1));
        assertEquals(2, order.getOrders().get(menu2));
        assertEquals(1, order.getOrders().get(menu3));
    }
}