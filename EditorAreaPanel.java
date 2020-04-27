import javax.swing.*;
import java.awt.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.BadLocationException;

public class EditorAreaPanel extends JPanel
{
    Font editorFont;
    static JTextArea editorPanel;
    static int a;
    static int b;
    
    static DefaultHighlighter highlighter;
    static DefaultHighlighter.DefaultHighlightPainter painter;
    
    public EditorAreaPanel ()
    {
        highlighter = (DefaultHighlighter) editorPanel.getHighlighter();
	painter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
	highlighter.setDrawsLayeredHighlights(false); // this is the key line
		
        editorPanel = new JTextArea();
        editorPanel.setVisible( true );
        editorPanel.setRows( 19 );
        editorPanel.setColumns( 40 );
        editorPanel.setWrapStyleWord( true );
        editorPanel.setFont(new Font ("Tahoma", Font.PLAIN, 19) );
        JScrollPane scrollPane = new JScrollPane( editorPanel );
        add ( scrollPane );
    }
    
    public void setContent ( String str )
    {
        editorPanel.setText( str );
    }
    
    public String getContent ()
    {
        return editorPanel.getText();
    }

    public void setEditorFont ( Font font )
    {
    	editorFont = font;
        editorPanel.setFont( editorFont);
    }

    public Font getEditorFont (){
	return editorPanel.getFont();
    }

    public int getSelectionFirst (){
	return editorPanel.getSelectionStart();
    }

    public int getSelectionLast (){
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
}
