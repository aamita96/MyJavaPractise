import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Demo05SynchronousQueue {
    public static void main(String[] args) {
        /**
         * Each insert operation must wait for a corresponding remove operation by
         * another thread and vice versa.
         * it
         */
        BlockingQueue<String> queue = new SynchronousQueue<>();
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer is waiting to transfer...");
                queue.put("Hello from producer!");
                System.out.println("Producer has transferred the message.");
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer was interrupted.");
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer is waiting to receive...");
                String message = queue.take();
                System.out.println("Consumer received: " + message);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer was interrupted.");
            }
        });

        producer.start();
        consumer.start();
    }
}
