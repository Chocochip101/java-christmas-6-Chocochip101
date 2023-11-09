package christmas.event;

import christmas.ui.InputView;
import christmas.ui.OutputView;

public class EventPlanner {
    public void start() {
        int userDate = getUserDate();
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
}


