## Linked List

The `LinkedList` class in Java is a part of the Collection framework and
implements the List interface. Unlike an ArrayList, which uses a
dynamic array to store the elements, **a LinkedList stores its elements
as nodes in a doubly linked list**. This provides different performance
characteristics and usage scenarios compared to ArrayList.

Here are the details about the `LinkedList` discussed in the sources:

### How LinkedList Works (Conceptual Structure)

A LinkedList is a linear data structure where each element is a separate
object called a `node`. Each node contains two parts:

Data: The value stored in the node.

Pointers: Two pointers, one pointing to the next node (next) and the other
pointing to the previous node (previous).

___

### Performance Considerations

LinkedList has different performance characteristics compared to ArrayList:

**Insertions and Deletions:** LinkedList is better for frequent insertions and deletions
in the middle of the list because it does not require shifting elements, as in
ArrayList.

**Random Access:** LinkedList has slower random access (get(int index)) compared
to ArrayList because it has to traverse the list from the beginning to reach the
desired index.

**Memory Overhead:** LinkedList requires more memory than ArrayList because
each node in a linked list requires extra memory to store references to the next
and previous nodes.