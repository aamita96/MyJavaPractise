# 🧭 Detailed Summary of the Vector Class

A Vector in Java is a part of the java.util package and is one of the legacy
classes in Java that implements the List interface.

It was introduced in JDK 1.0 before collection framework and is
synchronized, making it thread-safe.

Now it is a part of collection framework.

However, due to its synchronization overhead, it's generally recommended to use other modern alternatives like ArrayList in single-threaded scenarios.

Despite this, Vector is still useful in certain situations, particularly in multi-
threaded environments where thread safety is a concern.

______________________________________________________________________

## Key Features of Vector

**Dynamic Array:** Like ArrayList, Vector is a dynamic array that grows automatically
when more elements are added than its current capacity.

**Synchronized 🔒:** All the methods in Vector are synchronized, which makes it thread-safe.
This means multiple threads can work on a Vector without the risk of corrupting the
data. However, this can introduce performance overhead in single-threaded
environments.

**Legacy Class:** Vector was part of Java's original release and is considered a legacy
class. It's generally recommended to use ArrayList in single-threaded environments
due to performance considerations.

**Resizing Mechanism:** When the current capacity of the vector is exceeded, it doubles
its size by default (or increases by a specific capacity increment if provided).

**Random Access:** Similar to arrays and ArrayList, Vector allows random access to elements, making it efficient for accessing elements using an index.

**Capacity and Resizing:**
    
* The default initial capacity of a `Vector` is **10** elements.
    
* When the internal array is full, the `Vector` automatically **resizes**. By default, the capacity **doubles** 📈 (increases by 100%) when a resize is necessary.
    
* You can specify a custom **capacity increment factor** during initialization. For example, if the capacity is 5 and the increment is set to 3, the new capacity becomes 8 when resizing is triggered.

**Null Values:**
* Unlike `HashMap`, which allows one null key, `Vector` is strict and **does not allow** 🚫 **null keys or null values** to be stored.

**Unique Capacity Method:**
* `Vector` offers a public method, `capacity()`, to check the size of its underlying internal array, a feature that requires "tricks" or Reflection to achieve with `ArrayList`.


## Constructors of Vector

**Vector():** Creates a vector with an initial capacity of 10.

**Vector(int initialCapacity):** Creates a vector with a specified initial capacity.

**Vector(int initialCapacity, int capacityIncrement):** Creates a vector with an initial
capacity and capacity increment (how much the vector should grow when its capacity
is exceeded).

**Vector(Collection <? extends E> c):** Creates a vector containing the elements of the
specified collection.

## 📊 Vector Methods and Time Complexity

The following table details the time complexity of common `Vector` operations. Note that these complexities reflect the *algorithmic* time complexity (based on array structure). The actual execution time will be higher than a non-synchronized structure due to the inherent **synchronization overhead** in every method call.

| Method | Description | Time Complexity (Algorithmic) |
| :--- | :--- | :--- |
| `add(E element)` | Appends an element to the end of the Vector. In the worst case (when resizing is required), internal elements must be copied. | $\text{Big O}(n)$ (Worst Case) |
| `add(int index, E element)` | Inserts an element at a specific index. Requires shifting all subsequent elements to the right. | $\text{Big O}(n)$ (Worst Case) |
| `get(int index)` | Retrieves an element using its index. Due to the internal array structure, access is direct. | $\text{Big O}(1)$ (Constant Time) |
| `set(int index, E element)` | Replaces the element already present at the specified index. | $\text{Big O}(1)$ (Constant Time) |
| `remove(int index)` | Removes the element at the specified index. Requires shifting subsequent elements to the left to fill the gap. | $\text{Big O}(n)$ (Worst Case) |
| `remove(Object o)` | Removes the first occurence of the specified element. Requires shifting subsequent elements to the left to fill the gap. | $\text{Big O}(n)$ (Worst Case) |
| `contains(Object o)` | Checks if the Vector holds a specific element. Requires iterating through elements. | $\text{Big O}(n)$ (Linear Time) |
| `size()` | Returns the total count of elements currently in the Vector. | $\text{Big O}(1)$ (Constant Time) |
| `capacity()` | Returns the size of the internal array allocated for storage 💡. | $\text{Big O}(1)$ (Constant Time) |
| `clear()` | Removes all elements from the Vector. | $\text{Big O}(n)$ (Linear Time) |

## Internal Implementation of Vector

Internally, Vector uses an array to store its elements.
The size of this array grows as needed when more
elements are added. The default behavior is to double
the size of the array when it runs out of space. This
resizing operation is a costly one, as it requires copying
the old elements to the new, larger array.

### Synchronization and Performance

- Since Vector methods are synchronized, it ensures that only one
thread can access the vector at a time. This makes it thread-safe
but can introduce performance overhead in single-threaded
environments because synchronization adds locking and unlocking
costs.

- In modern Java applications, ArrayList is generally preferred over
Vector when synchronization isn't required. For thread-safe
collections, the CopyOnWriteArrayList or ConcurrentHashMap
from the java.util.concurrent package is often recommended
instead.