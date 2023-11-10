package christmas.ui;

import static christmas.global.DateUtil.convertInputToDate;
import static christmas.global.OrderUtil.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Order;

public class InputView {
    public static int readDate() {
        String input = Console.readLine();
        return convertInputToDate(input);
    }

    public static Order readOrder() {
        String input = Console.readLine();
        return convertInputToOrder(input);
    }
}

