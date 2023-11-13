package christmas.domain;

public class EventBadge {
    private final Badge badge;

    enum Badge {
        STAR(5_000, "별"),
        TREE(10_000, "트리"),
        SANTA(20_000, "산타"),
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
        if (price >= Badge.SANTA.minimumPrice) {
            return Badge.SANTA;
        }
        if (price >= Badge.TREE.minimumPrice) {
            return Badge.TREE;
        }
        if (price >= Badge.STAR.minimumPrice) {
            return Badge.STAR;
        }
        return Badge.NOTHING;
    }

    public String getBadgeName() {
        return badge.name;
    }
}
