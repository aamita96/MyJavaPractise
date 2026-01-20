// import java.util.HashMap;
import java.util.Hashtable;

public class Demo01HashTable {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        // HashTable is synchronized
        // no null key or value
        // Legacy Class, and its not used anymore becuase it's replaced by ConcurrentHashMap.
        // Slower than HashMap
        // only linked list in case of collision
        // all methods are synchronized

        hashtable.put("Apple", 200);
        hashtable.put("Orange", 100);
        hashtable.put("Mango", 250);
        System.out.println(hashtable);
        System.out.println("Value for key Apple: " + hashtable.get("Apple"));
        System.out.println("Does key 3 exist? " + hashtable.containsKey("Orange"));
        // hashtable.remove("Mango");
        // hashtable.put(null, null); // throws exception
        // hashtable.put(null, 88); // throws exception
        System.out.println(hashtable);

        Hashtable<Integer, String> map = new Hashtable<>();
        Thread thread1 = new Thread(() -> {
            for (int i =0; i < 1000; i++) {
                map.put(i, "Thread1");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put(i, "Thread2");
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Final size of HashMap " + map.size());
    }    
}
