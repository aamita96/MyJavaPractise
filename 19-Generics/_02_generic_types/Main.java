public class Main {
    public static void main(String[] args) {
        Box<Integer> boxInt = new Box<>();
        Box<String> boxStr = new Box<>();
        boxStr.setValue("I am using Generics!");
        boxInt.setValue(12345);
        // String i = box.getValue();
        System.out.println(boxInt.getValue());
        System.out.println(boxStr.getValue());


        /**
         * Common naming convention to give types
         * T : Type
         * E : Element (used in collections)
         * K : Key (used in maps)
         * V : Value (used in maps)
         * N : Number
         */

        Pair<String, Integer> pair = new Pair<>("Age", 30);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }
}