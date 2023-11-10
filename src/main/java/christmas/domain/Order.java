package christmas.domain;

import static christmas.global.ErrorMessage.INVALID_ORDER_FORMAT_ERROR;

import christmas.domain.menus.Drink;
import christmas.domain.menus.Menus;
import java.util.Map;

public class Order {
    private static final int MAX_ORDER_COUNT = 20;
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
        int count = 0;
        for (Menus key : input.keySet()) {
            count += input.get(key);
        }
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
}
