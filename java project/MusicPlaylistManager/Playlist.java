import java.util.*;

public class Playlist {
    private Song head;
    private Song tail;

    public Playlist() {
        head = null;
        tail = null;
    }

    public void addSong(String title, String artist) {
        Song newSong = new Song(title, artist);
        if (head == null) {
            head = tail = newSong;
        } else {
            tail.next = newSong;
            newSong.prev = tail;
            tail = newSong;
        }
        System.out.println("Added: " + title + " by " + artist);
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("\nPlaylist (Forward):");
        Song temp = head;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ". " + temp.title + " by " + temp.artist);
            temp = temp.next;
            index++;
        }
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("\nPlaylist (Backward):");
        Song temp = tail;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ". " + temp.title + " by " + temp.artist);
            temp = temp.prev;
            index++;
        }
    }

    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        Song temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Song not found.");
            return;
        }
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        System.out.println("Removed: " + title);
    }

    public void searchSong(String title) {
        Song temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + temp.title + " by " + temp.artist);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Song not found.");
    }

    public void shufflePlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        List<Song> songList = new ArrayList<>();
        Song temp = head;
        while (temp != null) {
            songList.add(temp);
            temp = temp.next;
        }
        Collections.shuffle(songList);
        head = tail = null;
        for (Song s : songList) {
            s.next = s.prev = null;
            addSong(s.title, s.artist);
        }
        System.out.println("Playlist shuffled!");
    }
}
