public class Main {
    public static void main(String[] args) {
        GenericContainer<Integer> container = new GenericContainer<>();
        container.add(222);
        System.out.println(container.get());
    }
}