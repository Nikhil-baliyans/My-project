import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelManager manager = new HotelManager();

        int choice;
        do {
            System.out.println("\n==== Hotel Room Booking System ====");
            System.out.println("1. Add Room");
            System.out.println("2. View All Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Room Type (Single/Double/Suite): ");
                    String type = sc.nextLine();
                    Room r = new Room(roomNo, type);
                    manager.addRoom(r);
                    break;
                case 2:
                    manager.viewAllRooms();
                    break;
                case 3:
                    System.out.print("Enter Room Number to Book: ");
                    int bookNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customer = sc.nextLine();
                    manager.bookRoom(bookNo, customer);
                    break;
                case 4:
                    System.out.print("Enter Room Number to Cancel Booking: ");
                    int cancelNo = sc.nextInt();
                    sc.nextLine();
                    manager.cancelBooking(cancelNo);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }
}
