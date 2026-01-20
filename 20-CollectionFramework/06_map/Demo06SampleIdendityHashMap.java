// import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Demo06SampleIdendityHashMap {
    public static void main(String[] args) {
        String key1 = new String("key");
        String key2 = new String("key");

        System.out.println(System.identityHashCode(key1));
        System.out.println(System.identityHashCode(key2));
        /**
         * here for comparing the key inside IdentityHashMap, identityHashCode and == (reference equality check or we can say address will be checked not the values) is used.
         */
        Map<String, Integer> map = new IdentityHashMap<>();
        map.put(key1, 1);
        map.put(key2, 2);

        System.out.println(map);
    }
}
