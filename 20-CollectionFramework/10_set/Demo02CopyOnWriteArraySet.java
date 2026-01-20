import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class Demo02CopyOnWriteArraySet {
    public static void main(String[] args) {
        /*
            ========================================================
            🟢 CopyOnWriteArraySet vs ConcurrentSkipListSet - Java
            ========================================================

            Both are thread-safe Set implementations, but differ
            in structure, performance, iteration, and use-cases.

            --------------------------------------------------------
            1️⃣ Core differences
            --------------------------------------------------------
            Feature                     | CopyOnWriteArraySet           | ConcurrentSkipListSet
            ----------------------------|------------------------------|----------------------
            Internal structure          | 📝 CopyOnWriteArrayList      | 🏹 Concurrent Skip List (multi-level linked list)
            Ordering                    | ❌ No guaranteed order       | ✅ Always sorted (natural order or Comparator)
            Thread-safety               | ✅ Fully thread-safe          | ✅ Fully thread-safe
            Iteration                   | 📸 Snapshot-based (fail-safe)| 🔄 Weakly consistent, sees some updates
            Read performance            | ⚡ Extremely fast (no locks) | ⚡ Fast, but slightly slower
            Write performance           | 🐢 Expensive (copy entire array)| ⚡ Efficient (fine-grained locking, O(log n))
            Memory usage                | 💾 High for frequent writes  | 💾 Reasonable, scales with size

            --------------------------------------------------------
            2️⃣ When to use
            --------------------------------------------------------
            🟢 CopyOnWriteArraySet:
            - Read-heavy, write-light scenarios
            - Frequent iteration
            - Writes are rare
            Example: 🎧 Event listeners, ⚙️ cached configuration values
            Reason: Snapshot iteration avoids ConcurrentModificationException, reads are lock-free

            🟢 ConcurrentSkipListSet:
            - Balanced or write-heavy scenarios
            - Need sorted order
            - Iterators tolerate concurrent modifications (weakly consistent)
            Example: 🏆 Real-time leaderboards, top scores, concurrent sorted data
            Reason: Fine-grained locking allows efficient writes, elements always sorted

            --------------------------------------------------------
            3️⃣ Iteration behavior
            --------------------------------------------------------
            Aspect                      | CopyOnWriteArraySet           | ConcurrentSkipListSet
            ----------------------------|------------------------------|----------------------
            Iterator type               | 📸 Fail-safe (snapshot)      | 🔄 Weakly consistent
            Modification during iteration | ✅ Safe, iterator sees snapshot | ✅ Safe, iterator may see some changes
            ConcurrentModificationException | ❌ Never thrown             | ❌ Never thrown

            --------------------------------------------------------
            4️⃣ Mental trick 🧠
            --------------------------------------------------------
            COW vs Skip:
            - 🐄 COW = CopyOnWrite → snapshot, very fast reads, slow writes → read-heavy
            - 🏹 Skip = Skip List → sorted, concurrent, balanced → read/write-heavy + sorted

            --------------------------------------------------------
            5️⃣ Example usage
            --------------------------------------------------------
            // 🐄 CopyOnWriteArraySet (read-heavy)
            Set<Integer> cowSet = new CopyOnWriteArraySet<>();
            cowSet.add(1);
            cowSet.add(2);
            cowSet.add(3);

            // 🏹 ConcurrentSkipListSet (sorted + concurrent)
            Set<Integer> skipSet = new ConcurrentSkipListSet<>();
            skipSet.add(3);
            skipSet.add(1);
            skipSet.add(2);
            // ✅ Automatically sorted: 1, 2, 3

            --------------------------------------------------------
            6️⃣ Quick exam / interview tip 🎯
            --------------------------------------------------------
            - 🐄 CopyOnWriteArraySet → Use when reads >> writes
            - 🏹 ConcurrentSkipListSet → Use when you need sorted order + concurrency
            - ❌ Both avoid ConcurrentModificationException unlike synchronizedSet
        */

        CopyOnWriteArraySet<Integer> copyOnWriteSet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();

        for (int i = 1; i <= 5; i++) {
            copyOnWriteSet.add(i);
            skipListSet.add(i);
        }

        // for (Integer i : skipListSet) {
        //     if (i == 20) skipListSet.add(6);
        //     System.out.println(i);
        // }

        System.out.println("Initial CopyOnWriteArraySet: " + copyOnWriteSet);
        System.out.println("Initial ConcurrentSkipListSet: " + skipListSet);

        System.out.println("Iterating and modifying CopyOnWriteArraySet:");
        for (int num : copyOnWriteSet) {
            System.out.println("Reading from CopyOnWriteArraySet: " + num);
            // Attempting to modify the set during iteration
            copyOnWriteSet.add(6);
        }

        System.out.println("Iterating and modifying ConcurrentSkipListSet:");
        for (int num : skipListSet) {
            System.out.println("Reading from ConcurrentSkipListSet: " + num);
            // Attempting to modify the set during iteration
            if (num == 5) skipListSet.add(6);
        }
    }
}
