import javax.swing.*;
import java.awt.*;

public class EditorAreaPanel extends JPanel
{
    JTextArea editorPanel;

    public EditorAreaPanel ()
    {
        editorPanel = new JTextArea();
        editorPanel.setVisible( true );
        editorPanel.setRows( 35 );
        editorPanel.setColumns( 60 );
        editorPanel.setWrapStyleWord( true );
        editorPanel.setFont(new Font ("Tahoma", Font.PLAIN, 19) );
        JScrollPane scrollPane = new JScrollPane( editorPanel );
        add ( scrollPane );
    }
    /**
     * This method is to display the String parameter to the JTextArea, but as expected, doesn't work!!!!!
     */
//    public void setAText ( String str )
//    {
//        editorPanel.setEditable( true );
//        editorPanel.setText( str );
//    }
}
