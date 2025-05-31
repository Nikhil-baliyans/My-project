import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();
        int choice;

        do {
            System.out.println("\n==== Map Navigation System ====");
            System.out.println("1. Add Place");
            System.out.println("2. Add Road");
            System.out.println("3. Display Map");
            System.out.println("4. Find Shortest Path");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Place Name: ");
                    String place = sc.nextLine();
                    graph.addPlace(place);
                    break;
                case 2:
                    System.out.print("Enter Source Place: ");
                    String source = sc.nextLine();
                    System.out.print("Enter Destination Place: ");
                    String dest = sc.nextLine();
                    System.out.print("Enter Distance (in km): ");
                    int dist = sc.nextInt();
                    graph.addRoad(source, dest, dist);
                    break;
                case 3:
                    graph.displayMap();
                    break;
                case 4:
                    System.out.print("Enter Start Place: ");
                    String start = sc.nextLine();
                    System.out.print("Enter End Place: ");
                    String end = sc.nextLine();
                    graph.findShortestPath(start, end);
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
