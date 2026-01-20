import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo03TerminalOps {
    public static void main(String[] args) {
        // Terminal operations are operations that end the stream pipeline and produce a result or side-effect
        List<Integer> list = Arrays.asList(0, 1, 2, 3);
        
        // 1. collect
        list.stream().skip(1).collect(Collectors.toList());
        //              or 
        list.stream().skip(1).toList();

        // 2. forEach
        list.stream().forEach(System.out::println);

        // 3. reduce: combines elements to produce a single result
        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
        //          or
        list.stream().reduce(Integer::sum);
        System.out.println(reduce.get());

        // 4. count

        // 5. anyMatch, allMatch, noneMatch
        boolean anyMatch = list.stream().anyMatch(x -> x % 2 == 0);
        boolean anyMatch1 = list.stream().allMatch(x -> x > 0);
        System.out.println(list.stream().noneMatch(x -> x < 0));
        System.out.println("Any Match: " + anyMatch);
        System.out.println("All Match: " + anyMatch1);

        // 6. findFirst, findAny
        // findFirst, findAny, anyMatch, allMatch, noneMatch all are short-circuit operations. Meaning, as soon as they find a match, they terminate and stop processing rest of the elements.
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        // 7. toArray() 
        Object[] array = Stream.of(1, 2, 3, 4, 5).toArray();

        // 8. min/max
        System.out.println("Min: " + Stream.of(55, 69, 3).min(Comparator.naturalOrder()).get());
        System.out.println("Max: " + Stream.of(55, 69, 3).max(Comparator.naturalOrder()).get());

        // 9. forEachOrdered
        List<Integer> numbers0 = Arrays.asList( 1, 2, 3, 4 , 5, 6, 7 ,8, 9, 10);
        System.out.println("Using forEach with parallel streams: ");
        numbers0.parallelStream().forEach(System.out::print); // when using forEach with parallel streams there's no order.
        System.out.println();

        System.out.println("Using forEachOrdered with parallel streams: ");
        numbers0.parallelStream().forEachOrdered(System.out::print);
        System.out.println();

        // Example: Filtering and collecting Names who's length > 3
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        System.out.println(names.stream().filter(x -> x.length() > 3).toList());

        // Example: Squaring and Sorting Numbers
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(numbers.stream().map(x -> x * x).toList());

        // Example: Summing values
        List<Integer> integers = Arrays.asList(1, 2, 5, 3, 4);
        System.out.println(integers.stream().reduce(Integer::sum).get());

        // Example: Counting occurrences of a character
        String sentence = "Hello World";
        System.out.println(sentence.chars().filter(x -> x == 'l').count());

        // Example
        // Streams cannot be reused after a terminal operation has been called
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);

        System.out.println(stream.map(String::toUpperCase).toList()); // exception

        // stateful(sorting,distinct is an example of stateful operator) & stateless (map is an example of stateless operator)
    }    
}
