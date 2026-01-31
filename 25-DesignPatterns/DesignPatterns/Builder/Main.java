package DesignPatterns.Builder;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder("large").addBacon().addCheese().build();

        System.out.println(pizza);
    }
}
