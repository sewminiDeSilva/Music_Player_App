import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
     private String title;
     private String artist;
     private ArrayList<Song> songs;

     //constructor
    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

//    public Album() {
//    }

    public boolean addSong(String title,double duration){
        if(findSong(title)== null){
            songs.add(new Song(title,duration));
//            System.out.println(title+"successfully added");
            return true;
        }else{
//            System.out.println("song already exist");
            return false;
        }
    }

  public Song findSong(String title) {
        for (Song checkSong:songs) {
            if(checkSong.getTitle().equals(title)){
                return checkSong;
            }

        }return null;
    }
public  boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber-1;
    if (index > 0 && index<= this.songs.size()) {
        playlist.add(this.songs.get(index));
        return true;

    }
//    System.out.println( "doesn't have song with track number"+ trackNumber);
    return false;
}

public boolean addToPlaylist(String title,LinkedList<Song> playlist){
        for(Song CheckedSong:this.songs){
            if (CheckedSong.getTitle().equals(title)) {
                playlist.add(CheckedSong);
                return  true;
            }

   }
//        System.out.println("There is no such a song");
    return false;
}

public Song searchSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }
}
