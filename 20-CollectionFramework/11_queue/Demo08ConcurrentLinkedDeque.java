import java.util.concurrent.ConcurrentLinkedDeque;

public class Demo08ConcurrentLinkedDeque {
    public static void main(String[] args) {
        /**
         * non-blocking, thread-safe double-ended queue
         * It uses compare and swap strategy internally.
         */
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        deque.add("Element 1");
        deque.addFirst("Element 0");
        deque.addLast("Element 2");
        System.out.println(deque);
    }    
}
