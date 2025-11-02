class SharedResource {
    private volatile boolean flag = false;

    public void setFlagTrue() {
        System.out.println("Writer thread made the thread true now!");
        flag = true;
    }

    public void printIfFlagTrue() {
        while(!flag) {
            // do nothing
        }
        System.out.println("Flag is true!");
    }
}

public class VolatileExample {
   public static void main(String[] args) {
        SharedResource resource = new SharedResource();
    
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            resource.setFlagTrue();
        });
        
        Thread readerThread = new Thread(()-> resource.printIfFlagTrue());

        writerThread.start();
        readerThread.start();
   }
}