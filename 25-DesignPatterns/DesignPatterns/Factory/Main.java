package DesignPatterns.Factory;

public class Main {
    public static void main(String[] args) {
        /**
         * Encapsulate object creation logic into a factory class or method, so client code doesn’t need to know exact class details.
         * Analogy: 
         * - Car factory → You tell it “I want a SUV” or “I want a Sedan,” and the factory builds the right car. 
         * - You don’t need to know how the car is assembled.
         */
        Shape s1 = ShapeFactory.getShape("circle");
        s1.draw();

        Shape s2 = ShapeFactory.getShape("triangle");
        s2.draw();
    }
}

// Product interface
interface Shape {
    void draw();
}

// Concrete Products
class Circle implements Shape {
    public void draw() { System.out.println("Drawing Circle"); }
}

class Rectangle implements Shape {
    public void draw() { System.out.println("Drawing Rectangle"); }
}

// Factory
class ShapeFactory {
    public static Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        else if (type.equalsIgnoreCase("rectangle")) return new Rectangle();
        throw new IllegalArgumentException("Unknown shape");
    }
}