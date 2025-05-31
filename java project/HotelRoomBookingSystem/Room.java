public class Room {
    private int roomNumber;
    private String type;
    private boolean isBooked;
    private String customerName;

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
        this.customerName = "";
    }

    public int getRoomNumber() { return roomNumber; }
    public String getType() { return type; }
    public boolean isBooked() { return isBooked; }
    public String getCustomerName() { return customerName; }

    public void bookRoom(String customerName) {
        this.isBooked = true;
        this.customerName = customerName;
    }

    public void cancelBooking() {
        this.isBooked = false;
        this.customerName = "";
    }

    public void display() {
        System.out.println("Room No: " + roomNumber + ", Type: " + type + ", Booked: " + (isBooked ? "Yes, by " + customerName : "No"));
    }
}
