package christmas.global;

import static christmas.global.ErrorMessage.INVALID_ORDER_FORMAT_ERROR;

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

    public static Order convertInputToOrder(String userInput) {
        Map<Menus, Integer> orderResult = new HashMap<>();
        String[] orders = userInput.split(COMMA_SEPARATOR);

        for (String order : orders) {
            String[] oneOrder = getOneOrder(order);
            orderResult.put(getMenu(oneOrder), getQuantity(oneOrder));
        }

        checkMenuDuplication(orderResult, orders);
        return new Order(orderResult);
    }

    private static void checkMenuDuplication(Map<Menus, Integer> orderResult, String[] orders) {
        if (orders.length != orderResult.size()) {
            throw new IllegalArgumentException(INVALID_ORDER_FORMAT_ERROR.getMessage());
        }
    }

    private static String[] getOneOrder(String order) {
        String[] oneOrder = order.split(HYPHEN);
        checkOneOrderChunkSize(oneOrder);
        return oneOrder;
    }

    private static void checkOneOrderChunkSize(String[] oneOrder) {
        if (oneOrder.length != ONE_ORDER_CHUNK_SIZE) {
            throw new IllegalArgumentException(INVALID_ORDER_FORMAT_ERROR.getMessage());
        }
    }

    private static int getQuantity(String[] parts) {
        checkQuantity(parts[QUANTITY_PART].trim());
        return Integer.parseInt(parts[QUANTITY_PART].trim());
    }

    private static void checkQuantity(String quantityPart) {
        checkInteger(quantityPart);
        checkQuantityRange(quantityPart);
    }

    private static void checkQuantityRange(String quantity) {
        if (Integer.parseInt(quantity) < 1) {
            throw new IllegalArgumentException(INVALID_ORDER_FORMAT_ERROR.getMessage());
        }
    }

    private static void checkInteger(String quantity) {
        try {
            Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER_FORMAT_ERROR.getMessage());
        }
    }

    private static Menus getMenu(String[] parts) {
        String menuName = parts[NAME_PART].trim();
        return MenuUtil.convertToMenu(menuName);
    }
}
