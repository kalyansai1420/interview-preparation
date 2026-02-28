import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PaymentSystemDemo {
    public static void main(String[] args) throws InterruptedException{
        
        // Shared queue ( real waiting happens here)
        BlockingQueue<Payment> queue = new ArrayBlockingQueue<>(5);

        // Worker pool ( limited concurrency)
        ExecutorService workers = Executors.newFixedThreadPool(3);

        // Start workers
        for (int i = 0; i < 3; i++) {
            workers.execute(new PaymentWorker(queue));
        }

        // Start producer
        Thread producer = new Thread(new PaymentProducer(queue));
        producer.start();

        // Let system run
        Thread.sleep(15000);

        System.out.println("Initiating shutdown...");
        workers.shutdownNow();
        workers.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("System stopped cleanly");
    }
}
