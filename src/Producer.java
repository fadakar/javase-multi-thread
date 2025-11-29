public class Producer implements Runnable {

    private final QueueThreadSafe<Integer> queue;
    private final int maxSize;


    public Producer(QueueThreadSafe<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }


    @Override
    public void run() {
        int i = 0;
        while (i++ <= maxSize) {
            try {
                this.queue.add(i);
                System.out.printf("Queue Size: %d%n", this.queue.length());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
