package christmas.domain;

import christmas.domain.menus.Drink;
import christmas.domain.menus.Menus;
import java.util.Map;

public class Order {
    private static final String INVALID_ORDER_FORMAT_ERROR = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final Map<Menus, Integer> orders;

    public Order(Map<Menus, Integer> input) {
        validate(input);
        this.orders = input;
    }

    private void validate(Map<Menus, Integer> input) {
        validateOnlyDrink(input);
    }

    private void validateOnlyDrink(Map<Menus, Integer> input) {
        for (Menus key : input.keySet()) {
            if (!isInstanceOf(key)) {
                return;
            }
        }
        throw new IllegalArgumentException(INVALID_ORDER_FORMAT_ERROR);
    }

    private static boolean isInstanceOf(Menus key) {
        return key instanceof Drink;
    }

    public Map<Menus, Integer> getOrders() {
        return orders;
    }
}
