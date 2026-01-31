package DesignPatterns.Singleton;

public class Main {
    public static void main(String[] args) {
        /**
         * Ensure a class has only one instance and provide a global point of access to it.
         * Think of it like: 
         * - The President of a country → only one, but everyone can refer to them. 
         * - Database connection pool → only one pool object shared everywhere.
         */
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println(db1  == db2);
    }
}
