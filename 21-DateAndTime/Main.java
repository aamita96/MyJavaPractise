import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // How to work with DATES & TIMES using Java
        // (LocalDate, LocalTime, LocalDateTime, UTC timestamp)

        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        Instant instant = Instant.now(); // UTC Timestamp

        System.out.println(instant);

        // Custom Format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println(dateTime.format(formatter));

        LocalDate customDate = LocalDate.of(2025, 12, 25);
        System.out.println(customDate);

        // Compare dates
        LocalDateTime date1 = LocalDateTime.of(2026,12, 25,12, 0, 0);
        LocalDateTime date2 = LocalDateTime.of(2026,12, 25,12, 0, 0);
//        LocalDateTime date2 = LocalDateTime.of(2026,1, 1,0, 0, 0);

        if(date1.isBefore(date2)) {
            System.out.println(date1 +" is earlier than " + date2);
        }
        else if(date1.isAfter(date2)) {
            System.out.println(date1 + " is later than " + date2);
        }
        else if (date1.equals(date2)) {
            System.out.println(date1 + " is equal to " + date2);
        }
    }
}
