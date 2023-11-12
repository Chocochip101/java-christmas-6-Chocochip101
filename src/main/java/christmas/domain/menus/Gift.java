package christmas.domain.menus;

public enum Gift {
    CHAMPAGNE("샴페인", 1);
    private final String name;
    private final int count;

    Gift(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
