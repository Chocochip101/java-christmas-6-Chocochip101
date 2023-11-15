package christmas.domain;

import static christmas.global.EventUtil.GIFT_MINIMUM_TOTAL_PRICE;

import christmas.domain.menus.Menus;
import java.time.LocalDate;
import java.util.Objects;

public class Reservation {
    private final Schedule schedule;
    private final Order order;

    public Reservation(Schedule schedule, Order order) {
        this.schedule = schedule;
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public int getTotalWithoutDiscount() {
        return order.getOrders().keySet().stream()
                .mapToInt(this::calculateMenuPrice)
                .sum();
    }

    private int calculateMenuPrice(Menus menu) {
        return menu.getPrice() * order.getOrders().get(menu);
    }

    public boolean hasGiftMenu() {
        if (getTotalWithoutDiscount() >= GIFT_MINIMUM_TOTAL_PRICE) {
            return true;
        }
        return false;
    }

    public LocalDate getScheduleLocalDate() {
        return LocalDate.of(schedule.getYear(), schedule.getMonth(), schedule.getDay());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reservation that = (Reservation) o;
        return Objects.equals(schedule, that.schedule) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedule, order);
    }
}
