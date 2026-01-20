// import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo02SampleLinkedHashMap {
    public static void main(String[] args) {
        /**
         * A LinkedHashMap stores keys and values, and keeps them in the same order you put them in.
         */
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11, 0.5f, true);

        // HashMap<String, Integer> map = new HashMap<>();
        linkedHashMap.put("Orange", 20);
        linkedHashMap.put("Apple", 10);
        linkedHashMap.put("Guava", 40);

        
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        linkedHashMap.get("Apple");
        linkedHashMap.get("Guava");
        System.out.println();

        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
