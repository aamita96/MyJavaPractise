enum Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    // To indicate the method is generic we include `<T>` before type.
    public <T extends Number> double apply(T a, T b) {
        return switch(this) {
            case ADD -> a.doubleValue() + b.doubleValue();
            case SUBTRACT -> a.doubleValue() - b.doubleValue();
            case MULTIPLY -> a.doubleValue() * b.doubleValue();
            case DIVIDE -> a.doubleValue() / b.doubleValue();
            default -> throw new AssertionError("Unknown operation: " + this);
        };

        // switch(this) {
        //      case ADD : 
        //         return a.doubleValue() + b.doubleValue();
        //     case SUBTRACT: 
        //         return a.doubleValue() - b.doubleValue();
        //     case MULTIPLY: 
        //         return a.doubleValue() * b.doubleValue();
        //     case DIVIDE: 
        //         return a.doubleValue() / b.doubleValue();
        //     default: throw new AssertionError("Unknown operation: " + this);
        // }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Operation.MULTIPLY.apply(10, 20));
    }
}