import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class NewCommentPanel extends JPanel
{
    public NewCommentPanel ()
    {
        setPreferredSize( new Dimension( 400, 130) );
        setBackground( Color.GREEN);
        setBorder( BorderFactory.createLineBorder( Color.BLUE) );

        JLabel insertLabel = new JLabel( "REVIEW OPTIONS" );
        insertLabel.setPreferredSize( new Dimension(400, 25));
        insertLabel.setFont( new Font( "Tahoma", Font.BOLD, 14 ) );
        insertLabel.setForeground( Color.BLUE );
        insertLabel.setBorder( new LineBorder( new Color(0, 0, 0) ) );
        insertLabel.setOpaque( true );
        insertLabel.setBackground( Color.WHITE );
        insertLabel.setHorizontalAlignment( SwingConstants.CENTER );
        insertLabel.setBounds( 200, 36, 201, 40 );
        add ( insertLabel );

        JButton wrongIndentationError = new JButton(" Wrong Indentation");
        wrongIndentationError.setBackground(Color.RED);
        wrongIndentationError.setForeground( Color.WHITE );
        wrongIndentationError.setPreferredSize( new Dimension( 190, 25) );
        wrongIndentationError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                EditorAreaPanel.addHighlight( Color.RED);
                CommentShowPanel.addComment( "Line ... : Wrong Identation Error." );
        	}

        });
        add ( wrongIndentationError );

        JButton inefficientError = new JButton("Inefficient Code");
        inefficientError.setBackground(Color.BLUE);
        inefficientError.setForeground( Color.WHITE );
        inefficientError.setPreferredSize( new Dimension( 170, 25) );
        inefficientError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                EditorAreaPanel.addHighlight( Color.BLUE);
                CommentShowPanel.addComment( "Line ... : Inefficient Code Error." );
        	}

        });
        add ( inefficientError );

        JButton namingConventionError = new JButton("Naming Conventions Error");
        namingConventionError.setBackground(Color.MAGENTA);
        namingConventionError.setForeground( Color.WHITE );
        namingConventionError.setPreferredSize( new Dimension( 190, 25) );
        namingConventionError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                EditorAreaPanel.addHighlight( Color.MAGENTA);
                CommentShowPanel.addComment( "Line ... : Nameing Convention Error." );
        	}

        });
        add ( namingConventionError );

        JButton javaDocError = new JButton("JavaDoc Error");
        javaDocError.setBackground(Color.yellow);
        javaDocError.setForeground( Color.BLACK );
        javaDocError.setPreferredSize( new Dimension( 170, 25) );
        javaDocError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                EditorAreaPanel.addHighlight( Color.yellow);
                CommentShowPanel.addComment( "Line ... : JavaDoc Comment Error." );
        	}

        });
        add ( javaDocError );

        JButton styleErrorButton = new JButton("Blank Line/Space Error");
        styleErrorButton.setBackground(Color.gray);
        styleErrorButton.setForeground( Color.WHITE );
        styleErrorButton.setPreferredSize( new Dimension( 190, 25) );
        styleErrorButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                EditorAreaPanel.addHighlight( Color.gray);
                CommentShowPanel.addComment( "Line ... : Style Error." );
        	}

        });
        add ( styleErrorButton );

        JButton commentError = new JButton("Comment Error");
        commentError.setBackground(Color.black);
        commentError.setForeground( Color.WHITE );
        commentError.setPreferredSize( new Dimension( 170, 25) );
        commentError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                EditorAreaPanel.addHighlight( Color.black);
                CommentShowPanel.addComment( "Line ... : Commment Error." );
        	}

        });
        add ( commentError );
        
    }

}
