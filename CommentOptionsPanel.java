import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @authors Javid Moradi, Hissam Faramawy, Ahmad Salman, Onuralp Avcı
 * @version 1.1
 */
public class CommentOptionsPanel extends JPanel
{
    private EditorAreaPanel display;
    private InsertACommentFrame insertACommentFrame;

    public CommentOptionsPanel ( EditorAreaPanel display )
    {
        this.display = display;
        setPreferredSize ( new Dimension ( 533, 130 ) );
        setBackground ( Color.darkGray );
        setBorder ( BorderFactory.createLineBorder ( Color.BLACK ) );

        JLabel commentOptionsLabel = new JLabel ( "COMMENT OPTIONS" );
        commentOptionsLabel.setPreferredSize ( new Dimension ( 450, 20 ) );
        commentOptionsLabel.setFont ( new Font ( "Tahoma", Font.BOLD, 18 ) );
        commentOptionsLabel.setForeground ( Color.BLACK );
        commentOptionsLabel.setBorder ( new LineBorder ( new Color ( 0, 0, 0 ) ) );
        commentOptionsLabel.setOpaque ( true );
        commentOptionsLabel.setBackground ( Color.WHITE );
        commentOptionsLabel.setHorizontalAlignment ( SwingConstants.CENTER );
        commentOptionsLabel.setBounds ( 200, 36, 201, 40 );
        add ( commentOptionsLabel );

        JButton insertCommentButton = new JButton ( "Insert A Comment" );
        insertCommentButton.setBackground ( new Color ( 164, 129, 255 ) );
        insertCommentButton.setForeground ( Color.BLACK );
        insertCommentButton.setFont ( new Font ( "Microsoft Tai Le", Font.BOLD, 20 ) );
        insertCommentButton.setBorder ( BorderFactory.createLineBorder ( Color.BLACK ) );
        insertCommentButton.setPreferredSize ( new Dimension ( 430, 40 ) );
        insertCommentButton.addActionListener ( new ActionListener ()
        {

            @Override
            public void actionPerformed ( ActionEvent e )
            {
                insertACommentFrame = new InsertACommentFrame ( display );
            }

        } );
        add ( insertCommentButton, BorderLayout.EAST );

        JButton deleteCommentButton = new JButton ( "Delete Comment" );
        deleteCommentButton.setBackground ( new Color ( 164, 129, 255 ) );
        deleteCommentButton.setForeground ( Color.BLACK );
        deleteCommentButton.setFont ( new Font ( "Microsoft Tai Le", Font.BOLD, 20 ) );
        deleteCommentButton.setBorder ( BorderFactory.createLineBorder ( Color.BLACK ) );
        deleteCommentButton.setPreferredSize ( new Dimension ( 430, 40 ) );
        deleteCommentButton.addActionListener ( new ActionListener ()
        {

            @Override
            public void actionPerformed ( ActionEvent e )
            {
                // TODO Auto-generated method stub

                CommentsModel.commentsBag.remove ( CommentShowPanel.listFiles.getSelectedValue () );

                EditorAreaPanel.removeHighlights ();
                EditorAreaPanel.reHighlight ( CommentsModel.commentsBag );

                CommentShowPanel.update ();
                CommentShowPanel.touchedForTheFirstTime = true;
            }

        } );
        add ( deleteCommentButton, BorderLayout.EAST );
    }
}
