import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {
        /**
         * Sorted map is an interface that extends Map and gurantees that the entries are sorted based on the keys, either in their natural ordering or by a specified comparator.
         * 
         * Since SortedMap is an interface, we cannot create objects from it. 
         * In order to use the functionalities of the SortedMap interface, we need to use the class TreeMap that implements it.
         * 
         * TreeMap interally uses Red Black Tree (self balancing binary search tree).
         * 
         * Usecase of Sorted Map - If you only care that keys stay sorted and can work with ranges. Then use Sorted Map interface.
         * 
         * Example:

            Student names sorted alphabetically

            Scores grouped by grade ranges

            Dictionary-like data

            📌 Limitation:
            You can’t easily move backward, or find nearest keys.

            Use it when: You only need sorted order and You don’t care about neighbors or reverse traversal
         */
        SortedMap<String, Integer> map = new TreeMap<>((a, b) -> b.compareTo(a));
        map.put("Vivek", 89);
        map.put("Shubham", 80);
        map.put("Sunil", 88);
        map.put("Amit", 80);
        map.put("Charu", 90);
        map.put("Devi", 91);

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map);
        System.out.println("subMap -> " + map.subMap("Vivek", "Shubham"));
        
        System.out.println(map.headMap("Devi"));

        System.out.println("---------Navigable Map----------");

        /**
         * Since NavigableMap is an interface, we cannot create objects from it. 
         * In order to use the functionalities of the NavigableMap interface, we need to use the TreeMap class that implements NavigableMap.
         * 
         * The NavigableMap is considered as a type of SortedMap. It is because NavigableMap extends the SortedMap interface. 
         * Hence, all SortedMap methods are also available in NavigableMap.
         * 
         * Think of it as: `SortedMap + navigation superpowers`
         * 
         * Extra capabilities
         * You can: 
         *  - Move both directions 
         *  - Find closest keys 
         *  - Work with inclusive/exclusive bounds
         *  - Get reverse views
         * 
         * Use it when: You need to search around a key, You want range queries, You want reverse traversal
         * 
         * Real-world examples: 
         *  - Time-based data (logs, events) 
         *  - Price ranges (find closest price) 
         *  - Leaderboards (next higher/lower score)
         *  - Scheduling systems
         */
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "One");
        navigableMap.put(5, "Five");
        navigableMap.put(3, "Three");

        System.out.println(navigableMap);
        System.out.println(navigableMap.ceilingKey(4));
        System.out.println(navigableMap.lowerKey(4));
        System.out.println(navigableMap.higherKey(4));
        System.out.println(navigableMap.higherEntry(4));
        System.out.println(navigableMap.descendingMap());
        System.out.println(navigableMap.pollFirstEntry());
        System.out.println(navigableMap);
    }
}
