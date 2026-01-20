import java.util.HashMap;
import java.util.Map;

public class Demo01SampleHashMap {
    public static void main(String[] args) {
        /**
         * In Java, a Map is an object that maps keys to values. It cannot contain duplicate keys, and each key can map to at most one value. 
         * Think of it as a dictionary where you look up a word(key) to find its defination(value).
         * 
         * **Key Characterstics of the Map Interface**
         * 
         *      **Key-Value Pairs**: Each entry in a Map consists of a key and a value.
         *      **Unique Keys**: No two entries can have the same key.
         *      **One Value per Key**: Each key maps to a single value.
         *      **Order**: Some implementations maintain insertion order(LinkedHashMap), natural order(TreeMap), or no order (HashMap).
         *
            **Key Characteristics**

         *      **Unordered**: Does not maintain any order of its elements.
         *      **Allows null Keys and Values**: Can have one null key and multiple null values.
         *      **Not Synchronized**: Not thread-safe; requires external synchronization if used in a multi-threaded context.
         *      **Performance**: Offers constant-time performance (O(1)) for basic operations like get and put, assuming the hash function disperses elements properly.
         *      
         *      
            **Internal Structure of HashMap**

            Basic Components of HashMap

            Key - The identifier used to retrieve value.
            Value - The data associated with the key.
            Bucket - A place where key-value paris are stored. Think of buckets as cells in a list(array).
            Hash Function - Converts a key into an index (bucket location) for storage.
            
         *  Hash Function - A hash function is an algorithm that takes an input (or "key") and returns a fixed-size string of bytes, typically a numerical value.
         *                  The output is known as hash code, hash value or simply hash. The primary function of a hash function is to map data of arbitrary size to data of fixed size.
         * 
         * Deterministic - The same input will always produce the same output.
         * Fixed Output Size - Regardless of the input size, the hash code has a consistent size (e.g., 32-bit, 64-bit).
         * Efficient Computation - The hash function should compute the hash quickly.
         * 
         * 
         * Time Complexity
         * 
         * HashMap provides constant time O(1) performance for basic operations like put() and get()
         */
        
        HashMap<Integer, String> map = new HashMap<>();
        map.put(31, "Shubham");
        map.put(11, "Akshit");
        map.put(2, "Bulbul");
        map.put(3, "Charu");
        System.out.println(map);

        System.out.println(map.get(3));
        System.out.println(map.get(69));
        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("Shubham"));

        System.out.println();
        // for (int i : map.keySet()) {
        //     System.out.println(map.get(i));
        // }
        
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println(map.remove(31));
        System.out.println(map);
    }
}