public enum Day {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    // We can define custom constructors inside the Enum.
    // Constructors must be declared private or default access. This prevents creating instances outside the predefined list.
    private Day(String capitalcase) {
        // System.out.println("constructor called!");
        this.capitalcase = capitalcase;
    }

    // We can define custom fields inside the Enum
    private String capitalcase;

    public String getCapitalCase() {
        return capitalcase;
    }

    // We can define a method inside the Enum
    public void display() {
        System.out.println("Today is " + this.name());
    }
}   

/**
 *  At compile time, the Enum structure is converted into a final class.
 *  Below is an example of how the enum will be converted which is actually just a sample.
 * 
    public final class Day extends java.lang.Enum<Day> {
    public static final Day SUNDAY = new Day("SUNDAY", 0);
    public static final Day MONDAY = new Day("MONDAY", 1);
    public static final Day TUESDAY = new Day("TUESDAY", 2);
    public static final Day WEDNESDAY = new Day("WEDNESDAY", 3);
    public static final Day THURSDAY = new Day("THURSDAY", 4);
    public static final Day FRIDAY = new Day("FRIDAY", 5);
    public static final Day SATURDAY = new Day("SATURDAY", 6);

    private static final Day[] VALUES = {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    };

    private Day(String name, int ordinal) {
        super(name, ordinal);
    }

    public static Day[] values() {
        return VALUES.clone();
    }

    public static Day valueOf(String name) {
        for (Day day : VALUES) {
            if (day.name().equals(name)) {
                return day;
            }
        }
        throw new IllegalArgumentException("No enum constant " + name);
    }
}
 */