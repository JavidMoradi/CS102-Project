import javax.swing.*;
import java.awt.*;

public class FileExplorerPanel extends JPanel
{
    public static DefaultListModel model;//<String>?
    JEditorPane dtrPnCode;
    
    public FileExplorerPanel ()
    {
        setPreferredSize( new Dimension( 200, 600 ) );
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(-1, 187, 196, 556);
        add(scrollPane);

        //DefaultListModel model = new DefaultListModel();
        model = new DefaultListModel();//<String>?
        JList lstFiles = new JList(model);//<String>?
        model.addElement("File Name #0.java");
        model.addElement( "File Name #1.java");
      


        lstFiles.setFont(new Font("Tahoma", Font.PLAIN, 20));
        scrollPane.setViewportView(lstFiles);
        lstFiles.setBackground(new Color(204, 0, 102));
        scrollPane.setLocation( new Point ( 600, 200 ) );

    }
}
