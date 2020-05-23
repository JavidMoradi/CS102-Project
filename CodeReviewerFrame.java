import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
/**
 * @authors Javid Moradi, Ahmad Salman, Atasagun Samed Şanap, Hissam Faramawy, Onuralp Avcı, Tuna Öğüt
 * @version 1.1
 */
public class CodeReviewerFrame extends JFrame
{
    private EditorAreaPanel display = new EditorAreaPanel ();
    //FileOptionsPanel fileOptionsPanel = new FileOptionsPanel( display );
    private JPanel p = new JPanel ();
    private JPanel panel = new JPanel ();

    public CodeReviewerFrame ( String title ) throws IOException
    {
        super ( title );
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setPreferredSize ( new Dimension ( 1500, 1000 ) );

        // Temporary Solution for "Resizing"
        setMinimumSize ( new Dimension ( 1470, 700 ) );

        ImageIcon img = new ImageIcon ( "icon.png" );
        setIconImage ( img.getImage () );

        setLayout ( new BorderLayout () );

        p.setLayout ( new BorderLayout () );
        p.add ( new HomeOptionsPanel ( display ), BorderLayout.LINE_START );
        p.add ( new NewCommentPanel ( display ), BorderLayout.CENTER );
        p.add ( new CommentOptionsPanel ( display ), BorderLayout.LINE_END );
        add ( p, BorderLayout.PAGE_START );

        panel.setLayout ( new BorderLayout () );
        panel.add ( new FileExplorerPanel (), BorderLayout.LINE_START );
        panel.add ( new FileOptionsPanel ( display ), BorderLayout.CENTER );
        panel.add ( new CommentShowPanel ( display ), BorderLayout.LINE_END );
        add ( panel, BorderLayout.CENTER );

        addWindowListener ( new closeSong () );

        pack ();
        setVisible ( true );

        /**
         * Everything Under This is experimental
         */
        GridBagConstraints constraints = new GridBagConstraints ();
        constraints.gridx = 0;
        constraints.gridy = 0;
        //add ( fileOptionsPanel, constraints );
    }

    /**
     * Plays the song (tune) on the directory of the project
     * @param musicLocation, song name with ".wav" extension
     */
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
    /**
     * Window Listener for tune that plays when user wants to close the program
     */
    class closeSong implements WindowListener
    {
        @Override
        public void windowOpened ( WindowEvent e )
        {
        }

        @Override
        public void windowClosing ( WindowEvent e )
        {
            playMusic ( "closingsong.wav" );
            int dialogButton = JOptionPane.showConfirmDialog ( null, "Close the program?", "ALERT",
                    JOptionPane.YES_NO_OPTION );
            if ( dialogButton == JOptionPane.YES_OPTION )
            {
                System.exit ( 0 );
            }
            else
            {
                remove ( dialogButton );
            }
        }

        @Override
        public void windowClosed ( WindowEvent e )
        {
        }

        @Override
        public void windowIconified ( WindowEvent e )
        {
        }

        @Override
        public void windowDeiconified ( WindowEvent e )
        {
        }

        @Override
        public void windowActivated ( WindowEvent e )
        {
        }

        @Override
        public void windowDeactivated ( WindowEvent e )
        {
        }
    }

}


