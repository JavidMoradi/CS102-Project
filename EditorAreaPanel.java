import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.util.ArrayList;

public class EditorAreaPanel extends JPanel
{
    Font editorFont;
    static CommentsModel commentControl;
    static JTextArea editorPanel;
    //static CommentsModel commentsModel;

    static JScrollPane scrollPane = new JScrollPane( editorPanel );
    static int a;
    static int b;

    static DefaultHighlighter highlighter;
    static DefaultHighlighter.DefaultHighlightPainter painter;

    public EditorAreaPanel ()
    {
        editorPanel = new JTextArea();
        editorPanel.setVisible( true );
        editorPanel.setRows( 28 );
        editorPanel.setColumns( 58 );
        editorPanel.setWrapStyleWord( true );
        editorPanel.setFont(new Font ("Tahoma", Font.PLAIN, 19) );
        editorPanel.setForeground( Color.WHITE );
        editorPanel.setBackground( Color.black );

		commentControl = new CommentsModel();

    //TextLineNumber tln = new TextLineNumber(textPane);
        scrollPane = new JScrollPane( editorPanel);
        TextLineNumber tln = new TextLineNumber(editorPanel);
        scrollPane.setRowHeaderView( tln );
        add ( scrollPane );
		highlighter = (DefaultHighlighter) editorPanel.getHighlighter();
		painter = new DefaultHighlighter.DefaultHighlightPainter( Color.RED);
		highlighter.setDrawsLayeredHighlights(false); // this is the key line
    }

    public void setContent ( String str )
    {
        editorPanel.setText( str );
    }

    public static String getContent()
    {
        String allContent;
        allContent = "";
        allContent = editorPanel.getText() + commentControl.getAllComments();
    	return allContent;
    }

    public void setEditorFont ( Font font )
    {
    	editorFont = font;
        editorPanel.setFont( editorFont);
    }

    public Font getEditorFont (){
	return editorPanel.getFont();
    }

    public static int getSelectionFirst (){
	return editorPanel.getSelectionStart();
    }

    public static int getSelectionLast (){
	return editorPanel.getSelectionEnd();
    }

    public static void addHighlight(Color color) {
	painter = new DefaultHighlighter.DefaultHighlightPainter(color);
	a = editorPanel.getSelectionStart();
	b = editorPanel.getSelectionEnd();
	try {
 	    highlighter.addHighlight(a, b, painter);
  	} catch (BadLocationException exeption) {
	// TODO Auto-generated catch block
  		exeption.printStackTrace();
  		}
    }

    public static JScrollPane getJScrollPane() {
    	return scrollPane;
    }


    public static int getLineNumber( int pos) {
    	String text;
    	String currentSubString;

    	int lineNumber;
    	text = editorPanel.getText();
    	lineNumber = 1	;

    	for( int i = 0; i <= pos; i++) {
    	   	currentSubString = text.substring(i, i+1);
    		if(currentSubString.equals("\n"))
    			lineNumber++;
    	}
    	return lineNumber;
    }

    //returns the starting position of the line
    public static int getPos(int lineNumber) {
    	int pos;
    	int count;
    	String text;
    	String currentSubString = "";

    	count = lineNumber;
    	pos = 0;
    	text = editorPanel.getText();

    	for( int i = 0; i < text.length(); i++){
    		currentSubString = text.substring(i, i+1);
		 	if(currentSubString.equals("\n"))
	            count--;
		 	if(count == 2)
		 		pos = i + 2 ;
    	}

    	return pos;
    }

    //adds pointer at the specified position
    public static void addNewPointer( int pos) {
    	//First we delete any previous pointers (if any)
    	//editorPanel.setText(editorPanel.getText().replace(">>",""));

    	RemovePointer();

    	//Secondly we add new one
    	String str;
    	str = ">>";
    	editorPanel.insert(str, pos);

    	//reHighlight because normally it loses highlight
    	reHighlight(CommentsModel.commentsBag);
    }

    public static void RemovePointer() {
    	String text;
    	String currentSubString;

    	text = editorPanel.getText();

    	 System.out.println("entered");
    	for( int i = 0; i < text.length() - 2; i++) {
    		currentSubString = text.substring(i, i+2);
    		 if(currentSubString.equals(">>")) {
    			 System.out.println("found");
    			 editorPanel.replaceRange("", i, i+2);
    		 }
    	}
    }

    public static void reHighlight( ArrayList<Comment> commentsBag) {
    	int a;
    	int b;
    	Color color;

    	for( int i = 0; i < commentsBag.size(); i++) {
    		a = commentsBag.get(i).getStartIndex();
    		b = commentsBag.get(i).getEndIndex();
    		color = commentsBag.get(i).getColor();

	    	painter = new DefaultHighlighter.DefaultHighlightPainter( color);
	    	try {
	     	    highlighter.addHighlight(a, b, painter);
	      	} catch (BadLocationException exeption) {
	    	// TODO Auto-generated catch block
	       	exeption.printStackTrace();
	       	}
    	}
    }
}