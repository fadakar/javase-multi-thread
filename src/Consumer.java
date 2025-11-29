public class Consumer implements Runnable {

    private final QueueThreadSafe<Integer> queue;
    private final IntegerSafe totalValue;

    public Consumer(QueueThreadSafe<Integer> queue, IntegerSafe totalValue) {
        this.queue = queue;
        this.totalValue = totalValue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Integer consumedValue = queue.take();
                totalValue.inc(consumedValue);
                System.out.printf("Sum of numbers: %d \n", totalValue.getValue());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
