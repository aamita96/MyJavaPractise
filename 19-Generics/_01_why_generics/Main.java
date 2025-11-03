import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /**
         * ArrayList list = new ArrayList();
         * list.add("Hello");
         * list.add("123");
         * list.add("3.14");

         * String str = (String) list.get(0);
         * String str1 = (String) list.get(1);
         * 
         * Above code has 3 major issues
         * 1) No Type safety
         * 2) Manual casting
         * 3) No Compile Time checking
         * 
         * These issues can be solved by Generics
         */

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        String s = list.get(0);
        String s1 = list.get(1);

        System.out.println(s);
        System.out.println(s1);
    }
}