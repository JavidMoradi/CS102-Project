import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewCommentPanel extends JPanel
{
    EditorAreaPanel display;
    ErrorSettingsFrame errorSettings;
    NewCommentPanel thisPanel;
    static ArrayList<Color> errorColors;

    public NewCommentPanel ( EditorAreaPanel display )
    {
        this.display = display;
        setPreferredSize( new Dimension( 370, 130) );
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
        
        errorColors = new ArrayList<Color>();

        JButton errorSettingsButton = new JButton();
        errorSettingsButton.setBackground(Color.GRAY);
        errorSettingsButton.setForeground( Color.WHITE );
        errorSettingsButton.setPreferredSize( new Dimension( 15, 15) );
        add ( errorSettingsButton );
        thisPanel = this;
        errorSettingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorSettings = new ErrorSettingsFrame( thisPanel);
            }
        });
        
        JButton wrongIndentationError = new JButton("Wrong Indentation");
        Color wrongIndentationColor = Color.RED;
        wrongIndentationError.setBackground(wrongIndentationColor);
        wrongIndentationError.setForeground( Color.WHITE );
        wrongIndentationError.setPreferredSize( new Dimension( 190, 25) );
        wrongIndentationError.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comment c;
                c = new Comment( "Wrong Indentation", display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), wrongIndentationColor);
                display.addHighlight( wrongIndentationColor );
                //add comment with 5 parameters!
                CommentsModel.addComment(c);
                CommentShowPanel.update();
            }
        });
        add ( wrongIndentationError );
        errorColors.add( wrongIndentationColor);

        JButton inefficientError = new JButton("Inefficient Code");
        Color inefficientErrorColor = Color.BLUE;
        inefficientError.setBackground(inefficientErrorColor);
        inefficientError.setForeground( Color.WHITE );
        inefficientError.setPreferredSize( new Dimension( 170, 25) );
        inefficientError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

                display.addHighlight( inefficientErrorColor);
        		Comment c;

        		display.addHighlight( inefficientErrorColor );

        		c = new Comment( "Inefficient Code Error", display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), inefficientErrorColor);

                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
               // CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Inefficient Code Error." );
        	}
        });
        add ( inefficientError );
        errorColors.add( inefficientErrorColor);

        JButton namingConventionError = new JButton("Naming Conventions Error");
        Color namingConventionColor = Color.MAGENTA;
        namingConventionError.setBackground( namingConventionColor);
        namingConventionError.setForeground( Color.WHITE );
        namingConventionError.setPreferredSize( new Dimension( 190, 25) );
        namingConventionError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		Comment c;

        		display.addHighlight( namingConventionColor);
        		c = new Comment( "Naming Convention Error", display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), namingConventionColor);

                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
              //  CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Nameing Convention Error." );
        	}
        });
        add ( namingConventionError );
        errorColors.add(namingConventionColor);

        JButton javaDocError = new JButton("JavaDoc Error");
        Color javaDocColor = new Color(24, 147, 196);
        javaDocError.setBackground(javaDocColor);
        javaDocError.setForeground( Color.WHITE );
        javaDocError.setPreferredSize( new Dimension( 170, 25) );
        javaDocError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Comment c;
        		display.addHighlight( javaDocColor);
        		c = new Comment( "JavaDoc Comment Error" , display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), javaDocColor);

                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
              //  CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " JavaDoc Comment Error." );
        	}
        });
        add ( javaDocError );
        errorColors.add(javaDocColor);

        JButton styleErrorButton = new JButton("Blank Line/Space Error");
        Color styleColor = Color.GRAY;
        styleErrorButton.setBackground( styleColor);
        styleErrorButton.setForeground( Color.WHITE );
        styleErrorButton.setPreferredSize( new Dimension( 190, 25) );
        styleErrorButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Comment c;
        		c = new Comment( "Style Error", display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), styleColor);

        		display.addHighlight( styleColor );
                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
             //   CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Style Error." );
        	}
        });
        add ( styleErrorButton );
        errorColors.add(styleColor);

        JButton commentError = new JButton("Comment Error");
        Color commentErrorColor = new Color( 29, 171, 34 );
        commentError.setBackground(commentErrorColor);
        commentError.setForeground( Color.WHITE );
        commentError.setPreferredSize( new Dimension( 170, 25) );
        commentError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Comment c;

        		c = new Comment( "Commment Error", display.getSelectionFirst(), display.getSelectionLast(), display.getLineNumber(display.getSelectionFirst()), commentErrorColor);

        		display.addHighlight( commentErrorColor );
                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
           //     CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Commment Error." );
        	}
        });
        add ( commentError );
        errorColors.add(commentErrorColor);
    }
    
    public static ArrayList<Color> getColors() {
        return errorColors;
    }
}
