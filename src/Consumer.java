public class Consumer implements Runnable {

    private QueueThreadSafe<Integer> queue;

    private int sum;

    public Consumer(QueueThreadSafe<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                sum += this.queue.take();
                System.out.printf("Sum of numbers: %d%n", sum);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
