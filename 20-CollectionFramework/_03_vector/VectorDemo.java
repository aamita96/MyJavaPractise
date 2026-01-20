import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(5, 3);
        vector.add(1);
        vector.add(1);
        vector.add(1);
        vector.add(1);
        vector.add(1);
        System.out.println(vector.capacity()); // past capacity is 5
        vector.add(1);
        System.out.println(vector.capacity()); // new capacity'll be 8
    }
}