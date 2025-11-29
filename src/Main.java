public class Main {
    public static void main(String[] args) {
        QueueThreadSafe<Integer> queue = new QueueThreadSafe<>(5);

        Producer producer = new Producer(queue, 10000);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        consumerThread.setPriority(Thread.MAX_PRIORITY);

        producerThread.start();
        consumerThread.start();
    }
}