package christmas.domain;

import static christmas.global.ErrorMessage.INVALID_ORDER_FORMAT_ERROR;
import static christmas.global.EventUtil.MAX_ORDER_COUNT;

import christmas.domain.menus.Drink;
import christmas.domain.menus.Menus;
import java.util.Map;
import java.util.Objects;

public class Order {

    private final Map<Menus, Integer> orders;

    public Order(Map<Menus, Integer> input) {
        validate(input);
        this.orders = input;
    }

    private void validate(Map<Menus, Integer> input) {
        validateOnlyDrink(input);
        validateMaxOrderCount(input);
    }

    private void validateMaxOrderCount(Map<Menus, Integer> input) {
        int count = input.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        if (exceedMaxCount(count)) {
            throw new IllegalArgumentException(INVALID_ORDER_FORMAT_ERROR.getMessage());
        }
    }

    private static boolean exceedMaxCount(int count) {
        return count > MAX_ORDER_COUNT;
    }

    private void validateOnlyDrink(Map<Menus, Integer> input) {
        for (Menus key : input.keySet()) {
            if (!isInstanceOf(key)) {
                return;
            }
        }
        throw new IllegalArgumentException(INVALID_ORDER_FORMAT_ERROR.getMessage());
    }

    private static boolean isInstanceOf(Menus key) {
        return key instanceof Drink;
    }

    public Map<Menus, Integer> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(orders, order.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders);
    }
}
