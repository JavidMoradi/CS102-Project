import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

public class CodeReviewerFrame extends JFrame
{
    FileOptionsPanel fileOptionsPanel = new FileOptionsPanel();
    public CodeReviewerFrame ( String title ) throws IOException
    {
        super(title);
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setPreferredSize( new Dimension( 1500, 1000 ) );

        add ( new FileExplorerPanel(), BorderLayout.SOUTH );
        add ( new HomeOptionsPanel () );
        add ( fileOptionsPanel, BorderLayout.SOUTH );
        //add ( new FileOptionsPanel () );//, BorderLayout.CENTER );
        add ( new NewCommentPanel () );
        add ( new CommentOptionsPanel());

        //add ( editorPanel );

        setLayout ( new FlowLayout() );

        pack();
        setVisible(true);

        /**
         * Everything Under This is experimental
         */
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        //add ( fileOptionsPanel, constraints );
    }
}
