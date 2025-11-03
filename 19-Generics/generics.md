[CLICK HERE FOR MEDIUM LINK](https://engineeringdigest.medium.com/generics-b158a743d18f)

# ✨ Java Generics: Comprehensive Study Notes

## I. Motivation and Historical Context 🕰️

*   Generics were introduced in **Java 5**.
*   The previous approach, using non-generic collections like `ArrayList`, stored everything as the base `Object` type.
*   This approach led to major issues:
    *   **Lack of Type Safety:** The collection could hold any type (String, Integer, Double) without restriction.
        *   *Example:* Adding a String, an Integer, and a Double to the same `ArrayList` caused no compile-time issue.
    *   **Manual Casting:** When retrieving items, the programmer had to manually cast the returned `Object` back to the intended specific type.
        *   *Example:* `String s = (String) list.get(0);`.
    *   **Runtime Exceptions:** Type errors were not checked at compile time, leading to dreaded **`ClassCastException`** at runtime if an incorrect cast was attempted.
        *   *Example:* If an Integer was stored, but cast manually to a String, the error occurred only when running the code.
*   **The Solution:** Generics enforce **type safety** at **compile time** and eliminate the need for **manual casting**.

## II. Fundamentals of Generics 🛡️

*   Generics allow defining classes, interfaces, or methods using **Placeholders** or **Type Parameters**.
*   These placeholders specify the data types that the component will work with.
*   Generics do not work with primitive types — `int[]` is not a subtype of `T[]`. Solution is to use wrapper types example - `Integer instead of int`.

### A. Generic Classes (Syntax)

*   The syntax uses **angular brackets** (`<>`) next to the class name.
*   The convention for a single type parameter is `T` (for Type).
*   *Example (Generic Box Class):*
    ```java
    class Box<T> {
        private T value; // Using the type parameter T
        // ... getters/setters using T
    }
    ```
*   When creating an object, the type is specified:
    ```java
    // The Box is now type-safe for Integers
    Box<Integer> myBox = new Box<>(); 
    // Note: The type on the right can often be omitted (Diamond Operator).
    ```
*   If a generic class is used without specifying the type (a "raw type"), the compiler gives a warning.

### B. Multiple Type Parameters 🔑

*   Classes can use more than one type parameter.
*   Common conventions include `K` (Key) and `V` (Value).
*   *Example (Pair Class):*
    ```java
    class Pair<K, V> {
        private K key;
        private V value;
        // ...
    }
    // Object creation:
    Pair<String, Integer> personAge = new Pair<>(); 
    // This allows storing a String key and an Integer value.
    ```
*   **Naming Conventions Reminder:** `T` (Type), `K/V` (Key/Value), and `E` (Element, often for collections) are typical styles, though any single letter (or even full word) can be used.

### C. Generic Interfaces 🗃️

*   Interfaces can also be defined with type parameters (e.g., `interface Container<T>`).
*   When a class implements a generic interface, it has two options:
    1.  **Specify the concrete type:** `class StringContainer implements Container<String>`.
    2.  **Make the implementing class generic:** `class MyContainer<T> implements Container<T>`.

### D. Generic Constructors 🏗️

*   A class does **not** need to be generic to contain a generic constructor.
*   The type parameter declaration (`<T>`) is placed immediately **before the constructor name**, restricting the generic scope to the constructor itself.
*   *Example (Non-Generic Class, Generic Constructor):*
    ```java
    class BoxTwo { // Class is NOT generic
        public <T> BoxTwo(T value) { // Constructor IS generic
            // T is defined only here
        }
    }
    ```

### E. Generic Methods ⚙️

*   Generic methods allow the method itself to be parameterized, regardless of whether the surrounding class is generic.
*   The type parameter declaration is placed **before the return type**.
*   *Example (Static Method to Print Any Array):*
    ```java
    public static <T> void printArray(T[] array) { 
        // Logic to print array elements
    }
    // Calling the method:
    Integer[] intArray = {1, 2, 3};
    printArray(intArray); // Works with Integer array
    String[] strArray = {"Hello", "World"};
    printArray(strArray); // Works with String array
    ```

### F. Generics and Enumerations (Enums)

## I. Enums: Inherently Type Safe 🔒

*   Enums (Enumerations) are **inherently type safe** in Java.
*   An enum variable can only hold constants defined within that enum.
    *   *Example:* If you define a `Day` enum (`SNDAY`, `MONDAY`), you can set a `Day` variable to `Day.MONDAY`.
    *   Attempting to set a `Day` variable to an unrelated type (like the String `"MONDAY"` or an Integer value) results in a **compile-time error**, confirming type safety.
*   Because enums already achieve type safety, the need to define the enum class itself as a generic type (e.g., `enum Day<T>`) is usually negated.

## II. Using Generic Methods Within Enums ⚙️

*   Although the enum definition itself might not be generic, you **can** define **generic methods** inside the enum body.
*   This is useful for operations that need to work across various types, such as mathematical operations.

### Example: The `Operation` Enum

*   Consider an enum called `Operation` defined with constants like `ADD`, `SUBTRACT`, `MULTIPLY`, and `DIVIDE`.
*   We can define a generic method `apply` within this enum to handle the calculation:
    ```java
    // Example definition showing the structure:
    public <T extends Number> Double apply(T op1, T op2) {
        // ... logic specific to ADD, SUBTRACT, etc.
    } 
    ```
*   **Bounding the Type:** The method uses bounded type parameters (`<T extends Number>`) to restrict the inputs (`T`) only to types that extend the `Number` class (like Integer, Float, Long).
*   **Mechanism:** Because `T` is bounded by `Number`, we can safely call methods like `doubleValue()` on the arguments (`op1`, `op2`) regardless of whether they were originally Integers or Floats, ensuring the operation can proceed and return a consistent `Double` result.
*   **Usage:** You apply the generic method to the specific enum constant instance:
    ```java
    Operation.ADD.apply(10, 20); // Works with Integers
    Operation.MULTIPLY.apply(5.0, 4.0); // Works with Doubles
    ```
*   This approach avoids the need to write separate, specific methods for every numerical wrapper class, leveraging generics for efficient, type-safe code reuse.

## III. Advanced Generics: Bounding and Wildcards 📏

### A. Bounded Type Parameters (Constraints)

*   Bounds are used to **restrict** the types that can be substituted for the type parameter `T`.
*   The keyword **`extends`** is used to apply a bound, regardless of whether the bound is a class or an interface.
*   *Example (Upper Bound on Number):* `<T extends Number>`
    *   This ensures that `T` must be `Number` or any subclass of `Number` (like Integer, Double, Float).
    *   Attempting to use `String` would result in a compile-time error.

*   **Multiple Bounds:** Constraints are separated by the ampersand (`&`).
    *   The **class bound must always be listed first**, followed by any interface bounds.
    *   *Example:* `<T extends Number & Printable>` (where `Number` is a class and `Printable` is an interface).

### B. Wildcards (`?`) ❓

*   Wildcards represent an **Unknown Type**.
*   They are primarily used when the method performs **read-only** operations and does not modify the collection.
*   **Critical Limitation:** If a simple wildcard (`<?>`) is used, you cannot **add** or **modify** elements in the collection (except for `null`), as the compiler does not know the specific type.

#### 1. Upper Bounded Wildcard (`? extends Type`)
*   Sets an **upper boundary** (a ceiling). The type can be `Type` or any subclass/subtype thereof.
*   Used when **reading** data from a generic structure.
    *   *Example (Summing numbers):* `public static double sum(ArrayList<? extends Number> numbers)`. This guarantees that we can safely retrieve values as `Number` (or convert them, like calling `doubleValue()`).

#### 2. Lower Bounded Wildcard (`? super Type`)
*   Sets a **lower boundary** (a floor). The type can be `Type` or any superclass/super-type thereof.
*   Used when **adding** data to a generic structure.
    *   *Example (Allowing additions):* `ArrayList<? super Integer> list`. This works because any element added (e.g., an Integer) is guaranteed to satisfy the lower bound, ensuring type safety when modifying the list.

## IV. Internal Mechanisms: Type Erasure 🗑️

*   Generics operate primarily at the **compile time** stage.
*   **Type Erasure** is the process where the compiler removes the generic type information after type checking is complete.
*   **Result in Bytecode:**
    *   If the type parameter was **unbounded** (`<T>`), it is replaced by **`Object`**.
    *   If the type parameter was **bounded** (`<T extends BoundedClass>`), it is replaced by the specific **bound class** (e.g., `Number`).
*   The compiler inserts necessary casts automatically into the bytecode to ensure safe retrieval during runtime. The JVM executes this "erased" code.

## V. Generics and Exceptions 💥

* __Java does not support generic exceptions due to type erasure. Type erasure means that generic type information is removed at runtime. Since exceptions are closely tied to runtime operations (like catching them in try-catch blocks), having generic exceptions wouldn't work as expected. For example, if you had an exception like MyGenericException<T>, you wouldn't be able to catch it with a specific type parameter because that type information would be erased at runtime.__

*   Java **does not support** creating generic exception classes due to type erasure (e.g., `class MyException<T> extends Exception`).

*   **Type erasure** means that generic type information is removed at runtime.

*   **Reason:** Exceptions are closely tied to **runtime operations**. Due to Type Erasure, the generic information is removed by the time the code runs. The JVM requires the **exact exception type** at runtime to create the object, which is not possible if the generic information has been erased.

*   **Workaround:** While the exception class cannot be generic, the **constructor can be generic**.
    *   *Example:* Define a non-generic `MyException` class that extends `Exception` but give it a generic constructor (`public <T> MyException(T data)`).
    *   This allows passing type-specific data (e.g., a String or an Integer) into the exception object when it is thrown, without violating the rule against generic exception classes.

**Example-**

```java
// Usage of MyException class in the main method
try {
    throw new MyException(123);
} catch(MyException e) {
    System.out.println("Caught exception: " + e.getMessage());
}

try {
    throw new MyException("Hello");
} catch(MyException e) {
    System.out.println("Caught exception: " + e.getMessage());
}

// code example of custom exception class
class MyException extends Exception {
    public <T> MyException(T value) {
        super("Exception related to value: " + value. toString() + " of type: " + palue.getClass ().getName ())
    }
}
```