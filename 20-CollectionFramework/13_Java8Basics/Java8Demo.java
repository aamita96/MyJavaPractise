import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Java8Demo {
    public static void main(String[] args) {
        // Java 8 --> lambda expression, Streams, Date & Time API
        
        // Lambda Expression
        // Lambda Expression is an anonymous function ( no name, no return type, no access modifier)

        Thread t1 = new Thread(() -> {
            System.out.println("Hello");
        });
        t1.start();

        
        MathOperation sum = (a, b) -> a + b; // This is actually a function which we're treating as a variable i.e., actually a functional programing.
        MathOperation substract = (a, b) -> b - a;
        System.out.println(sum.operate(2, 2));
        System.out.println(substract.operate(2, 10));
        
        // Predicate 
        // Functional Interface (boolean valued function)
        // You're storing a condition test in a variable and that's what functional programming is about.
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 5 even ? " + isEven.test(5));

        Predicate<String> isWordStartingWithA = str -> str.toLowerCase().startsWith("a");
        Predicate<String> endsWithIng = str -> str.toLowerCase().endsWith("ing");
        // we can combine two predicates like below
        Predicate<String> hasIngForm = isWordStartingWithA.and(endsWithIng);
        System.out.println("Starts with A and ends with ing? " + hasIngForm.test("acting"));

        // Function: Takes input and produces output
        Function<Integer, Integer> doubleIt = (x) -> 2 * x;
        Function<Integer, Integer> tripleIt = (x) -> 5 * x;
        System.out.println(doubleIt.andThen(tripleIt).apply(5));
        System.out.println(doubleIt.compose(tripleIt).apply(5)); // In compose, argument passed to compose will execute first then then function it is attached with.
        System.out.println(Function.identity().apply(4));

        // Consumer : As name suggest consumer only consumes. They don't have return type
        Consumer<Integer> print = (x) -> System.out.println(x);
        print.accept(44);
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Consumer<List<Integer>> printList = x -> {
            for (int i : x) 
                System.out.println(i);
        };
        printList.accept(list);

        // Supplier: It doesn't take input but returns/supplies something.
        Supplier<String> giveHelloWorld = () -> "Hello World";
        System.out.println(giveHelloWorld.get());

        // A simple example to show using combined together
        Predicate<Integer> predicate = (x) -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer =  x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if (predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }

        // BiPredicate, BiConsumer, BiFunction

        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        System.out.println("BiPredicate -> " + isSumEven.test(2, 5));

        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x + " - " + y);
        };
        biConsumer.accept(15, "test biConsumer");
        BiFunction<String, String, Integer> biFunction = (x,y) -> (x + y).length();
        System.out.println(biFunction.apply("a", "bc"));

        // UnaryOperator, BinaryOperator in case you have all same argument types.
        UnaryOperator<Integer> doubleItWithUnary = (x) -> 2 * x;
        System.out.println("With Unary: " + doubleItWithUnary.apply(300));
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
        System.out.println("Binary Operator: " + binaryOperator.apply(20, 1));

        // Method Reference --> use method without invoking & in place of lambda expression
        List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");
        students.forEach(x -> System.out.println(x));
        students.forEach(System.out::println); // :: here stands for method reference.

        // Constructor Reference
        List<String> names = Arrays.asList("A", "B", "C");
        List<MobilePhone> mobilePhoneList = names.stream().map(MobilePhone::new).collect(Collectors.toList());
        System.out.println(mobilePhoneList);
    }
}

class MobilePhone {
    String name;

    MobilePhone(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass() + " - " + this.name;
    }
}

interface MathOperation {
    int operate(int a, int b);
}