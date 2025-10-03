public class Hotel {
    private String name;
    private int totalRooms;
    private int reservedRooms;

    public Hotel(String name, int totalRooms, int reservedRooms) {
        this.name = name;
        this.totalRooms = totalRooms;
        this.reservedRooms = reservedRooms;
    }

    public void reserveRoom(String guestName, int numOfRooms) {
        
        // ReservatoinValidation is a local inner class.
        class ReservationValidation {
            boolean validate() {
                if(guestName == null || guestName.isBlank() == true) {
                    System.out.println("Guest name can't be empty!");
                    return false;
                }

                if(numOfRooms < 0) {
                    System.out.println("Number of rooms can't be negative!");
                    return false;
                }

                if (reservedRooms + numOfRooms > totalRooms) {
                    System.out.println("No enough rooms available.");
                    return false;
                }

                return true;
            }
        }

        ReservationValidation validator = new ReservationValidation();
        if (validator.validate()) {
            reservedRooms += numOfRooms;
            System.out.println("Reservation confirmed for " + guestName + " for " + numOfRooms + " rooms.");
        } else {
            System.out.println("Reservation failed!");
        }
    }
}