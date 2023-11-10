package christmas.global;

import static christmas.global.ErrorMessage.MENU_NAME_ERROR;

import christmas.domain.menus.Appetizer;
import christmas.domain.menus.Dessert;
import christmas.domain.menus.Drink;
import christmas.domain.menus.MainMenu;
import christmas.domain.menus.Menus;

public class MenuUtil {

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
        throw new IllegalArgumentException(MENU_NAME_ERROR.getMessage());
    }
}