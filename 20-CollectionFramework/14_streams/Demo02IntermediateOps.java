import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo02IntermediateOps {
    public static void main(String[] args) {
        // Intermediate operations transform a stream into another stream.
        // They are lazy, meaning they don't execute until a terminal operation is invoked.

        List<String> list = Arrays.asList("Akshit", "Ram", "Shyam", "Ghanshyam", "Ram");
        // 1. Filter
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("A"));
        // no filtering at this point
        System.out.println(filteredStream.count()); // count is a terminal operation and will produce the result after filter.
        // 2. map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        // 3. sorted
        Stream<String> sortedStream = list.stream().sorted();
        System.out.println(sortedStream.toList());
        Stream<String> sortedStreamUsingComparator = list.stream().sorted((a, b) -> a.length() - b.length());
        System.out.println(sortedStreamUsingComparator.toList());

        // 4. district
        System.out.println(list.stream().filter(x -> x.startsWith("R")).distinct().count());

        // 5. limit
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());

        // 6. skip
        System.out.println(Stream.iterate(1, x -> x + 1 ).skip(50).limit(100).count());

        // 7. peek
        // Performs an action on each element as it is consumed.
        Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println).count();

        // 8. flatMap
        // Handle streams of collections, lists, or arrays where each element is itself a collection.
        // Flatten nested structures (e.g., lists within lists) so that they can be processed as a single sequence of elements
        // Transform and flatten elements at the same time.
        List<List<String>> listofLists = Arrays.asList(
            Arrays.asList("apple", "banana"),
            Arrays.asList("orange", "kiwi"),
            Arrays.asList("peer", "grape")
        );

        System.out.println(listofLists.get(1).get(1));
        System.out.println(listofLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());
        List<String> sentences = Arrays.asList(
            "Hello worlds",
            "Java Streams are powerful",
            "FlatMap is useful"
        );
        System.out.println(sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")).map(String::toUpperCase)).toList());
    }    
}
