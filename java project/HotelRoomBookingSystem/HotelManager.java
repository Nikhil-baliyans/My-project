import java.util.ArrayList;

public class HotelManager {
    private ArrayList<Room> rooms = new ArrayList<>();

    public void addRoom(Room r) {
        rooms.add(r);
        System.out.println("Room added successfully!");
    }

    public void viewAllRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }
        System.out.println("\nRoom List:");
        for (Room r : rooms) {
            r.display();
        }
    }

    public Room searchRoom(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                return r;
            }
        }
        return null;
    }

    public void bookRoom(int roomNumber, String customerName) {
        Room r = searchRoom(roomNumber);
        if (r != null) {
            if (!r.isBooked()) {
                r.bookRoom(customerName);
                System.out.println("Room booked successfully!");
            } else {
                System.out.println("Room already booked.");
            }
        } else {
            System.out.println("Room not found.");
        }
    }

    public void cancelBooking(int roomNumber) {
        Room r = searchRoom(roomNumber);
        if (r != null) {
            if (r.isBooked()) {
                r.cancelBooking();
                System.out.println("Booking cancelled successfully!");
            } else {
                System.out.println("Room is not booked.");
            }
        } else {
            System.out.println("Room not found.");
        }
    }
}
