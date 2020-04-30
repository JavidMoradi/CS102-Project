import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCommentPanel extends JPanel
{
    EditorAreaPanel display = new EditorAreaPanel();

    public NewCommentPanel ( EditorAreaPanel display )
    {
        this.display = display;
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
        		Color color;
        		Comment c;

        		color = Color.RED;
        		c = new Comment( "Wrong Indentation", display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), color);

        		display.addHighlight( color );
                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
        	}


        });
        add ( wrongIndentationError );

        JButton inefficientError = new JButton("Inefficient Code");
        inefficientError.setBackground(Color.BLUE);
        inefficientError.setForeground( Color.WHITE );
        inefficientError.setPreferredSize( new Dimension( 170, 25) );
        inefficientError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

                display.addHighlight( Color.BLUE);
        		Color color;
        		Comment c;

        		color = Color.BLUE;
        		display.addHighlight( color );

        		c = new Comment( "Inefficient Code Error", display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), color);

                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
               // CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Inefficient Code Error." );
        	}

        });
        add ( inefficientError );

        JButton namingConventionError = new JButton("Naming Conventions Error");
        namingConventionError.setBackground(Color.MAGENTA);
        namingConventionError.setForeground( Color.WHITE );
        namingConventionError.setPreferredSize( new Dimension( 190, 25) );
        namingConventionError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		Color color;
        		Comment c;

        		color = Color.MAGENTA;
        		display.addHighlight( color);
        		c = new Comment( "Naming Convention Error", display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), color);

                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
              //  CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Nameing Convention Error." );
        	}

        });
        add ( namingConventionError );

        JButton javaDocError = new JButton("JavaDoc Error");
        javaDocError.setBackground(new Color(24, 147, 196));
        javaDocError.setForeground( Color.WHITE );
        javaDocError.setPreferredSize( new Dimension( 170, 25) );
        javaDocError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Color color;
        		Comment c;

        		color = new Color(24, 147, 196);
        		display.addHighlight( color);
        		c = new Comment( "JavaDoc Comment Error" , display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), color);

                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
              //  CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " JavaDoc Comment Error." );
        	}

        });
        add ( javaDocError );

        JButton styleErrorButton = new JButton("Blank Line/Space Error");
        styleErrorButton.setBackground(Color.gray);
        styleErrorButton.setForeground( Color.WHITE );
        styleErrorButton.setPreferredSize( new Dimension( 190, 25) );
        styleErrorButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Color color;
        		Comment c;

        		color = Color.gray;
        		display.addHighlight( color);
        		c = new Comment( "Style Error", display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), color);

        		display.addHighlight( color );
                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
             //   CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Style Error." );
        	}

        });
        add ( styleErrorButton );

        JButton commentError = new JButton("Comment Error");
        commentError.setBackground(new Color( 29, 171, 34 ));
        commentError.setForeground( Color.WHITE );
        commentError.setPreferredSize( new Dimension( 170, 25) );
        commentError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Color color;
        		Comment c;

        		color = new Color( 29, 171, 34 );
        		display.addHighlight( color);

        		c = new Comment( "Commment Error", display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), color);

        		display.addHighlight( color );
                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
           //     CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Commment Error." );
        	}

        });
        add ( commentError );
    }
}