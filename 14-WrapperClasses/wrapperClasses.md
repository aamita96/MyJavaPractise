# 📝 Mastering Java Wrapper Classes

We focuses on **Wrapper Classes** in Java, explaining their necessity and how they facilitate the conversion between primitive data types and objects.

### 1. Why Wrapper Classes Are Needed 🧐

*   **Java is not Pure OOP** 🚫: Java is object-oriented, but not *purely* so, because it contains **eight primitive data types** (like `int`, `float`, `boolean`).
*   **Primitives Lack Methods** ⚙️: Primitives are not objects, meaning they do not have associated methods or properties (e.g., you cannot call `a.method()` on `int a = 1`). Objects, like `String`, provide many methods (e.g., `str.toLowerCase()`).
*   **Collection Limitations** 📦: Many advanced Java frameworks and collection classes (like `List` and `ArrayList`) **do not support primitive types**. They require objects to work.
    *   **Example**: Writing `List<int>` results in an error; you must use the wrapper class `List<Integer>` instead.

### 2. Wrapper Classes: The Solution 🎁

*   **Definition**: Wrapper classes **"wrap"** or convert a primitive data type into an object.
*   **Purpose**: To allow primitives to be used in object-only contexts and to utilize object-oriented features (like methods).
*   **Mapping Table** 📊: Each primitive type has a corresponding wrapper class (e.g., `int` maps to `Integer`, `boolean` maps to `Boolean`, `float` maps to `Float`, etc.).

### 🔁 Java Primitive Types and Their Wrapper Classes

| Primitive Type | Wrapper Class (Object)    | Description                        |
|----------------|---------------------------|------------------------------------|
| `byte`         | `Byte`                    | 8-bit signed integer               |
| `short`        | `Short`                   | 16-bit signed integer              |
| `int`          | `Integer`                 | 32-bit signed integer              |
| `long`         | `Long`                    | 64-bit signed integer              |
| `float`        | `Float`                   | 32-bit floating-point              |
| `double`       | `Double`                  | 64-bit floating-point              |
| `char`         | `Character`               | 16-bit Unicode character           |
| `boolean`      | `Boolean`                 | true or false                      |


### 3. Memory and Object Differences 🧠

*   **Primitive Variables** (`int a = 1`):
    *   `a` is a primitive variable.
    *   The value (1) is stored on the **Stack**.
    *   Cannot hold a `null` value; defaults to 0.
*   **Wrapper Objects** (`Integer b = 1`):
    *   `b` is a reference variable (an object of the `Integer` class).
    *   The value (1) is stored on the **Heap**.
    *   Can hold a **`null`** value.
    *   **Example**: Calling `b.hashCode()`, `b.toString()`, or `b.longValue()` is possible because `b` is an object.

### 4. Automatic Conversion: Autoboxing & Autounboxing 🔁

Java handles the conversion between primitives and wrappers automatically, which is known as **automatic boxing/unboxing**.

*   **Autoboxing (Primitive to Object)** 📦: The automatic process of converting a primitive value into its corresponding wrapper object.
    *   **Simplified Example**: Instead of writing the manual way (`Integer b = Integer.valueOf(1)`), Java allows the simplified syntax: `Integer b = 1;`.
*   **Autounboxing (Object to Primitive)** 🔓: The automatic process of converting a wrapper object back into its corresponding primitive value.
    *   **Simplified Example**: Instead of writing the manual way (`int c = b.intValue()`), Java allows the simplified syntax: `int c = b;`.

### 5. Utility Methods in Wrapper Classes ➕

Wrapper classes provide numerous static utility methods that simplify common tasks.

*   **Finding Maximum/Minimum**: Use static methods to find extremes.
    *   **Example**: `Integer.max(1, 2)` or finding system limits using `Integer.MAX_VALUE`.
*   **Base Conversions**: Converting numbers to different string bases.
    *   **Example**: Finding the binary representation of 10: `Integer.toBinaryString(10)`.
*   **String Conversion**: Converting a `String` that looks like a number into a number object.
    *   **Example**: `String str = "123"; Integer.valueOf(str)` converts the string "123" into an `Integer` object.

### 6. Comparing Wrapper Objects ⚖️

*   When checking the equality of primitive types, you use `==` (`int x == int y`).
*   When checking the equality of **wrapper objects**, it is safer and standard practice to use the **`.equals()`** method to compare the values they hold, since `==` compares the memory addresses (references).
    *   **Example**: To check if two wrapper objects `b` and `c` hold the same value: `b.equals(c)`.

### 7. Reference Handling Note (Deep Dive) 💡

Here, we discusses how wrapper classes behave when passed to functions, touching upon Java's use of **pass-by-value** for references.

*   When an object reference (like `Integer b`) is passed to a function, the reference's *address* is copied.
*   If the method modifies the *object* using the copied reference (e.g., changing `x.id = 2`), the original object is affected.
*   However, if the method reassigns the *copied reference variable* itself (e.g., `a = 2`), the original caller's reference variable still points to the old value.