public class CreditCardv0 implements Payment {

    @Override
    public void pay(double totalAmount) {
        System.out.println("Paid " + totalAmount + " using Credit Card.");
    }
}