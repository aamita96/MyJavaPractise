import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo01PrimitiveStreams {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        Stream<Integer> stream = Arrays.stream(numbers);

        /**
         * You need boxed() when: 
         * - You want to work with collections (List<Integer>, Set<Integer>) 
         * - You want to use object-based stream operations 
         * - You need to use generic APIs
         */
        int[] numbersWithPrimivites = {1, 2, 3, 4, 5};
        IntStream stream2 = Arrays.stream(numbersWithPrimivites);

        stream2.boxed().forEach(System.out::print);
        System.out.println();
        System.out.println(IntStream.range(5, 100).boxed().toList());
        System.out.println(IntStream.rangeClosed(5, 100).boxed().toList());

        IntStream.of(66, 77, 88, 99, 111).forEach(System.out::println);

        DoubleStream doubles = new Random().doubles(2);
        // System.out.println("Random Doubles : " + doubles.boxed().toList());
        // System.out.println(doubles.summaryStatistics());
        doubles.mapToInt(x -> (int) x + 1).forEach(System.out::println);
        // System.out.println(doubles.sum()); // sum is terminal operator after executing this it will stop the stream.

        IntStream ints = new Random().ints(2);
        System.out.println("Random Integers: " + ints.boxed().toList());
    }    
}
