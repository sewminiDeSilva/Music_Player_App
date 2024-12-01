import java.util.*;

public class Main {
    private static  ArrayList<Album> albums =new ArrayList<>();

    public static void main(String[] args) {


        Album album = new Album("1989", "Taylor Swift");

        album.addSong("Style", 3.51);
        album.addSong("Blank Space", 3.55);
        album.addSong("Shake It Off", 3.39);
        album.addSong("Wildest Dreams", 3.40);
        albums.add(album);

        album = new Album("Divide", "Ed Sheeran");

        album.addSong("Shape of You", 3.54);
        album.addSong("Perfect", 4.23);
        album.addSong("Castle on the Hill", 4.21);
        album.addSong("Galway Girl", 2.50);
        albums.add(album);


LinkedList<Song> playList_1 =new LinkedList<>();
    albums.get(0).addToPlaylist("Blank Space", playList_1);
    albums.get(0).addToPlaylist("Shake It Off", playList_1);
  albums.get(1).addToPlaylist("Galway Girl", playList_1);
  albums.get(1).addToPlaylist("Castle on the Hill", playList_1);

play(playList_1);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit =false;
        boolean forward =true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.isEmpty()) {
            System.out.println("This playlist have no song");

        }else {
            System.out.println("Now playing"+ listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing" + listIterator.next().toString());

                    } else {
                        System.out.println("no song available");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = true;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing" + listIterator.next().toString());
                    } else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = false;
                        } else {
                            System.out.println("we are the first song");
                        }
                    } else {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("we have reached end of list");
                        }
                    }
                    break;
                case 4:
                   printList(playList);
                   break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (!playList.isEmpty()) {
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+ listIterator.next().toString());
                        }
                        else{
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                        }
                    }
            }break;
                    case 7:
                    System.out.println("Enter song title to search:");
                    String titleToSearch = sc.nextLine();
                    Song foundSong = albums.get(0).searchSong(titleToSearch); // Search in first album as an example
                    if (foundSong != null) {
                        System.out.println("Found: " + foundSong.toString());
//                        foundSong.play();
                    } else {
                        System.out.println("Song not found.");
                    }
                    break;
        }}}


 private  static  void printMenu(){
     System.out.println("Available options\n press");
     System.out.println("""
             0-to quit
             1-to play next song
             2-to play previous song
             3- to replay the current song
             4- List of all songs
             5-print all available options
             6-delete current song
             7-search for a song""");
 }
 private static  void printList(LinkedList<Song> playList){
     Iterator<Song> iterator = playList.iterator();
     System.out.println("------------");

     while(iterator.hasNext()){
         System.out.println(iterator.next());
     }
     System.out.println("-------------");
 }

}
