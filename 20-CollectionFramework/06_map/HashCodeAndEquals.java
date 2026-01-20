import java.util.HashMap;
import java.util.Objects;

public class HashCodeAndEquals {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bob", 2);
        Person p3 = new Person("Alice", 1);
        
        map.put(p1, "Engineer");
        map.put(p2, "Designer");
        map.put(p3, "Manager");

        System.out.println("HashMap size: " + map.size());
        System.out.println("Value for p1: " + map.get(p1));
        System.out.println("Value for p3: " + map.get(p3));
    }
}

class Person {
    private String name;
    private int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
        // return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Person p = (Person) obj;
        return id == p.getId() && Objects.equals(name, p.getName());
    }

    @Override
    public String toString() {
        return "id:" + id + ", name: " + name;
    }
}
