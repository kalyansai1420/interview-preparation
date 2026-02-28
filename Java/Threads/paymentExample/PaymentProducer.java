import java.util.concurrent.BlockingQueue;

public class PaymentProducer implements Runnable{
    private final BlockingQueue<Payment> queue;

    PaymentProducer(BlockingQueue<Payment> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for(int i=1;i<=10;i++){
                Payment payment = new Payment(i);
                queue.put(payment); // Blocks if queue is full

                System.out.println(
                    "Received payment "+ i
                );

                Thread.sleep(500); // simulate incoming traffic
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
