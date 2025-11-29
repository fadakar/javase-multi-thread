import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        QueueThreadSafe<Integer> queue = new QueueThreadSafe<>(5);
        IntegerSafe totalValue = new IntegerSafe();

        Thread[] producerList = {
                new Thread(new Producer(queue, 10000)),
                new Thread(new Producer(queue, 10000)),
        };

        Thread[] consumerList = {
                new Thread(new Consumer(queue, totalValue)),
                new Thread(new Consumer(queue, totalValue)),
                new Thread(new Consumer(queue, totalValue)),
                new Thread(new Consumer(queue, totalValue))
        };

        for (Thread thread : producerList) {
            thread.start();
        }

        for (Thread thread : consumerList) {
            thread.start();
        }

        for (Thread thread : producerList) {
            thread.join();
        }

        for (Thread thread : consumerList) {
            thread.interrupt();
        }

        for (Thread thread : consumerList) {
            thread.join();
        }

        System.out.println("total value: " + totalValue.getValue());
    }
}