import java.util.ArrayList;
import java.util.List;

public class Queue<T extends Number> {
    private final List<T> list = new ArrayList<>();

    public void add(T number) {
        list.add(number);
    }

    public T pull() {
        T number = list.getFirst();
        list.removeFirst();
        return number;
    }

    public int length() {
        return list.size();
    }
}
