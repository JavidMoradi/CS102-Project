import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CodeReviewerFrame extends JFrame
{
    EditorAreaPanel display = new EditorAreaPanel ();
    //FileOptionsPanel fileOptionsPanel = new FileOptionsPanel( display );
    JPanel p = new JPanel ();
    JPanel panel = new JPanel ();

    public CodeReviewerFrame ( String title ) throws IOException
    {
        super ( title );
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setPreferredSize ( new Dimension ( 1500, 1000 ) );

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
}
