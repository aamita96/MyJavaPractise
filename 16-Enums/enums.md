# 🎥 Understanding Java Enums

### ❓ What is an Enum?

*   **Definition:** Enum stands for **Enumeration**.
*   **Meaning:** Enumeration means "listing things" 📜.
*   **Purpose:** Enums represent a fixed set of constants, preventing duplication and spelling errors in code.
    *   **Examples of Fixed Lists:** Months in a year, departments in a college (e.g., CS, IT, Civil), or days of the week.

### 🚫 The Problem Enums Solve (Handling Constant Duplication)

*   **Issue:** When the same string (e.g., "Monday") is used repeatedly in an application (the video notes this happens 11 times in the example), the IDE gives a warning.
*   **Risk:** Duplicating literals increases the chance of spelling mistakes (e.g., using "Small a" or mixing up letters), leading to errors.

#### 📉 Old Approach: Using Classes or Interfaces for Constants

To centralize constants before Enums, developers used `static final` fields.

*   **Example (Class Definition):** Defining constants in a class.
    ```java
    public class DayClass {
        public static final String MONDAY = "Monday";
        public static final String SUNDAY = "Sunday";
        // ... all other days
    }
    ```
*   **Example (Usage):** Constants were accessed via the class name.
    *   `DayClass.MONDAY`
    *   `DayClass.SUNDAY`
    *   `DayClass.SATURDAY`
*   **Interface Benefit:** Using an interface makes `public static final` redundant (they are implied), offering a slightly smaller syntax.

### ✨ Enum Creation (The Better Solution)

Enums provide a simpler, cleaner syntax for constant listing.

*   **Creation:** An Enum is created using the `enum` keyword (e.g., `public enum Day`).
*   **Constant Definition:** Constants are listed as comma-separated values.
    *   **Example (Day Enum):**
        ```java
        public enum Day {
            SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY 
        }
        ```
*   **Usage:**
    *   Accessing a constant: `Day.MONDAY`.
    *   Relationship Check: Every constant listed (e.g., `MONDAY`) has a relationship with the Enum type ("Monday is a Day").

### 🧠 Internal Working (Compilation)

*   **Conversion:** At **compile time**, the Enum structure is converted into a **`final class`**.
*   **Inheritance:** This generated class **extends** the predefined Java class `java.lang.Enum`.
    *   *Rationale:* This extension allows the Enum constants to access built-in methods like `ordinal()`.
*   **Immutability:** The class is made `final` to prevent it from being extended, thus preserving the fixed set of constants (e.g., seven days).
*   **Constants as Instances:** Each constant is internally treated as a `public static final` instance of the Enum class.
    *   **Conceptual Example:** The constant `SUNDAY` is compiled into code similar to: `public static final Day SUNDAY = new Day(...)`.

### 💻 Built-in Enum Methods

All constants inherit powerful methods from the base `Enum` class.

| Method | Description | Example Code | Expected Output | Source |
| :--- | :--- | :--- | :--- | :--- |
| **`ordinal()`** | Returns the **index** (position) of the constant, starting from 0. | `MONDAY.ordinal()` | 1 (if SUNDAY is 0) | |
| **`name()`** | Returns the constant name as a `String`. | `MONDAY.name()` | "MONDAY" | |
| **`toString()`** | By default, returns the same value as `name()`. | `MONDAY.toString()` | "MONDAY" | |
| **`values()`** | Returns an **array** of all the constants defined in the Enum. | `Day[] values = Day.values();` | Array of all 7 days | |
| **`valueOf(String)`** | Converts a matching input `String` into the corresponding Enum instance. | `Day enumDay = Day.valueOf("MONDAY");` | Returns `Day.MONDAY` instance |
| **`valueOf(String)` (Error)** | If the string does not match, an exception is thrown. | `Day.valueOf("SNA")` | Throws an exception 💥 | |

*   **Looping Example using `values()`:** Iterates and prints every constant.

    ```java
    for (Day i : Day.values()) { 
        System.out.println(i); // Prints SUNDAY, MONDAY, TUESDAY, etc.
    }
    ```

### ⚙️ Customizing Enums (Fields, Methods, and Constructors)

Enums can have custom logic, fields, and constructors, provided the list of constants is terminated by a semicolon (`;`).

#### 1. Custom Methods

*   **Example (Method Definition):** Defining a method inside the Enum.
    ```java
    public void display() {
        System.out.println("Today is " + this.name());
    }
    ```
*   **Example (Usage):** Calling the method on an instance.
    *   `MONDAY.display()`

#### 2. Custom Fields and Constructors 🏗️

*   **Field Definition:** Custom fields must be **private**.
    *   **Example:** `private String lowerCaseName;`.
*   **Constructor Rule:** Custom constructors must be declared **`private` or default access**. This prevents creating instances outside the predefined list.
*   **Parameterized Constants Example:** Constants are defined by passing parameters, requiring a matching constructor.
    *   **Constants:** `SUNDAY("Sunday"), MONDAY("Monday")`.
    *   **Constructor:** `private Day(String lower)`.
    *   **Instantiation Count:** When any constant is accessed, the custom constructor is called for **all** constants (e.g., seven times for all seven days) to instantiate them.
*   **Accessing Fields (Getters):** Since fields are private, a Getter is required.
    *   **Example Usage:** `MONDAY.getLower()` prints **"Monday"**.
*   **Multiple Fields Example:** Enums can store multiple custom values.
    *   **Example (Fields):** `private String lowerCaseName;` and `private String hindi;`.
    *   **Example (Constants with two params):** `MONDAY("Monday", "सोमवार")`.
    *   **Example Usage:** `MONDAY.getHindi()` prints **"सोमवार"**.

### 🔀 Enums in Switch Statements

Enums are ideal for use in control flow switch statements.

#### 1. Traditional Switch Syntax (Pre-Java 12)

Uses colons (`:`) and requires a `break` statement.

*   **Example:**
    ```java
    switch (day) {
        case MONDAY:
            System.out.println("Today is MONDAY");
            break; // Required
        case TUESDAY:
            // ...
        default:
            System.out.println("Weekend arrived"); 
    }
    ```

#### 2. Modern Switch Syntax (Java 12+) 🚀

Uses the arrow (`->`) notation, where `break` statements are unnecessary.

*   **Example:** `case MONDAY -> System.out.println("M");`.

#### 3. Switch as an Expression (Returning a Value)

The modern switch can be used as an expression (assigned to a variable).

*   **Key Requirement:** When used as an expression, **all possible cases must be covered** (usually by including a `default` case) to ensure a return value is guaranteed.
*   **Example:**
    ```java
    String result = switch (day) { // Semicolon required at the end
        case MONDAY -> "M";
        case TUESDAY -> "T"; 
        // ... all cases 
        default -> "Weekend"; // Must be handled for expression
    };
    ```
*   **Output Examples:** If `day = Day.MONDAY`, `result` is "M". If `day = Day.WEDNESDAY`, `result` is **"Weekend"** (via default).

### 🏠 Nested Enums

Enums can be defined inside a class.

*   **Static Nature:** Enums are **inherently static** (attached to the class, not the instance), so the `static` keyword is redundant.
*   **Example (Definition):**
    ```java
    public class Main {
        public enum Months {
            JANUARY, FEBRUARY
        }
    }
    ```
*   **Example (Usage from outside `Main`):** Accessing the nested Enum.
    *   `Main.Months.JANUARY`.