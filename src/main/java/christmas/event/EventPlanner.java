package christmas.event;

import christmas.ui.InputView;
import christmas.ui.OutputView;

public class EventPlanner {
    public void start() {
        OutputView.printExpectedVisitDate();
        InputView.readDate();
    }
}


