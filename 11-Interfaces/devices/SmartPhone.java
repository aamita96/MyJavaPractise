package devices;

public class SmartPhone implements Camera, MusicPlayer, Phone {

    @Override
    public void playMusic() {
        System.out.println("Music started playing..");
    }

    @Override
    public void stopMusic() {
        System.out.println("Music stopped..");
    }

    @Override
    public void makeCall(int phoneNumber) {
        System.out.println("Calling " + phoneNumber + "...");
    }
    
    @Override
    public void endCall() {
        System.out.println("Call ended");
    }

    @Override
    public void takePhoto() {
        System.out.println("Photo captured.");
    }

    @Override
    public void recordVideo() {
        System.out.println("Recording video");
    }
}