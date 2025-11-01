public class LambdaExpression {
    public static void main(String[] args) {
        // Runnable runnable = new Runnable() {
        //     @Override
        //     public void run() {
        //         System.out.println("Hello");
        //     }
        // };

        // The above statement can be simplified using lambda expression
        // Runnable runnable = () -> System.out.println("Hello");
        // Thread t1 = new Thread(runnable); // even we can avoid this runnable object assignment and pass it directly in Thread.


        Thread task1 = new Thread(() -> System.out.println("Hello"));
    
        task1.start();
    }
}