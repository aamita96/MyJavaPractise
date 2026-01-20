import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Demo01Queue {
    public static void main(String[] args) {
        /**
         * A data structure that works on the FIFO(First-In-First-Out) principle.
         * Elements are added at the end and removed from the front.
         * 
         * As we have read, LinkedList can act as ** Stack ** similarly LinkedList can also act as ** Queue ** as well.
         */

        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(50); // enqueue
        list.addLast(20); // enqueue
        list.addLast(30); // enqueue

        System.out.println(list);
        // Integer removedElement = list.removeFirst(); // dequeue
        // System.out.println("removedElement: " + removedElement);
        System.out.println(list);

        System.out.println(list.getFirst()); // peek

        /**
         * Queue is an interface and used as Type for which we can use LinkedList() as implementation class.
         * Queue interface simplifies the implementation if we use Type as LinkedList then we'll have alot of methods which might not be relavent for queue implementation.
         */
        Queue<Integer> queue = new LinkedList<>();
        // queue.add(10);
        queue.offer(10);
        // queue.add(20);
        // queue.add(30);

        System.out.println(queue);

        // System.out.println(queue.remove()); // throws java.util.NoSuchElementException if empty
        // System.out.println(queue.poll());
        // System.out.println(queue.poll());

        // System.out.println(queue.element()); // throws java.util.NoSuchElementException if empty
        System.out.println(queue.peek());
        System.out.println(queue);


        
        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2); 
        queue2.offer(20);
        queue2.add(10);
        
        // throws exception java.lang.IllegalStateException: Queue full if values added more than the capacity using add()
        queue2.offer(110);
        System.out.println(queue2);
        
    }    
}
