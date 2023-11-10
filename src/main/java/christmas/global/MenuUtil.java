package christmas.global;

import christmas.domain.menus.Appetizer;
import christmas.domain.menus.Dessert;
import christmas.domain.menus.Drink;
import christmas.domain.menus.MainMenu;
import christmas.domain.menus.Menus;

public class MenuUtil {
    private static final String MENU_NAME_ERROR = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static Menus convertToMenu(String menuName) {
        for (Dessert dessert : Dessert.values()) {
            if (dessert.getName().equalsIgnoreCase(menuName)) {
                return dessert;
            }
        }

        for (MainMenu mainMenu : MainMenu.values()) {
            if (mainMenu.getName().equalsIgnoreCase(menuName)) {
                return mainMenu;
            }
        }

        for (Appetizer appetizer : Appetizer.values()) {
            if (appetizer.getName().equalsIgnoreCase(menuName)) {
                return appetizer;
            }
        }

        for (Drink drink : Drink.values()) {
            if (drink.getName().equalsIgnoreCase(menuName)) {
                return drink;
            }
        }
        throw new IllegalArgumentException(MENU_NAME_ERROR);
    }
}