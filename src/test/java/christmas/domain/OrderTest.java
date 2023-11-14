package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("같은 메뉴로 구성될 때, 동등하다.")
    public void testEquals() {
        //given
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, 1);
        orderResult.put(menu2, 2);
        orderResult.put(menu3, 1);

        //when
        Order order1 = new Order(orderResult);
        Order order2 = new Order(orderResult);

        //then
        assertTrue(order1.equals(order2));
    }

    @Test
    @DisplayName("다른 메뉴로 구성될 때, 동등하지 않다.")
    public void testDifferentEquals() {
        //given
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;
        Menus menu4 = MainMenu.BBQ_RIBS;

        Map<Menus, Integer> orderResult1 = new HashMap<>();
        orderResult1.put(menu1, 1);
        orderResult1.put(menu2, 2);
        orderResult1.put(menu3, 1);

        Map<Menus, Integer> orderResult2 = new HashMap<>();
        orderResult2.put(menu1, 1);
        orderResult2.put(menu2, 2);
        orderResult2.put(menu4, 2);

        //when
        Order order1 = new Order(orderResult1);
        Order order2 = new Order(orderResult2);

        //then
        assertFalse(order1.equals(order2));
    }

    @Test
    @DisplayName("같은 객체의 해시코드는 동일하다")
    public void testOrderHashCode() {
        //given
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, 1);
        orderResult.put(menu2, 2);
        orderResult.put(menu3, 1);

        //when
        Order order1 = new Order(orderResult);
        Order order2 = new Order(orderResult);

        //then
        assertEquals(order1.hashCode(), order2.hashCode());
    }

    // TODO 15줄?
    @Test
    @DisplayName("다른 객체의 해시코드는 다르다")
    public void testDifferentOrderHashCode() {
        //given
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;
        Menus menu4 = MainMenu.BBQ_RIBS;

        Map<Menus, Integer> orderResult1 = new HashMap<>();
        orderResult1.put(menu1, 1);
        orderResult1.put(menu2, 2);
        orderResult1.put(menu3, 1);

        Map<Menus, Integer> orderResult2 = new HashMap<>();
        orderResult2.put(menu1, 1);
        orderResult2.put(menu2, 2);
        orderResult2.put(menu4, 2);

        //when
        Order order1 = new Order(orderResult1);
        Order order2 = new Order(orderResult2);

        //then
        assertNotEquals(order1.hashCode(), order2.hashCode());
    }
}