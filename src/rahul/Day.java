package rahul;

public enum Day {
    SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);
    private final int va;

    Day(int va) {
        this.va = va;
    }

    public int getVa() {
        return this.va;
    }
}
class ui {
    public static void main(String[] args) {
        for (Day day : Day.values())
            System.out.println("day " + day.name() + " value " + day.getVa());
    }
}

