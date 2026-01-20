## 🍪 The Stack Class: Last In, First Out (LIFO)

The `Stack` class is a **legacy class** 🏛️ (dating back before the Java Collections Framework, JDK 1.2) that implements a fundamental data structure adhering to the **LIFO (Last In, First Out) principle**.

### Key Features and Principles

1.  **LIFO Principle:**
    *   The core principle of a stack is LIFO: the **last item added** to the stack is the **first one removed**.
    *   This is conceptually similar to a **stack of books** 📚 or a **stack of cookies** 🍪. When removing items, you always take the element that is at the very top (the newest element).
    *   Using the analogy of putting numbers into a bucket (1, 2, 3 added), the removal process reverses the order (3, 2, 1 removed).

2.  **Inheritance and Thread Safety:**
    *   The `Stack` class **extends the `Vector` class**.
    *   Because it extends `Vector`, the `Stack` is automatically **synchronized** 🔒 and **thread-safe** 🛡️. This means that when multiple threads access the stack simultaneously, they are handled sequentially, which helps prevent data corruption (though this synchronization adds performance overhead compared to non-synchronized structures like `ArrayList`).

3.  **Structural Anomaly (Vector Inheritance):**
    *   Because `Stack` is a subclass of `Vector`, it **inherits all methods** from `Vector`.
    *   This inheritance means that even though a stack is conceptually LIFO-only, a developer could use `Vector`'s methods (like `add` or `remove(index)`) to **insert or remove elements from the middle**.
    *   However, using these inherited non-LIFO methods violates the fundamental nature of the stack data structure.

4.  **Use Case:**
    *   The `Stack` should be used specifically when a **LIFO behavior** is required and when thread safety is a necessary concern.

***

## ⚙️ Stack Methods and Time Complexity

The dedicated stack methods provide specific LIFO functionality focused on manipulating the "top" of the stack. Since these are highly localized operations (operating on the end of the underlying array, inherited from `Vector`), they are generally very fast ($\text{Big O}(1)$).

| Method | Description | Time Complexity (Algorithmic) |
| :--- | :--- | :--- |
| `push(E item)` | Adds (pushes) an element onto the top of the stack. | $\text{Big O}(1)$ (Average) / $\text{Big O}(n)$ (Worst Case) |
| `pop()` | Removes and **returns** the element at the top of the stack. | $\text{Big O}(1)$ (Constant Time) |
| `peek()` | Retrieves (peeks at) the element at the top of the stack **without removing it**. | $\text{Big O}(1)$ (Constant Time) |
| `search(Object o)` | Searches for an element and returns its position relative to the top of the stack. | $\text{Big O}(n)$ (Linear Time) |
| `isEmpty()` | Checks whether the stack contains any elements. | $\text{Big O}(1)$ (Constant Time) |
| `size()` | Returns the number of elements currently in the stack. | $\text{Big O}(1)$ (Constant Time) |

*Notes on Complexity:*

1.  The core LIFO operations (`push`, `pop`, `peek`) are typically constant time ($\text{Big O}(1)$) because they directly access the end of the internal array used by `Vector`.
2.  The $\text{Big O}(n)$ worst-case complexity for `push` occurs only if the underlying array capacity is exceeded and the entire internal array needs to be copied during the automatic resizing process, similar to `ArrayList` or `Vector` resizing.
3.  The `search` method requires traversing 🚶‍♂️ through the elements from the top down to find the item, hence its linear time complexity ($\text{Big O}(n)$). Notably, `search` uses **1-based indexing** from the top, not the 0-based indexing common in array-like structures.