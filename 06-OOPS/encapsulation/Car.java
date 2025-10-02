package encapsulation;

public class Car {
    // properties/fields/instance variables & behaviour/methods
    private String color;
    private String brand;
    private String model;
    private int year;
    private int speed;

    public Car(String color, String brand, String model, int year, int speed) {
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = speed;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void accelerate(int increment) {
        speed += increment;
    }

    public void brake(int decrement) {
        speed -= decrement;

        if (speed < 0) {
            speed = 0;
        }
    }

    public void showCarInfo() {
        System.out.printf("Year %d %S %S %S at speed of %d", this.year, this.color, this.brand, this.model, this.speed);
    }
}