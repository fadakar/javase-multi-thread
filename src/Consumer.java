public class Consumer implements Runnable {

    private Queue<Integer> queue;

    private int sum;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (this.queue.length() == 0) {
                    try {
                        this.queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                sum += this.queue.pull();
                this.queue.notify();
                System.out.printf("Sum of numbers: %d%n", sum);
            }
        }
    }
}
