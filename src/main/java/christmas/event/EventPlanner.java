package christmas.event;

import christmas.domain.Order;
import christmas.domain.Reservation;
import christmas.domain.Schedule;
import christmas.global.DateUtil;
import christmas.ui.InputView;
import christmas.ui.OutputView;

public class EventPlanner {
    public void start() {
        Reservation reservation = new Reservation(getUserSchedule(), getUserOrder());
        OutputView.printEventPreview(reservation.getSchedule());
        OutputView.printOrderMenus(reservation.getOrder());
    }

    private Schedule getUserSchedule() {
        return new Schedule(DateUtil.YEAR, DateUtil.MONTH, getUserDate());
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


