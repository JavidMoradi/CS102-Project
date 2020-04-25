import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

public class CodeReviewerFrame extends JFrame
{
EditorAreaPanel editorPanel = new EditorAreaPanel();
    public CodeReviewerFrame ( String title ) throws IOException
    {
        super(title);
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setPreferredSize( new Dimension( 1500, 1000 ) );
        //setBackground( Color.CYAN );


//        add ( fileOptionsPanel );
//        add ( editorPanel  );
//        add ( homeOptionsPanel );
//
//        add ( newCommentPanel, BorderLayout.EAST );
//        add ( commentOptionsPanel, BorderLayout.NORTH );
//        add ( fileExplorerPanel );
//        add ( editorPanel );
        add ( new HomeOptionsPanel (), BorderLayout.WEST );
        add ( new FileOptionsPanel () );//, BorderLayout.CENTER );
        add ( new NewCommentPanel (), BorderLayout.EAST );
        add ( new CommentOptionsPanel(), BorderLayout.NORTH );
        add ( new FileExplorerPanel() );
        add ( editorPanel );

//        editorPanel.add ( new FileExplorerPanel() );
//        add ( editorPanel, BorderLayout.CENTER );

        setLayout ( new FlowLayout() );

        pack();
        setVisible(true);
    }
}
