// import java.util.concurrent.Executors;
// import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;

public class ExecutorFramework {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(9);
        // Executors.newScheduledThreadPool(2);
        // Executors.newSingleThreadExecutor();
        // ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            /*
             * 
             * Example - 
             * Future<Integer> future = executor.submit(() -> 43);
             * System.out.println(future.get());
             * executor.submit returns future, if you want to check if the executor.submit statement has returned something then you can check using Future.
             */

            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });
        }

        executor.shutdown();
        // executor.shutdownNow();

        // try {
        //     while(!executor.awaitTermination(500, TimeUnit.MILLISECONDS)) {
        //         System.out.println("Waiting...");
        //     }
        // } catch(InterruptedException e) {
        //     Thread.currentThread().interrupt();
        // }
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