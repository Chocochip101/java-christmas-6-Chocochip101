package christmas.domain;

import christmas.domain.menus.Menus;
import java.util.Map;

public class Order {
    private final Map<Menus, Integer> orders;

    public Order(Map<Menus, Integer> orders) {
        this.orders = orders;
    }

    public Map<Menus, Integer> getOrders() {
        return orders;
    }
}
