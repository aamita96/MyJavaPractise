import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Demo05ParallelStreams {
    public static void main(String[] args) {
        // A type of stream that enables parallel processing of elements
        // Allowing multiple threads to process parts of the stream simultaneously.
        // This can significantly improve performance for large data sets
        // workload is distributed across multiple threads

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factorialList = list.stream().map(Demo05ParallelStreams::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with stream: " + (endTime - startTime) + " ms");

        // with parallel stream
        startTime = System.currentTimeMillis();
        list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        factorialList = list.parallelStream().map(Demo05ParallelStreams::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: " + (endTime - startTime) + " ms");

        // Parallel streams are most effective for CPU-intensive or large datasets where tasks are independent
        // They may add overhead for simple tasks or small datasets

        // Find Cumulative Sum: This example is to show how parallel streams can be wrong choice here for this task.
        // [1, 2, 3, 4, 5] --> [1, 3, 6, 10, 15]

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> cumulativeSum = numbers.parallelStream().map(x -> sum.addAndGet(x)).sequential().toList();
        System.out.println(cumulativeSum);
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
