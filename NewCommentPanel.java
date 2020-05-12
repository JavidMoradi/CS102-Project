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
        setPreferredSize( new Dimension( 200, 130) );
        setBackground( Color.darkGray);
        setBorder( BorderFactory.createLineBorder( Color.BLACK) );

        JLabel insertLabel = new JLabel( "ERROR REVIEW OPTIONS" );
        insertLabel.setPreferredSize( new Dimension(640, 20));
        insertLabel.setFont( new Font( "Tahoma", Font.BOLD, 18 ) );
        insertLabel.setForeground( Color.BLACK );
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
        wrongIndentationError.setForeground( Color.BLACK );
        wrongIndentationError.setPreferredSize( new Dimension( 210, 40) );
        wrongIndentationError.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
        wrongIndentationError.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comment c;
                c = new Comment( "Wrong Indentation",
                        display.getSelectionFirst(),
                        display.getSelectionLast(),
                        display.getLineNumber(display.getSelectionFirst()),
                        wrongIndentationColor,
                        FileExplorerPanel.FileNamesForComments);

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
        inefficientError.setForeground( Color.BLACK );
        inefficientError.setPreferredSize( new Dimension( 210, 40) );
        inefficientError.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
        inefficientError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		Comment c;

        		display.addHighlight( inefficientErrorColor );
                System.out.println( FileExplorerPanel.FileNamesForComments);

        		c = new Comment( "Inefficient Code Error",
                        display.getSelectionFirst(),
                        display.getSelectionLast(),
                        display.getLineNumber(display.getSelectionFirst()),
                        inefficientErrorColor,
                        FileExplorerPanel.FileNamesForComments
                        );

                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
               // CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Inefficient Code Error." );
        	}
        });
        add ( inefficientError );
        errorColors.add( inefficientErrorColor);

        JButton namingConventionError = new JButton("Naming Conventions");
        Color namingConventionColor = Color.MAGENTA;
        namingConventionError.setBackground( namingConventionColor);
        namingConventionError.setForeground( Color.BLACK );
        namingConventionError.setPreferredSize( new Dimension( 210, 40) );
        namingConventionError.setFont(new Font("Microsoft Tai Le", Font.BOLD, 17));
        namingConventionError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		Comment c;

        		display.addHighlight( namingConventionColor);
        		c = new Comment( "Naming Convention Error",
                        display.getSelectionFirst(),
                        display.getSelectionLast(),
                        display.getLineNumber(display.getSelectionFirst()),
                        namingConventionColor,
                        FileExplorerPanel.FileNamesForComments);

                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
              //  CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Nameing Convention Error." );
        	}
        });
        add ( namingConventionError );
        errorColors.add(namingConventionColor);

        JButton javaDocError = new JButton("JavaDoc");
        Color javaDocColor = new Color(24, 147, 196);
        javaDocError.setBackground(javaDocColor);
        javaDocError.setForeground( Color.BLACK );
        javaDocError.setPreferredSize( new Dimension( 210, 40) );
        javaDocError.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
        javaDocError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Comment c;
        		display.addHighlight( javaDocColor);
        		c = new Comment( "JavaDoc Comment Error" ,
                        display.getSelectionFirst(),
                        display.getSelectionLast(),
                        display.getLineNumber(display.getSelectionFirst()),
                        javaDocColor,
                        FileExplorerPanel.FileNamesForComments);

                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
              //  CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " JavaDoc Comment Error." );
        	}
        });
        add ( javaDocError );
        errorColors.add(javaDocColor);

        JButton styleErrorButton = new JButton("Blank Line/Space");
        Color styleColor = Color.GRAY;
        styleErrorButton.setBackground( styleColor);
        styleErrorButton.setForeground( Color.BLACK );
        styleErrorButton.setPreferredSize( new Dimension( 210, 40) );
        styleErrorButton.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
        styleErrorButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Comment c;
        		c = new Comment( "Style Error",
                        display.getSelectionFirst(),
                        display.getSelectionLast(),
                        display.getLineNumber(display.getSelectionFirst()),
                        styleColor,
                        FileExplorerPanel.FileNamesForComments);

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
        commentError.setForeground( Color.BLACK );
        commentError.setPreferredSize( new Dimension( 210, 40) );
        commentError.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
        commentError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Comment c;

        		c = new Comment( "Commment Error",
                        display.getSelectionFirst(),
                        display.getSelectionLast(),
                        display.getLineNumber(display.getSelectionFirst()),
                        commentErrorColor,
                        FileExplorerPanel.FileNamesForComments);

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
