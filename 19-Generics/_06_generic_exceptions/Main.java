public class Main {
    public static void main(String[] args) {
        try {
            throw new MyException(123);
        } catch(MyException e) {
            System.out.println(e);
        }

        try {
            throw new MyException("Hello");
        } catch(MyException e) {
            System.out.println(e);
        }
    }
}

class MyException extends Exception {
    public <T> MyException(T value) {
        super("Exception related to value: " + value. toString() + " of type: " + value.getClass ().getName ());
    } 
}