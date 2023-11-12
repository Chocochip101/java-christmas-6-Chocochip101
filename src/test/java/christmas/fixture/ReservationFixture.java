package christmas.fixture;

import christmas.domain.Order;
import christmas.domain.Reservation;
import christmas.domain.Schedule;
import christmas.domain.menus.Appetizer;
import christmas.domain.menus.Dessert;
import christmas.domain.menus.MainMenu;
import christmas.domain.menus.Menus;
import java.util.HashMap;
import java.util.Map;

public class ReservationFixture {
    public static Reservation createReservationWithDiscount() {
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        int year = 2023;
        int month = 12;
        int day = 12;

        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, 2);
        orderResult.put(menu2, 2);
        orderResult.put(menu3, 3);

        Order order = new Order(orderResult);
        Schedule schedule = new Schedule(year, month, day);

        return new Reservation(schedule, order);
    }

    public static Reservation createReservationWeekEnd() {
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        int year = 2023;
        int month = 12;
        int day = 15;

        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, 2);
        orderResult.put(menu2, 2);
        orderResult.put(menu3, 3);

        Order order = new Order(orderResult);
        Schedule schedule = new Schedule(year, month, day);

        return new Reservation(schedule, order);
    }

    public static Reservation createReservationWithStar() {
        Menus menu1 = Appetizer.CAESAR_SALAD;
        Menus menu2 = Dessert.CHOCOLATE_CAKE;
        Menus menu3 = MainMenu.T_BONE_STEAK;

        int year = 2023;
        int month = 12;
        int day = 10;

        Map<Menus, Integer> orderResult = new HashMap<>();
        orderResult.put(menu1, 2);
        orderResult.put(menu2, 2);
        orderResult.put(menu3, 3);

        Order order = new Order(orderResult);
        Schedule schedule = new Schedule(year, month, day);

        return new Reservation(schedule, order);
    }
}
