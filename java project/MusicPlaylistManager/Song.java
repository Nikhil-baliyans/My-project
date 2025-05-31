public class Song {
    String title;
    String artist;
    Song next;
    Song prev;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.next = null;
        this.prev = null;
    }
}
