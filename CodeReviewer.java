import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class CodeReviewer
{

    // Main method
    public static void main ( String[] args ) throws IOException
    {
        try
        {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel ( "com.jtattoo.plaf.smart.SmartLookAndFeel" );
        } catch ( ClassNotFoundException ex )
        {
            java.util.logging.Logger.getLogger ( CodeReviewer.class.getName () ).log ( java.util.logging.Level.SEVERE,
                    null, ex );
        } catch ( InstantiationException ex )
        {
            java.util.logging.Logger.getLogger ( CodeReviewer.class.getName () ).log ( java.util.logging.Level.SEVERE,
                    null, ex );
        } catch ( IllegalAccessException ex )
        {
            java.util.logging.Logger.getLogger ( CodeReviewer.class.getName () ).log ( java.util.logging.Level.SEVERE,
                    null, ex );
        } catch ( javax.swing.UnsupportedLookAndFeelException ex )
        {
            java.util.logging.Logger.getLogger ( CodeReviewer.class.getName () ).log ( java.util.logging.Level.SEVERE,
                    null, ex );
        }
        CodeReviewerFrame frame = new CodeReviewerFrame ( " Jhub " );
        frame.setExtendedState ( JFrame.MAXIMIZED_BOTH );
        playMusic ( "openingsong.wav" );


    }

    public static void playMusic ( String musicLocation )
    {
        try
        {

            File musicPath = new File ( musicLocation );
            if ( musicPath.exists () )
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream ( musicPath );
                Clip clip = AudioSystem.getClip ();
                clip.open ( audioInput );
                clip.start ();

            }
            else
            {
                System.out.println ( "null" );
            }

        } catch ( Exception e )
        {
            e.printStackTrace ();

        }
    }
}




