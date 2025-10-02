public class Test {
    public static void main(String[] args) {
        // while loop
        
        /*
            Syntax -

            initialisation
            while(condition) {
                code
                increment
            }
        */

        /* int i = 1; // initialisation
        while(i <= 10) {
            System.out.println(i);
            i++;
        } */

        // do-while loop

       /* 
            Syntax - 
            
            initilisation
            do {
                code
                increment
            } while(condition);
       */ 
        // int j = 1;

        // do {
        //     System.out.println(j);
        //     j++;
        // } while(j < 1);

        // for loop

        /**
            Syntax -

            for(initilisation; condition; increment) {
                code
            }
         */

        for(int i = 1, k = 1; k <= 6; i = i * 10, k++) {
            System.out.println(i);
        }
        
        // count digits of a number

        int n = 46734633;
        int count = 0;

        while(n > 0) {
            n = n / 10;
            count++;
        }

        System.out.println(count);


        /*
            *
            **
            ***
            ****
            *****
            ******
        */

       for(int i=0; i <= 6; i++) {
        for (int j = 0; j <= i; j++ ) {
            System.out.print("*");
        }
        System.out.println();
       }
    }
} 