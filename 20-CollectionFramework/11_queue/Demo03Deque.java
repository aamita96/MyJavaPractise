import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Demo03Deque {
    public static void main(String[] args) {
        /**
         * Deque = double-ended queue
         * Allows insertion and deletion of elements from both ends.
         * Versatile than regular queue and stacks because they support all the operations of both.
         * 
         * INSERTION METHODS
         * 
         *      addFirst(E e): Inserts the specified element at the front.
         *      addLast(E e): Inserts the specified element at the end.
         *      
         *      offerFirst(E e): Inserts the specified element at the front if possible.
         *      offerLast(E e): Inserts the specified element at the end if possible.
         * 
         * EXAMINATION METHODS
         * 
         *      getFirst(): Retrieves, but does not remove, the first element.
         *      getLast(): Retrieves, but does not remove, the last element.
         *      
         *      peekFirst(): Retrieves, but does not remove, the first element, or returns null if empty.
         *      peekLast(): Retrieves, but does not remove, the last element, or returns null if empty.
         * 
         * STACK METHODS
         * 
         *      push(E e): Adds an element at the front (equivalent to addFirst(E e)).
         *      pop(): Removes and returns the first element (equivalent to removeFirst())..
         *
         */

        Deque<Integer> deque1 = new ArrayDeque<>(); // (internally ArrayDeque uses array i.e., ArrayDeque) faster iteration, low memory, no null allowed
        deque1.addFirst(10);
        deque1.offerFirst(5);
        deque1.addLast(20);
        deque1.offerLast(25);

        System.out.println("First Element: " + deque1.getFirst()); // Outputs 5
        System.out.println("Last Element: " + deque1.getLast());   // Outputs 25
        // deque1.remove(20);
        deque1.removeFirst(); // removes 5
        deque1.pollLast(); // removes 25
        
        // deque1.add(3000);
        // deque1.addFirst(40);
        // deque1.add(25);
        // deque1.addFirst(33);


        System.out.println(deque1);

        Deque<Integer> deque2 = new LinkedList<>(); // insertion, deletion somewhere in middle
    }    
}
