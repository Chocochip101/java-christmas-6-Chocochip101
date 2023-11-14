package christmas.event;

import christmas.domain.Benefit;
import christmas.domain.EventBadge;
import christmas.domain.Order;
import christmas.domain.Reservation;
import christmas.domain.Schedule;
import christmas.global.DateUtil;
import christmas.ui.InputView;
import christmas.ui.OutputView;

public class EventPlanner {
    public void start() {
        OutputView.printWelcomeCommand();
        Reservation reservation = new Reservation(getUserSchedule(), getUserOrder());
        printReservationInformation(reservation);
        Benefit benefit = new Benefit(reservation);
        printBenefit(benefit);
        OutputView.printEstimatedPrice(reservation.getTotalWithoutDiscount(), benefit.getTotalDiscount());
        EventBadge eventBadge = new EventBadge(benefit.getTotalBenefit());
        OutputView.printEventBadge(eventBadge);
    }

    private static void printReservationInformation(Reservation reservation) {
        OutputView.printEventPreview(reservation.getSchedule());
        OutputView.printOrderMenus(reservation.getOrder());
        OutputView.printTotalWithoutDiscount(reservation.getTotalWithoutDiscount());
        OutputView.printGiftMenu(reservation.hasGiftMenu());
    }

    private static void printBenefit(Benefit benefit) {
        if (benefit.getTotalBenefit() == 0) {
            OutputView.printNothingBenefit();
            OutputView.printNothingTotalBenefit();
            return;
        }
        OutputView.printBenefit(benefit);
        OutputView.printTotalBenefit(benefit.getTotalBenefit());
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


