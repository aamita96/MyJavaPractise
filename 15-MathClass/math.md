## 📝 Java Math Class Essentials

This summary provides detailed notes on the methods and constants found within Java's powerful `Math` class, which is part of the automatically imported `java.lang` package.

### 💡 Core Setup and Basics

*   **Automatic Import:** The `java.lang` package, which contains the `Math` class, is automatically imported into every Java program.
*   **Purpose:** The `Math` class provides many predefined, basic methods for common mathematical operations (e.g., max, min, square root, absolute value, power).

### ⚖️ Comparison and Absolute Values

*   **Maximum Value:** To find the maximum of two numbers, use `Math.max(a, b)`.
    *   *Implementation Detail:* This method uses a ternary operator internally (equivalent to an if-else statement) to determine which value to return.
*   **Minimum Value:** Similarly, use `Math.min(a, b)` to find the smallest number.
*   **Absolute Value:** Use `Math.abs(c)` to obtain the positive (absolute) value of a number.
    *   *Implementation Detail:* If the number is negative, the method multiplies it by $-1$; otherwise, it returns the number as is.

### 📊 Floating Point Operations (Ceiling, Floor, and Rounding)

These methods operate primarily on `double` values:

*   **Ceiling (`Math.ceil(d)`):** Returns the **smallest integer greater than** or equal to the input. ⬆️
    *   Example: For $1.12$, the ceiling is $2.0$.
*   **Floor (`Math.floor(d)`):** Returns the **largest integer less than** or equal to the input. ⬇️
    *   Example: For $1.12$, the floor is $1$.
*   **Rounding (`Math.round()`):** Returns the **closest integer** or `long` value. 🎯
    *   $1.12$ rounds to $1$.
    *   $1.52$ rounds to $2$ (since it is closer to $2$).

### 🔢 Powers and Roots

*   **Square Root:** Use `Math.sqrt(e)` to calculate the square root of a number.
    *   Example: $\sqrt{144}$ returns $12$. It supports inputting doubles like $1.52$.
*   **Power Function:** Use `Math.pow(base, exponent)` to calculate $base^{exponent}$.
    *   Example: $\text{Math.pow}(12, 2)$ returns $144$.
    *   The method supports non-integer exponents, such as $\text{Math.pow}(12, 2.1)$.

### 📚 Logarithms and Trigonometry

*   **Natural Logarithm:** Use `Math.log()` (log base $e$).
*   **Base 10 Logarithm:** Use `Math.log10()`.
    *   Note: $\log_{10}(10)$ equals $1$.
*   **Trigonometry:** All standard trigonometric functions are available, including `Math.sin()`, `Math.cos()`, and `Math.tan()`. 📐
*   **Angle Conversion (Rarely Used):** Methods exist to convert angles: `Math.toDegrees()` and `Math.toRadians()`.

### ✨ Mathematical Constants

The `Math` class provides essential constant values:

*   **Pi:** `Math.PI`. 🥧
*   **E (Base of Natural Logarithm):** `Math.E` (approximately $2.7$).

### 🎲 Random Number Generation

*   **Basic Random Generation:** `Math.random()` generates a `double` value.
    *   The range is $0.0$ (inclusive) up to, but **excluding**, $1.0$.
*   **Generating Random Integers (e.g., 0 to 10):**
    *   If you multiply `Math.random()` by $10$ and cast it to an `int`, the maximum resulting integer will be $9$.
    *   To ensure the maximum value (e.g., $10$) is included, you must multiply by one greater than the desired maximum ($11$ in this case).
    *   Formula for $0$ to $N$: `(int) (Math.random() * (N + 1))`.
    *   This ensures the minimum is $0$ and the maximum is $N$.

### ⚙️ Specialized Methods (Advanced/Rare)

*   **`Math.nextAfter(start, direction)`:** Returns the floating-point number adjacent to the `start` number, moving in the direction of the second argument.
    *   If `start` is $1$ and `direction` is $2$, the result is $1.000...1$ (moving forward).
    *   If `start` is $1$ and `direction` is $0$, the result is $0.999...9$ (moving backward).
*   **`Math.nextBefore()`:** A related method, though these are typically used only in rare circumstances.