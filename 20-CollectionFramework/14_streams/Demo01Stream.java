import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo01Stream {
    public static void main(String[] args) {
        // Streams are feature introduced in Java 8
        // to process collections of data in a functional and declarative manner
        // Simplify data processing.
        // Embrace functional programming
        // Improve readability and maintainbility.
        // Enable easy parallelism

        // What is Stream?
        // A sequence of elements supporting functional and declarative programming.

        // How to use Streams?
        // source, intermediate operations & terminal operation
        
        List<Integer> numbers = Arrays.asList(2, 1, 5, 4, 3);
        
        // Stream way of sorting.
        System.out.println(numbers.stream().sorted().toList());
        System.out.println(numbers);

        // Count even numbers in list (traditional way)

        int count = 0;
        for (int i : numbers) {
            if (i % 2 == 0) count++;
        }
        System.out.println(count);

        
        // creating streams
        // 1 From collections
        System.out.println(numbers.stream().filter(x -> x % 2 == 0).count()); // count even numbers in list (stream way)
        // 2. From Arrays
        String[] arrays = {"a", "b", "c"};
        Arrays.stream(arrays);

        // 3. Using Stream.of()
        Stream<String> stream = Stream.of("Apple", "Dates", "Banana", "Oranges");
        System.out.println(stream);

        // 4. Infinite streams // use limit to limit the stream with particular numbers
        Stream<Integer> generate = Stream.generate(() -> 1);
        // System.out.println(generate.count());
        List<Integer> collect = Stream.iterate(1, (x) -> x + 1).limit(100).collect(Collectors.toList());
        System.out.println(collect);
    }    
}
