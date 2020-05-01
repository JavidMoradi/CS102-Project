import javax.swing.*;
import java.awt.*;

public class CodeReviewerFrame extends JFrame
{
	EditorAreaPanel display = new EditorAreaPanel();
    //FileOptionsPanel fileOptionsPanel = new FileOptionsPanel( display );

    public CodeReviewerFrame ( String title )
    {
        super(title);
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        setPreferredSize( new Dimension( 1500, 1000 ) );



        add ( new HomeOptionsPanel ( display));

        add ( new NewCommentPanel ( display ) );
        add ( new CommentOptionsPanel( display ), BorderLayout.EAST);
        add ( new FileExplorerPanel( display ) );
        add ( new FileOptionsPanel( display ) );
        add( new CommentShowPanel( display ) );

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
