import java.util.ArrayList;
import java.util.*;

class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1; // to return in decending order.
    }
}

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listWithCapacity = new ArrayList<>(20);
        
        /**
         * Or you can write in this way
         * List<Integer> list = new ArrayList<>();
         * 
         * Default constructor, creates an empty ArrayList with an initial capacity of 10
         * ArrayList<String> list = new ArrayList<>();
            
         *  // Creating an ArrayList with a specified initial capacity
            ArrayList<String> listWithCapacity = new ArrayList<>(20);

         * // Creating an ArrayList from another collection
            List<String> anotherList = Arrays.asList("Apple", "Banana", "Orange");
            ArrayList<String> listFromCollection = new ArrayList<>(anotherList);
         * 
         * In mordern Java V9 we're allowed to create List using List.of as well
         * There's a difference in creating list with Arrays.asList() and List.of(). 
         * With asList() you can't add or remove values but set the existing values whereas with List.of() you can't even set the values.
         * List<Integer> list3 = List.of(1, 2, 3, 4);
         */
        
        list.add(2); // 0 index
        list.add(1); // 1 index
        list.add(3); // 2 index

        System.out.println(list.get(0)); // gets the 0 index value
        System.out.println(list.size()); // gets the size/length of the array list

        System.out.println("List value starts -");
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) +" ");
        }

        System.out.println();
        System.out.println("List value with For Each starts -");
        for(int i : list) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println(list.contains(3));
        System.out.println(list.contains(4));

        list.remove(1);

        System.out.println(list.size());

        /**
         * add method with index and element shifts the element 
         * list.add(index, element);
         */

        list.add(1, 50);
        System.out.println(list.size());
        System.out.println(list.get(2));

        // Collections.sort(list);

        // we can create a comparator class and use it to sort the list or to make it simple we could use lamda expression.
        // list.sort(new MyComparator());
        list.sort((o1, o2) -> o2 - o1);
        System.out.println(list);

        List<String> words = Arrays.asList("banana", "apple", "dates");
        
        // The logic that we used is for custom sorting using length to sort values in decending order(Meaning highest to lowest in length).
        words.sort((o1, o2) -> o2.length() - o1.length());
        System.out.println(words);

        // System.out.println("List with Capacity: " + listWithCapacity.size());
    }
}