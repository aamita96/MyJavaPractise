public class Test {
    public static void main(String[] args) {
        // TestWithThread testWithThread = new TestWithThread(); // NEW STATE
        // testWithThread.start(); 

        TestwithRunnable t1 = new TestwithRunnable(); // NEW STATE
        Thread thread = new Thread(t1);
        /*
         * Note - Java often treats "Ready to run" and "Executing" as the single RUNNABLE state, 
         * hence RUNNING is not explicitly defined in Java's Thread.State enum.
         */
        thread.start(); // RUNNABLE

        System.out.println("Hello--");
        System.out.println(Thread.currentThread().getName()); // To get the name of the current thread.
    }
}