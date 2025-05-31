import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int choice;

        do {
            System.out.println("\n=== Music Playlist Manager ===");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. View Playlist (Forward)");
            System.out.println("4. View Playlist (Backward)");
            System.out.println("5. Search Song");
            System.out.println("6. Shuffle Playlist");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Song Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Artist Name: ");
                    String artist = sc.nextLine();
                    playlist.addSong(title, artist);
                    break;
                case 2:
                    System.out.print("Enter Song Title to Remove: ");
                    String removeTitle = sc.nextLine();
                    playlist.removeSong(removeTitle);
                    break;
                case 3:
                    playlist.displayForward();
                    break;
                case 4:
                    playlist.displayBackward();
                    break;
                case 5:
                    System.out.print("Enter Song Title to Search: ");
                    String searchTitle = sc.nextLine();
                    playlist.searchSong(searchTitle);
                    break;
                case 6:
                    playlist.shufflePlaylist();
                    break;
                case 7:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);
    }
}
