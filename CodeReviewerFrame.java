import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CodeReviewerFrame extends JFrame
{
   EditorAreaPanel editorPanel = new EditorAreaPanel();
    public CodeReviewerFrame ( String title )
    {
        super(title);
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setPreferredSize( new Dimension( 1500, 1000 ) );


        add ( new HomeOptionsPanel (), BorderLayout.WEST );
        add ( new FileOptionsPanel (), BorderLayout.CENTER );
        add ( new NewCommentPanel (), BorderLayout.EAST );
        add ( new CommentOptionsPanel(), BorderLayout.NORTH );
        editorPanel.add ( new FileExplorerPanel() );
        add ( editorPanel, BorderLayout.CENTER );
        //add ( new FileExplorerPanel() );

        setLayout ( new FlowLayout() );

        pack();
        setVisible(true);
    }
}
