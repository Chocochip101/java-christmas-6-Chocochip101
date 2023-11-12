package christmas.event;

import christmas.domain.Order;
import christmas.domain.Schedule;
import christmas.global.DateUtil;
import christmas.ui.InputView;
import christmas.ui.OutputView;

public class EventPlanner {
    public void start() {
        Schedule schedule = new Schedule(DateUtil.YEAR, DateUtil.MONTH, getUserDate());
        Order order = getUserOrder();
        OutputView.printEventPreview(schedule);
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


