import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo07ConcurrentLinkedQueue {
    private static ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>();
    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    taskQueue.add("Task" + System.currentTimeMillis()); // Adds task (will use locks internally)
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    String task = taskQueue.poll(); // Takes task (will use locks internally)
                    System.out.println("Processing: " + task);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
