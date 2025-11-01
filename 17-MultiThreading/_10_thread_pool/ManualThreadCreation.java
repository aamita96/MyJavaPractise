/*
 * Why Thread Pool?
 * 1) Resource Management
 * 2) Response Time
 * 3) Control Over Thread Count
 * 
 * We'll use Executors Framework in Java to manage Thread Pool
 * 
 * The Executors Framework was introduced in Java 5 as part of the java.util.concurrent 
 * package to simplify the development of concurrent applications by abstracting away 
 * many of the complexities involved in creating and managing threads. 
 * 
 * Prior to Executors Framework developers were facing following problems-
 * - Manual Thread Management
 * - Resource Management
 * - Scalability
 * - Thread Reuse
 * - Error Handling
 */

public class ManualThreadCreation {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        
        // we're managing custom threads here which is actually a tedious task to make it easy we can use Executor Framework
        Thread[] threads = new Thread[9]; 

        for (int i = 1; i < 10; i++) {
            int finalI = i;
            threads[i - 1] = new Thread(
                () -> {
                    long result = factorial(finalI);
                    System.out.println(result);
                }
            );
            threads[i - 1].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
        
        long result = 1;
        
        for (int i = 1; i <=n; i++) {
            result *= i;
        }
        
        return result;
    }
}