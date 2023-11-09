package christmas.ui;

import static christmas.global.DateUtil.convertInputToDate;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readDate() {
        String input = Console.readLine();
        return convertInputToDate(input);
    }
}

