# 🌟 Object-Oriented Programming (OOP) in Java

Object-Oriented Programming (OOP) in Java is built upon **4 core pillars**:

1) Encapsulation
2) Inheritance
3) Polymorphism
4) Abstraction

---
<br/>

## 🔐 1. Encapsulation

**Encapsulation** is the process of bundling data (variables) and methods that operate on the data into a single unit — a class.

### 🎯 Purpose:
- Hide sensitive data from outside access.
- Enforce controlled access via methods.

### ✅ To achieve encapsulation:
- Declare class variables as `private`.
- Provide **public** `get` and `set` methods to access and update private variables.

```java
public class Person {
    private String name;

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String newName) {
        this.name = newName;
    }
}
```

## 🧬 2. Inheritance

**Inheritance** allows one class to acquire the properties and methods of another class.

### 🔑 Terminology:

- Superclass (Parent): The class being inherited from.

- Subclass (Child): The class that inherits from the parent.

🛠 Syntax:

Use the extends keyword.
```java
class Animal {
    void makeSound() {
        System.out.println("Some sound...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Woof!");
    }
}
```

### 🧩 The super() Keyword:

Used to refer to the parent class. Commonly used to:

1) Call the parent class constructor (default or parameterized).

2) Avoid naming conflicts between subclass and superclass.

3) Access superclass methods or fields.

```java
class Animal {
    Animal(String name) {
        System.out.println("Animal: " + name);
    }
}

class Dog extends Animal {
    Dog() {
        super("Dog"); // Calls Animal's constructor
    }
}
```

<br/><br/>

# 🧬 Types of Inheritance in Java

Inheritance is one of the core pillars of Object-Oriented Programming (OOP). It allows a class (child/subclass) to inherit properties and behaviors (fields and methods) from another class (parent/superclass).

---

## 📚 Types of Inheritance in Java

Java supports several types of inheritance:

1. 🔗 **Single Inheritance**
2. 🔗 **Multilevel Inheritance**
3. 🔗 **Hierarchical Inheritance**
4. 🚫 **Multiple Inheritance (Using Interfaces)**
5. 🔗 **Hybrid Inheritance (Via Interfaces)**

> ⚠️ **Note**: Java **does not support multiple inheritance with classes** directly to avoid ambiguity (diamond problem). However, it supports it using **interfaces**.

---

## 1️⃣ Single Inheritance

One subclass inherits from one superclass.

### ✅ Example:

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // Inherited from Animal
        d.bark();  // Defined in Dog
    }
}
```

## 2️⃣ Multilevel Inheritance

A class inherits from a class which in turn inherits from another class.

### ✅ Example:
```java
class Animal { // grandparent class
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal { // parent class
    void bark() {
        System.out.println("Barking...");
    }
}

class Puppy extends Dog { // class
    void weep() {
        System.out.println("Weeping...");
    }
}

public class Main {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.eat();   // From Animal
        p.bark();  // From Dog
        p.weep();  // From Puppy
    }
}
```
## 3️⃣ Hierarchical Inheritance

Multiple classes inherit from a single superclass.

### ✅ Example:

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Meowing...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();

        Cat c = new Cat();
        c.eat();
        c.meow();
    }
}
```
## 4️⃣ Multiple Inheritance (Using Interfaces)

Java does not support multiple inheritance with classes, but it allows it using interfaces.

### ✅ Example:

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck is flying...");
    }

    public void swim() {
        System.out.println("Duck is swimming...");
    }
}

public class Main {
    public static void main(String[] args) {
        Duck d = new Duck();
        d.fly();
        d.swim();
    }
}
```
> ✅ Interfaces resolve the diamond problem by enforcing implementation in the subclass, thus avoiding ambiguity.


## 5️⃣ Hybrid Inheritance (Combination via Interfaces)

Java does not support hybrid inheritance directly with classes, but it can be achieved using a combination of classes and interfaces.

### ✅ Example:
```java
interface A {
    void methodA();
}

interface B {
    void methodB();
}

class C {
    void methodC() {
        System.out.println("Method from class C");
    }
}

class D extends C implements A, B {
    public void methodA() {
        System.out.println("Implemented methodA");
    }

    public void methodB() {
        System.out.println("Implemented methodB");
    }
}

public class Main {
    public static void main(String[] args) {
        D obj = new D();
        obj.methodA();
        obj.methodB();
        obj.methodC();
    }
}
```

<br/>

## 🌀 3. Polymorphism

**Polymorphism** means "many forms" — allowing the same method or object to behave differently based on context.

### 📚 Types:

- Compile-time polymorphism (Method Overloading)

- Runtime polymorphism (Method Overriding)

<br/>

## Difference Between Compile-Time and Runtime Polymorphism in Java

### ⚙️ Compile-Time Polymorphism (Method Overloading)

Occurs when multiple methods have the same name but different parameter lists. The method to invoke is determined **at compile time**.

#### ✅ Example: Method Overloading

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));           // Output: 5
        System.out.println(calc.add(2.5, 3.5));       // Output: 6.0
        System.out.println(calc.add(1, 2, 3));        // Output: 6
    }
}
```
<br/>

>📌 The add method is overloaded with different parameter types and counts — the compiler resolves which method to call.

### ⏱️ Runtime Polymorphism (Method Overriding)

Occurs when a subclass provides a specific implementation of a method already defined in its parent class. The method to invoke is determined at runtime, based on the object type.

```java
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myAnimal.makeSound(); // Output: Some generic animal sound
        myDog.makeSound();    // Output: Bark
        myCat.makeSound();    // Output: Meow
    }
}
```

> 📌 The makeSound() method is overridden in Dog and Cat classes, and the decision on which version to call is made at runtime.

## 🧼 4. Abstraction

**Abstraction** is the process of hiding implementation details and exposing only the essential features.

**Abstraction** can be achieved with either abstract classes or interfaces.

The abstract keyword is a non-access modifier, used for classes and methods:

- **Abstract class:** is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).

- **Abstract method:** can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).

### 🧰 Achieved via:

- Abstract classes

- Interfaces

### 🔍 Abstract Class:

- Cannot be instantiated directly.

- Can contain both abstract (no body) and concrete methods.

```java
abstract class Animal {
    abstract void makeSound(); // Abstract method
    void sleep() {
        System.out.println("Sleeping...");
    }
}
```

### 🔗 Abstract Method:

- Has no body.

- Must be implemented by subclasses.

```java
class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark!");
    }
}
```
<br/><br/>

## Java Access Modifiers

| Modifier     | Class | Package | Subclass | World | Usage Context                                                                 |
|--------------|:-----:|:-------:|:--------:|:-----:|--------------------------------------------------------------------------------|
| `public`     |  ✅   |   ✅    |   ✅     |  ✅   | Used when the member/class should be accessible from everywhere.              |
| `protected`  |  ❌   |   ✅    |   ✅     |  ❌   | Used for class members that should be accessible in the same package and by subclasses. |
| (default)*   |  ❌   |   ✅    |   ❌     |  ❌   | No modifier: accessible only within the same package.                         |
| `private`    |  ❌   |   ❌    |   ❌     |  ❌   | Accessible only within the same class.                                        |

\* Default means no access modifier is specified.

### Notes:
- Top-level **classes** can only be `public` or **default** (package-private).
- `private` and `protected` cannot be used for top-level classes.
- `private` is typically used for encapsulation, hiding internal fields and methods.
- `protected` gives a middle ground, especially in inheritance hierarchies.

