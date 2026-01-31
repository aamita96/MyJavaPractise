import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer>  list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(10);
        list.add(30);
        list.add(50);
        // for (int i : list ) {
        //     System.out.println(i);
        // }

        // Normal for loop thows java.util.ConcurrentModificationException for removing values while reading but iterator allows it.
        // for (int i : list) {
        //     if (i % 2 == 0) {
        //         list.remove(Integer.valueOf(i));
        //     }
        // }

        System.out.println(list);

        /**
         * 8️⃣ Simple rule to remember 🧩
            Think like this:
                
                🟢 iterator()
                - “I just want to read or remove elements”
                - “Forward only”

                🔵 listIterator()
                - “I want full control”
                - “Forward + backward”
                - “Add, replace, index”
         */
        
        // Internally it converts this above loop like below -
        // Iterator<Integer> iterator = list.iterator();
        // while (iterator.hasNext()) {
        //     int number = iterator.next();
        //     if (number % 2 == 0) {
        //         iterator.remove();
        //     }
        // }
        // System.out.println(list);

        // List Iterator is more powerful as it has more functions to loop.
        // It allows to set the values while iterating.
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next() == 30) {
                listIterator.set(33);
            }
        }
        
        System.out.println(list);
    }    
}
