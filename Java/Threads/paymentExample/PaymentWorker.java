import java.util.concurrent.BlockingQueue;

public class PaymentWorker implements Runnable {
    private final BlockingQueue<Payment> queue;

    PaymentWorker(BlockingQueue<Payment> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true){
                // WAITING state if queue empty
                Payment payment = queue.take();

                System.out.println(
                    Thread.currentThread().getName() +
                    " processing payment " + payment.id
                );

                // TIMED_WAITING
                Thread.sleep(2000);
                System.out.println(
                    Thread.currentThread().getName() +
                    " completed payment " + payment.id
                );
            }
        } catch (InterruptedException e) {
            // Graceful shutdown
            System.out.println(
                Thread.currentThread().getName() +
                " shutting down"
            );
            Thread.currentThread().interrupt();
        }
    }
}
