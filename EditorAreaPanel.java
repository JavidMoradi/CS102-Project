import javax.swing.*;
import java.awt.*;

public class EditorAreaPanel extends JPanel
{
    JTextArea editorPanel;
	Font editorFont;
    
    public EditorAreaPanel ()
    {
        
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
}
