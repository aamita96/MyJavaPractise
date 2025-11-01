class ThreadMethods extends Thread {
    public ThreadMethods(String name) {
        super(name);
    }
    @Override
    public void run() {
        /* for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running.");
            Thread.yield();
        } */

       while(true) {
            System.out.println("Hello World!");
       }
    }
    
    public static void main(String[] args) throws InterruptedException {
        ThreadMethods t1 = new ThreadMethods("t1");
        ThreadMethods t2 = new ThreadMethods("t2");

        t1.setDaemon(true);
        t1.start();
        System.out.println("Main done");
    }
}