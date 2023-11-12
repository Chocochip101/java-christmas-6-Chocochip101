package christmas.domain;

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
                .mapToInt(menu -> menu.getPrice() * order.getOrders().get(menu))
                .sum();
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
