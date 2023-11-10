package christmas.global;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.Order;
import christmas.domain.menus.Dessert;
import christmas.domain.menus.Drink;
import christmas.domain.menus.MainMenu;
import christmas.domain.menus.Menus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderUtilTest {
    @Test
    @DisplayName("주문 생성에 성공한다.")
    public void testCreateOrder() {
        //given
        String userInput = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Menus menu1 = MainMenu.T_BONE_STEAK;
        Menus menu2 = MainMenu.BBQ_RIBS;
        Menus menu3 = Dessert.CHOCOLATE_CAKE;
        Menus menu4 = Drink.ZERO_COKE;

        //when
        Order order = OrderUtil.convertInputToOrder(userInput);

        //then
        assertAll(
                () -> assertEquals(order.getOrders().get(menu1), 1),
                () -> assertEquals(order.getOrders().get(menu2), 1),
                () -> assertEquals(order.getOrders().get(menu3), 2),
                () -> assertEquals(order.getOrders().get(menu4), 1)
        );
    }

    @Test
    @DisplayName("컴마사이에 빈칸이 주어진 주문 생성에 성공한다.")
    public void testCreateOrderWithCommaBlank() {
        //given
        String userInput = " 티본스테이크-1, 바비큐립-1 ,초코케이크-2,  제로콜라-1";
        Menus menu1 = MainMenu.T_BONE_STEAK;
        Menus menu2 = MainMenu.BBQ_RIBS;
        Menus menu3 = Dessert.CHOCOLATE_CAKE;
        Menus menu4 = Drink.ZERO_COKE;

        //when
        Order order = OrderUtil.convertInputToOrder(userInput);

        //then
        assertAll(
                () -> assertEquals(order.getOrders().get(menu1), 1),
                () -> assertEquals(order.getOrders().get(menu2), 1),
                () -> assertEquals(order.getOrders().get(menu3), 2),
                () -> assertEquals(order.getOrders().get(menu4), 1)
        );
    }

    @Test
    @DisplayName("하이픈 사이에 빈칸이 주어진 주문 생성에 성공한다.")
    public void testCreateOrderWithHyphenBlank() {
        //given
        String userInput = " 티본스테이크- 1, 바비큐립 -1 ,초코케이크-2,  제로콜라  -1";
        Menus menu1 = MainMenu.T_BONE_STEAK;
        Menus menu2 = MainMenu.BBQ_RIBS;
        Menus menu3 = Dessert.CHOCOLATE_CAKE;
        Menus menu4 = Drink.ZERO_COKE;

        //when
        Order order = OrderUtil.convertInputToOrder(userInput);

        //then
        assertAll(
                () -> assertEquals(order.getOrders().get(menu1), 1),
                () -> assertEquals(order.getOrders().get(menu2), 1),
                () -> assertEquals(order.getOrders().get(menu3), 2),
                () -> assertEquals(order.getOrders().get(menu4), 1)
        );
    }

    @DisplayName("적절하지 않은 주문 입력 시, 예외가 발생한다.")
    @ValueSource(strings = {
            "티본스테이크-- 1, 바비큐립 -1 ,초코케이크-2,  제로콜라  -1",
            "티본스테이크- 1, 바비큐립 -1 ,초코케이크-2,  ,제로콜라  -1",
            "티본스테이크- 1, 바비큐립 -1 ,초코케이크-2,  ,제로콜라  -1",
            "티본스테이크- 1, 비비큐립 -1 ,초코케이크-2,제로콜라  -1",
            "티본스테이크- 1, 바비큐립 -1 ,,초코케이크-2,  ,제로콜라  -1",
            "티본스테이크- 11., 바비큐립 -1 ,,초코케이크-2,  ,제로콜라  -1",
            "티본스테이크- 1, 바비큐립 -1 ,,초코케이크-2,  ,제로콜라  -14.23",
            "티본스테이크- 1, 바비큐립 -1 ,티본스테이크-2,  제로콜라  -1",
            "제로콜라 -1",
            "제로콜라 -1,레드와인-2"
    })
    @ParameterizedTest
    public void testInvalidOrder(String order) {
        //given&when&then
        assertThatThrownBy(() -> OrderUtil.convertInputToOrder(order))
                .isInstanceOf(IllegalArgumentException.class);
    }
}