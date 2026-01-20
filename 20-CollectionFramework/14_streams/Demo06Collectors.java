import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Demo06Collectors {
    public static void main(String[] args) {
        // Collectors is a utility class
        // provides a set of methods to create common collectors

        // 1. Collecting to a List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> res = names.stream()
        .filter(x -> x.startsWith("A"))
        .collect(Collectors.toList());
        System.out.println(res);

        // 2. Collecting to a Set
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println(nums.stream().collect(Collectors.toSet()));

        // 3. Collecting to a Specific Collection
        ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        // 4. Joining Strings
        // Concatenates stream elements into a single String
        String concatNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(concatNames);

        // 5. Summarizing Data
        // Generates statistical summary (count, sum, min, average, max)
        List<Integer> numbers = Arrays.asList(7, 2, 11, 4, 5, 3);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());

        // 6. Calculating Averages
        double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average: " + average);

        // 7. Counting Elements
        long count = numbers.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

        // 8. Grouping Elements
        List<String> words = Arrays.asList("hello", "world", "java", "streams", "collecting");

        System.out.println(words.stream().collect(Collectors.groupingBy(x -> x.length())));
        
        // when you are done with grouping, then if you have to perform any operation with group then you can mention it as second parameter
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", "))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap);

        // 9. Partitioning Elements
        // Partitions elements into two groups (true and false) based on predicate.

        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5 )));

        // 10. Mapping and collecting
        // Applies a mapping function before collecting
        System.out.println(words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));

        // Example 1: Collecting names by Length
        List<String> l1 = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
        System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));

        // Example 2: Counting Word Occurences
        String sentence = "hello world hello java world";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        // Example 3: Partitioning Even and Odd Numbers
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));

        // Example 4: Summing values in a Map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 15);
        System.out.println(items.values().stream().reduce(Integer::sum).get());
        System.out.println(items.values().stream().collect(Collectors.summingInt(x -> x)));

        // Example 5: Creating a Map from Stream Elements
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length())));

        // Example 6: get the counts of words in the list.
        List<String> words2 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "kiwi");
        System.out.println(words2.stream().collect(Collectors.toMap(k -> k.toUpperCase(), v -> 1, (x, y) -> x + y)));
    }
}
