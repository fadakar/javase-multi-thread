import java.util.ArrayList;
import java.util.List;

public class QueueThreadSafe<T extends Number> {
    private final List<T> list = new ArrayList<>();
    private final int maxConcurrent;

    public QueueThreadSafe(int maxConcurrent) {
        this.maxConcurrent = maxConcurrent;
    }

    public synchronized void add(T number) throws InterruptedException {
        if(list.size() >= maxConcurrent) {
            wait();
        }

        list.add(number);
        notify();
    }

    public synchronized T take() throws InterruptedException {
        if(list.isEmpty()){
            wait();
        }

        T number = list.getFirst();
        list.removeFirst();
        notify();
        return number;
    }

    public synchronized int length() {
        return list.size();
    }
}
