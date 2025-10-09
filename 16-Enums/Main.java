public class Main {
    public static void main(String[] args) {
        Day day = Day.MONDAY; // All the constants that you have written in enum is a constant of type Day.

        System.out.println(day);
        day.display();
        System.out.println(day.getCapitalCase());

        // int ordinal = monday.ordinal(); // ordinal fetches index of that particular day.
        // System.out.println(ordinal);
        // System.out.println("Day name from name() : " + monday.name()); // name() method can be used to perform some string operations.

        // System.out.println(Day.TUESDAY);
        // System.out.println(Day.SUNDAY);
        
        // Day weekday = Day.valueOf("WEDNESDAY"); // Converts a matching input String into the corresponding Enum instance.
        // System.out.println(weekday);
        // weekday.display();
        

        // Enums with Switch statements
        // Traditional syntax of switch
        switch(day) {
            case MONDAY: 
                System.out.println("MONDAY from Switch Statement");
                break; // Required
            case TUESDAY:
                System.out.println("TUESDAY from Switch Statement");
                break; // Required
            default: 
                System.out.println("Weekend arrived!");
        }

        // New syntax of switch
        String res = switch(day) {
            case MONDAY -> "M";
            case TUESDAY -> "T";
            default -> "Weekend";
        };
        
        System.out.println(res);
    }
}