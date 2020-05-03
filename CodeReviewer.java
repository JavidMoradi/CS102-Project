import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class CodeReviewer {

    // Main method
    public static void main(String[] args) throws IOException {

        playMusic("openingsong.wav");
        CodeReviewerFrame frame = new CodeReviewerFrame(" Jhub ");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }

    public static void playMusic(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();

            } else {
                System.out.println("null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

