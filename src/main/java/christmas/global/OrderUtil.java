package christmas.global;

import christmas.domain.Order;
import christmas.domain.menus.Menus;
import java.util.HashMap;
import java.util.Map;

public class OrderUtil {
    private static final String COMMA_SEPARATOR = ",";
    private static final String HYPHEN = "-";
    private static final int NAME_PART = 0;
    private static final int QUANTITY_PART = 1;
    private static final int ONE_ORDER_CHUNK_SIZE = 2;
    private static final String INVALID_ORDER_FORMAT_ERROR = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static Order convertInputToOrder(String userInput) {
        Map<Menus, Integer> orderResult = new HashMap<>();
        String[] orders = userInput.split(COMMA_SEPARATOR);

        for (String order : orders) {
            String[] oneOrder = getOneOrder(order);
            orderResult.put(getMenu(oneOrder), getQuantity(oneOrder));
        }
        return new Order(orderResult);
    }

    private static String[] getOneOrder(String order) {
        String[] oneOrder = order.split(HYPHEN);
        checkOneOrderChunkSize(oneOrder);
        return oneOrder;
    }

    private static void checkOneOrderChunkSize(String[] oneOrder) {
        if (oneOrder.length != ONE_ORDER_CHUNK_SIZE) {
            throw new IllegalArgumentException(INVALID_ORDER_FORMAT_ERROR);
        }
    }

    private static int getQuantity(String[] parts) {
        return Integer.parseInt(parts[QUANTITY_PART].trim());
    }

    private static Menus getMenu(String[] parts) {
        String menuName = parts[NAME_PART].trim();
        return MenuUtil.convertToMenu(menuName);
    }
}
