import javax.swing.*;
import java.awt.*;

public class CodeReviewerFrame extends JFrame
{
    EditorAreaPanel editorAreaPanel = new EditorAreaPanel();
    FileOptionsPanel fileOptionsPanel;
    public CodeReviewerFrame ( String title )
    {
        super(title);
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setPreferredSize( new Dimension( 1500, 1000 ) );
        editorAreaPanel.setVisible( true );
        fileOptionsPanel = new FileOptionsPanel( editorAreaPanel );
        
        add ( new HomeOptionsPanel ( editorAreaPanel ) );
        
        add ( new NewCommentPanel ( editorAreaPanel ) );
        add ( new CommentOptionsPanel( editorAreaPanel ), BorderLayout.EAST);
        add ( new FileExplorerPanel( editorAreaPanel ) );
        add ( fileOptionsPanel );
        

        setLayout ( new FlowLayout( ) );

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
