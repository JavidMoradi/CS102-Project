import javax.swing.*;
import java.awt.*;

public class FileExplorerPanel extends JPanel
{
    public static DefaultListModel model;
    
    public FileExplorerPanel ()
    {
        setPreferredSize( new Dimension( 200, 220 ) );
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
        
        model = new DefaultListModel();
        JList lstFiles = new JList(model);
        model.addElement("File Name #0.java");
        model.addElement( "File Name #1.java");
        lstFiles.setPreferredSize( new Dimension( 180, 150 ) );
        
        lstFiles.setFont(new Font("Tahoma", Font.PLAIN, 20));
        scrollPane.setViewportView(lstFiles);
        lstFiles.setBackground(new Color(204, 0, 102));
    }
}
