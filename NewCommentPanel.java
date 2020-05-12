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
    static ArrayList<JButton> errorButtons;

    public NewCommentPanel ( EditorAreaPanel display )
    {
        this.display = display;
        setPreferredSize( new Dimension( 200, 130) );
        setBackground( Color.darkGray);
        setBorder( BorderFactory.createLineBorder( Color.BLACK) );

        errorColors = new ArrayList<Color>();
        errorButtons = new ArrayList<JButton>();

        errorColors.add( Color.RED);
        errorColors.add( Color.BLUE);
        errorColors.add( Color.MAGENTA);
        errorColors.add( new Color(24, 147, 196));
        errorColors.add( Color.GRAY);
        errorColors.add( new Color( 29, 171, 34 ));


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
        wrongIndentationError.setBackground( errorColors.get(0));
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
                        errorColors.get(0),
                        FileOptionsPanel.theFileName);

                //add comment with 5 parameters!
                CommentsModel.addComment(c);
                CommentShowPanel.update();
            }
        });
        add ( wrongIndentationError );
        errorButtons.add(wrongIndentationError);

        JButton inefficientError = new JButton("Inefficient Code");
        inefficientError.setBackground(errorColors.get(1));
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
        errorButtons.add(inefficientError);

        JButton namingConventionError = new JButton("Naming Conventions");
        namingConventionError.setBackground( errorColors.get(2));
        namingConventionError.setForeground( Color.BLACK );
        namingConventionError.setPreferredSize( new Dimension( 210, 40) );
        namingConventionError.setFont(new Font("Microsoft Tai Le", Font.BOLD, 17));
        namingConventionError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		Comment c;
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
        errorButtons.add(namingConventionError);

        JButton javaDocError = new JButton("JavaDoc");
        javaDocError.setBackground( errorColors.get(3));
        javaDocError.setForeground( Color.BLACK );
        javaDocError.setPreferredSize( new Dimension( 210, 40) );
        javaDocError.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
        javaDocError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Comment c;
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
        errorButtons.add(javaDocError);

        JButton styleErrorButton = new JButton("Blank Line/Space");
        styleErrorButton.setBackground( errorColors.get(4));
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

                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
             //   CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Style Error." );
        	}
        });
        add ( styleErrorButton );
        errorButtons.add(styleErrorButton);

        JButton commentError = new JButton("Comment Error");
        commentError.setBackground( errorColors.get(5));
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

                //add comment with 5 parameters!
        		CommentsModel.addComment(c);
                CommentShowPanel.update();
           //     CommentShowPanel.addComment( "Line: " + display.getLineNumber(display.getSelectionFirst()) + " Commment Error." );
        	}
        });
        add ( commentError );
        errorButtons.add(commentError);

    }
    
    public void editColor(int pos, Color color) {
        errorColors.set( pos, color);
        errorButtons.get( pos).setBackground( color);
    }
}
