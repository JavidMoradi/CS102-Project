import javax.swing.*;
import java.awt.*;

public class EditorAreaPanel extends JPanel
{
    JTextArea editorPanel;

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
}