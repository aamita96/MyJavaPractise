// import java.util.ArrayDeque;
// import java.util.LinkedList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Demo02PriorityQueue {
    public static void main(String[] args) {
        /**
         * Part of the Queue Interface
         * Orders elements based on their natural ordering (for primitives lowest first)
         * Custom comparator for customized ordering
         * Does not allow NULL elements
         * 
         * Internal Working
         * 
         * PriorityQueue is implemented as a min-heap by default (for natural ordering)
         */
        
        // Queue<Integer> pq = new PriorityQueue<>();
        // Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // Custom ordering using comperator
        //                  OR
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        
        pq.offer(20);
        pq.offer(10);
        pq.offer(30);
        pq.offer(15);
        pq.offer(1);
        
        // System.out.println(pq);
        // System.out.println(pq.poll());
        // System.out.println(pq.element());
        // System.out.println(pq);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }    
}
