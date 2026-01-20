## The List Interface 📋

The `List` interface represents an **ordered sequence** of elements and **allows duplicate elements**. Elements can be accessed by their index (index-based access).

The `List` interface in Java is a part of the java.util package and
is a sub-interface of the Collection interface. It provides a
way to store an **ordered collection of elements** (known as a
sequence). Lists allow for precise control over where
elements are inserted and **can contain duplicate elements**.

The List interface is implemented by several classes in the
Java Collection Framework, such as ArrayList, LinkedList,
Vector, and Stack.

Key Features of the List Interface-
1) Order Preservation
2) Index-Based Access
3) Allows Duplicates

## Array List

### **Internal working of Array List-** 
- Unlike a regular array, which has a fixed size, an ArrayList can grow and shrink as elements are added or removed. This dynamic resizing is achieved by creating a new array when the current array is full and copying the elements to the new array.

- When you create an ArrayList, it has an initial capacity (default is 10). The capacity refers to the size of the internal array that can hold elements before needing to resize.

**Adding Elements**

When we add an element to an ArrayList, the following steps occur

- **Check Capacity:** Before adding the new element, ArrayList checks if
there is enough space in the internal array (elementData). If the array is
full, it needs to be resized.

- **Resize if Necessary:** If the internal array is full, the ArrayList will create
a new array with a larger capacity (usually 1.5 times the current
capacity) and copy the elements from the old array to the new array.

- **Add the Element:** The new element is then added to the internal array at
the appropriate index, and the size is incremented.

**Resizing the Array**

- **Initial Capacity:** By default, the initial capacity is 10. This means the
internal array can hold 10 elements before it needs to grow.

- **Growth Factor:** When the internal array is full, a new array is created
with a size 1.5 times the old array. This growth factor balances
memory efficiency and resizing cost.

- **Copying Elements:** When resizing occurs, all elements from the old
array are copied to the new array, which is an O(n) operation, where
n is the number of elements in the ArrayList.

**Removing Elements**

- **Check Bounds:** The ArrayList first checks if the index is within the
valid range.

- **Remove the Element:** The element is removed, and all elements to
the right of the removed element are shifted one position to the left
to fill the gap.

- **Reduce Size:** The size is decremented by 1.