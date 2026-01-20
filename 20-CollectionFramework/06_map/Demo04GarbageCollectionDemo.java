import java.lang.ref.WeakReference;

public class Demo04GarbageCollectionDemo {
    public static void main(String[] args) {
         WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Apple", "16 Pro Max"));
        System.out.println(phoneWeakReference.get());
        // System.out.println(phoneWeakReference.get().brand + " - " + phoneWeakReference.get().model);
        System.gc();

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        System.out.println(phoneWeakReference.get());
        // System.out.println(phoneWeakReference.get().brand + " - " + phoneWeakReference.get().model);
    }
}

class Phone {
    String brand;
    String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
}
