public class Producer implements Runnable {

    private final Queue<Integer> queue;
    private final int maxSize;
    private final int maxConcurrentSize;


    public Producer(Queue<Integer> queue, int maxSize, int maxConcurrentSize) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.maxConcurrentSize = maxConcurrentSize;
    }


    @Override
    public void run() {
        int i = 0;
        while (i++ <= maxSize) {
            synchronized (queue) {
                if(this.queue.length() >= maxConcurrentSize) {
                    try {
                        this.queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                this.queue.add(i);
                System.out.printf("Queue Size: %d%n", this.queue.length());
                this.queue.notify();
            }
        }
    }
}
