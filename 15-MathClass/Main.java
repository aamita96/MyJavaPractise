public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 11;
        
        int max = Math.max(a, b);
        System.out.println(max);
        
        int min = Math.min(a, b);
        System.out.println(min);
        
        int c = -222;
        System.out.println(Math.abs(c));
        
        double d = 1.34;
        double ceil = Math.ceil(d);
        System.out.println(ceil); // output - 2

        double floor = Math.floor(d);
        System.out.println(floor); // output - 1

        int e = 144;
        System.out.println(Math.sqrt(e));

        System.out.println(Math.pow(12,2));
    }
}