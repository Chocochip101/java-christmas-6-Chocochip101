package christmas.domain;

import java.util.Arrays;

public class EventBadge {
    private final Badge badge;

    enum Badge {
        SANTA(20_000, "산타"),
        TREE(10_000, "트리"),
        STAR(5_000, "별"),
        NOTHING(0, "없음");

        private final int minimumPrice;
        private final String name;

        Badge(int minimumPrice, String name) {
            this.minimumPrice = minimumPrice;
            this.name = name;
        }
    }

    public EventBadge(int totalPrice) {
        this.badge = initialize(totalPrice);
    }

    private Badge initialize(int price) {
        return Arrays.stream(Badge.values())
                .filter(badge -> price >= badge.minimumPrice)
                .findFirst()
                .orElse(Badge.NOTHING);
    }

    public String getBadgeName() {
        return badge.name;
    }
}
