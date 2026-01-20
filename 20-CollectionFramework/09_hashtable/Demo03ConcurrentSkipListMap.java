import java.util.concurrent.ConcurrentSkipListMap;

public class Demo03ConcurrentSkipListMap {
    public static void main(String[] args) {
        /**
         * Probabilistic data-structure that allows for effecient search, insertion and deletion operations.
         * It is similar to a sorted linkedlist but with multiple layers that "skip" over portions of the list to provide faster access to elements.
         * 
         * All method available in navigable map are also available in ** ConcurrentSkipListMap **.
         */
        ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();
        map.put("Mongo", 200);
    }
}