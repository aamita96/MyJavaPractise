public class Methods {
    public static void main(String[] args) {
        /*
            accessModifier returnType methodName(parameters) { 
                method body
            }
        */    
       int[] arr = {2,3,45, -99, 0, 87,88, 0};
       sumArray(arr);

       multiplication(3.4, 4.3);
    }

    public static void sumArray(int ...arr) {
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        System.out.println(sum);
    }

    /*
        With method overloading, multiple methods can have the same name with different parameters:
    */
    // Example of method overloading
    public static void multiplication(int a, int b) {
        System.out.println(a * b);
    }

    public static void multiplication(double a , double b) {
        System.out.println(a * b);
    }
}