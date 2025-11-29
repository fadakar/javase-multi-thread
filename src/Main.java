import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        Producer producer = new Producer(queue, 10000, 5);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        consumerThread.setPriority(Thread.MAX_PRIORITY);

        producerThread.start();
        consumerThread.start();
    }
}