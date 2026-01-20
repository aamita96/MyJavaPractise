import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Milk");
        list.add("Eggs");
        list.add("Bread");
        System.out.println("Initial Shopping list: " + list);

        for(String item : list) {
            System.out.println(item);

            if (item.equals("Eggs")) {
                list.add("Butter");
                System.out.println("Added Butter while reading.");
            }
        }

        System.out.println(list);

    }
}