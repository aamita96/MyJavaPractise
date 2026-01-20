import java.util.LinkedList;
import java.util.Arrays;

public class LinkedlistExample {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(7);
        linkedList.addFirst(0); // O(1), as we just have to adjust the pointers of the new and first node.
        linkedList.addLast(11); // O(1), as we just have to adjust the pointers of the new and last node.
        System.out.println(linkedList.get(2)); // O(n) -> to print any value we have to loop over it then we'll be able to print.
        System.out.println("First -> " + linkedList.getFirst());
        System.out.println("Last -> " +linkedList.getLast());
        System.out.println(linkedList);
        linkedList.removeIf(x -> x % 2 == 0);
        System.out.println(linkedList);


        // On the fly this is how you can create linked list.
        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Bat", "Rat", "Dog", "Elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Bat", "Rat", "Lion"));
        animals.removeAll(animalsToRemove); // This will remove all the matching animals from the targetted linked list.
        System.out.println(animals);
    }
}