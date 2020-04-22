import javax.swing.*;
import java.awt.*;

public class EditorAreaPanel extends JPanel
{
    JEditorPane editorPanel;

    /**
     * There is a problem with the JEditorPane, for some reason
     * it cannot select any part of the text even though I copy
     * amd Pasted it from the previous Version of the project.
     * The one we designed on eclipse.
     * Keep in mind this is all work in progress
     */
    public EditorAreaPanel ()
    {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(194, 186, 967, 556);
        add(scrollPane);
        editorPanel = new JEditorPane();
        scrollPane.setViewportView(editorPanel);
        editorPanel.setSelectionColor(Color.WHITE);
        editorPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editorPanel.setFont(new Font("Tahoma", Font.PLAIN, 19));
        editorPanel.setForeground(Color.BLACK);
        editorPanel.setBackground(Color.WHITE);
        editorPanel.setPreferredSize( new Dimension( 500, 500 ) );


    }
}
