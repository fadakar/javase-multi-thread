public class IntegerSafe {
    private int value;

    public synchronized void inc(Integer number) {
        value += number;
    }

    public synchronized void dec(Integer number) {
        value -= number;
    }

    public synchronized void setValue(Integer number) {
        value = number;
    }

    public synchronized Integer getValue() {
        return value;
    }
}
