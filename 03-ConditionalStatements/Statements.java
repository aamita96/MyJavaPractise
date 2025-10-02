public class Statements {
    public static void main(String[] args) {
        //relational operators
            // Relational Operators compare two values and return a boolean result
        int a = 2;
        int b = 4;
        boolean c = a > b;
        System.out.println(c);
        
        // logical operators
            // && logical AND
            // || logical OR
            // ! logical NOT
        
        // conditional statements

        int age = 20;

        if (age >= 18) {
            System.out.println("You are an adult!");
        } else {
            System.out.println("You are a child!");
        }

        // if-else ladder
        int day = 6;

        /* if (day == 1) {
            System.out.println("Monday");
        } else if (day == 2) {
            System.out.println("Tuesday");
        } else if (day == 3) {
            System.out.println("Wednesday");
        } else if (day == 4) {
            System.out.println("Thursday");
        } else if (day == 5) {
            System.out.println("Friday");
        } else if (day == 6) {
            System.out.println("Saturday");
        } else if (day == 7) {
            System.out.println("Sunday");
        } */

       /*
            Switch can be used with following types -
            byte, short, char, int, String, Enum types 
            These types contains exact values so these are allowed with switch case.

            In case of double or floating values we have to use if-else statements.
        */
       switch(day) {
            case 1: 
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tudesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid!");
       }
    } 
}