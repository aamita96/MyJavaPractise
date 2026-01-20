import java.util.LinkedHashMap;
import java.util.Map;

public class Demo03LRUCache<K, V> extends LinkedHashMap<K, V>{
    private int capacity;

    public Demo03LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
    
    public static void main(String[] args) {
        Demo03LRUCache<String, Integer> studentMap = new Demo03LRUCache<>(3);
        studentMap.put("Alice", 89);
        studentMap.put("Bob", 88);
        studentMap.put("Ram", 99);
        studentMap.put("Vipul", 85);

        studentMap.get("Bob");
        studentMap.get("Alice");
        studentMap.put("Alice", 100); // here put is also consider as accessing a value.

        System.out.println(studentMap);
    }
}
