import java.util.concurrent.ConcurrentHashMap;

public class Demo02ConcurrentHashMap {
    public static void main(String[] args) {
        /**
         * The ** ConcurrentHashMap ** class of the Java collections framework provides a thread-safe map. 
         * That is, multiple threads can access the map at once without affecting the consistency of entries in a map.
         * 
         * It implements the ConcurrentMap interface.
         * 
         * ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>(initialCapacity, loadFactor);
         * 
         * By default - 
         *  - the capacity of the map will be 16
         *  - the load factor will be 0.75
         * 
         * ** ConcurrentHashMap vs HashMap **
         * 
         * Here are some of the differences between ConcurrentHashMap and HashMap, 
         * 
         *  - ConcurrentHashMap is a thread-safe collection. That is, multiple threads can access and modify it at the same time. 
         *  - ConcurrentHashMap provides methods for bulk operations like forEach(), search() and reduce().
         * 
         * ** Why ConcurrentHashMap? **
         * 
         *  - The ConcurrentHashMap class allows multiple threads to access its entries concurrently.
         *  - By default, the concurrent hashmap is divided into 16 segments. This is the reason why 16 threads are allowed to concurrently modify the map at the same time. However, any number of threads can access the map at a time.
         *  - The putIfAbsent() method will not override the entry in the map if the specified key already exists.
         *  - It provides its own synchronization.
         */
        
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        // Hashtable<Integer, String> map = new Hashtable<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
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
