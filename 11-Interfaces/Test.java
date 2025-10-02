import animals.Dog;
import animals.Animal;

import devices.SmartPhone;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.run();

        // System.out.println(Dog.MAX_AGE);
        // System.out.println(Animal.MAX_AGE);

        Animal.info();

        SmartPhone phone = new SmartPhone();
        phone.playMusic();
        phone.stopMusic();

        phone.recordVideo();
        phone.takePhoto();

        phone.makeCall(989204333);
        phone.endCall();
    }
}