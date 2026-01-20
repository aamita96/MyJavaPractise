import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Demo08ImmutableMap {
    public static void main(String[] args) {
        /**
         * ImmutableMap, as suggested by the name, is a type of Map which is immutable. It means that the content of the map are fixed or constant after declaration, that is, they are read-only.
         * If any attempt made to add, delete and update elements in the Map, UnsupportedOperationException is thrown.
         * An ImmutableMap does not allow null element either.
         * If any attempt made to create an ImmutableMap with null element, NullPointerException is thrown. If any attempt is made to add null element in Map, UnsupportedOperationException is thrown.
         * 
         * ** Advantages of ImmutableMap **
         * 
         * - They are thread safe.
         * - They are memory efficient.
         * - Since they are immutable, hence they can be passed over to third party libraries without any problem.
         */

        Map<String, Integer> map = new HashMap<>();
        map.put("Mango", 200);
        map.put("Apple", 150);
        map.put("Guava", 80);

        // To make specified map into an unmodifiable map then we can use Collections.unmodifiableMap() method.
        Map<String, Integer> map2 = Collections.unmodifiableMap(map);
        // map2.put("Orange", 100); // throws UnsupportedOperationException 
        System.out.println(map2);

        // Since Java 9, we have a clean way to create Unmodifiable map using Map.of().
        // But its limited to 10 key-value pairs. To overcome this limitation we can use Map.ofEntries(); 
        Map<String, Integer> map3 = Map.of("Shubham", 60, "Vivek", 70, "Amit", 76);
        // map3.put("Rinku", 55); // throws UnsupportedOperationException

        Map<String, Integer> mapEntries = Map.ofEntries(Map.entry("Akshit", 89), Map.entry("Akshita", 80));
        System.out.println("Entries using ofEntries " + mapEntries);
    }
}
