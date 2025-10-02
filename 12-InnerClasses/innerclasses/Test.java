// import innerclasses.Car;

public class Test {
    public static void main(String[] args) {
        /*
        // Example to check inner class
        Car car = new Car("Creta");
        Car.Engine engine = car.new Engine();
        engine.start();
        engine.stop(); 
        */

        /* 
        Computer computer = new Computer("HP", "Ultrabook", "Windows");
        computer.getOS().displayInfo();

        // Static class instances
        Computer.USB usb = new Computer.USB("type-c");
        usb.displayInfo(); 
        */

       ShoppingCart cart = new ShoppingCart(150);
    //    CreditCardv0 cc = new CreditCardv0();
    
    //  Example of annonymous class - here Payment is an interface but we create a temporary class using {} and implemted the pay method to make the payment.
       cart.processPayemnt(new Payment() {
            @Override
            public void pay(double amount) {
                System.out.println("Paid " + amount + " using UPI.");
            }
       });

    }
}