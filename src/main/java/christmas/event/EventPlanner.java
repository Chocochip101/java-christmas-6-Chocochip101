package christmas.event;

import christmas.domain.Order;
import christmas.ui.InputView;
import christmas.ui.OutputView;

public class EventPlanner {
    public void start() {
        int userDate = getUserDate();
        Order userOrder = getUserOrder();
    }

    private int getUserDate() {
        try {
            OutputView.printExpectedVisitDate();
            return InputView.readDate();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getUserDate();
        }
    }

    private Order getUserOrder() {
        try {
            OutputView.printOrderMenu();
            return InputView.readOrder();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getUserOrder();
        }
    }
}


