import java.util.EnumMap;
import java.util.Map;

public class Demo07EnumMap {
    public static void main(String[] args) {
        /**
         * EnumMap is a specialized implementation of the Map interface for enumeration types. 
         * The EnumMap class is a member of the Java Collections Framework and is not synchronized.
         * EnumMap is an ordered collection and they are maintained in the natural order of their keys (the natural order of keys means the order in which enum constants are declared inside the enum type).
         * It’s a high-performance map implementation, much faster than HashMap.
         * EnumMap doesn't allow a null key and throws NullPointerException when we attempt to insert the null key.
         * EnumMap is internally represented as arrays. This representation is extremely compact and efficient.
         * 
         * If all the keys in a Map are values from a single enum, it is recommended to use an EnumMap as the specific implementation. 
         * An EnumMap, which has the advantage of knowing all possible keys in advance, is more efficient compared to other implementations, 
         * as it can use a simple array as its underlying data structure.
         * 
         * Noncompliant code example - 
         * 
         * enum Color {
         *  RED, BLUE, ORANGE;
         * }
         * 
         * Map<Color, String> colorMap = new HashMap<>(); // Noncompliant
         * 
         * Compliant solution example -
         * 
         * Map<Color, String> colorMap = new EnumMap<>(Color.class);
         */

        Map<Day, String> map = new EnumMap<>(Day.class);
        map.put(Day.WEDNESDAY, "Learning Java");
        System.out.println(map);
        System.out.println(Day.WEDNESDAY.ordinal());

    }
}

enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
};