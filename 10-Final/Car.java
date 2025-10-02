public class Car extends Vehicle {
    private final int speedLimit;

    public Car() {
        speedLimit = 200;
    }
    
    public int getSpeedLimit() {
        return speedLimit;
    }

    @Override
    public void accelerate() {

    }

    @Override
    public void decelerate() {

    }
}