import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

class Producer implements Runnable {
    private BlockingQueue<Integer> queue;
    private int value = 0;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Producer produced: " + value);
                queue.put(value++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                Thread.currentThread().interrupt();
                System.out.println("Producer Interrupted");
                // e.printStackTrace();
            }
        }
    }   
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer value = queue.take();
                System.out.println("Consumer consumed: " + value);
                Thread.sleep(2000);
            
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                Thread.currentThread().interrupt();
                System.out.println("Consumer Interrupted");
                // e.printStackTrace();
            }
        }
    }   
}

public class Demo04BlockingQueue {
    public static void main(String[] args) {
        /**
         * thread-safe queue
         * wait for queue to become non-empty / wait for space
         * simplify concurrency problems like producer-consumer
         * 
         * standard queue --> immediately
         *      empty --> remove    (no waiting)
         *      full --> add        (no waiting)
         * 
         * blocking queue
         *      put     --> Blocks if the queue is full until space becomes available
         *      take    --> Blocks if the queue is empty until an element becomes available.
         *      offer   --> Waits for space to become available, up to the specified timeout.
         * 
         * A bounded, array blocking queue is backed by circular array
         * low memory overhead
         * uses a single lock for both enque and dequeue operations.
         * more thread --> problem
         */

        // BlockingQueue<Integer> bDQ = new ArrayBlockingQueue<>(2);
        // Thread producer = new Thread(new Producer(bDQ));
        // Thread consumer = new Thread(new Consumer(bDQ));
        // producer.start();
        // consumer.start();

        /**
         * A LinkedBlockingQueue is optionally bounded, i.e., backed by linkedlist and could produce MemoryOutOfBoundException because by default it takes a capacity of Integer.MAX_VALUE. So recommended to bound by adding capacity.
         * Uses two seperate locks for enque and dequeue operations.
         * Higher concurrency between producers and consumers.
         * When more threads are there then linked blocking queue is recommended to use.
         * 
         */
        BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();

        /**
         * A PriorityBlockingQueue is also optionally bounded, and has default initial capacity (11) that orders its elements according to their natural ordering or a provided comparator.
         * Backed by binary heap as array and can grow dynamically
         * As its unbounded (as space for adding value will always be available), put wont block.
         */
        BlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();
        priorityBlockingQueue.add("Apple");
        priorityBlockingQueue.add("Cherry");
        priorityBlockingQueue.add("Banana");
        System.out.println("head --> " + priorityBlockingQueue.peek());
        System.out.println(priorityBlockingQueue);
    }    
}
