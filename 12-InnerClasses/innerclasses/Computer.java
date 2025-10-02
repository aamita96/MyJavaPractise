public class Computer {
    private String brand;
    private String model;
    private OperatingSystem os;

    public Computer(String brand, String model, String osName) {
        this.brand = brand;
        this.model = model;
        this.os = new OperatingSystem(osName);
    }

    public OperatingSystem getOS() {
        return this.os;
    }

    class OperatingSystem {
        private String osName;

        public OperatingSystem(String osName) {
            this.osName = osName;
        }

        public void displayInfo() {
            System.out.println("Brand: " + brand +", Computer Model: " + model + ", OS: " + osName);
        }
    }

    // USB is a static nested class
    static class USB {
        private String type;

        public USB(String type) {
            this.type = type;
        }

        void displayInfo() {
            System.out.println("USB type: " + type);
        }
    }
}