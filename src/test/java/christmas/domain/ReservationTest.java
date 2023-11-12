package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.menus.Appetizer;
import christmas.domain.menus.Dessert;
import christmas.domain.menus.MainMenu;
import christmas.domain.menus.Menus;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservationTest {
    @Test
    @DisplayName("예약 생성에 성공한다.")
    public void testOrder() {
        //given
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        int year = 2023;
        int month = 12;
        int day = 12;

        //when
        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, 1);
        orderResult.put(menu2, 2);
        orderResult.put(menu3, 3);

        Order order = new Order(orderResult);
        Schedule schedule = new Schedule(year, month, day);

        Reservation reservation = new Reservation(schedule, order);

        //then
        assertAll(
                () -> assertEquals(reservation.getOrder(), order),
                () -> assertEquals(reservation.getOrder().getOrders().get(menu1), 1),
                () -> assertEquals(reservation.getOrder().getOrders().get(menu2), 2),
                () -> assertEquals(reservation.getOrder().getOrders().get(menu3), 3),
                () -> assertEquals(reservation.getOrder(), order),
                () -> assertEquals(reservation.getSchedule(), schedule),
                () -> assertEquals(reservation.getSchedule().getYear(), year),
                () -> assertEquals(reservation.getSchedule().getMonth(), month),
                () -> assertEquals(reservation.getSchedule().getDay(), day)
        );
    }

    @Test
    @DisplayName("같은 예약으로 구성될 때, 동등하다.")
    public void testEquals() {
        //given
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        int year = 2023;
        int month = 12;
        int day = 12;

        //when
        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, 1);
        orderResult.put(menu2, 2);
        orderResult.put(menu3, 3);

        Order order = new Order(orderResult);
        Schedule schedule = new Schedule(year, month, day);

        Reservation reservation1 = new Reservation(schedule, order);
        Reservation reservation2 = new Reservation(schedule, order);

        //then
        assertTrue(reservation1.equals(reservation2));
    }

    @Test
    @DisplayName("다른 메뉴로 구성될 때, 동등하지 않다.")
    public void testDifferentEquals() {
        //given
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        int year = 2023;
        int month = 12;
        int day1 = 12;
        int day2 = 13;

        //when
        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, 1);
        orderResult.put(menu2, 2);
        orderResult.put(menu3, 3);

        Order order = new Order(orderResult);
        Schedule schedule1 = new Schedule(year, month, day1);
        Schedule schedule2 = new Schedule(year, month, day2);

        Reservation reservation1 = new Reservation(schedule1, order);
        Reservation reservation2 = new Reservation(schedule2, order);

        //then
        assertFalse(reservation1.equals(reservation2));
    }

    @Test
    @DisplayName("같은 객체의 해시코드는 동일하다")
    public void testOrderHashCode() {
        //given
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        int year = 2023;
        int month = 12;
        int day = 12;

        //when
        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, 1);
        orderResult.put(menu2, 2);
        orderResult.put(menu3, 3);

        Order order = new Order(orderResult);
        Schedule schedule = new Schedule(year, month, day);

        Reservation reservation1 = new Reservation(schedule, order);
        Reservation reservation2 = new Reservation(schedule, order);

        //then
        assertEquals(reservation1.hashCode(), reservation2.hashCode());
    }

    @Test
    @DisplayName("다른 객체의 해시코드는 다르다")
    public void testDifferentOrderHashCode() {
        //given
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        int year = 2023;
        int month = 12;
        int day1 = 12;
        int day2 = 13;

        //when
        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, 1);
        orderResult.put(menu2, 2);
        orderResult.put(menu3, 3);

        Order order = new Order(orderResult);
        Schedule schedule1 = new Schedule(year, month, day1);
        Schedule schedule2 = new Schedule(year, month, day2);

        Reservation reservation1 = new Reservation(schedule1, order);
        Reservation reservation2 = new Reservation(schedule2, order);

        //then
        assertNotEquals(reservation1.hashCode(), reservation2.hashCode());
    }

    @Test
    @DisplayName("할인 전 총 금액 반환에 성공한다.")
    public void testTotalWithoutDiscount() {
        //given
        int count1 = 1;
        int count2 = 3;
        int count3 = 4;
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        int year = 2023;
        int month = 12;
        int day = 12;

        int expectedPrice = menu1.getPrice() * count1 + menu2.getPrice() * count2 + menu3.getPrice() * count3;

        //when
        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, count1);
        orderResult.put(menu2, count2);
        orderResult.put(menu3, count3);

        Order order = new Order(orderResult);
        Schedule schedule = new Schedule(year, month, day);

        Reservation reservation = new Reservation(schedule, order);

        //then
        assertEquals(reservation.getTotalWithoutDiscount(), expectedPrice);
    }

    @Test
    @DisplayName("증정 금액 이상일 경우, 증정품을 제공한다.")
    public void testGiftMenu() {
        //given
        int count1 = 1;
        int count2 = 3;
        int count3 = 4;
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        int year = 2023;
        int month = 12;
        int day = 12;

        //when
        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, count1);
        orderResult.put(menu2, count2);
        orderResult.put(menu3, count3);

        Order order = new Order(orderResult);
        Schedule schedule = new Schedule(year, month, day);

        Reservation reservation = new Reservation(schedule, order);

        //then
        assertTrue(reservation.hasGiftMenu());
    }

    @Test
    @DisplayName("증정 금액 이하일 경우, 증정품을 제공하지 않는다.")
    public void testNoGiftMenu() {
        //given
        int count1 = 1;
        int count2 = 1;
        int count3 = 1;
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        int year = 2023;
        int month = 12;
        int day = 12;

        //when
        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, count1);
        orderResult.put(menu2, count2);
        orderResult.put(menu3, count3);

        Order order = new Order(orderResult);
        Schedule schedule = new Schedule(year, month, day);

        Reservation reservation = new Reservation(schedule, order);

        //then
        assertFalse(reservation.hasGiftMenu());
    }
}