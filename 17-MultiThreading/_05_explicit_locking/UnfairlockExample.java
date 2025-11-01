import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairlockExample {
    /**
     * In an unfair lock scenario, the threads acquire the lock in an arbitrary manner.
     * When multiple threads (like T1, T2, and T3) are trying to acquire the lock, there is no specific order or sequence to determine which thread will receive the lock next. 
     * For example, after T1 releases the lock, T3 might acquire it before T2, even if T2 requested it earlier.
     * 
     * By default, the ReentrantLock is an unfair lock unless explicitly configured otherwise.
     * Using an unfair lock carries the risk of starvation, where a low-priority or unlucky thread might be continuously overlooked and never receive the lock, thus preventing it from running.
     * 
     * A fair lock operates on a FIFO (First In First Out) principle, meaning the thread that waited the longest or was the "first in line" is the one that gets the lock.
     * Enforcing fairness is crucial because it ensures that every thread gets a chance to acquire the resource, thereby resolving the issue of starvation.
     */
    private final Lock unfairLock = new ReentrantLock();
    // private final Lock fair = new ReentrantLock(true); // This is how you set the fairness to true.

    public void accessResource() {
        unfairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            unfairLock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock");
        }
    }

    public static void main(String[] args) {
        UnfairlockExample example = new UnfairlockExample();

        Runnable task = new Runnable(){
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        try {
            thread1.start();
            Thread.sleep(50);
            thread2.start();
            Thread.sleep(50);
            thread3.start();
            Thread.sleep(50);
        } catch(Exception e) {
            
        }
    }
}