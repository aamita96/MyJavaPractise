public class Test {
    StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        String str1 = "Hello";
        str1.concat("World"); // Strings are by default immutable so if we concat and expect the output of
        // str1 = "Hello World" then the result will be "Hello" only.
        // System.out.println(str1);
        // By default strings are thread-safe becuase they are immutable.

        String result = "";
        for (int i = 0; i < 100; i++) {
            result = result + " Hello";
        }

        // System.out.println(result); // This will result in 100's of Hello but
        // internally its creating 100 temporary strings which can lead to poor
        // performance.

        // StringBuilder is good but its not thread-safe.
        // StringBuilder sb = new StringBuilder("Hello");
        // sb.append("\tWorld").append("!");
        // sb.insert(5, " Java");
        // sb.replace(0, 4, "Java");
        // sb.delete(1, 4);
        // sb.reverse();
        // sb.charAt(0);
        // sb.length();
        // sb.substring(4, 9);
        // String string = sb.toString(); // generates immutable string from string
        // builder
        // System.out.println(string);

        // StringBuffer is thread-safe
        StringBuffer sb = new StringBuffer();
        Task t1 = new Task(sb);
        Task t2 = new Task(sb);
        Task t3 = new Task(sb);
        Task t4 = new Task(sb);
        Task t5 = new Task(sb);
        Task t6 = new Task(sb);
        Task t7 = new Task(sb);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Final length: " + sb.length());
    }
}

class Task extends Thread {
    private StringBuffer sb;

    public Task(StringBuffer sb) {
        this.sb = sb;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            sb.append("a");
        }
    }
}