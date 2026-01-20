import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class Demo01SetOverview {

    public static void main(String[] args) {
        /**
         * Set is a collection that cannot contain duplicate elements.
         * faster operations as it's based on principles of hashmap. So time complexity of finding and insertion is O(1).
         * 
         * Map has implementation clasess -> HashMap, LinkedHashMap, TreeMap, EnumMap
         * 
         * similarly we have for set as well
         * Set -> HashSet, LinkedHashSet, TreeSet, EnumSet
         * 
         *                  ----------------------------------------------------------
         * The **Set** interface of the Java Collections framework provides the features of the mathematical set in Java. It extends the Collection interface.
         * Unlike the List interface, sets cannot contain duplicate elements.
         * 
         * ** Classes that implement Set **
         * 
         * Since Set is an interface, we cannot create objects from it. 
         * 
         * In order to use functionalities of the Set interface, we can use these implementation classes: 
         *  - HashSet - unordered
         *  - LinkedHashSet 
         *  - EnumSet 
         *  - TreeSet 
         * 
         * These classes are defined in the Collections framework and implement the Set interface.
         * 
         */

        /*
            ========================
            Java Set Implementations
            ========================

            All Set implementations:
            - Store UNIQUE elements (no duplicates)
            - Do NOT support indexing
            - At most one null element (except TreeSet & EnumSet)

            --------------------------------------------------
            1) HashSet
            --------------------------------------------------
            - Uses Hash Table internally
            - Order: ❌ No guaranteed order
            - Performance:
                add(), remove(), contains() → O(1) average
            - Allows: ✔ one null element
            - Fastest general-purpose Set

            Use cases:
            - Removing duplicates
            - Fast membership checks
            - When order does NOT matter

            Example:
            Set<Integer> set = new HashSet<>();

            --------------------------------------------------
            2) LinkedHashSet
            --------------------------------------------------
            - Uses Hash Table + Doubly Linked List
            - Order: ✔ Maintains INSERTION order
            - Performance:
                Slightly slower than HashSet
            - Allows: ✔ one null element

            Use cases:
            - Preserve insertion order
            - Ordered unique elements
            - Recently accessed / user-entered data

            Example:
            Set<String> set = new LinkedHashSet<>();

            --------------------------------------------------
            3) TreeSet
            --------------------------------------------------
            - Uses Red-Black Tree (Self-balancing BST)
            - Order: ✔ SORTED order
                (Natural ordering or Comparator)
            - Performance:
                add(), remove(), contains() → O(log n)
            - Allows: ❌ NO null elements

            Extra features:
            - headSet(), tailSet(), subSet()
            - first(), last()

            Use cases:
            - Sorted unique data
            - Leaderboards
            - Range-based queries

            Example:
            Set<Integer> set = new TreeSet<>();

            --------------------------------------------------
            4) EnumSet
            --------------------------------------------------
            - Special Set ONLY for enum types
            - Uses Bit Vectors internally
            - Order: ✔ Natural order of enum constants
            - Performance:
                Extremely fast & memory-efficient
            - Allows: ❌ NO null
            - Limitation: ❌ Works ONLY with enums

            Use cases:
            - Storing enum constants
            - Flags, permissions, fixed categories

            Example:
            enum Day { MON, TUE, WED, THU, FRI }
            Set<Day> days = EnumSet.of(Day.MON, Day.FRI);

            --------------------------------------------------
            Quick Summary
            --------------------------------------------------
            HashSet       → Fastest, no order
            LinkedHashSet → Insertion order
            TreeSet       → Sorted order
            EnumSet       → Enums only, fastest & compact

            Rule of thumb:
            - Default choice → HashSet
            - Need order → LinkedHashSet
            - Need sorting → TreeSet
            - Using enums → EnumSet
        */

        Set<Integer> set = new LinkedHashSet<>();
        set.add(02);
        set.add(01);
        set.add(05);
        set.add(03);
        set.add(20); // duplicate element is added to check wether Set removes it or not.
        System.out.println("LinkedHashSet -> " + set);
        System.out.println(set.contains(5));
        // set.clear();
        System.out.println(set.isEmpty());

        System.out.println(" ------------------- Tree Set Values-------------------------");

        TreeSet<Integer> treeSet = new TreeSet<>(); // TreeSet implements NavigableSet which provides few additional methods like ceiling, floor
        treeSet.add(02);
        treeSet.add(01);
        treeSet.add(05);
        treeSet.add(03);
        treeSet.add(20);
        System.out.println(treeSet.floor(4));
        System.out.println(treeSet.higher(500));
        System.out.println(treeSet.contains(5));
        System.out.println(treeSet.remove(5));
        // treeSet.clear();
        System.out.println(treeSet.isEmpty());
        for(int v : treeSet) {
            System.out.print(v);
        }
        System.out.println();

        System.out.println("TreeSet -> " + treeSet);

        // For thread safety use Collections.synchronizedSet(set) or RECOMMENDED: Replaced with a concurrent Set (CopyOnWriteArraySet, ConcurrentSkipListSet)

        // Set<Integer> synchronizedSet = Collections.synchronizedSet(set);
        
        // synchronized(set) {
        //     for(int i : synchronizedSet) {
        //         if (i == 5) {
        //             synchronizedSet.add(55); // Throws java.util.ConcurrentModificationException
        //         }
        //         System.out.println(i);
        //     }
        // }

        // System.out.println(synchronizedSet);


        // recommended to use for thread-safety
        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();
        skipListSet.add(20);
        skipListSet.add(40);
        skipListSet.add(30);
        skipListSet.add(60);
        skipListSet.add(20);

        for(int i : skipListSet) {
            if (i == 30) {
                skipListSet.add(55); // Allows addtion while reading
            }
            System.out.print(i);
        }
        System.out.println();
        System.out.println(skipListSet);

        // unmodifiable
        // Set<Integer> unmodifiableSet = Set.of(1,2,3,4,5,6,7,8, 9, 10, 11, 12, 13);
        // unmodifiableSet.add(500); // Throws java.lang.UnsupportedOperationException

        // to make modifiable set, unmodifiable modifiable we can use Set.of() or Collections.un 
        Set<Integer> unmodifiableSet = Collections.unmodifiableSet(set);
        System.out.println(unmodifiableSet);
        unmodifiableSet.add(500); // Throws java.lang.UnsupportedOperationException
    }    
}
