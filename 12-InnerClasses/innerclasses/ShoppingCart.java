public class ShoppingCart {
    private double totalAmount;

    public ShoppingCart(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void processPayemnt(Payment paymentMethod) {
        paymentMethod.pay(totalAmount);
    }
}