public class Producer implements Runnable {

    private final QueueThreadSafe<Integer> queue;
    private final int size;


    public Producer(QueueThreadSafe<Integer> queue, int size) {
        this.queue = queue;
        this.size = size;
    }


    @Override
    public void run() {
        int i = 0;
        while (i++ <= size) {
            try {
                this.queue.add(i);
                System.out.printf("Queue Size: %d%n", this.queue.length());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
