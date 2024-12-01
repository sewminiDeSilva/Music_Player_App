//import javax.sound.sampled.*;
//import java.io.File;
//import java.io.IOException;

public class Song {

    String title;
    double duration;
   //String filePath;

    public Song(String title, double duration) {
        this.title = title;
        this.duration=duration;
       // this.filePath=filepath;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }



//    public void play() {
//        try {
//            File audioFile = new File(filePath);
//            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioInputStream);
//            clip.start();
//            System.out.println("Playing: " + title);
//            // Keep the program running while the clip is playing
//            Thread.sleep(clip.getMicrosecondLength() / 1000);
//        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
//            System.out.println("Error playing the song: " + e.getMessage());
//        }
 //   }
//******This is not operational without audio files.


    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
