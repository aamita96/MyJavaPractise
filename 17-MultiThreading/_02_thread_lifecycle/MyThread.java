class MyThread extends Thread {
    // By accepting parameter into constructor we can set the name of the thread.
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            System.out.println(Thread.currentThread().getName() + " - PRIORITY -" + Thread.currentThread().getPriority());
            Thread.sleep(5000);
        }
        catch(InterruptedException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) throws InterruptedException{
        MyThread t1 = new MyThread("MyThread"); // NEW
        t1.setPriority(Thread.MIN_PRIORITY);
        System.out.println(t1.getState()); // NEW
        t1.start(); // RUNNABLE/RUNNING
        System.out.println(t1.getState()); // RUNNABLE/RUNNING

        Thread.sleep(1000);
        System.out.println(t1.getName() + " PRIORITY: " + t1.getPriority() + ", STATE: " + t1.getState()); // TIMED_WAITING
        // t1.interrupt(); // Sends an interrupt signal to the thread.
        t1.join();
        System.out.println(t1.getState()); // TERMINATED
    }
}