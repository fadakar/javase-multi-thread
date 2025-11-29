import java.util.LinkedList;
import java.util.List;

public class QueueThreadSafe<T extends Number> {
    private final List<T> list = new LinkedList<>();
    private final int maxConcurrent;

    public QueueThreadSafe(int maxConcurrent) {
        this.maxConcurrent = maxConcurrent;
    }

    public synchronized void add(T number) throws InterruptedException {
        while(list.size() >= maxConcurrent) {
            wait();
        }

        list.add(number);
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while(list.isEmpty()) {
            wait();
        }

        T number = list.removeFirst();
        notifyAll();
        return number;
    }

    public synchronized int length() {
        return list.size();
    }
}
